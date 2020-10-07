package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.world.gen.ModBiomeFeatures;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class WasteLandsBiome extends HumlandsBaseBiome {

	public WasteLandsBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		ModBiomeFeatures.addDeadTrees(this, 1);
		DefaultBiomeFeatures.addGrass(this);
		ModBiomeFeatures.addCustomRocks(this, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5);
		ModBiomeFeatures.addCustomRocks(this, BlockInit.SCRAP_SAND.get().getDefaultState(), 5);
		ModBiomeFeatures.addSandbergs(this, BlockInit.SCRAP_SAND.get().getDefaultState(), 3);
		ModBiomeFeatures.addOreClump(this, BlockInit.FLUX_ORE_CLUMP.get().getDefaultState(), 6);
	}
	
	@Override
	public int getSkyColor() {
		return 0x96E3B7;
	}
}
