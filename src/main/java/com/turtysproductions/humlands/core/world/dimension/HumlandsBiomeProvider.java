package com.turtysproductions.humlands.core.world.dimension;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.turtysproductions.humlands.core.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class HumlandsBiomeProvider extends BiomeProvider {

	private Random rand;

	public HumlandsBiomeProvider() {
		super(biomeList);
		rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.WASTELAND.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.WASTELAND.get();
	}
}