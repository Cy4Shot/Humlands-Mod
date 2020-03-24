package com.turtysproductions.humlands.core.world.dimension;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BiomeInit;
import com.turtysproductions.humlands.core.world.generator.VoronoiGenerator;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class HumlandsBiomeProvider extends BiomeProvider {
	private VoronoiGenerator biomeNoise;

	public HumlandsBiomeProvider(HumlandsBiomeProviderSettings genSettings) {
		super(biomeList);
		this.biomeNoise = new VoronoiGenerator(genSettings.getSeed(), 0);
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.FAR_HUMLANDS.get(),
			BiomeInit.DIRTY_HUMLANDS.get(), BiomeInit.BLUE_HUMLANDS_FOREST.get(), BiomeInit.GREEN_HUMLANDS_FOREST.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		double noiseVal = biomeNoise.noise(x, z, 0.2d);
		HumlandsMod.LOGGER.debug(noiseVal);
		if(noiseVal > 0.5) return BiomeInit.FAR_HUMLANDS.get();
		else if(noiseVal > 0) return BiomeInit.DIRTY_HUMLANDS.get();
		else if(noiseVal > -0.5) return BiomeInit.BLUE_HUMLANDS_FOREST.get();
		else return BiomeInit.GREEN_HUMLANDS_FOREST.get();
	}
}