package com.turtysproductions.humlands.common.events;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BiomeInit;
import com.turtysproductions.humlands.core.util.MusicRegistry;
import com.turtysproductions.humlands.core.util.MusicUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

//Code for music events provided by SynthChris

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = HumlandsMod.MOD_ID, value = Dist.CLIENT)
public class MusicEvents {
	private static final Minecraft CLIENT = Minecraft.getInstance();

	private static ISound playingMusic;
	public static SoundEvent playingSound;
	public static float flicker;
	public static float prevFlicker;

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			prevFlicker = flicker;

			double targetFlicker = Math.random();
			targetFlicker *= targetFlicker;

			flicker += (targetFlicker - flicker) * 0.5;
		}

		if (!CLIENT.isGamePaused()) {
			if (CLIENT.player == null)
				return;
			if (event.phase == TickEvent.Phase.END) {
				if (playingMusic != null && !CLIENT.getSoundHandler().isPlaying(playingMusic)) {
					playingMusic = null;
					playingSound = null;
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlaySound(PlaySoundEvent event) {
		if (!(Arrays.stream(Thread.currentThread().getStackTrace())
				.anyMatch(e -> e.getClassName().equals(MusicTicker.class.getName()))))
			return;

		if (CLIENT.player != null && MusicUtil.isModDimension(CLIENT.player.world)) {
			SoundEvent sound = getMusicSound(CLIENT.player);
			if (sound == null || playingSound == sound) {
				event.setResultSound(null);
				return;
			}
			
			CLIENT.getSoundHandler().stop(playingMusic);
			playingMusic = SimpleSound.music(sound);
			playingSound = sound;
			event.setResultSound(playingMusic);
		}
	}

	@Nullable
	private static SoundEvent getMusicSound(PlayerEntity player) {
		Biome biome = player.world.getBiome(player.getPosition());
		if (biome == BiomeInit.DIRTY_HUMLANDS.get())
			return MusicRegistry.DIRTY_HUMLANDS;
		else if (biome == BiomeInit.RUBBER_WOOD_FOREST.get())
			return MusicRegistry.RUBBER_FOREST;
		else if (biome == BiomeInit.RUINED_LANDS.get())
			return MusicRegistry.RUINED_LANDS;
		else
			return MusicRegistry.FAR_HUMLANDS;
	}
}
