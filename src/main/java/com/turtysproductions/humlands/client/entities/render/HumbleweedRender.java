package com.turtysproductions.humlands.client.entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.client.entities.model.HumbleweedModel;
import com.turtysproductions.humlands.common.entities.Humbleweed;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HumbleweedRender extends MobRenderer<Humbleweed, HumbleweedModel<Humbleweed>> {
	protected static final ResourceLocation HUMBLEWEED_TEXTURE = new ResourceLocation(HumlandsMod.MOD_ID,
			"textures/entities/humbleweed.png");

	public HumbleweedRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HumbleweedModel<Humbleweed>(), 0.7f);
	}

	@Override
	public ResourceLocation getEntityTexture(Humbleweed entity) {
		return HUMBLEWEED_TEXTURE;
	}

	@OnlyIn(Dist.CLIENT)
	public static int getCustomsPackedOverlay(LivingEntity livingEntityIn, float uIn) {
		return OverlayTexture.getPackedUV(OverlayTexture.getU(uIn), OverlayTexture.getV(false));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void render(Humbleweed entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(
				new net.minecraftforge.client.event.RenderLivingEvent.Pre<Humbleweed, HumbleweedModel<Humbleweed>>(
						entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn)))
			return;
		matrixStackIn.push();
		this.entityModel.swingProgress = this.getSwingProgress(entityIn, partialTicks);

		boolean shouldSit = entityIn.isPassenger()
				&& (entityIn.getRidingEntity() != null && entityIn.getRidingEntity().shouldRiderSit());
		this.entityModel.isSitting = shouldSit;
		this.entityModel.isChild = entityIn.isChild();
		float f = MathHelper.interpolateAngle(partialTicks, entityIn.prevRenderYawOffset, entityIn.renderYawOffset);
		float f1 = MathHelper.interpolateAngle(partialTicks, entityIn.prevRotationYawHead, entityIn.rotationYawHead);
		float f2 = f1 - f;
		if (shouldSit && entityIn.getRidingEntity() instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) entityIn.getRidingEntity();
			f = MathHelper.interpolateAngle(partialTicks, livingentity.prevRenderYawOffset,
					livingentity.renderYawOffset);
			f2 = f1 - f;
			float f3 = MathHelper.wrapDegrees(f2);
			if (f3 < -85.0F)
				f3 = -85.0F;
			if (f3 >= 85.0F)
				f3 = 85.0F;
			f = f1 - f3;
			if (f3 * f3 > 2500.0F)
				f += f3 * 0.2F;
			f2 = f1 - f;
		}

		float f6 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
		if (entityIn.getPose() == Pose.SLEEPING) {
			Direction direction = entityIn.getBedDirection();
			if (direction != null) {
				float f4 = entityIn.getEyeHeight(Pose.STANDING) - 0.1F;
				matrixStackIn.translate((double) ((float) (-direction.getXOffset()) * f4), 0.0D,
						(double) ((float) (-direction.getZOffset()) * f4));
			}
		}

		float f7 = this.handleRotationFloat(entityIn, partialTicks);
		this.applyRotations(entityIn, matrixStackIn, f7, f, partialTicks);
		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entityIn, matrixStackIn, partialTicks);
		matrixStackIn.translate(0.0D, (double) -1.501F, 0.0D);
		float f8 = 0.0F;
		float f5 = 0.0F;
		if (!shouldSit && entityIn.isAlive()) {
			f8 = MathHelper.lerp(partialTicks, entityIn.prevLimbSwingAmount, entityIn.limbSwingAmount);
			f5 = entityIn.limbSwing - entityIn.limbSwingAmount * (1.0F - partialTicks);
			if (entityIn.isChild()) {
				f5 *= 3.0F;
			}

			if (f8 > 1.0F) {
				f8 = 1.0F;
			}
		}

		this.entityModel.setLivingAnimations(entityIn, f5, f8, partialTicks);
		this.entityModel.setRotationAngles(entityIn, f5, f8, f7, f2, f6);
		boolean flag = this.isVisible(entityIn);
		boolean flag1 = !flag && !entityIn.isInvisibleToPlayer(Minecraft.getInstance().player);
		RenderType rendertype = this.func_230042_a_(entityIn, flag, flag1);
		if (rendertype != null) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(rendertype);
			this.entityModel.render(matrixStackIn, ivertexbuilder, packedLightIn,
					getCustomsPackedOverlay(entityIn, this.getOverlayProgress(entityIn, partialTicks)), 1.0F, 1.0F,
					1.0F, flag1 ? 0.15F : 1.0F);
		}

		if (!entityIn.isSpectator()) {
			for (LayerRenderer<Humbleweed, HumbleweedModel<Humbleweed>> layerrenderer : this.layerRenderers) {
				layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2,
						f6);
			}
		}

		matrixStackIn.pop();
		net.minecraftforge.client.event.RenderNameplateEvent renderNameplateEvent = new net.minecraftforge.client.event.RenderNameplateEvent(
				entityIn, entityIn.getDisplayName().getFormattedText(), matrixStackIn, bufferIn);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
		if (renderNameplateEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY
				&& (renderNameplateEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW
						|| this.canRenderName(entityIn)))
			this.renderName(entityIn, renderNameplateEvent.getContent(), matrixStackIn, bufferIn, packedLightIn);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(
				new net.minecraftforge.client.event.RenderLivingEvent.Post<Humbleweed, HumbleweedModel<Humbleweed>>(
						entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
	}
}
