package com.turtysproductions.humlands.core.util;

import javax.annotation.Nullable;

import com.turtysproductions.humlands.core.init.DimensionInit;

import net.minecraft.world.World;

public class MusicUtil {
	public static boolean isModDimension(@Nullable World world) {
		if(world == null) return false;
		return world.dimension.getType().getModType() == DimensionInit.HUMLANDS_DIM;
	}
}
