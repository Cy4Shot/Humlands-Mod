package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			HumlandsMod.MOD_ID);

	public static final RegistryObject<SoundEvent> HUMADILLO_HURT = SOUNDS.register("entity.humadillo.hurt",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "entity.humadillo.hurt")));
	
	public static final RegistryObject<SoundEvent> HUMADILLO_DEATH = SOUNDS.register("entity.humadillo.death",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "entity.humadillo.death")));
	
	public static final RegistryObject<SoundEvent> DIRTY_HUMLANDS = SOUNDS.register("ambient.humlands.dirty_humlands",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "ambient.humlands.dirty_humlands")));
	
	public static final RegistryObject<SoundEvent> FAR_HUMLANDS = SOUNDS.register("ambient.humlands.far_humlands",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "ambient.humlands.far_humlands")));
	
	public static final RegistryObject<SoundEvent> RUINED_LANDS = SOUNDS.register("ambient.humlands.ruined_lands",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "ambient.humlands.ruined_lands")));
	
	public static final RegistryObject<SoundEvent> RUBBER_FOREST = SOUNDS.register("ambient.humlands.rubber_forest",
			() -> new SoundEvent(new ResourceLocation(HumlandsMod.MOD_ID, "ambient.humlands.rubber_forest")));
}
