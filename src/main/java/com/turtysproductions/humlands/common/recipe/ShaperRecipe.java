package com.turtysproductions.humlands.common.recipe;

import java.util.ArrayList;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShaperRecipe {
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.create();
	private final ArrayList<Item> allowed_input = new ArrayList<Item>();
	private final ArrayList<Item> allowed_tools = new ArrayList<Item>();

	public ShaperRecipe() {
		// Add Recipes Here: Input, Tool, Output
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
		for (Cell<ItemStack, ItemStack, ItemStack> cell : smeltingList.cellSet()) {
			if (cell.getRowKey().getItem() == input.getItem() && cell.getColumnKey().getItem() == tool.getItem()) {
				HumlandsMod.LOGGER.debug(cell.getValue());
				return cell.getValue();
			}
		}
		return ItemStack.EMPTY;
	}

	public Table<ItemStack, ItemStack, ItemStack> getSmeltingList() {
		return this.smeltingList;
	}

	public boolean isAllowedItem(Item item) {
		return allowed_input.contains(item);
	}

	public boolean isAllowedTool(Item item) {
		return allowed_tools.contains(item);
	}
}
