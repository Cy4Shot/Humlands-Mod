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
import net.minecraft.world.gen.feature.template.GravityStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

public class RuinedLandsPileFeature extends Feature<NoFeatureConfig> {

	private static final ResourceLocation PILE_1 = new ResourceLocation("humlands:ruined_lands/pile/pile_1");
	private static final ResourceLocation PILE_2 = new ResourceLocation("humlands:ruined_lands/pile/pile_2");
	private static final ResourceLocation PILE_3 = new ResourceLocation("humlands:ruined_lands/pile/pile_3");
	private static final ResourceLocation[] PILES = new ResourceLocation[] { PILE_1, PILE_2, PILE_3 };

	public RuinedLandsPileFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		Random random = worldIn.getRandom();
		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
		Template template = ((ServerWorld) worldIn.getWorld()).getSaveHandler().getStructureTemplateManager()
				.getTemplateDefaulted(PILES[random.nextInt(PILES.length)]);
		ChunkPos chunkpos = new ChunkPos(pos);
		BlockPos blockpos = template.transformedSize(rotation);
		int j = random.nextInt(16 - blockpos.getX());
		int k = random.nextInt(16 - blockpos.getZ());
		template.addBlocksToWorld(worldIn,
				template.getZeroPositionWithTransform(new BlockPos(pos.getX() + j, pos.getY(), pos.getZ() + k),
						Mirror.NONE, rotation),
				(new PlacementSettings()).setRotation(rotation)
						.setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(),
								chunkpos.getXEnd(), 256, chunkpos.getZEnd()))
						.setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK)
						.addProcessor(new GravityStructureProcessor(Heightmap.Type.WORLD_SURFACE, 0)),
				4);
		return true;
	}
}
