package com.turtysproductions.humlands.common.datagen.generators;

import com.turtysproductions.humlands.common.init.BlockInit;

import net.minecraft.data.DataGenerator;

public class LootTablesDataGen extends LootTableBaseProvider {

	public LootTablesDataGen(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
	protected void addTables() {
		lootTables.put(BlockInit.SCRAP_GLASS.get(), createStandardTable("scrap_glass", BlockInit.SCRAP_GLASS.get()));
		lootTables.put(BlockInit.SCRAP_SAND.get(), createStandardTable("scrap_sand", BlockInit.SCRAP_SAND.get()));
		lootTables.put(BlockInit.SCRAP_SANDSTONE.get(), createStandardTable("scrap_sandstone", BlockInit.SCRAP_SANDSTONE.get()));
		lootTables.put(BlockInit.TEST_BLOCK.get(), createStandardTable("test_block", BlockInit.TEST_BLOCK.get()));
		lootTables.put(BlockInit.SIFTER.get(), createStandardTable("sifter", BlockInit.SIFTER.get()));
	}

	@Override
	public String getName() {
		return "Humlands Mod - Loottables";
	}
}
