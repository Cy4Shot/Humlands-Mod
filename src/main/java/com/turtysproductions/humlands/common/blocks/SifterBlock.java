package com.turtysproductions.humlands.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class SifterBlock extends Block {

	public static final VoxelShape SHAPE_DEFAULT = Stream.of(Block.makeCuboidShape(4, 24, 2, 12, 25, 12),
			Block.makeCuboidShape(7, 25, -1, 10, 27, 10), Block.makeCuboidShape(6, 3, 12, 9, 6, 27),
			Block.makeCuboidShape(0, 0, 0, 16, 11, 16), Block.makeCuboidShape(7, 13, 4, 10, 29, 7),
			Block.makeCuboidShape(6, 6, 25, 9, 19, 27), Block.makeCuboidShape(4, 27, 3, 12, 28, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public SifterBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_DEFAULT;
	}
}
