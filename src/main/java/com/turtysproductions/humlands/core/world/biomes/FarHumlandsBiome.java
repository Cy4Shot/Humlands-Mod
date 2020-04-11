package com.turtysproductions.humlands.core.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FarHumlandsBiome extends Biome {

	public FarHumlandsBiome(Builder props) {
		super(props);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addGrassAndDeadBushes(this);
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
