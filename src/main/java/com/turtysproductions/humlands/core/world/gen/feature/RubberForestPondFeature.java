package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.GravityStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class RubberForestPondFeature extends Feature<NoFeatureConfig> {

	private static final ResourceLocation STRUCTURE_POND_1 = new ResourceLocation("humlands:pond/pond_1");
	private static final ResourceLocation STRUCTURE_POND_2 = new ResourceLocation("humlands:pond/pond_2");

	private static final ResourceLocation[] PONDS = new ResourceLocation[] { STRUCTURE_POND_1, STRUCTURE_POND_2,

	};

	public RubberForestPondFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49873_1_) {
		super(p_i49873_1_);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		Random random = worldIn.getRandom();
		Rotation[] arotation = Rotation.values();
		Rotation rotation = arotation[random.nextInt(arotation.length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(PONDS[random.nextInt(PONDS.length)]);
		BlockPos blockpos = template.transformedSize(rotation);
		int j = random.nextInt(20 - 0);
		int k = random.nextInt(20 - 0);
		int l = 256;
		for (int i1 = 0; i1 < blockpos.getX(); ++i1) {
			for (int j1 = 0; j1 < blockpos.getZ(); ++j1) {
				l = Math.min(l, worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ()));
			}
		}
		template.addBlocksToWorld(worldIn,
				template.getZeroPositionWithTransform(new BlockPos(pos.add(j, 0, k).getX(), l, pos.add(j, 0, k).getZ()),
						Mirror.NONE, rotation),
				(new PlacementSettings()).setRotation(rotation)
						.setBoundingBox(
								new MutableBoundingBox((0 - 25600), (0 - 25600), (0 - 25600), 25600, 256, 25600))
						.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK)
						.addProcessor(new GravityStructureProcessor(Heightmap.Type.WORLD_SURFACE_WG, 0)),
				4);
		return true;

	}
}
