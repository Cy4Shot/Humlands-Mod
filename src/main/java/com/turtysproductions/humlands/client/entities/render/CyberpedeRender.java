package com.turtysproductions.humlands.client.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.entities.model.CyberpedeModel;
import com.turtysproductions.humlands.common.entities.Cyberpede;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CyberpedeRender extends MobRenderer<Cyberpede, CyberpedeModel<Cyberpede>>
{
   protected static final ResourceLocation CYBERPEDE_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/cyberpede/cyberpede.png");
   
   public CyberpedeRender(EntityRendererManager renderManagerIn)
   {
	   super(renderManagerIn, new CyberpedeModel<Cyberpede>(), 1.0f);
   }
   
   @Override
	public ResourceLocation getEntityTexture(Cyberpede entity) {
		
		return CYBERPEDE_TEXTURE;
	}
}
