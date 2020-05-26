package com.turtysproductions.humlands.core.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;

public class HumlandsBaseBiome extends Biome {

	protected HumlandsBaseBiome(Builder biomeBuilder) {
		super(biomeBuilder);
	}

	public void addCustomSpawn(EntityClassification type, SpawnListEntry spawnListEntry) {
		this.addSpawn(type, spawnListEntry);
	}
}
