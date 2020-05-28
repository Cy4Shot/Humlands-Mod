package com.turtysproductions.humlands.common.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.tileentities.ShaperTileEntity;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class ShaperBlock extends Block {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF; // Double block
																										// half
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING; // Direction facing

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
		this.setDefaultState(
				this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(HALF, DoubleBlockHalf.LOWER));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return state.get(HALF) == DoubleBlockHalf.UPPER ? selectShape(state.get(FACING)).withOffset(0d, -1d, 0d)
				: selectShape(state.get(FACING));
	}

	private VoxelShape selectShape(Direction dir) {
		switch (dir) {
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

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y
				&& doubleblockhalf == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf
					? stateIn.with(FACING, facingState.get(FACING))
					: Blocks.AIR.getDefaultState();
		} else {
			return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN
					&& !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState()
							: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(),
				state.with(HALF, DoubleBlockHalf.UPPER).with(FACING, worldIn.getBlockState(pos).get(FACING)), 3);
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (context.getPos().getY() < 255
				&& context.getWorld().getBlockState(context.getPos().up()).isReplaceable(context))
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(HALF,
					DoubleBlockHalf.LOWER);
		else
			return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if (state.get(HALF) != DoubleBlockHalf.UPPER)
			return super.isValidPosition(state, worldIn, pos);
		else {
			if (state.getBlock() != this)
				return super.isValidPosition(state, worldIn, pos);
			return worldIn.getBlockState(pos.down()).getBlock() == this
					&& worldIn.getBlockState(pos.down()).get(HALF) == DoubleBlockHalf.LOWER;
		}
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult p_225533_6_) {
		if (worldIn.isRemote)
			return ActionResultType.PASS;
		BlockPos newPos = pos;
		if(state.get(HALF) == DoubleBlockHalf.UPPER) newPos = pos.down();
		ShaperTileEntity tileEntity = (ShaperTileEntity) worldIn.getTileEntity(newPos);
		HumlandsMod.LOGGER.debug(tileEntity);
		int slot = state.get(HALF) == DoubleBlockHalf.UPPER ? 1 : 0;

		if (player.getHeldItem(handIn).isEmpty() && !tileEntity.getInventory().get(slot).isEmpty())
			tileEntity.removeInv(slot, player);
		else {
			if (slot == 1)
				tileEntity.addTool(player.getHeldItem(handIn));
			else
				tileEntity.addItem(player.getHeldItem(handIn), 200);
		}

		return ActionResultType.SUCCESS;
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		BlockPos blockpos = state.get(HALF) == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() == this && blockstate.get(HALF) != state.get(HALF)) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
			if (!worldIn.isRemote && !player.isCreative()) {
				spawnDrops(state, worldIn, pos, (TileEntity) null, player, player.getHeldItemMainhand());
				spawnDrops(blockstate, worldIn, blockpos, (TileEntity) null, player, player.getHeldItemMainhand());
			}
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, HALF);
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
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		return false;
	}

	@Override
	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return state.get(HALF) == DoubleBlockHalf.LOWER;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		HumlandsMod.LOGGER.debug("Init Enitty");
		return TileEntityTypesInit.SHAPER_TILE_ENTITY.get().create();
	}
}
