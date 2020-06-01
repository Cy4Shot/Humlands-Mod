package com.turtysproductions.humlands.common.recipe;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShaperRecipe {
	private static final ShaperRecipe INSTANCE = new ShaperRecipe();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable
			.<ItemStack, ItemStack, ItemStack>create();

	private final ArrayList<Item> allowed_input = new ArrayList<Item>();
	private final ArrayList<Item> allowed_tools = new ArrayList<Item>();

	public static ShaperRecipe getInstance() {
		return INSTANCE;
	}

	public ShaperRecipe() {
		// Add Recipes Here!
		addShaperRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(ItemInit.HAMMER.get()),
				new ItemStack(ItemInit.GOLD_PLATE.get()));
	}

	public void addShaperRecipe(ItemStack input, ItemStack tool, ItemStack result) {
		if (getShaperResult(input, tool) != ItemStack.EMPTY)
			return;
		this.smeltingList.put(input, tool, result);

		if (!this.allowed_input.contains(input.getItem())) {
			this.allowed_input.add(input.getItem());
		}
		if (!this.allowed_tools.contains(tool.getItem())) {
			this.allowed_tools.add(tool.getItem());
		}
	}

	public ItemStack getShaperResult(ItemStack input, ItemStack tool) {
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if (ItemStack.areItemStacksEqual(input, (ItemStack) entry.getKey())) {
				for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if (ItemStack.areItemStacksEqual(tool, (ItemStack) ent.getKey())) {
						return (ItemStack) ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}

	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		return this.smeltingList;
	}

	public boolean isAllowedItem(Item item) {
		return allowed_input.contains(item);
	}

	public boolean isAllowedTool(Item item) {
		return allowed_tools.contains(item);
	}
}
