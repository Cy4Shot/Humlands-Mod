package com.turtysproductions.humlands.core.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HumlandsGreenForestBiome extends Biome {

	public HumlandsGreenForestBiome(Builder props) {
		super(props);
		DefaultBiomeFeatures.addDenseGrass(this);
	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 0xFFC586;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		return 0x90814D;
	}
}
