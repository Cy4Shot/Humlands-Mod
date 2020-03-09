package com.turtysproductions.humlands.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingReuseItem extends Item
{
	public CraftingReuseItem(Item.Properties properties) {
		super(properties);
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) 
	{
		return itemStack.copy();
	}
	
	@Override
	public boolean hasContainerItem() 
	{
		return true;
	}
	
}
