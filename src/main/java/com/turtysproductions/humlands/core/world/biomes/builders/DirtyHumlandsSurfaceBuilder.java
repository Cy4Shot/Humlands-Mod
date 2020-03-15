package com.turtysproductions.humlands.core.world.biomes.builders;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DirtyHumlandsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
	private static final BlockState GRASS = Blocks.GRASS_BLOCK.getDefaultState();
	private static final BlockState CDIRT = Blocks.COARSE_DIRT.getDefaultState();
	private static final BlockState BROWN_C = Blocks.BROWN_CONCRETE_POWDER.getDefaultState();
	private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
	
	public DirtyHumlandsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51311_1_) {
	      super(p_i51311_1_);
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		BlockState TOP = null;
		switch(random.nextInt(3)) {
		case 1:
			TOP = CDIRT;
		case 2:
			TOP = BROWN_C;
		default:
			TOP = GRASS;
		}
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(TOP, DIRT, CDIRT));
	}
}
