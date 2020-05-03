package com.turtysproductions.humlands.core.world.gen.builder;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class RuinedLandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public RuinedLandsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> config) {
		super(config);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(2);
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
				defaultFluid, seaLevel, seed,
				new SurfaceBuilderConfig(i == 1 ? Blocks.SANDSTONE.getDefaultState() : Blocks.SAND.getDefaultState(),
						Blocks.SAND.getDefaultState(), Blocks.SANDSTONE.getDefaultState()));
	}
}