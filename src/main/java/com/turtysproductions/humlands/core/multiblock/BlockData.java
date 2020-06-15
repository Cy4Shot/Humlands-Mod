package com.turtysproductions.humlands.core.multiblock;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BlockData {
	public List<BlockState> allowedBlocks;
	public BlockPos pos;

	public BlockData(int x, int y, int z, List<BlockState> allowedBlocks) {
		this.allowedBlocks = allowedBlocks;
		this.pos = new BlockPos(x, y, z);
	}
}