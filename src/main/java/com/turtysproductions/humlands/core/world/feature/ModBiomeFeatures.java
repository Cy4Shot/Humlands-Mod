package com.turtysproductions.humlands.core.world.feature;

import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {

	public static void addRubberTrees(Biome biomeIn, int steam_chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				new HumlandsRubberTreeFeature(TreeFeatureConfig::func_227338_a_, steam_chance)
						.withConfiguration((new TreeFeatureConfig.Builder(
								new SimpleBlockStateProvider(BlockInit.RUBBER_WOOD_LOG.get().getDefaultState()),
								new SimpleBlockStateProvider(BlockInit.RUBBER_LEAVES.get().getDefaultState()),
								new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(3)
										.ignoreVines().build())
						.withPlacement(
								Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addOvergroundFossils(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				new HumlandsFossilFeature(NoFeatureConfig::deserialize)
						.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	public static void addCustomRocks(Biome biomeIn, BlockState block, int frequency) {
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(block, 0))
						.withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(frequency))));
	}

	public static void addOreClump(Biome biomeIn, BlockState block, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				new HumlandsOreClumpFeature(BlockClusterFeatureConfig::func_227300_a_)
						.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block),
								new SimpleBlockPlacer())).tries(64).func_227317_b_().build())
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(8))));
	}

	public static void addPonds(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new RubberForestPondFeature(NoFeatureConfig::deserialize)
						.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	public static void addLumberMills(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new LumberMillFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

}
