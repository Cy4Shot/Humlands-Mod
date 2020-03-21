package com.turtysproductions.humlands.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class OreClump extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public OreClump(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	public static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6, 0, 11, 7, 1, 12),
			Block.makeCuboidShape(5, 0, 5, 11, 6, 11), Block.makeCuboidShape(5, 0, 2, 8, 3, 5),
			Block.makeCuboidShape(11, 0, 6, 14, 3, 9), Block.makeCuboidShape(3, 0, 4, 5, 2, 6),
			Block.makeCuboidShape(10, 0, 3, 12, 2, 5), Block.makeCuboidShape(11, 0, 9, 13, 2, 11),
			Block.makeCuboidShape(7, 0, 11, 9, 2, 13), Block.makeCuboidShape(3, 0, 10, 5, 2, 12),
			Block.makeCuboidShape(4, 0, 6, 5, 1, 7), Block.makeCuboidShape(4, 0, 9, 5, 1, 10),
			Block.makeCuboidShape(12, 0, 4, 13, 1, 5), Block.makeCuboidShape(8, 0, 4, 9, 1, 5),
			Block.makeCuboidShape(10, 0, 11, 11, 1, 12), Block.makeCuboidShape(5, 0, 11, 6, 1, 12)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(9, 0, 4, 10, 1, 5),
			Block.makeCuboidShape(5, 0, 5, 11, 6, 11), Block.makeCuboidShape(8, 0, 11, 11, 3, 14),
			Block.makeCuboidShape(2, 0, 7, 5, 3, 10), Block.makeCuboidShape(11, 0, 10, 13, 2, 12),
			Block.makeCuboidShape(4, 0, 11, 6, 2, 13), Block.makeCuboidShape(3, 0, 5, 5, 2, 7),
			Block.makeCuboidShape(7, 0, 3, 9, 2, 5), Block.makeCuboidShape(11, 0, 4, 13, 2, 6),
			Block.makeCuboidShape(11, 0, 9, 12, 1, 10), Block.makeCuboidShape(11, 0, 6, 12, 1, 7),
			Block.makeCuboidShape(3, 0, 11, 4, 1, 12), Block.makeCuboidShape(7, 0, 11, 8, 1, 12),
			Block.makeCuboidShape(5, 0, 4, 6, 1, 5), Block.makeCuboidShape(10, 0, 4, 11, 1, 5)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(4, 0, 6, 5, 1, 7),
			Block.makeCuboidShape(5, 0, 5, 11, 6, 11), Block.makeCuboidShape(11, 0, 5, 14, 3, 8),
			Block.makeCuboidShape(7, 0, 11, 10, 3, 14), Block.makeCuboidShape(10, 0, 3, 12, 2, 5),
			Block.makeCuboidShape(11, 0, 10, 13, 2, 12), Block.makeCuboidShape(5, 0, 11, 7, 2, 13),
			Block.makeCuboidShape(3, 0, 7, 5, 2, 9), Block.makeCuboidShape(4, 0, 3, 6, 2, 5),
			Block.makeCuboidShape(9, 0, 4, 10, 1, 5), Block.makeCuboidShape(6, 0, 4, 7, 1, 5),
			Block.makeCuboidShape(11, 0, 12, 12, 1, 13), Block.makeCuboidShape(11, 0, 8, 12, 1, 9),
			Block.makeCuboidShape(4, 0, 10, 5, 1, 11), Block.makeCuboidShape(4, 0, 5, 5, 1, 6)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(11, 0, 9, 12, 1, 10),
			Block.makeCuboidShape(5, 0, 5, 11, 6, 11), Block.makeCuboidShape(2, 0, 8, 5, 3, 11),
			Block.makeCuboidShape(6, 0, 2, 9, 3, 5), Block.makeCuboidShape(4, 0, 11, 6, 2, 13),
			Block.makeCuboidShape(3, 0, 4, 5, 2, 6), Block.makeCuboidShape(9, 0, 3, 11, 2, 5),
			Block.makeCuboidShape(11, 0, 7, 13, 2, 9), Block.makeCuboidShape(10, 0, 11, 12, 2, 13),
			Block.makeCuboidShape(6, 0, 11, 7, 1, 12), Block.makeCuboidShape(9, 0, 11, 10, 1, 12),
			Block.makeCuboidShape(4, 0, 3, 5, 1, 4), Block.makeCuboidShape(4, 0, 7, 5, 1, 8),
			Block.makeCuboidShape(11, 0, 5, 12, 1, 6), Block.makeCuboidShape(11, 0, 10, 12, 1, 11)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		return false;
	}

	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}
}
