package com.turtysproductions.humlands.common.world.dimension;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

public class HumlandsDimension extends Dimension {

	public HumlandsDimension(World worldIn, DimensionType typeIn) {
		super(worldIn, typeIn, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new HumlandsChunkGenerator(world, new HumlandsBiomeProvider(), new HumlandsGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		for (int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
			for (int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
				BlockPos blockPos = this.findSpawn(i, j, checkValid);
				if (blockPos != null) {
					return blockPos;
				}
			}
		}
		return null;
	}

	@Nullable
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		BlockPos.Mutable blockMutable = new BlockPos.Mutable(posX, 0, posZ);
		Biome biome = this.world.getBiome(blockMutable);
		BlockState blockstate = biome.getSurfaceBuilderConfig().getTop();
		if (checkValid && !blockstate.getBlock().isIn(BlockTags.VALID_SPAWN)) {
			return null;
		} else {
			Chunk chunk = this.world.getChunk(posX >> 4, posZ >> 4);
			int i = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, posX & 15, posZ & 15);
			if (i < 0) {
				return null;
			} else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, posX & 15, posZ & 15) > chunk
					.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, posX & 15, posZ & 15)) {
				return null;
			} else {
				for (int j = i + 1; j >= 0; --j) {
					blockMutable.setPos(posX, j, posZ);
					BlockState blockstate1 = this.world.getBlockState(blockMutable);
					if (!blockstate1.getFluidState().isEmpty()) {
						break;
					}
					if (blockstate1.equals(blockstate)) {
						return blockMutable.up().toImmutable();
					}
				}
				return null;
			}
		}
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return new Vec3d(0,0,0);
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}
}
