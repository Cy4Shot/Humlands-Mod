package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.feature.ModBiomeFeatures;

import net.minecraft.world.biome.Biome;

public class RubberWoodForestBiome extends Biome {

	public RubberWoodForestBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		ModBiomeFeatures.addRubberTrees(this, 40);
	}
}
