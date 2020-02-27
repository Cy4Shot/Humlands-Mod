package com.turtysproductions.humlands.init;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HumlandsMod.MOD_ID);

	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
}
