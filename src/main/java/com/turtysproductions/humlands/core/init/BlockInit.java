package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.blocks.CustomDoor;
import com.turtysproductions.humlands.common.blocks.RubberWoodLog;
import com.turtysproductions.humlands.common.blocks.CustomFence;
import com.turtysproductions.humlands.common.blocks.CustomFenceGate;
import com.turtysproductions.humlands.common.blocks.CustomLeaves;
import com.turtysproductions.humlands.common.blocks.CustomLogBlock;
import com.turtysproductions.humlands.common.blocks.CustomPressurePlate;
import com.turtysproductions.humlands.common.blocks.CustomSlab;
import com.turtysproductions.humlands.common.blocks.CustomStairs;
import com.turtysproductions.humlands.common.blocks.CustomTrapdoor;
import com.turtysproductions.humlands.common.blocks.CustomWoodButton;
import com.turtysproductions.humlands.common.blocks.OreClump;
import com.turtysproductions.humlands.common.blocks.ScrapGlassBlock;
import com.turtysproductions.humlands.common.blocks.ScrapSandBlock;
import com.turtysproductions.humlands.common.blocks.ShaperBlock;
import com.turtysproductions.humlands.common.blocks.SifterBlock;
import com.turtysproductions.humlands.common.blocks.CustomGrass;
import com.turtysproductions.humlands.common.blocks.RubberStreamingRubberWoodLog;
import com.turtysproductions.humlands.common.blocks.TimeCapsule;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HumlandsMod.MOD_ID);

	public static final RegistryObject<Block> IRON_ORE_CLUMP = BLOCKS.register("iron_ore_clump", () -> new OreClump(PropertyInit.ORE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> COAL_ORE_CLUMP = BLOCKS.register("coal_ore_clump", () -> new OreClump(PropertyInit.ORE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> GOLD_ORE_CLUMP = BLOCKS.register("gold_ore_clump", () -> new OreClump(PropertyInit.ORE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> LAPIS_ORE_CLUMP = BLOCKS.register("lapis_ore_clump", () -> new OreClump(PropertyInit.ORE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> REDSTONE_ORE_CLUMP = BLOCKS.register("redstone_ore_clump", () -> new OreClump(PropertyInit.ORE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> BLUE_FOREST_GRASS_BLOCK = BLOCKS.register("blue_forest_grass_block", () -> new Block(PropertyInit.DIRT_PROPERTY));
	public static final RegistryObject<Block> GREEN_FOREST_GRASS_BLOCK = BLOCKS.register("green_forest_grass_block", () -> new Block(PropertyInit.DIRT_PROPERTY));
	public static final RegistryObject<Block> HUMLANDS_PORTAL_BLOCK = BLOCKS.register("humlands_portal_block", () -> new Block(PropertyInit.PORTAL_PROPERTY));
	public static final RegistryObject<Block> SCRAP_SAND = BLOCKS.register("scrap_sand", () -> new ScrapSandBlock(PropertyInit.SAND_PROPERTY));
	public static final RegistryObject<Block> SCRAP_SANDSTONE = BLOCKS.register("scrap_sandstone", () -> new Block(PropertyInit.SANDSTONE_PROPERTY));
	public static final RegistryObject<Block> SCRAP_GLASS = BLOCKS.register("scrap_glass", () -> new ScrapGlassBlock(PropertyInit.GLASS_PROPERTY));
	public static final RegistryObject<Block> SIFTER = BLOCKS.register("sifter", () -> new SifterBlock(PropertyInit.MACHINE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> SHAPER = BLOCKS.register("shaper", () -> new ShaperBlock(PropertyInit.MACHINE_PROPERTY.notSolid()));
        public static final RegistryObject<Block> RUBBER_WOOD_LOG = BLOCKS.register("rubber_wood_log", () -> new RubberWoodLog(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD_LOG = BLOCKS.register("stripped_rubber_wood_log", () -> new CustomLogBlock(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_STREAMING_RUBBER_WOOD_LOG = BLOCKS.register("rubber_streaming_rubber_wood_log", () -> new RubberStreamingRubberWoodLog(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> RUBBER_LEAVES = BLOCKS.register("rubber_leaves", () -> new CustomLeaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RUBBER_WOOD_PLANKS = BLOCKS.register("rubber_wood_planks", () -> new Block(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_STAIRS = BLOCKS.register("rubber_wood_stairs", () -> new CustomStairs(RUBBER_WOOD_PLANKS.get().getDefaultState(), Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_BUTTON = BLOCKS.register("rubber_wood_button", () -> new CustomWoodButton(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_SLAB = BLOCKS.register("rubber_wood_slab", () -> new CustomSlab(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_FENCE_GATE = BLOCKS.register("rubber_wood_fence_gate", () -> new CustomFenceGate(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_FENCE = BLOCKS.register("rubber_wood_fence", () -> new CustomFence(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_PRESSURE_PLATE = BLOCKS.register("rubber_wood_pressure_plate", () -> new CustomPressurePlate(Sensitivity.EVERYTHING, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_TRAPDOOR = BLOCKS.register("rubber_wood_trapdoor", () -> new CustomTrapdoor(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> RUBBER_WOOD_DOOR = BLOCKS.register("rubber_wood_door", () -> new CustomDoor(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
        public static final RegistryObject<Block> RUBBER_WOOD_FOREST_GRASS = BLOCKS.register("rubber_wood_forest_grass", () -> new CustomGrass(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> RUBBER_WOOD_FOREST_DIRT = BLOCKS.register("rubber_wood_forest_dirt", () -> new Block(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.GROUND)));
        public static final RegistryObject<Block> TIME_CAPSULE = BLOCKS.register("time_capsule", () -> new TimeCapsule(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE)));
	
}
