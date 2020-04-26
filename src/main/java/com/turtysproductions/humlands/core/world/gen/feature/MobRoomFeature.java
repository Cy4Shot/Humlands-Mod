package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.EntityTypesInit;

import net.minecraft.block.Blocks;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.storage.loot.LootTables;

public class MobRoomFeature extends Feature<NoFeatureConfig> {

	public MobRoomFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		pos = new BlockPos(pos.getX(), worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ()),
				pos.getZ());

		int j = rand.nextInt(2) + 2;
		int k1 = rand.nextInt(2) + 2;

		for (int k3 = -j - 1; k3 <= j + 1l; ++k3) {
			for (int i4 = 3; i4 >= -1; --i4) {
				for (int k4 = -k1 - 1; k4 <= k1 + 1; ++k4) {
					BlockPos blockpos1 = pos.add(k3, i4, k4);
					if (k3 != -j - 1 && i4 != -1 && k4 != -k1 - 1 && k3 != j + 1 && i4 != 4 && k4 != k1 + 1) {
						if (worldIn.getBlockState(blockpos1).getBlock() != Blocks.CHEST)
							worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 2);
					} else if (blockpos1.getY() >= 0
							&& !worldIn.getBlockState(blockpos1.down()).getMaterial().isSolid())
						worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 2);
					else if (worldIn.getBlockState(blockpos1).getBlock() != Blocks.CHEST) {
						if (i4 == -1 && rand.nextInt(4) != 0)
							worldIn.setBlockState(blockpos1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 2);
						else
							worldIn.setBlockState(blockpos1, Blocks.COBBLESTONE.getDefaultState(), 2);
					}
				}
			}
		}

		for (int l3 = 0; l3 < 2; ++l3) {
			for (int j4 = 0; j4 < 3; ++j4) {
				BlockPos blockpos2 = new BlockPos(pos.getX() + rand.nextInt(j * 2 + 1) - j, pos.getY(),
						pos.getZ() + rand.nextInt(k1 * 2 + 1) - k1);
				if (worldIn.isAirBlock(blockpos2)) {
					int j3 = 0;

					for (Direction direction : Direction.Plane.HORIZONTAL)
						if (worldIn.getBlockState(blockpos2.offset(direction)).getMaterial().isSolid())
							++j3;

					if (j3 == 1) {
						worldIn.setBlockState(blockpos2,
								StructurePiece.func_197528_a(worldIn, blockpos2, Blocks.CHEST.getDefaultState()), 2);
						LockableLootTileEntity.setLootTable(worldIn, rand, blockpos2, LootTables.CHESTS_SIMPLE_DUNGEON);
						break;
					}
				}
			}
		}

		worldIn.setBlockState(pos, Blocks.SPAWNER.getDefaultState(), 2);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof MobSpawnerTileEntity) {
			((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic()
					.setEntityType(EntityTypesInit.HUMADILLO.get());
		} else
			HumlandsMod.LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
