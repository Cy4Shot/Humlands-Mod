package com.turtysproductions.humlands.client.entities;

import com.turtysproductions.humlands.client.entities.render.HumadilloRender;
import com.turtysproductions.humlands.client.entities.render.HumahogRender;
import com.turtysproductions.humlands.client.entities.render.HumbleweedRender;
import com.turtysproductions.humlands.client.entities.render.MummyRender;
import com.turtysproductions.humlands.core.init.EntityTypesInit;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityBinderInit {
	public static void bindAllEntities() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMADILLO.get(), HumadilloRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.MUMMY.get(), MummyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMBLEWEED.get(), HumbleweedRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMAHOG.get(), HumahogRender::new);
	}
}
