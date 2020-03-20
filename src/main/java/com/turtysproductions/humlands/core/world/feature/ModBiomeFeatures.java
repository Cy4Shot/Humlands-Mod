package com.turtysproductions.humlands.core.world.feature;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {
	public static void addOvergroundFossils(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				new HumlandsFossilFeature(NoFeatureConfig::deserialize)
						.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(6))));
	}
}
