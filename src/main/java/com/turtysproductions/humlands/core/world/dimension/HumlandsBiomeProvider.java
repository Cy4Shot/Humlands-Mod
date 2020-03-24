package com.turtysproductions.humlands.core.world.dimension;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.turtysproductions.humlands.core.init.BiomeInit;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.PerlinNoiseGenerator;

public class HumlandsBiomeProvider extends BiomeProvider {

	private HumlandsBiomeProviderSettings genSettings;
	private PerlinNoiseGenerator noise;
	private float biomeSize = 16.0f;

	public HumlandsBiomeProvider(HumlandsBiomeProviderSettings genSettings) {
		super(biomeList);
		this.genSettings = genSettings;
		this.noise = new PerlinNoiseGenerator(new SharedSeedRandom(this.genSettings.getSeed()), 3, -3);
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.FAR_HUMLANDS.get(),
			BiomeInit.DIRTY_HUMLANDS.get(), BiomeInit.BLUE_HUMLANDS_FOREST.get(), BiomeInit.GREEN_HUMLANDS_FOREST.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		double noiseVal = noise.noiseAt(((float)x)/biomeSize, ((float)z)/biomeSize, true);
		if(noiseVal > 0.3) return BiomeInit.FAR_HUMLANDS.get();
		else if(noiseVal > 0) return BiomeInit.DIRTY_HUMLANDS.get();
		else if(noiseVal > -0.3) return BiomeInit.BLUE_HUMLANDS_FOREST.get();
		else return BiomeInit.GREEN_HUMLANDS_FOREST.get();
	}
}