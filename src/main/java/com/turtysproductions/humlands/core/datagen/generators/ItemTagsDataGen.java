package com.turtysproductions.humlands.core.datagen.generators;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ItemTagsDataGen extends ItemTagsProvider {
	public ItemTagsDataGen(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerTags() {
		// foods
		addForgeTag("slime/royal", ItemInit.ROYAL_SLIME.get());
	}

	private void addForgeTag(String name, Item... items) {
		HumlandsMod.LOGGER.debug("Creating item tag for forge:" + name);
		ResourceLocation loc = new ResourceLocation("forge", name);
		getBuilder(new Tag<Item>(loc)).replace(false).add(items).build(loc);
	}

	@Override
	public String getName() {
		return "Humlands Mod - Item Tags";
	}
}
