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
		if (!(noise < -1.0D) && !(noise > 2.0D)) {
	         if (noise > 1.0D) {
	            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(CDIRT, DIRT, CDIRT));
	         } else {
	            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(BROWN_C, DIRT, CDIRT));
	         }
	      } else {
	         SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(GRASS, DIRT, CDIRT));
	      }
		BlockState TOP = null;
		switch(random.nextInt(3)) {
		case 0:
			TOP = GRASS;
		case 1:
			TOP = CDIRT;
		case 2:
			TOP = BROWN_C;
		}
	}
}
