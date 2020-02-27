package com.turtysproductions.humlands.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.item.HumlandsTab;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, HumlandsMod.MOD_ID);
	
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));
}
