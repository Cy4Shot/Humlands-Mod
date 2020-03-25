package com.turtysproductions.humlands.core.world.dimension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.turtysproductions.humlands.core.init.BiomeInit;
import com.turtysproductions.humlands.core.world.generator.VoronoiGenerator;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class HumlandsBiomeProvider extends BiomeProvider {
	private VoronoiGenerator biomeNoise;
	double biomeSize = 32.0d;

	public HumlandsBiomeProvider(HumlandsBiomeProviderSettings genSettings) {
		super(biomeList);
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) genSettings.getSeed());
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.FAR_HUMLANDS.get(),
			BiomeInit.DIRTY_HUMLANDS.get(), BiomeInit.BLUE_HUMLANDS_FOREST.get(), BiomeInit.GREEN_HUMLANDS_FOREST.get(),
			BiomeInit.RUBBER_STREAMING_RUBBER_WOOD_FOREST.get());
	private static final List<Biome> allBiomes = Arrays.asList(BiomeInit.FAR_HUMLANDS.get(),
			BiomeInit.DIRTY_HUMLANDS.get(), BiomeInit.BLUE_HUMLANDS_FOREST.get(), BiomeInit.GREEN_HUMLANDS_FOREST.get(),
			BiomeInit.RUBBER_STREAMING_RUBBER_WOOD_FOREST.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(allBiomes,
				biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
	}

	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}
}