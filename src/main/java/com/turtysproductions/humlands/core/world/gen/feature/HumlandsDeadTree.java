package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;

import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class HumlandsDeadTree extends Tree {

	public static final TreeFeatureConfig DEAD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.DEAD_WOOD_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.DEAD_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0)))
					.baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().build();
	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(DEAD_TREE_CONFIG);
	}
}
