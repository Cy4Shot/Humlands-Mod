package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.feature.ModBiomeFeatures;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DirtyHumlandsBiome extends Biome{
	public DirtyHumlandsBiome(Builder props) {
		super(props);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addDenseGrass(this);
		ModBiomeFeatures.addOvergroundFossils(this, 6);
		ModBiomeFeatures.addCustomRocks(this, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3);
	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 203212166;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		return 9470285;
	} 
}
