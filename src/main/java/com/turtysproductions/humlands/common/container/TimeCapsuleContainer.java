package com.turtysproductions.humlands.common.container;

import java.util.Objects;

import com.turtysproductions.humlands.init.BlockInit;
import com.turtysproductions.humlands.init.ContainerTypesInit;
import com.turtysproductions.humlands.common.tileentities.TimeCapsuleTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class TimeCapsuleContainer extends Container 
{

	public final TimeCapsuleTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public TimeCapsuleContainer(final int windowId, final PlayerInventory playerInventory,
			final TimeCapsuleTileEntity tileEntity) 
	{
		super(ContainerTypesInit.TIME_CAPSULE_CONTAINER.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Main Inventory
		//startX and startY are determined by the highlighted point:
		//_______________
		//|-            |
		//|             |
		//|             |
		//|             |
		//|             |
		//|             |
		//|_____________|
		//A slot
		
		//In the normal chest rows are 4 and columns are 9.          COLUMN
		//                                                        ROW
		int startX = 62;
		int startY = 17;
		int slotSizePlus2 = 18;
		for (int row = 0; row < 5; ++row) 
		{
			for (int column = 0; column < 3; ++column) 
			{
				this.addSlot(new Slot(tileEntity, (row * 3) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
			}
		}
		
		//Main Player Inventory
		int startPlayerInvX = 8;
		int startPlayerInvY = startY * 7 + 1;
		for(int row = 0; row < 3; ++row)
		{
			for(int column = 0; column < 9; ++column)
			{
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startPlayerInvX + (column * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
			}
		}
		
		//Hotbar
		int hotbarY = startPlayerInvY + (startPlayerInvY /2) -2;
		for(int column = 0; column < 9; ++column)
		{
			this.addSlot(new Slot(playerInventory, column, startPlayerInvX + (column * slotSizePlus2), hotbarY));
		}
	}
		
	
	private static TimeCapsuleTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data)
	{
		Objects.requireNonNull(playerInventory, "playerInvetory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if(tileAtPos instanceof TimeCapsuleTileEntity)
		{
			return (TimeCapsuleTileEntity)tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct!" + tileAtPos);
	}
	
	public TimeCapsuleContainer(final int windowIn, final PlayerInventory playerInventory, final PacketBuffer data) 
	{
	this(windowIn, playerInventory, getTileEntity(playerInventory, data));
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.TIME_CAPSULE.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < 36) {
				if (!this.mergeItemStack(stack1, 15, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(stack1, 0, 15, false)) {
				return ItemStack.EMPTY;
			}

			if (stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return stack;
	}
	
}
