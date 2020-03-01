package com.turtysproductions.humlands.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

public class HumlandsBiomeProvider extends BiomeProvider {

	private Random rand;

	public HumlandsBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(Biomes.PLAINS);

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return Biomes.PLAINS;
	}
}