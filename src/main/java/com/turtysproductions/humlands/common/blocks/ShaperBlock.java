package com.turtysproductions.humlands.common.blocks;

import java.util.stream.Stream;

import com.turtysproductions.humlands.core.init.NullBlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
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
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class ShaperBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6, 15, 7, 10, 17, 11),
			Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 28, 0, 16, 32, 16),
			Block.makeCuboidShape(5, 4, 11, 11, 28, 15), Block.makeCuboidShape(2, 27, 2, 14, 28, 9),
			Block.makeCuboidShape(2, 4, 2, 14, 5, 9), Block.makeCuboidShape(5, 15, 1, 11, 17, 3),
			Block.makeCuboidShape(4, 15, 2, 5, 17, 3), Block.makeCuboidShape(11, 15, 2, 12, 17, 3),
			Block.makeCuboidShape(5, 15, 7, 6, 17, 8), Block.makeCuboidShape(4, 15, 3, 6, 17, 7),
			Block.makeCuboidShape(10, 15, 7, 11, 17, 8), Block.makeCuboidShape(10, 15, 3, 12, 17, 7))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(6, 15, 5, 10, 17, 9),
			Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 28, 0, 16, 32, 16),
			Block.makeCuboidShape(5, 4, 1, 11, 28, 5), Block.makeCuboidShape(2, 27, 7, 14, 28, 14),
			Block.makeCuboidShape(2, 4, 7, 14, 5, 14), Block.makeCuboidShape(5, 15, 13, 11, 17, 15),
			Block.makeCuboidShape(11, 15, 13, 12, 17, 14), Block.makeCuboidShape(4, 15, 13, 5, 17, 14),
			Block.makeCuboidShape(10, 15, 8, 11, 17, 9), Block.makeCuboidShape(10, 15, 9, 12, 17, 13),
			Block.makeCuboidShape(5, 15, 8, 6, 17, 9), Block.makeCuboidShape(4, 15, 9, 6, 17, 13)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(7, 15, 6, 11, 17, 10),
			Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 28, 0, 16, 32, 16),
			Block.makeCuboidShape(11, 4, 5, 15, 28, 11), Block.makeCuboidShape(2, 27, 2, 9, 28, 14),
			Block.makeCuboidShape(2, 4, 2, 9, 5, 14), Block.makeCuboidShape(1, 15, 5, 3, 17, 11),
			Block.makeCuboidShape(2, 15, 11, 3, 17, 12), Block.makeCuboidShape(2, 15, 4, 3, 17, 5),
			Block.makeCuboidShape(7, 15, 10, 8, 17, 11), Block.makeCuboidShape(3, 15, 10, 7, 17, 12),
			Block.makeCuboidShape(7, 15, 5, 8, 17, 6), Block.makeCuboidShape(3, 15, 4, 7, 17, 6)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	public static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(5, 15, 6, 9, 17, 10),
			Block.makeCuboidShape(0, 0, 0, 16, 4, 16), Block.makeCuboidShape(0, 28, 0, 16, 32, 16),
			Block.makeCuboidShape(1, 4, 5, 5, 28, 11), Block.makeCuboidShape(7, 27, 2, 14, 28, 14),
			Block.makeCuboidShape(7, 4, 2, 14, 5, 14), Block.makeCuboidShape(13, 15, 5, 15, 17, 11),
			Block.makeCuboidShape(13, 15, 4, 14, 17, 5), Block.makeCuboidShape(13, 15, 11, 14, 17, 12),
			Block.makeCuboidShape(8, 15, 5, 9, 17, 6), Block.makeCuboidShape(9, 15, 4, 13, 17, 6),
			Block.makeCuboidShape(8, 15, 10, 9, 17, 11), Block.makeCuboidShape(9, 15, 10, 13, 17, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public ShaperBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

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
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
		return false;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(), NullBlockInit.NULL_BLOCK.get().getDefaultState());
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		worldIn.removeBlock(pos.up(), false);
		super.onBlockHarvested(worldIn, pos, state, player);
	}
}
