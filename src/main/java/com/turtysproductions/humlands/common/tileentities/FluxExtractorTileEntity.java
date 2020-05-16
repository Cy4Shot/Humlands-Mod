package com.turtysproductions.humlands.common.tileentities;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.turtysproductions.humlands.common.container.FluxExtractorContainer;
import com.turtysproductions.humlands.core.init.ContainerTypesInit;
import com.turtysproductions.humlands.core.init.ItemInit;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;

import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class FluxExtractorTileEntity extends LockableTileEntity
		implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {

	private static final int[] SLOTS_UP = new int[] { 0 };
	private static final int[] SLOTS_DOWN = new int[] { 2, 1 };
	private static final int[] SLOTS_HORIZONTAL = new int[] { 1 };
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private int burnTime;
	private int recipesUsed;
	private int cookTime;
	private int cookTimeTotal;
	public int pseudoProgressTime;

	protected final IIntArray furnaceData = new IIntArray() {
		public int get(int index) {
			switch (index) {
			case 0:
				return FluxExtractorTileEntity.this.burnTime;
			case 1:
				return FluxExtractorTileEntity.this.recipesUsed;
			case 2:
				return FluxExtractorTileEntity.this.cookTime;
			case 3:
				return FluxExtractorTileEntity.this.cookTimeTotal;
			default:
				return 0;
			}
		}

		public void set(int index, int value) {
			switch (index) {
			case 0:
				FluxExtractorTileEntity.this.burnTime = value;
				break;
			case 1:
				FluxExtractorTileEntity.this.recipesUsed = value;
				break;
			case 2:
				FluxExtractorTileEntity.this.cookTime = value;
				break;
			case 3:
				FluxExtractorTileEntity.this.cookTimeTotal = value;
			}
		}

		public int size() {
			return 4;
		}
	};
	private final Map<ResourceLocation, Integer> field_214022_n = Maps.newHashMap();
	protected final IRecipeType<? extends AbstractCookingRecipe> recipeType;

	protected FluxExtractorTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		this.recipeType = IRecipeType.SMELTING;
	}

	public FluxExtractorTileEntity() {
		super(TileEntityTypesInit.FLUX_EXTRACTOR_TILE_ENTITY.get());
		this.recipeType = IRecipeType.SMELTING;
	}

	public static Map<Item, Integer> getBurnTimes() {
		Map<Item, Integer> map = Maps.newLinkedHashMap();
		addItemBurnTime(map, ItemInit.FLUX_VIAL.get(), 1600);
		return map;
	}

	private static void addItemBurnTime(Map<Item, Integer> map, IItemProvider itemProvider, int burnTimeIn) {
		map.put(itemProvider.asItem(), burnTimeIn);
	}

	private boolean isBurning() {
		return this.burnTime > 0;
	}

	public IIntArray getFurnaceData() {
		return this.furnaceData;
	}

	public void read(CompoundNBT compound) {
		super.read(compound);
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.items);
		this.burnTime = compound.getInt("BurnTime");
		this.cookTime = compound.getInt("CookTime");
		this.cookTimeTotal = compound.getInt("CookTimeTotal");
		this.recipesUsed = 200;

		for (int j = 0; j < compound.getShort("RecipesUsedSize"); ++j) {
			ResourceLocation resourcelocation = new ResourceLocation(compound.getString("RecipeLocation" + j));
			int k = compound.getInt("RecipeAmount" + j);
			this.field_214022_n.put(resourcelocation, k);
		}

	}

	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		compound.putInt("BurnTime", this.burnTime);
		compound.putInt("CookTime", this.cookTime);
		compound.putInt("CookTimeTotal", this.cookTimeTotal);
		ItemStackHelper.saveAllItems(compound, this.items);
		compound.putShort("RecipesUsedSize", (short) this.field_214022_n.size());
		int i = 0;
		for (Entry<ResourceLocation, Integer> entry : this.field_214022_n.entrySet()) {
			compound.putString("RecipeLocation" + i, entry.getKey().toString());
			compound.putInt("RecipeAmount" + i, entry.getValue());
			++i;
		}
		return compound;
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT comp = new CompoundNBT();
		write(comp);
		return new SUpdateTileEntityPacket(this.pos, 1, comp);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		read(pkt.getNbtCompound());
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag) {
		this.read(tag);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	public void tick() {
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.cookTime > this.pseudoProgressTime) {
			this.pseudoProgressTime = this.cookTime;
			this.syncClient();
		}
		if (this.burnTime > 0)
			--this.burnTime;
		else
			this.pseudoProgressTime = 0;

		if (!this.world.isRemote) {
			ItemStack itemstack = this.items.get(1);
			if (!itemstack.isEmpty() && !this.items.get(0).isEmpty()) {
				if (!this.isBurning() && this.canSmelt()) {
					this.burnTime = 200;
					this.pseudoProgressTime = 0;
					this.recipesUsed = this.burnTime;
					flag1 = true;
					if (itemstack.hasContainerItem())
						this.items.set(1, itemstack.getContainerItem());
					else if (!itemstack.isEmpty()) {
						if (itemstack.isEmpty()) {
							this.items.set(1, itemstack.getContainerItem());
						}
					}
				}

				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;
					this.syncClient();
					if (this.cookTime == this.getCookTime()) {
						this.cookTime = 0;
						this.pseudoProgressTime = 0;
						this.cookTimeTotal = this.getCookTime();
						this.smelt();
						flag1 = true;
					}
				}
			}

			if (flag != this.isBurning())
				flag1 = true;
		}

		if (flag1)
			this.syncClient();
	}

	private void syncClient() {
		this.getWorld().markBlockRangeForRenderUpdate(pos, this.getBlockState(), this.getBlockState());
		this.getWorld().notifyBlockUpdate(pos, this.getBlockState(), this.getBlockState(), 3);
		markDirty();
	}

	private boolean canSmelt() {
		return (!this.items.get(0).isEmpty()) && this.items.get(2).isEmpty() && !this.items.get(1).isEmpty();
	}

	private void smelt() {
		if (this.canSmelt()) {
			ItemStack itemstack1 = new ItemStack(ItemInit.FULL_VIAL.get());
			ItemStack itemstack2 = this.items.get(2);
			if (itemstack2.isEmpty())
				this.items.set(2, itemstack1.copy());
			else if (itemstack2.getItem() == itemstack1.getItem())
				itemstack2.grow(itemstack1.getCount());
			this.items.get(0).shrink(1);
			this.items.get(1).shrink(1);
			this.burnTime = 0;
			this.pseudoProgressTime = 0;
		}
	}

	protected int getBurnTime(ItemStack p_213997_1_) {
		return p_213997_1_.isEmpty() ? 0 : net.minecraftforge.common.ForgeHooks.getBurnTime(p_213997_1_);
	}

	protected int getCookTime() {
		return 200;
	}

	public int[] getSlotsForFace(Direction side) {
		if (side == Direction.DOWN)
			return SLOTS_DOWN;
		else
			return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
	}

	public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		return !(direction == Direction.DOWN && index == 1);
	}

	public int getSizeInventory() {
		return this.items.size();
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty())
				return false;
		}

		return true;
	}

	public ItemStack getStackInSlot(int index) {
		return this.items.get(index);
	}

	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.items, index, count);
	}

	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.items, index);
	}

	public void setInventorySlotContents(int index, ItemStack stack) {
		this.items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());
	}

	public boolean isUsableByPlayer(PlayerEntity player) {
		return this.world.getTileEntity(this.pos) != this ? false
				: player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
						(double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 2)
			return false;
		else if (index != 1)
			return true;
		else
			return isFuel(stack) || stack.getItem() == Items.BUCKET && this.items.get(1).getItem() != Items.BUCKET;
	}

	public void clear() {
		this.items.clear();
	}

	public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
		if (recipe != null) {
			this.field_214022_n.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
				return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
			});
		}

	}

	@Nullable
	public IRecipe<?> getRecipeUsed() {
		return null;
	}

	public void onCrafting(PlayerEntity player) {
	}

	public void func_213995_d(PlayerEntity p_213995_1_) {
		List<IRecipe<?>> list = Lists.newArrayList();

		for (Entry<ResourceLocation, Integer> entry : this.field_214022_n.entrySet()) {
			p_213995_1_.world.getRecipeManager().getRecipe(entry.getKey()).ifPresent((p_213993_3_) -> {
				list.add(p_213993_3_);
				func_214003_a(p_213995_1_, entry.getValue(), ((AbstractCookingRecipe) p_213993_3_).getExperience());
			});
		}

		p_213995_1_.unlockRecipes(list);
		this.field_214022_n.clear();
	}

	private static void func_214003_a(PlayerEntity p_214003_0_, int p_214003_1_, float p_214003_2_) {
		if (p_214003_2_ == 0.0F) {
			p_214003_1_ = 0;
		} else if (p_214003_2_ < 1.0F) {
			int i = MathHelper.floor((float) p_214003_1_ * p_214003_2_);
			if (i < MathHelper.ceil((float) p_214003_1_ * p_214003_2_)
					&& Math.random() < (double) ((float) p_214003_1_ * p_214003_2_ - (float) i)) {
				++i;
			}

			p_214003_1_ = i;
		}

		while (p_214003_1_ > 0) {
			int j = ExperienceOrbEntity.getXPSplit(p_214003_1_);
			p_214003_1_ -= j;
			p_214003_0_.world.addEntity(new ExperienceOrbEntity(p_214003_0_.world, p_214003_0_.getPosX(),
					p_214003_0_.getPosY() + 0.5D, p_214003_0_.getPosZ() + 0.5D, j));
		}
	}

	public void fillStackedContents(RecipeItemHelper helper) {
		for (ItemStack itemstack : this.items) {
			helper.accountStack(itemstack);
		}
	}

	net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers = net.minecraftforge.items.wrapper.SidedInvWrapper
			.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(
			net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
		if (!this.removed && facing != null
				&& capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (facing == Direction.UP)
				return handlers[0].cast();
			else if (facing == Direction.DOWN)
				return handlers[1].cast();
			else
				return handlers[2].cast();
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void remove() {
		super.remove();
		for (int x = 0; x < handlers.length; x++)
			handlers[x].invalidate();
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent(".flux_extractor");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new FluxExtractorContainer(ContainerTypesInit.FLUX_EXTRACTOR_CONTAINER.get(), id, this.world, this.pos,
				player, player.player, this);
	}

	public static boolean isFuel(ItemStack p_213991_0_) {
		return net.minecraftforge.common.ForgeHooks.getBurnTime(p_213991_0_) > 0;
	}

	public NonNullList<ItemStack> getItems() {
		return items;
	}
}
