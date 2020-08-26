package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.gen.ModBiomeFeatures;

import net.minecraft.world.biome.DefaultBiomeFeatures;

public class WasteLandsBiome extends HumlandsBaseBiome {

	public WasteLandsBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		ModBiomeFeatures.addPonds(this, 80);
		ModBiomeFeatures.addDeadTrees(this, 1);
		DefaultBiomeFeatures.addGrass(this);
	}
	
	@Override
	public int getSkyColor() {
		return 0x96E3B7;
	}
}
