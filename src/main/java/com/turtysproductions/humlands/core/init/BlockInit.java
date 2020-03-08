package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.blocks.ScrapGlassBlock;
import com.turtysproductions.humlands.common.blocks.ScrapSandBlock;
import com.turtysproductions.humlands.common.blocks.SifterBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HumlandsMod.MOD_ID);

	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));

	public static final RegistryObject<Block> HUMLANDS_PORTAL_BLOCK = BLOCKS.register("humlands_portal_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SCRAP_SAND = BLOCKS.register("scrap_sand", () -> new ScrapSandBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> SCRAP_SANDSTONE = BLOCKS.register("scrap_sandstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SCRAP_GLASS = BLOCKS.register("scrap_glass", () -> new ScrapGlassBlock(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> SIFTER = BLOCKS.register("sifter", () -> new SifterBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 17.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).notSolid()));
}
