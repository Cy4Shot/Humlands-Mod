package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.world.dimension.HumlandsModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Bus.MOD)
public class DimensionInit {
	
	@ObjectHolder("humlands:humlands")
	public static final ModDimension HUMLANDS_DIM = null;

	@SubscribeEvent
	public static void onDimensionRegistryEvent(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new HumlandsModDimension().setRegistryName("humlands:humlands"));
	}
}
