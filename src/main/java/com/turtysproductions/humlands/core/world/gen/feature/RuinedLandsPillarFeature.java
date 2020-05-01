package com.turtysproductions.humlands.core.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

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

public class RuinedLandsPillarFeature extends Feature<NoFeatureConfig> {

	private static final ResourceLocation PILLAR_1 = new ResourceLocation("humlands:ruined_lands/pillar/pillar_1");
	private static final ResourceLocation PILLAR_2 = new ResourceLocation("humlands:ruined_lands/pillar/pillar_2");
	private static final ResourceLocation[] PILLARS = new ResourceLocation[] { PILLAR_1, PILLAR_2};

	public RuinedLandsPillarFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		Random random = worldIn.getRandom();
		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(PILLARS[random.nextInt(PILLARS.length)]);
		ChunkPos chunkpos = new ChunkPos(pos);
		PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
				.setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(),
						chunkpos.getXEnd(), 256, chunkpos.getZEnd()))
				.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
		BlockPos blockpos = template.transformedSize(rotation);
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
				new BlockPos(pos.add(j, 0, 0).getX(), l, pos.add(0, 0, k).getZ()), Mirror.NONE, rotation);
		template.addBlocksToWorld(worldIn, blockpos1, placementsettings, 4);
		return true;
	}
}
