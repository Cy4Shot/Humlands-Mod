package com.turtysproductions.humlands.common.test;

import java.util.Arrays;
import java.util.List;

import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.multiblock.BlockData;
import com.turtysproductions.humlands.core.multiblock.BlockPatternBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class MultiblockPattern extends BlockPatternBase {

	private static List<BlockState> frameBlocks = Arrays.asList(BlockInit.MULTIBLOCK_PART.get().getDefaultState());
	private static List<BlockState> controllerBlocks = Arrays
			.asList(BlockInit.MULTIBLOCK_CONTROLLER.get().getDefaultState());

	private static BlockData[] data = { new BlockData(0, 0, 0, frameBlocks), new BlockData(0, 1, 0, frameBlocks),
			new BlockData(0, 2, 0, frameBlocks), new BlockData(1, 0, 0, frameBlocks),
			new BlockData(1, 1, 0, controllerBlocks), new BlockData(1, 2, 0, frameBlocks),
			new BlockData(2, 0, 0, frameBlocks), new BlockData(2, 1, 0, frameBlocks),
			new BlockData(2, 2, 0, frameBlocks) };

	private static Block[] allowedBlocks = { BlockInit.MULTIBLOCK_CONTROLLER.get(), BlockInit.MULTIBLOCK_PART.get() };

	public MultiblockPattern() {
		super(data, allowedBlocks, new BlockPos(2, 2, 0));
	}
}
