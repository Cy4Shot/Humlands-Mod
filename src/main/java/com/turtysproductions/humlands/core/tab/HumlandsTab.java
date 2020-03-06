package com.turtysproductions.humlands.core.tab;

import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HumlandsTab extends ItemGroup {
	
	public static final ItemGroup HUMLANDS = new HumlandsTab(ItemGroup.GROUPS.length, "humlands");

	public HumlandsTab(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.TEST_ITEM.get());
	}
}
