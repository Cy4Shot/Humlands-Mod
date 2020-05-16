package com.turtysproductions.humlands.client.entities.model;

import com.turtysproductions.humlands.common.entities.Humahog;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class HumahogModel<T extends Humahog> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer hair;
	private final ModelRenderer snout;
	private final ModelRenderer hair2;
	private final ModelRenderer hair3;
	private final ModelRenderer hair4;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public HumahogModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -6.0F, 8, 5, 12, 0.0F, false);

		hair = new ModelRenderer(this);
		hair.setRotationPoint(0.0F, 14.0F, -3.0F);
		setRotationAngle(hair, -0.1745F, 0.0F, 0.1745F);
		hair.setTextureOffset(0, 17).addBox(-4.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F, false);

		snout = new ModelRenderer(this);
		snout.setRotationPoint(0.0F, 17.0F, -6.0F);
		snout.setTextureOffset(8, 17).addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F, false);
		snout.setTextureOffset(26, 17).addBox(-1.0F, 1.0F, -4.0F, 2, 2, 2, 0.0F, false);
		snout.setTextureOffset(0, 1).addBox(1.0F, 0.0F, -6.0F, 0, 1, 2, 0.0F, false);
		snout.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -6.0F, 0, 1, 2, 0.0F, false);

		hair2 = new ModelRenderer(this);
		hair2.setRotationPoint(0.0F, 14.0F, -3.0F);
		setRotationAngle(hair2, 0.1745F, 0.0F, 0.1745F);
		hair2.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, 0.0F, 4, 0, 4, 0.0F, false);

		hair3 = new ModelRenderer(this);
		hair3.setRotationPoint(0.0F, 14.0F, -3.0F);
		setRotationAngle(hair3, 0.1745F, 0.0F, -0.1745F);
		hair3.setTextureOffset(0, 4).addBox(0.0F, 0.0F, 0.0F, 4, 0, 4, 0.0F, false);

		hair4 = new ModelRenderer(this);
		hair4.setRotationPoint(0.0F, 14.0F, -3.0F);
		setRotationAngle(hair4, -0.1745F, 0.0F, -0.1745F);
		hair4.setTextureOffset(0, 8).addBox(0.0F, 0.0F, -4.0F, 4, 0, 4, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg1.setTextureOffset(26, 26).addBox(-4.0F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg2.setTextureOffset(8, 23).addBox(2.0F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg3.setTextureOffset(0, 21).addBox(-4.0F, -5.0F, 5.0F, 2, 5, 2, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg4.setTextureOffset(20, 20).addBox(2.0F, -5.0F, 5.0F, 2, 5, 2, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		hair.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		hair2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		hair3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		hair4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		snout.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leg2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leg3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leg4.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}
