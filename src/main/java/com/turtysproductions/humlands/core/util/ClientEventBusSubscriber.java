package com.turtysproductions.humlands.core.util;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.client.gui.TimeCapsuleScreen;
import com.turtysproductions.humlands.common.entities.render.HumadilloRender;
import com.turtysproductions.humlands.core.init.ContainerTypesInit;
import com.turtysproductions.humlands.core.init.EntityTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.TIME_CAPSULE_CONTAINER.get(), TimeCapsuleScreen::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMADILLO.get(), HumadilloRender::new);
	}
}
