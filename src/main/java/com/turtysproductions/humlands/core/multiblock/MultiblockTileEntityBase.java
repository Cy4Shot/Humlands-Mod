package com.turtysproductions.humlands.core.multiblock;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class MultiblockTileEntityBase extends TileEntity implements ITickableTileEntity {

	private static final BlockPos[] axisBlockPosArray = { BlockPosUtil.EnumBlockPosAxis.NEG_X.pos,
			BlockPosUtil.EnumBlockPosAxis.NEG_Y.pos, BlockPosUtil.EnumBlockPosAxis.NEG_Z.pos,
			BlockPosUtil.EnumBlockPosAxis.POS_X.pos, BlockPosUtil.EnumBlockPosAxis.POS_Y.pos,
			BlockPosUtil.EnumBlockPosAxis.POS_Z.pos };

	public MultiblockTileEntityBase(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	abstract public BlockPatternBase getBlockPattern();

	public boolean isFormedMultiBlock(BlockPos controllerPos) {
		World world = this.getWorld();
		BlockData[] pattern = getBlockPattern().getData();
		Block[] allowed = getBlockPattern().getAllowedBlocks();
		BlockPos corner = iterateOn(iterateOn(iterateOn(controllerPos, allowed, world, axisBlockPosArray[0]), allowed,
				world, axisBlockPosArray[1]), allowed, world, axisBlockPosArray[2]);
		for (BlockPos axis : BlockPosUtil.directions) {
			if (hasStructureAtX(pattern, corner, axis, getBlockPattern().getXBound()))
				return true;
			if (hasStructureAtY(pattern, corner, axis, getBlockPattern().getYBound()))
				return true;
			if (hasStructureAtZ(pattern, corner, axis, getBlockPattern().getZBound()))
				return true;
		}
		return false;
	}

	private boolean hasStructureAtX(BlockData[] pattern, BlockPos corner, BlockPos axis, int flip) {
		for (BlockData data : pattern) {
			if (!(data.allowedBlocks
					.contains(world.getBlockState(BlockPosUtil
							.multiplyBPos(new BlockPos(flip - data.pos.add(1, 1, 1).getX(),
									data.pos.add(1, 1, 1).getY(), data.pos.add(1, 1, 1).getZ()), axis)
							.add(corner.subtract(new BlockPos(1, 1, 1))))))) {
				//HumlandsMod.LOGGER.debug("failed multiblock test in direction:" + axis.toString());
				return false;
			}
		}
		return true;
	}

	private boolean hasStructureAtY(BlockData[] pattern, BlockPos corner, BlockPos axis, int flip) {
		for (BlockData data : pattern) {
			if (!(data.allowedBlocks
					.contains(world.getBlockState(BlockPosUtil
							.multiplyBPos(new BlockPos(data.pos.add(1, 1, 1).getX(),
									flip - data.pos.add(1, 1, 1).getY(), data.pos.add(1, 1, 1).getZ()), axis)
							.add(corner.subtract(new BlockPos(1, 1, 1))))))) {
				//HumlandsMod.LOGGER.debug("failed multiblock test in direction:" + axis.toString());
				return false;
			}
		}
		return true;
	}

	private boolean hasStructureAtZ(BlockData[] pattern, BlockPos corner, BlockPos axis, int flip) {
		for (BlockData data : pattern) {
			if (!(data.allowedBlocks.contains(world.getBlockState(BlockPosUtil
					.multiplyBPos(new BlockPos(data.pos.add(1, 1, 1).getX(), data.pos.add(1, 1, 1).getY(),
							flip - data.pos.add(1, 1, 1).getZ()), axis)
					.add(corner.subtract(new BlockPos(1, 1, 1))))))) {
				//HumlandsMod.LOGGER.debug("failed multiblock test in direction:" + axis.toString());
				return false;
			}
		}
		return true;
	}

	private BlockPos iterateOn(BlockPos originalPos, Block[] allowed, World world, BlockPos axis) {
		BlockPos currentPos = originalPos;
		while (Arrays.asList(allowed).contains(world.getBlockState(currentPos.add(axis)).getBlock())) {
			currentPos = currentPos.add(axis);
		}
		return currentPos;
	}
}
