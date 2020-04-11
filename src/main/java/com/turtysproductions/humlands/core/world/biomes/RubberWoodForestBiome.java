package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.feature.ModBiomeFeatures;

import net.minecraft.world.biome.Biome;

public class RubberWoodForestBiome extends Biome {

	public RubberWoodForestBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		ModBiomeFeatures.addPonds(this, 70);
		ModBiomeFeatures.addRubberTrees(this, 40);
		ModBiomeFeatures.addLumberMills(this, 200);
	}

	@Override
	public int getSkyColor() {
		return 0x0AA9AE;
	}
}
