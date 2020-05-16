package com.turtysproductions.humlands.common.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HumlandsSpecifiedItemSlot extends Slot {
	private Item item;
	public HumlandsSpecifiedItemSlot(IInventory inventoryIn, int index, int xPosition, int yPosition, Item item) {
		super(inventoryIn, index, xPosition, yPosition);
		this.item = item;
	}

	public boolean isItemValid(ItemStack stack) {
		return stack.getItem().equals(item);
	}
}
