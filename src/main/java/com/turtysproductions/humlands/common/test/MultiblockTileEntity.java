package com.turtysproductions.humlands.common.test;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;
import com.turtysproductions.humlands.core.multiblock.BlockPatternBase;
import com.turtysproductions.humlands.core.multiblock.MultiblockTileEntityBase;

import net.minecraft.tileentity.TileEntityType;

public class MultiblockTileEntity extends MultiblockTileEntityBase {

	private MultiblockPattern pattern;

	public MultiblockTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		this.pattern = new MultiblockPattern();
	}

	public MultiblockTileEntity() {
		this(TileEntityTypesInit.MULTIBLOCK_TILE_ENTITY.get());
	}

	@Override
	public void tick() {
		HumlandsMod.LOGGER.debug(this.isFormedMultiBlock(this.pos));
	}

	@Override
	public BlockPatternBase getBlockPattern() {
		return pattern;
	}
}
