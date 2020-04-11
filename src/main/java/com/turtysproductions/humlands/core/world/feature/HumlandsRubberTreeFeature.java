package com.turtysproductions.humlands.core.world.feature;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class HumlandsRubberTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {
	
	int extra_log_chance;

	public HumlandsRubberTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config, int extra_log_chance) {
		super(config);
		this.extra_log_chance = extra_log_chance;
	}

	public boolean func_225557_a_(IWorldGenerationReader worldReader, Random rand, BlockPos pos, Set<BlockPos> set1,
			Set<BlockPos> set2, MutableBoundingBox mutableBoundingBox, TreeFeatureConfig config) {
		int i = config.baseHeight + rand.nextInt(config.heightRandA + 1) + rand.nextInt(config.heightRandB + 1);
		int j = config.trunkHeight >= 0 ? config.trunkHeight + rand.nextInt(config.trunkHeightRandom + 1)
				: i - (config.foliageHeight + rand.nextInt(config.foliageHeightRandom + 1));
		int k = config.foliagePlacer.func_225573_a_(rand, j, i, config);
		Optional<BlockPos> optional = this.func_227212_a_(worldReader, i, j, k, pos, config);
		if (!optional.isPresent())
			return false;
		else {
			BlockPos blockpos = optional.get();
			this.setDirtAt(worldReader, blockpos.down(), blockpos);
			config.foliagePlacer.func_225571_a_(worldReader, rand, config, i, j, k, blockpos, set2);
			this.func_227213_a_(worldReader, rand, i, blockpos,
					config.trunkTopOffset + rand.nextInt(config.trunkTopOffsetRandom + 1), set1, mutableBoundingBox,
					config);
			return true;
		}
	}

	@Override
	protected boolean func_227216_a_(IWorldGenerationReader worldReader, Random rand, BlockPos pos,
			Set<BlockPos> blockSet, MutableBoundingBox boundingBox, BaseTreeFeatureConfig config) {
		if (!isAirOrLeaves(worldReader, pos) && !isTallPlants(worldReader, pos) && !isWater(worldReader, pos))
			return false;
		else {
			this.func_227217_a_(worldReader, pos,
					rand.nextInt(extra_log_chance) == 0
							? BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get().getDefaultState()
							: BlockInit.RUBBER_WOOD_LOG.get().getDefaultState(),
					boundingBox);
			blockSet.add(pos.toImmutable());
			return true;
		}
	}
}
