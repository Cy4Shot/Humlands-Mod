package com.turtysproductions.humlands.core.util;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.client.gui.TimeCapsuleScreen;
import com.turtysproductions.humlands.common.entities.render.HumadilloRender;
import com.turtysproductions.humlands.common.entities.render.HumahogRender;
import com.turtysproductions.humlands.common.entities.render.HumbleweedRender;
import com.turtysproductions.humlands.common.entities.render.MummyRender;
import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.init.ContainerTypesInit;
import com.turtysproductions.humlands.core.init.EntityTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.MUMMY.get(), MummyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMBLEWEED.get(), HumbleweedRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMAHOG.get(), HumahogRender::new);
		RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCRAP_GLASS.get(), RenderType.getTranslucent());
	}
}
