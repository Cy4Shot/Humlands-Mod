package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
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

public class LumberMillFeature extends Feature<NoFeatureConfig> {

	private static final ResourceLocation STRUCTURE_LUMBER_MILL_1 = new ResourceLocation(
			"humlands:lumbermill/lumber_mill");

	private static final ResourceLocation[] LUMBER_MILLS = new ResourceLocation[] { STRUCTURE_LUMBER_MILL_1 };

	public LumberMillFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49873_1_) {
		super(p_i49873_1_);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		Random random = worldIn.getRandom();
		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(LUMBER_MILLS[random.nextInt(LUMBER_MILLS.length)]);
		BlockPos blockpos = template.transformedSize(rotation);
		int j = random.nextInt(32 - 0);
		int k = random.nextInt(32 - 0);
		int l = 256;
		for (int i1 = 0; i1 < blockpos.getX(); ++i1) {
			for (int j1 = 0; j1 < blockpos.getZ(); ++j1) {
				l = Math.min(l,
						worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX() + i1 + j, pos.getZ() + j1 + k));
			}
		}
		HumlandsMod.LOGGER.debug(new BlockPos(pos.getX() + j, l, pos.getZ() + k));
		template.addBlocksToWorld(worldIn,
				template.getZeroPositionWithTransform(new BlockPos(pos.getX() + j, l, pos.getZ() + k), Mirror.NONE,
						rotation),
				(new PlacementSettings()).setRotation(rotation).setRandom(random)
						.addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK),
				4);
		return true;

	}
}
