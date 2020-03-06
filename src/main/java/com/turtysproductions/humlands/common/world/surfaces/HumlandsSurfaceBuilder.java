package com.turtysproductions.humlands.common.world.surfaces;

import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class HumlandsSurfaceBuilder {
	public static final SurfaceBuilderConfig WASTELAND_PLATEAU = new SurfaceBuilderConfig(BlockInit.SCRAP_SAND.get().getDefaultState(), BlockInit.SCRAP_SANDSTONE.get().getDefaultState(), Blocks.GRAVEL.getDefaultState());
}
