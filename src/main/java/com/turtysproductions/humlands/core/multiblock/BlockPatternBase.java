package com.turtysproductions.humlands.core.multiblock;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class BlockPatternBase {
	private BlockData[] data;
	private Block[] allowedBlocks;
	private BlockPos xyzBounds;

	public BlockPatternBase(BlockData[] data, Block[] allowedBlocks, BlockPos xyzBounds) {
		this.data = data;
		this.allowedBlocks = allowedBlocks;
		this.xyzBounds = xyzBounds;
	}

	public BlockData[] getData() {
		return data;
	}

	public Block[] getAllowedBlocks() {
		return allowedBlocks;
	}

	public int getXBound() {
		return xyzBounds.getX();
	}

	public int getYBound() {
		return xyzBounds.getY();
	}

	public int getZBound() {
		return xyzBounds.getZ();
	}
}
