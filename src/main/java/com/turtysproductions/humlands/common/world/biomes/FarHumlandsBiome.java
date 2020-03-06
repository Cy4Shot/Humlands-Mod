package com.turtysproductions.humlands.common.world.biomes;

import com.turtysproductions.humlands.common.init.BlockInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FarHumlandsBiome extends Biome {

	public FarHumlandsBiome(Builder props) {
		super(props);
		BlockInit.SCRAP_GLASS.get().getDefaultState();
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addGrassAndDeadBushes(this);
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.CAT, 50, 10, 100));
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
