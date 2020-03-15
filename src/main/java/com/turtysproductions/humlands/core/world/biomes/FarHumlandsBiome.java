package com.turtysproductions.humlands.core.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FossilsFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FarHumlandsBiome extends Biome {

	public FarHumlandsBiome(Builder props) {
		super(props);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addGrassAndDeadBushes(this);
		this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION,
				new FossilsFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
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
