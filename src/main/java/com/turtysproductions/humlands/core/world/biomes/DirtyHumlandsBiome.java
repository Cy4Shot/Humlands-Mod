package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.world.gen.ModBiomeFeatures;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DirtyHumlandsBiome extends HumlandsBaseBiome {
	
	public DirtyHumlandsBiome(Builder props) {
		super(props);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addDenseGrass(this);
		ModBiomeFeatures.addOvergroundFossils(this, 6);
		ModBiomeFeatures.addCustomRocks(this, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3);
		ModBiomeFeatures.addOreClump(this, BlockInit.COAL_ORE_CLUMP.get().getDefaultState(), 2);
		ModBiomeFeatures.addOreClump(this, BlockInit.IRON_ORE_CLUMP.get().getDefaultState(), 3);
		ModBiomeFeatures.addOreClump(this, BlockInit.GOLD_ORE_CLUMP.get().getDefaultState(), 4);
		ModBiomeFeatures.addOreClump(this, BlockInit.REDSTONE_ORE_CLUMP.get().getDefaultState(), 3);
		ModBiomeFeatures.addOreClump(this, BlockInit.LAPIS_ORE_CLUMP.get().getDefaultState(), 3);
		ModBiomeFeatures.addOreClump(this, BlockInit.FLUX_ORE_CLUMP.get().getDefaultState(), 5);
	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 0xFFC586;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		return 0x90814D;
	}
	
	@Override
	public int getSkyColor() {
		return 0xB9A382;
	}
}
