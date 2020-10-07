package com.turtysproductions.humlands.core.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;

public abstract class MultiblockControllerBlockBase extends Block {

	public MultiblockControllerBlockBase(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	abstract public TileEntityType<? extends MultiblockTileEntityBase> getTileEntityType();
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return getTileEntityType().create();
	}
}
