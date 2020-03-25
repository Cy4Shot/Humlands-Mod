package com.turtysproductions.humlands.core.world.biomes.builder;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class HumlandsBlueForestSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	public HumlandsBlueForestSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51311_1_) {
		super(p_i51311_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
				defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(BlockInit.BLUE_FOREST_GRASS_BLOCK.get().getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()));
	}
}
