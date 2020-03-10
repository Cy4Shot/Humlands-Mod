package com.turtysproductions.humlands.core.datagen;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.datagen.generators.BlockStatesDataGen;
import com.turtysproductions.humlands.core.datagen.generators.BlockTagsDataGen;
import com.turtysproductions.humlands.core.datagen.generators.ItemModelsDataGen;
import com.turtysproductions.humlands.core.datagen.generators.ItemTagsDataGen;
import com.turtysproductions.humlands.core.datagen.generators.LanguagesDataGen;
import com.turtysproductions.humlands.core.datagen.generators.LootTablesDataGen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HumLandsDataGen {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			HumlandsMod.LOGGER.debug("Starting server side data generators");
			generator.addProvider(new LootTablesDataGen(generator));
			generator.addProvider(new BlockTagsDataGen(generator));
			generator.addProvider(new ItemTagsDataGen(generator));
		}

		if (event.includeClient()) {
			HumlandsMod.LOGGER.debug("Starting client side data generators");
			generator.addProvider(new BlockStatesDataGen(generator, HumlandsMod.MOD_ID, event.getExistingFileHelper()));
			generator.addProvider(new ItemModelsDataGen(generator, HumlandsMod.MOD_ID, event.getExistingFileHelper()));
			generator.addProvider(new LanguagesDataGen(generator, "en_us"));
		}
	}
}
