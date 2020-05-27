package com.turtysproductions.humlands.core.util;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicRegistry {
	public static final SoundEvent DIRTY_HUMLANDS = makeSoundEvent("dirty_humlands");
	public static final SoundEvent FAR_HUMLANDS = makeSoundEvent("far_humlands");
	public static final SoundEvent RUINED_LANDS = makeSoundEvent("ruined_lands");
	public static final SoundEvent RUBBER_FOREST = makeSoundEvent("rubber_forest");

	@SubscribeEvent
	public static void onRegisterSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(DIRTY_HUMLANDS, FAR_HUMLANDS, RUINED_LANDS, RUBBER_FOREST);
	}

	private static SoundEvent makeSoundEvent(String name) {
		SoundEvent sound = new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, name));
		sound.setRegistryName(new ResourceLocation(HumlandsMod.MOD_ID, name));
		return sound;
	}
}
