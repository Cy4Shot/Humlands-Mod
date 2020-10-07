package com.turtysproductions.humlands.client.entities.render;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.entities.model.CorruptedGolemModel;
import com.turtysproductions.humlands.common.entities.CorruptedGolem;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CorruptedGolemRender extends MobRenderer<CorruptedGolem, CorruptedGolemModel<CorruptedGolem>>
{
   protected static final ResourceLocation CORRUPTED_GOLEM_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID, "textures/entities/corruptedgolem/corrupted_golem.png");
   
   public CorruptedGolemRender(EntityRendererManager renderManagerIn)
   {
	   super(renderManagerIn, new CorruptedGolemModel<CorruptedGolem>(), 1.0f);
   }
   
   @Override
	public ResourceLocation getEntityTexture(CorruptedGolem entity) {
		
		return CORRUPTED_GOLEM_TEXTURE;
	}
}