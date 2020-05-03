package com.turtysproductions.humlands.common.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.Humbleweed;
import com.turtysproductions.humlands.common.entities.model.HumbleweedModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HumbleweedRender extends MobRenderer<Humbleweed, HumbleweedModel<Humbleweed>>
{
	   protected static final ResourceLocation HUMBLEWEED_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/humbleweed.png");
	   
	   public HumbleweedRender(EntityRendererManager renderManagerIn)
	   {
		   super(renderManagerIn, new HumbleweedModel<Humbleweed>(), 0.7f);
	   }
	   
	   @Override
		public ResourceLocation getEntityTexture(Humbleweed entity) {
			
			return HUMBLEWEED_TEXTURE;
		}
	}
