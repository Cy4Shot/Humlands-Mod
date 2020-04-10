package com.turtysproductions.humlands.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlintingItem extends Item {

	public GlintingItem(Item.Properties properties) {
		super(properties);
	}

	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}