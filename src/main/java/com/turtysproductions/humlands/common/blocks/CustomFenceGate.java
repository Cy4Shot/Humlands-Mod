package com.turtysproductions.humlands.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CustomFenceGate extends FenceGateBlock {

	public CustomFenceGate(Properties properties) {
		super(properties);

	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face){
		return 20;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face){
		return 5;
	}
}
