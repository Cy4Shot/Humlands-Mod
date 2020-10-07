package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.particles.DrippingRubberParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLES = new DeferredRegister<>(
			ForgeRegistries.PARTICLE_TYPES, HumlandsMod.MOD_ID);

	public static final RegistryObject<BasicParticleType> DRIPPING_RUBBER = PARTICLES.register("dripping_rubber",
			() -> new BasicParticleType(false));

	// Used to register the particle factories, created in the particle class
	// (Client only)
	@SuppressWarnings("resource")
	@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = HumlandsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FactoryHandler {
		@SubscribeEvent
		public static void registerFactories(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(ParticleInit.DRIPPING_RUBBER.get(),
					DrippingRubberParticle.FACTORY::new);
		}
	}
}
