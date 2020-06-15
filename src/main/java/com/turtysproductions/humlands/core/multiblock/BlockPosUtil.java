package com.turtysproductions.humlands.core.multiblock;

import net.minecraft.util.math.BlockPos;

public class BlockPosUtil {

	public static BlockPos multiplyBPos(BlockPos a, BlockPos b) {
		return new BlockPos(a.getX() * b.getX(), a.getY() * b.getY(), a.getZ() * b.getZ());
	}
	
	public enum EnumBlockPosAxis {
		POS_X(new BlockPos(1, 0, 0)),
		POS_Y(new BlockPos(0, 1, 0)),
		POS_Z(new BlockPos(0, 0, 1)),
		NEG_X(new BlockPos(-1, 0, 0)),
		NEG_Y(new BlockPos(0, -1, 0)),
		NEG_Z(new BlockPos(0, 0, -1));
		
		public BlockPos pos;
		
		EnumBlockPosAxis(BlockPos pos) {
			this.pos = pos;
		}
	}
	
	public static final BlockPos[] directions = {
			new BlockPos(1, 1, 1),
			new BlockPos(1, 1, -1),
			new BlockPos(1, -1, 1),
			new BlockPos(1, -1, -1),
			new BlockPos(-1, 1, 1),
			new BlockPos(-1, 1, -1),
			new BlockPos(-1, -1, 1),
			new BlockPos(-1, -1, -1)
	};
}
