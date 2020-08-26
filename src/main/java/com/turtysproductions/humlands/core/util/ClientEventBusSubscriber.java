package com.turtysproductions.humlands.core.util;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.entities.EntityBinderInit;
import com.turtysproductions.humlands.client.gui.FluxExtractorScreen;
import com.turtysproductions.humlands.client.gui.TimeCapsuleScreen;
import com.turtysproductions.humlands.client.ter.ShaperTileEntityRenderer;
import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.init.ContainerTypesInit;
import com.turtysproductions.humlands.core.init.TileEntityTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.TIME_CAPSULE_CONTAINER.get(), TimeCapsuleScreen::new);
		ScreenManager.registerFactory(ContainerTypesInit.FLUX_EXTRACTOR_CONTAINER.get(), FluxExtractorScreen::new);
		EntityBinderInit.bindAllEntities();
		RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_WOOD_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEAD_WOOD_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCRAP_GLASS.get(), RenderType.getTranslucent());
		TileEntityRendererDispatcher.instance.setSpecialRendererInternal(TileEntityTypesInit.SHAPER_TILE_ENTITY.get(),
				new ShaperTileEntityRenderer(TileEntityRendererDispatcher.instance));
	}
}
