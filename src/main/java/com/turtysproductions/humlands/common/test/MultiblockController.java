package com.turtysproductions.humlands.common.test;

import com.turtysproductions.humlands.core.init.TileEntityTypesInit;
import com.turtysproductions.humlands.core.multiblock.MultiblockControllerBlockBase;
import com.turtysproductions.humlands.core.multiblock.MultiblockTileEntityBase;

import net.minecraft.tileentity.TileEntityType;

public class MultiblockController extends MultiblockControllerBlockBase {

	public MultiblockController(Properties properties) {
		super(properties);
	}

	@Override
	public TileEntityType<? extends MultiblockTileEntityBase> getTileEntityType() {
		return TileEntityTypesInit.MULTIBLOCK_TILE_ENTITY.get();
	}

}
