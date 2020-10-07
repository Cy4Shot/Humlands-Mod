package com.turtysproductions.humlands.common.tileentities;

import com.turtysproductions.humlands.common.recipe.ShaperRecipe;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IClearable;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;

public class ShaperTileEntity extends TileEntity implements IClearable, ITickableTileEntity {

	private final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);
	private int cookingTime;
	private int cookingTotalTime = 200;
	public ShaperRecipe recipeHandler;
	public boolean isCooking;

	public ShaperTileEntity() {
		this(TileEntityTypesInit.SHAPER_TILE_ENTITY.get());
	}

	public ShaperTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		recipeHandler = new ShaperRecipe();
		cookingTotalTime = 200;
	}

	@Override
	public void tick() {
		if (!this.world.isRemote) {
			ItemStack itemstack = this.inventory.get(0);
			if (!itemstack.isEmpty() && !this.inventory.get(1).isEmpty()) {
				this.cookingTime++;
				if (this.cookingTime >= this.cookingTotalTime) {
					this.inventory.set(0, recipeHandler.getShaperResult(itemstack, this.inventory.get(1)));
					this.cookingTime = 0;
					this.inventoryChanged();
				}
			}
		}
	}

	public NonNullList<ItemStack> getInventory() {
		return this.inventory;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.inventory.clear();
		ItemStackHelper.loadAllItems(compound, this.inventory);
		this.cookingTime = compound.getInt("CookingTime");
		this.cookingTotalTime = compound.getInt("CookingTotalTime");
		this.isCooking = compound.getBoolean("IsCooking");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		this.writeItems(compound);
		compound.putInt("CookingTime", this.cookingTime);
		compound.putInt("CookingTotalTime", this.cookingTotalTime);
		compound.putBoolean("IsCooking", this.isCooking);
		return compound;
	}

	private CompoundNBT writeItems(CompoundNBT compound) {
		super.write(compound);
		ItemStackHelper.saveAllItems(compound, this.inventory, true);
		return compound;
	}

	public boolean addItem(ItemStack itemStackIn) {
		if (this.inventory.get(0).isEmpty()) {
			this.cookingTime = 0;
			this.inventory.set(0, itemStackIn.split(1));
			this.inventoryChanged();
			return true;
		}
		return false;
	}

	public boolean addTool(ItemStack itemStackIn) {
		if (this.inventory.get(1).isEmpty()) {
			this.inventory.set(1, itemStackIn.split(1));
			this.inventoryChanged();
			return true;
		}
		return false;
	}

	public boolean removeInv(int slot, PlayerEntity player) {
		if (!this.inventory.get(slot).isEmpty()) {
			this.cookingTime = 0;
			player.inventory.addItemStackToInventory(this.inventory.get(slot));
			this.inventory.set(slot, ItemStack.EMPTY);
			this.inventoryChanged();
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		this.inventory.clear();
	}

	
	public void dropAllItems() {
		if (!this.getWorld().isRemote) {
			InventoryHelper.dropItems(this.getWorld(), this.getPos(), this.getInventory());
		}

		this.inventoryChanged();
	}

	private void inventoryChanged() {
		this.markDirty();
		this.getWorld().notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), 3);
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return new SUpdateTileEntityPacket(this.getPos(), 1, nbt);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
		this.read(packet.getNbtCompound());
	}

}
