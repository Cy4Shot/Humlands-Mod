package com.turtysproductions.humlands.client.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.entities.model.CentipedeModel;
import com.turtysproductions.humlands.common.entities.Centipede;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CentipedeRender extends MobRenderer<Centipede, CentipedeModel<Centipede>>
{
   protected static final ResourceLocation CENTIPEDE_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/centipede/centipede.png");
   
   public CentipedeRender(EntityRendererManager renderManagerIn)
   {
	   super(renderManagerIn, new CentipedeModel<Centipede>(), 1.0f);
   }
   
   @Override
	public ResourceLocation getEntityTexture(Centipede entity) {
		
		return CENTIPEDE_TEXTURE;
	}
}