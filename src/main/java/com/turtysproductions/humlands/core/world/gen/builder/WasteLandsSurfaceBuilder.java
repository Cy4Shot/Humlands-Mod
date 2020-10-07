package com.turtysproductions.humlands.core.world.gen.builder;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class WasteLandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public WasteLandsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> config) {
		super(config);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(2);
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
				defaultFluid, seaLevel, seed,
				new SurfaceBuilderConfig(
						i == 1 ? BlockInit.SCRAP_SAND.get().getDefaultState()
								: BlockInit.WASTELAND_GRASS.get().getDefaultState(),
						BlockInit.WASTELAND_GRASS.get().getDefaultState(),
						BlockInit.SCRAP_SAND.get().getDefaultState()));
	}
}