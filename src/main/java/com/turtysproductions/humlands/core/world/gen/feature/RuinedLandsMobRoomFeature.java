package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.core.init.EntityTypesInit;
import com.turtysproductions.humlands.core.init.LootTableInit;

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

public class RuinedLandsMobRoomFeature extends Feature<NoFeatureConfig> {

	public RuinedLandsMobRoomFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		int l = 256;
		int height = 8;
		int j = rand.nextInt(2) + 5;
		int k1 = rand.nextInt(2) + 5;
		for (int i1 = 0; i1 < j * 2; ++i1) {
			for (int j1 = 0; j1 < k1 * 2; ++j1) {
				l = Math.min(l, worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + i1 + j * 2,
						pos.getZ() + j1 + k1 * 2));
			}
		}
		pos = new BlockPos(pos.getX(), l, pos.getZ());

		for (int k3 = -j - 1; k3 <= j + 1l; ++k3) {
			for (int i4 = height; i4 >= -1; --i4) {
				for (int k4 = -k1 - 1; k4 <= k1 + 1; ++k4) {
					BlockPos blockpos1 = pos.add(k3, i4, k4);
					if (!(k3 != -j - 1 && i4 != -1 && k4 != -k1 - 1 && k3 != j + 1 && i4 != height && k4 != k1 + 1)) {
						if (worldIn.getBlockState(blockpos1).getBlock() != Blocks.CHEST) {
							if (rand.nextInt(2) != 0)
								worldIn.setBlockState(blockpos1, Blocks.SANDSTONE.getDefaultState(), 2);
							else
								worldIn.setBlockState(blockpos1, Blocks.SMOOTH_SANDSTONE.getDefaultState(), 2);
						}
					} else if (worldIn.getBlockState(blockpos1).getBlock() != Blocks.CHEST
							&& worldIn.getBlockState(blockpos1).getBlock() != Blocks.TORCH)
						worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 2);
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
						LockableLootTileEntity.setLootTable(worldIn, rand, blockpos2, LootTableInit.MOB_ROOM_CHEST);
						break;
					}
				}
			}
		}

		worldIn.setBlockState(pos, Blocks.TORCH.getDefaultState(), 2);
		worldIn.setBlockState(pos.down(1), Blocks.SPAWNER.getDefaultState(), 2);
		TileEntity tileentity = worldIn.getTileEntity(pos.down(1));
		if (tileentity instanceof MobSpawnerTileEntity)
			((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic().setEntityType(EntityTypesInit.MUMMY.get());
		return true;
	}
}
