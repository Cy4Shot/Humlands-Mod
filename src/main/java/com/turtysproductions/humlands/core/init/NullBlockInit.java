package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NullBlockInit {
	//THIS IS FOR 2 TALL MACHINES. THIS MAKES IT SO THAT THEY DO NOT REGISTER AS ITEMS
	public static final DeferredRegister<Block> NULL_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, HumlandsMod.MOD_ID);
	public static final RegistryObject<Block> NULL_BLOCK = NULL_BLOCKS.register("null_block", () -> new Block(Block.Properties.create(Material.AIR)));
}
