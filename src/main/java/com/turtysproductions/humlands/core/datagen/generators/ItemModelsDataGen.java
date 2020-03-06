package com.turtysproductions.humlands.core.datagen.generators;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class ItemModelsDataGen extends ItemModelProvider {
	public ItemModelsDataGen(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		// blocks
		blockParented(BlockInit.SCRAP_GLASS.get(), "block/scrap_glass");
		blockParented(BlockInit.SCRAP_SAND.get(), "block/scrap_sand");
		blockParented(BlockInit.SCRAP_SANDSTONE.get(), "block/scrap_sandstone");
		blockParented(BlockInit.TEST_BLOCK.get(), "block/test_block");
		/*
		 * not implemented blockParented(BlockInit.SIFTER.get(), "block/sifter");
		 */

		// items
		itemGenerated(ItemInit.ROYAL_FLAN_RAW.get(), "item/royal_flan_raw");
		itemGenerated(ItemInit.ROYAL_FLAN.get(), "item/royal_flan");
		itemGenerated(ItemInit.ROYAL_SLIME.get(), "item/royal_slime");
		itemGenerated(ItemInit.SUPER_ROYAL_FLAN_RAW.get(), "item/royal_flan_raw");
		itemGenerated(ItemInit.SUPER_ROYAL_FLAN.get(), "item/royal_flan");
		itemGenerated(ItemInit.SUPER_ROYAL_SLIME.get(), "item/royal_slime");
	}

	public void blockParented(Block block, String model) {
		HumlandsMod.LOGGER.debug("Creating item block model for " + block.getRegistryName());
		getBuilder(block.getRegistryName().getPath()).parent(new ModelFile.UncheckedModelFile(modLoc(model)));
	}

	public void itemHandheld(Item item, String texture) {
		HumlandsMod.LOGGER.debug("Creating handheld item model for " + item.getRegistryName());
		getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/handheld"))).texture("layer0",
				modLoc(texture));
	}

	public void itemGenerated(Item item, String texture) {
		HumlandsMod.LOGGER.debug("Creating generated item model for " + item.getRegistryName());
		getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0",
				modLoc(texture));
	}

	@Override
	public String getName() {
		return "Humlands Mod - Item Models";
	}
}
