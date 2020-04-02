package com.turtysproductions.humlands.core.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class HumlandsOreClumpFeature extends Feature<BlockClusterFeatureConfig> {
	public HumlandsOreClumpFeature(Function<Dynamic<?>, ? extends BlockClusterFeatureConfig> config) {
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, BlockClusterFeatureConfig config) {
		worldIn.setBlockState(new BlockPos(pos.getX(),
				worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ()), pos.getZ()),
				config.stateProvider.getBlockState(rand, pos), 4);
		return true;
	}
}