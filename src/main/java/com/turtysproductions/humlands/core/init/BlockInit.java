package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.blocks.ScrapGlassBlock;
import com.turtysproductions.humlands.common.blocks.ScrapSandBlock;
import com.turtysproductions.humlands.common.blocks.ShaperBlock;
import com.turtysproductions.humlands.common.blocks.SifterBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HumlandsMod.MOD_ID);

	public static final RegistryObject<Block> HUMLANDS_PORTAL_BLOCK = BLOCKS.register("humlands_portal_block", () -> new Block(PropertyInit.PORTAL_PROPERTY));
	public static final RegistryObject<Block> SCRAP_SAND = BLOCKS.register("scrap_sand", () -> new ScrapSandBlock(PropertyInit.SAND_PROPERTY));
	public static final RegistryObject<Block> SCRAP_SANDSTONE = BLOCKS.register("scrap_sandstone", () -> new Block(PropertyInit.SANDSTONE_PROPERTY));
	public static final RegistryObject<Block> SCRAP_GLASS = BLOCKS.register("scrap_glass", () -> new ScrapGlassBlock(PropertyInit.GLASS_PROPERTY));
	public static final RegistryObject<Block> SHAPER = BLOCKS.register("shaper", () -> new ShaperBlock(PropertyInit.MACHINE_PROPERTY.notSolid()));
	public static final RegistryObject<Block> SIFTER = BLOCKS.register("sifter", () -> new SifterBlock(PropertyInit.MACHINE_PROPERTY.notSolid()));
	
}
