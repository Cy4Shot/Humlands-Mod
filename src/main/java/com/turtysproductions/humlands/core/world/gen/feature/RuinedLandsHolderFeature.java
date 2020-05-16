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
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class RuinedLandsHolderFeature extends Feature<NoFeatureConfig> {

	private static final ResourceLocation HOLDER_1 = new ResourceLocation("humlands:ruined_lands/holder/holder_1");
	private static final ResourceLocation HOLDER_2 = new ResourceLocation("humlands:ruined_lands/holder/holder_2");
	private static final ResourceLocation HOLDER_3 = new ResourceLocation("humlands:ruined_lands/holder/holder_3");
	private static final ResourceLocation HOLDER_4 = new ResourceLocation("humlands:ruined_lands/holder/holder_4");

	private static final ResourceLocation[] HOLDERS = new ResourceLocation[] { HOLDER_1, HOLDER_2, HOLDER_3, HOLDER_4 };

	public RuinedLandsHolderFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		Random random = worldIn.getRandom();
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(HOLDERS[random.nextInt(HOLDERS.length)]);
		ChunkPos chunkpos = new ChunkPos(pos);
		BlockPos blockpos = template.transformedSize(Rotation.NONE);
		int j = random.nextInt(16 - blockpos.getX());
		int k = random.nextInt(16 - blockpos.getZ());
		int l = 256;
		for (int i1 = 0; i1 < blockpos.getX(); ++i1) {
			for (int j1 = 0; j1 < blockpos.getZ(); ++j1) {
				l = Math.min(l,
						worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + i1 + j, pos.getZ() + j1 + k));
			}
		}
		BlockPos blockpos1 = template.getZeroPositionWithTransform(
				new BlockPos(pos.add(j, 0, 0).getX(), l, pos.add(0, 0, k).getZ()), Mirror.NONE, Rotation.NONE);
		template.addBlocksToWorld(worldIn, blockpos1,
				(new PlacementSettings()).setRotation(Rotation.NONE)
						.setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(),
								chunkpos.getXEnd(), 256, chunkpos.getZEnd()))
						.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK),
				4);
		if (!worldIn.getBlockState(blockpos1.up().south().east()).getBlock().equals(Blocks.AIR)) {
			int r = random.nextInt(4);
			if (r == 0) {
				worldIn.setBlockState(blockpos1.up(2).south().east(), Blocks.CHEST.getDefaultState(), 2);
				LockableLootTileEntity.setLootTable(worldIn, rand, blockpos1.up(2).south().east(),
						LootTableInit.MOB_ROOM_CHEST);
			} else if (r == 1)
				worldIn.setBlockState(blockpos1.up(2).south().east(), Blocks.GOLD_BLOCK.getDefaultState(), 2);
			else if (r == 2) {
				worldIn.setBlockState(blockpos1.up(2).south().east(), Blocks.SPAWNER.getDefaultState(), 2);
				TileEntity tileentity = worldIn.getTileEntity(blockpos1.up(2).south().east());
				if (tileentity instanceof MobSpawnerTileEntity)
					((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic()
							.setEntityType(EntityTypesInit.MUMMY.get());
			} else
				worldIn.setBlockState(blockpos1.up(2).south().east(), Blocks.IRON_BLOCK.getDefaultState(), 2);
		}
		return true;
	}
}
