package com.turtysproductions.humlands.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingReuseItem extends Item {
	
	public CraftingReuseItem(Item.Properties properties) {
		super(properties);
	}

	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
}
