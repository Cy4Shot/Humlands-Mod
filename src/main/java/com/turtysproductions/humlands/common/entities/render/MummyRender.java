package com.turtysproductions.humlands.common.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.Mummy;
import com.turtysproductions.humlands.common.entities.model.MummyModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MummyRender extends MobRenderer<Mummy, MummyModel<Mummy>> {
	protected static final ResourceLocation MUMMY_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID,
			"textures/entities/mummy.png");

	public MummyRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MummyModel<Mummy>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Mummy entity) {
		return MUMMY_TEXTURE;
	}
}
