package com.turtysproductions.humlands.core.datagen.generators;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class BlockStatesDataGen extends BlockStateProvider {

	public BlockStatesDataGen(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		singleTextureBlock(BlockInit.SCRAP_GLASS.get(), "scrap_glass", "block/scrap_glass");
		singleTextureBlock(BlockInit.SCRAP_SAND.get(), "scrap_sand", "block/scrap_sand");
	}

	public void singleTextureBlock(Block block, String model, String textureName) {
		simpleBlock(block);
		HumlandsMod.LOGGER.debug("Creating block states model for :" + block.getRegistryName());
	}

	@Override
	public String getName() {
		return "Humlands Mod -  Blockstates";
	}
}