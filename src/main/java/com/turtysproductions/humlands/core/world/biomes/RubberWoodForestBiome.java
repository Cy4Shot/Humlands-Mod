package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.gen.ModBiomeFeatures;

import net.minecraft.world.biome.DefaultBiomeFeatures;

public class RubberWoodForestBiome extends HumlandsBaseBiome {

	public RubberWoodForestBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		ModBiomeFeatures.addPonds(this, 70);
		ModBiomeFeatures.addRubberTrees(this, 40);
		ModBiomeFeatures.addLumberMills(this, 200);
		DefaultBiomeFeatures.addGrass(this);
	}

	@Override
	public int getSkyColor() {
		return 0x0AA9AE;
	}
}
