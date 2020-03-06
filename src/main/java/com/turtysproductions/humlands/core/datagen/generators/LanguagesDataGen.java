package com.turtysproductions.humlands.core.datagen.generators;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguagesDataGen extends LanguageProvider {
	public LanguagesDataGen(DataGenerator gen, String locale) {
		super(gen, HumlandsMod.MOD_ID, locale);
	}

	@Override
	protected void addTranslations() {
		add("item.humlands.test_item", "Test Item");
		add("block.humlands.test_block", "Test Block");

		add("block.humlands.scrap_sand", "Scrap Sand");
		add("block.humlands.scrap_sandstone", "Scrap Sandstone");
		add("block.humlands.scrap_glass", "Scrap Glass");
		add("blocks.humlands.sifter", "Sifter");

		add("item.humlands.royal_slime", "Royal Slime");
		add("item.humlands.royal_flan_raw", "Raw Royal Flan");
		add("item.humlands.royal_flan", "Royal Flan");
		add("item.humlands.super_royal_slime", "Super Royal Slime");
		add("item.humlands.super_royal_flan_raw", "Super Raw Royal Flan");
		add("item.humlands.super_royal_flan", "Super Royal Flan");
	}

	@Override
	public String getName() {
		return "Humlands Mod - Languages";
	}
}