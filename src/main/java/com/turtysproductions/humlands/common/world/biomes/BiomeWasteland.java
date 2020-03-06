package com.turtysproductions.humlands.common.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BiomeWasteland extends Biome {

	public BiomeWasteland(Builder props) {
		super(props);
		DefaultBiomeFeatures.addSavannaTrees(this);
	    this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 2, 4, 4));
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public int getSkyColor() {
		return 0xB9A08A;
	}

	@OnlyIn(Dist.CLIENT)
	public int getFogColor(float celestialAngle, float partialTicks) {
		return 0xB9A08A;
	}
	
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}
	

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 0x795C32;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		return 0xaca801;
	}
}
