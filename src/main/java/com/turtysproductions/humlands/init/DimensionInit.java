package com.turtysproductions.humlands.init;

import com.turtysproductions.HumlandsMod;
import com.turtysproductions.world.dimension.HumlandsWorldProvider;
import java.util.HashMap;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import java.util.Map;

public class DimensionInit {
  
    public static DimensionType humlandsDimensionType;
    public static Map<Integer, String> dimensionProfileMap = new HashMap<>();
   
    public static void init() {
        if (HumlandsMod.DIMENSION_ID != -1 && HumlandsMod.DIMENSION_ID != 0 && HumlandsMod.DIMENSION_ID != 1) {
            humlandsDimensionType = DimensionType.register(HumlandsMod.MODID, "_humlands", HumlandsMod.DIMENSION_ID, HumlandsWorldProvider.class, false);
            DimensionManager.registerDimension(HumlandsMod.DIMENSION_ID, humlandsDimensionType);
            humlandsDimensionType.put(HumlandsMod.DIMENSION_ID, HumlandsMod.DIMENSION_PROFILE);
        }
    }
}
