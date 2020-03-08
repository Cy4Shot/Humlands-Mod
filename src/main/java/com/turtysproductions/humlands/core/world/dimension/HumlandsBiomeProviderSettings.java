package com.turtysproductions.humlands.core.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class HumlandsBiomeProviderSettings implements IBiomeProviderSettings {
	private final long seed;
	private final WorldType worldType;
	private HumlandsGenSettings generatorSettings = new HumlandsGenSettings();

	public HumlandsBiomeProviderSettings(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public HumlandsBiomeProviderSettings setGeneratorSettings(HumlandsGenSettings settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public HumlandsGenSettings getGeneratorSettings() {
		return this.generatorSettings;
	}
}
