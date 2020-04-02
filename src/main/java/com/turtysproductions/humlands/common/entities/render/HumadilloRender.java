package com.turtysproductions.humlands.common.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.Humadillo;
import com.turtysproductions.humlands.common.entities.model.HumadilloModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HumadilloRender extends MobRenderer<Humadillo, HumadilloModel<Humadillo>>
{
   protected static final ResourceLocation HUMADILLO_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/humadillo.png");
   
   public HumadilloRender(EntityRendererManager renderManagerIn)
   {
	   super(renderManagerIn, new HumadilloModel<Humadillo>(), 0.7f);
   }
   
   @Override
	public ResourceLocation getEntityTexture(Humadillo entity) {
		
		return HUMADILLO_TEXTURE;
	}
}
