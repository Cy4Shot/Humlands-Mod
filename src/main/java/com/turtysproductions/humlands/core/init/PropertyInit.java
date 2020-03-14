package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.core.tab.HumlandsTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class PropertyInit
{
    // I didn't do this system for the items because I thought it was not so necessary to be fair.
    // The idea of this is to be able to easyly re-use the same property for multiple blocks, for example for slabs and stairs of the same material.
    public static final Block.Properties MACHINE_PROPERTY = Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 17.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE);
    public static final Block.Properties PORTAL_PROPERTY = Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F).sound(SoundType.STONE);
    public static final Block.Properties SAND_PROPERTY = Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND);
    public static final Block.Properties SANDSTONE_PROPERTY = Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F).sound(SoundType.STONE);
    public static final Block.Properties GLASS_PROPERTY = Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid();
}

