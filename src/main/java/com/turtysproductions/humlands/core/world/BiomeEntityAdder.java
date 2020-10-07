package com.turtysproductions.humlands.core.world;

import com.turtysproductions.humlands.core.init.BiomeInit;
import com.turtysproductions.humlands.core.init.EntityTypesInit;
import com.turtysproductions.humlands.core.world.biomes.HumlandsBaseBiome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class BiomeEntityAdder {
	public static void addEntitiesToBiomes() {
		BiomeInit.BIOMES.getEntries().stream().map(RegistryObject::get).forEach(biome -> {
			//Add new entity spawning here:
			//Example is shown below
			if (biome.equals(BiomeInit.RUINED_LANDS.get()))
				((HumlandsBaseBiome) biome).addCustomSpawn(EntityClassification.AMBIENT,
						new Biome.SpawnListEntry(EntityTypesInit.HUMBLEWEED.get(), 8, 3, 10));
		});
	}
}
