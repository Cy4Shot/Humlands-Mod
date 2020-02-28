package com.turtysproductions.humlands.init;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.ObjectHolder;

public class DimensionInit {
	
	public static final ResourceLocation DIMENSION_ID = new ResourceLocation(HumlandsMod.MOD_ID, "humlands");
	
	@ObjectHolder(HumlandsMod.MOD_ID + ":humlands")
	public static ModDimension DIMENSION;
	
	public static DimensionType DIMENSION_TYPE;
}
