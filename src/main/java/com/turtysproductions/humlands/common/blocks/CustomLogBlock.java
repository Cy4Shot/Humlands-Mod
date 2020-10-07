package com.turtysproductions.humlands.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CustomLogBlock extends LogBlock {

	public CustomLogBlock(MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face){
		return 5;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face){
		return 5;
	}
}
