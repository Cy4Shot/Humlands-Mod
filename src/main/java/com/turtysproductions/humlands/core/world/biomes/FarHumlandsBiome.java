package com.turtysproductions.humlands.core.world.biomes;

import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FarHumlandsBiome extends HumlandsBaseBiome {

	public FarHumlandsBiome(Builder props) {
		super(props);
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
	
	@Override
	public int getSkyColor() {
		return 0xC8AC4D;
	}
}
