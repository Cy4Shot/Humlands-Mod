package com.turtysproductions.humlands.common.datagen;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.datagen.generators.BlockStatesDataGen;
import com.turtysproductions.humlands.common.datagen.generators.BlockTagsDataGen;
import com.turtysproductions.humlands.common.datagen.generators.ItemModelsDataGen;
import com.turtysproductions.humlands.common.datagen.generators.ItemTagsDataGen;
import com.turtysproductions.humlands.common.datagen.generators.LanguagesDataGen;
import com.turtysproductions.humlands.common.datagen.generators.LootTablesDataGen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HumLandsDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		HumlandsMod.LOGGER.debug("Starting server side data generators");
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new LootTablesDataGen(generator));
			generator.addProvider(new BlockTagsDataGen(generator));
			generator.addProvider(new ItemTagsDataGen(generator));
		}

		if (event.includeClient()) {
			HumlandsMod.LOGGER.debug("Starting client side data generators");
			generator.addProvider(new BlockStatesDataGen(generator, HumlandsMod.MOD_ID, event.getExistingFileHelper()));
			generator.addProvider(new ItemModelsDataGen(generator, HumlandsMod.MOD_ID, event.getExistingFileHelper()));
			generator.addProvider(new LanguagesDataGen(generator, HumlandsMod.MOD_ID));
		}
	}
}
