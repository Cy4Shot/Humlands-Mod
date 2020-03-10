package com.turtysproductions.humlands.core.datagen.generators;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class BlockTagsDataGen extends BlockTagsProvider {
	
	public BlockTagsDataGen(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerTags() {
		addForgeTag("glass/scrap", BlockInit.SCRAP_GLASS.get());
	}

	private void addForgeTag(String name, Block... items) {
		HumlandsMod.LOGGER.debug("Creating block tag for forge:" + name);
		ResourceLocation loc = new ResourceLocation("forge", name);
		getBuilder(new Tag<Block>(loc)).replace(false).add(items).build(loc);
	}

	@Override
	public String getName() {
		return "Humlands Mod -  Block Tags";
	}
}