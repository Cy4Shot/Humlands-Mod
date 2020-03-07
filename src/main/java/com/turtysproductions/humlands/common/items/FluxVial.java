package com.turtysproductions.humlands.common.items;

import javax.annotation.Nullable;

import com.turtysproductions.humlands.common.advancement.TriggerInit;
import com.turtysproductions.humlands.core.init.FluidInit;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FluxVial extends Item {

	public FluxVial(java.util.function.Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(builder);
		this.fluidSupplier = supplier;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn,
				this.getFluid() == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY
						: RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn,
				itemstack, raytraceresult);
		if (ret != null)
			return ret;
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.resultPass(itemstack);
		} else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.resultPass(itemstack);
		} else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult) raytraceresult;
			BlockPos blockpos = blockraytraceresult.getPos();
			Direction direction = blockraytraceresult.getFace();
			BlockPos blockpos1 = blockpos.offset(direction);
			if (worldIn.isBlockModifiable(playerIn, blockpos)
					&& playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {
				if (this.getFluid() == Fluids.EMPTY) {
					BlockState blockstate1 = worldIn.getBlockState(blockpos);
					if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
						Fluid fluid = ((IBucketPickupHandler) blockstate1.getBlock()).pickupFluid(worldIn, blockpos,
								blockstate1);
						if (fluid != Fluids.EMPTY) {
							playerIn.addStat(Stats.ITEM_USED.get(this));

							SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
							if (soundevent == null)
								soundevent = fluid.isIn(FluidInit.Tags.FLUX) ? SoundEvents.ITEM_BUCKET_FILL_LAVA
										: SoundEvents.ITEM_BUCKET_FILL;
							playerIn.playSound(soundevent, 1.0F, 1.0F);
							ItemStack itemstack1 = this.fillBucket(itemstack, playerIn, fluid.getFilledBucket());
							if (!worldIn.isRemote) {
								TriggerInit.FILLED_VIAL.trigger((ServerPlayerEntity) playerIn,
										new ItemStack(fluid.getFilledBucket()));
							}

							return ActionResult.resultSuccess(itemstack1);
						}
					}

					return ActionResult.resultFail(itemstack);
				} else {
					BlockState blockstate = worldIn.getBlockState(blockpos);
					BlockPos blockpos2 = blockstate.getBlock() instanceof ILiquidContainer
							&& this.getFluid() == FluidInit.FLUX_FLUID.get() ? blockpos : blockpos1;
					if (this.tryPlaceContainedLiquid(playerIn, worldIn, blockpos2, blockraytraceresult)) {
						this.onLiquidPlaced(worldIn, itemstack, blockpos2);
						if (playerIn instanceof ServerPlayerEntity) {
							CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) playerIn, blockpos2, itemstack);
						}

						playerIn.addStat(Stats.ITEM_USED.get(this));
						return ActionResult.resultSuccess(this.emptyBucket(itemstack, playerIn));
					} else {
						return ActionResult.resultFail(itemstack);
					}
				}
			} else {
				return ActionResult.resultFail(itemstack);
			}
		}
	}

	protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
		return !player.abilities.isCreativeMode ? new ItemStack(ItemInit.FLUX_VIAL.get()) : stack;
	}

	public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos) {
	}

	private ItemStack fillBucket(ItemStack emptyVials, PlayerEntity player, Item fullVial) {
		if (player.abilities.isCreativeMode) {
			return emptyVials;
		} else {
			emptyVials.shrink(1);
			if (emptyVials.isEmpty()) {
				return new ItemStack(fullVial);
			} else {
				if (!player.inventory.addItemStackToInventory(new ItemStack(fullVial))) {
					player.dropItem(new ItemStack(fullVial), false);
				}

				return emptyVials;
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn,
			@Nullable BlockRayTraceResult blockraytraceresult) {
		if (!(this.getFluid() instanceof FlowingFluid)) {
			return false;
		} else {
			BlockState blockstate = worldIn.getBlockState(posIn);
			Material material = blockstate.getMaterial();
			boolean flag = blockstate.isReplaceable(this.getFluid());
			if (blockstate.isAir() || flag
					|| blockstate.getBlock() instanceof ILiquidContainer && ((ILiquidContainer) blockstate.getBlock())
							.canContainFluid(worldIn, posIn, blockstate, this.getFluid())) {
				if (worldIn.dimension.doesWaterVaporize() && this.getFluid().isIn(FluidInit.Tags.FLUX)) {
					int i = posIn.getX();
					int j = posIn.getY();
					int k = posIn.getZ();
					worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F,
							2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

					for (int l = 0; l < 8; ++l) {
						worldIn.addParticle(ParticleTypes.LARGE_SMOKE, (double) i + Math.random(),
								(double) j + Math.random(), (double) k + Math.random(), 0.0D, 0.0D, 0.0D);
					}

				} else if (blockstate.getBlock() instanceof ILiquidContainer
						&& this.getFluid() == FluidInit.FLUX_FLUID.get()) {
					if (((ILiquidContainer) blockstate.getBlock()).receiveFluid(worldIn, posIn, blockstate,
							((FlowingFluid) this.getFluid()).getStillFluidState(false))) {
						this.playEmptySound(player, worldIn, posIn);
					}
				} else {
					if (!worldIn.isRemote && flag && !material.isLiquid()) {
						worldIn.destroyBlock(posIn, true);
					}

					this.playEmptySound(player, worldIn, posIn);
					worldIn.setBlockState(posIn, this.getFluid().getDefaultState().getBlockState(), 11);
				}

				return true;
			}
			{
				return blockraytraceresult == null ? false
						: this.tryPlaceContainedLiquid(player, worldIn,
								blockraytraceresult.getPos().offset(blockraytraceresult.getFace()),
								(BlockRayTraceResult) null);
			}
		}
	}

	protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
		SoundEvent soundevent = this.getFluid().getAttributes().getEmptySound();
		if (soundevent == null)
			soundevent = this.getFluid().isIn(FluidInit.Tags.FLUX) ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA
					: SoundEvents.ITEM_BUCKET_EMPTY;
		worldIn.playSound(player, pos, soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack,
			@Nullable net.minecraft.nbt.CompoundNBT nbt) {
		if (this.getClass() == FluxVial.class)
			return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
		else
			return super.initCapabilities(stack, nbt);
	}

	private final java.util.function.Supplier<? extends Fluid> fluidSupplier;

	public Fluid getFluid() {
		return fluidSupplier.get();
	}

}
