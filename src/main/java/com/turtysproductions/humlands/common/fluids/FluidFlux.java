package com.turtysproductions.humlands.common.fluids;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.init.FluidInit;
import com.turtysproductions.humlands.common.init.ItemInit;

import net.minecraft.block.Block.Properties;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class FluidFlux extends FlowingFluid {
	@Override
	public Fluid getFlowingFluid() {
		return FluidInit.FLUX_FLOWING.get();
	}

	@Override
	public Fluid getStillFluid() {
		return FluidInit.FLUX_FLUID.get();
	}

	@Override
	protected boolean canSourcesMultiply() {
		return true;
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {

	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 3;
	}

	@Override
	public Item getFilledBucket() {
		return ItemInit.FULL_VIAL.get();
	}

	protected boolean setDirection(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid,
			Direction direction) {
		return direction == Direction.DOWN && !fluid.isIn(FluidInit.Tags.FLUX);
	}

	@Override
	public int getTickRate(IWorldReader world) {
		return 100;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0F;
	}

	@Override
	protected BlockState getBlockState(IFluidState state) {
		return FluidInit.FLUIDFLUX_FLUX.getBlockState(getDefaultState()).with(FlowingFluidBlock.LEVEL,
				Integer.valueOf(getLevelFromState(state)));
	}

	@Override
	protected FluidAttributes createAttributes() {
		return FluidAttributes.builder(new ResourceLocation(HumlandsMod.MOD_ID, "blocks/flux_still"),
				new ResourceLocation(HumlandsMod.MOD_ID, "blocks/flux_flow")).build(this);
	}

	public static class Flowing extends FluidFlux {

		@Override
		protected void fillStateContainer(Builder<Fluid, IFluidState> builder) {
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		@Override
		public boolean isSource(IFluidState state) {
			return false;
		}

		@Override
		public int getLevel(IFluidState state) {
			return state.get(FluidFlux.LEVEL_1_8);
		}

		@Override
		protected boolean canDisplace(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid,
				Direction direction) {

			return false;
		}

	}

	public static class Source extends FluidFlux {

		public Source(Properties create) {

		}

		@Override
		public boolean isSource(IFluidState state) {
			return true;
		}

		@Override
		public int getLevel(IFluidState state) {
			return 8;
		}

		@Override
		protected boolean canDisplace(IFluidState state, IBlockReader world, BlockPos pos, Fluid fluid,
				Direction direction) {

			return false;
		}

	}
}
