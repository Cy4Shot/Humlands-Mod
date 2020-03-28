package com.turtysproductions.humlands.core.world.dimension;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.turtysproductions.humlands.core.init.BiomeInit;
import com.turtysproductions.humlands.core.world.generator.VoronoiGenerator;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraftforge.fml.RegistryObject;

public class HumlandsBiomeProvider extends BiomeProvider {

	private static final Set<Biome> biomeList = new HashSet<>();

	private VoronoiGenerator biomeNoise;
	double biomeSize = 32.0d;

	public HumlandsBiomeProvider(HumlandsBiomeProviderSettings genSettings) {
		super(biomeList);
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) genSettings.getSeed());
		BiomeInit.BIOMES.getEntries().stream().map(RegistryObject::get).forEach(biome -> {
			biomeList.add(biome);
		});
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(new LinkedList<Biome>(biomeList),
				biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
	}

	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1) return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}
}