package com.turtysproductions.humlands.common.blocks;

import java.util.stream.Stream;

import com.turtysproductions.humlands.common.tileentities.TimeCapsuleTileEntity;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TimeCapsule extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(3, 1, 5, 15, 6, 11),
			Block.makeCuboidShape(4, 0, 6, 14, 1, 10), Block.makeCuboidShape(4, 2, 4, 14, 5, 5),
			Block.makeCuboidShape(4, 2, 11, 14, 5, 12), Block.makeCuboidShape(15, 2, 6, 16, 5, 10),
			Block.makeCuboidShape(5, 3, 2, 6, 4, 4), Block.makeCuboidShape(11, 3, 2, 12, 4, 4),
			Block.makeCuboidShape(6, 3, 1, 11, 4, 2), Block.makeCuboidShape(5, 3, 12, 6, 4, 14),
			Block.makeCuboidShape(6, 3, 14, 11, 4, 15), Block.makeCuboidShape(11, 3, 12, 12, 4, 14))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(5, 1, 3, 11, 6, 15),
			Block.makeCuboidShape(6, 0, 4, 10, 1, 14), Block.makeCuboidShape(11, 2, 4, 12, 5, 14),
			Block.makeCuboidShape(4, 2, 4, 5, 5, 14), Block.makeCuboidShape(6, 2, 15, 10, 5, 16),
			Block.makeCuboidShape(12, 3, 5, 14, 4, 6), Block.makeCuboidShape(12, 3, 11, 14, 4, 12),
			Block.makeCuboidShape(14, 3, 6, 15, 4, 11), Block.makeCuboidShape(2, 3, 5, 4, 4, 6),
			Block.makeCuboidShape(1, 3, 6, 2, 4, 11), Block.makeCuboidShape(2, 3, 11, 4, 4, 12)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(1, 1, 5, 13, 6, 11),
			Block.makeCuboidShape(2, 0, 6, 12, 1, 10), Block.makeCuboidShape(2, 2, 11, 12, 5, 12),
			Block.makeCuboidShape(2, 2, 4, 12, 5, 5), Block.makeCuboidShape(0, 2, 6, 1, 5, 10),
			Block.makeCuboidShape(10, 3, 12, 11, 4, 14), Block.makeCuboidShape(4, 3, 12, 5, 4, 14),
			Block.makeCuboidShape(5, 3, 14, 10, 4, 15), Block.makeCuboidShape(10, 3, 2, 11, 4, 4),
			Block.makeCuboidShape(5, 3, 1, 10, 4, 2), Block.makeCuboidShape(4, 3, 2, 5, 4, 4)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(5, 1, 1, 11, 6, 13),
			Block.makeCuboidShape(6, 0, 2, 10, 1, 12), Block.makeCuboidShape(4, 2, 2, 5, 5, 12),
			Block.makeCuboidShape(11, 2, 2, 12, 5, 12), Block.makeCuboidShape(6, 2, 0, 10, 5, 1),
			Block.makeCuboidShape(2, 3, 10, 4, 4, 11), Block.makeCuboidShape(2, 3, 4, 4, 4, 5),
			Block.makeCuboidShape(1, 3, 5, 2, 4, 10), Block.makeCuboidShape(12, 3, 10, 14, 4, 11),
			Block.makeCuboidShape(14, 3, 5, 15, 4, 10), Block.makeCuboidShape(12, 3, 4, 14, 4, 5)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public TimeCapsule(Properties properties) {
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

		return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {

		super.fillStateContainer(builder);
		builder.add(FACING);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {

		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {

		return TileEntityTypesInit.TIME_CAPSULE_TILE_ENTITY.get().create();
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TimeCapsuleTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (TimeCapsuleTileEntity) tile, pos);
				return ActionResultType.SUCCESS;
			}

		}
		return ActionResultType.FAIL;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {

		if (state.getBlock() != newState.getBlock()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TimeCapsuleTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((TimeCapsuleTileEntity) tile).getItems());
			}
		}
	}
}
