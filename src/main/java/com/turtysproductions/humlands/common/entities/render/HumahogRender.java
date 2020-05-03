package com.turtysproductions.humlands.common.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.Humahog;
import com.turtysproductions.humlands.common.entities.model.HumahogModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HumahogRender extends MobRenderer<Humahog, HumahogModel<Humahog>>
{
   protected static final ResourceLocation HUMAHOG_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/humahog/humahog.png");
   
   public HumahogRender(EntityRendererManager renderManagerIn)
   {
	   super(renderManagerIn, new HumahogModel<Humahog>(), 0.3f);
   }
   
   @Override
	public ResourceLocation getEntityTexture(Humahog entity) {
		
		return HUMAHOG_TEXTURE;
	}
}
