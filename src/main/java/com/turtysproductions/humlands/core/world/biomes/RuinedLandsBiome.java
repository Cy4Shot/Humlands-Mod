package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.gen.ModBiomeFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class RuinedLandsBiome extends Biome {

	public RuinedLandsBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		DefaultBiomeFeatures.addDeadBushes(this);
		ModBiomeFeatures.addRuinedLands(this);
	}

	@Override
	public int getSkyColor() {
		return 0x0AA9AE;
	}
}
