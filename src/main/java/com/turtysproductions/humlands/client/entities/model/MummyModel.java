package com.turtysproductions.humlands.client.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.turtysproductions.humlands.common.entities.Mummy;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MummyModel<T extends Mummy> extends EntityModel<T> {
	private final ModelRenderer ArmR;
	private final ModelRenderer ArmL;
	private final ModelRenderer LegL;
	private final ModelRenderer LegR;
	private final ModelRenderer Head;
	private final ModelRenderer Body;

	public MummyModel() {
		textureWidth = 64;
		textureHeight = 64;

		ArmR = new ModelRenderer(this);
		ArmR.setRotationPoint(6.0F, 0.0F, 0.0F);
		ArmR.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ArmL = new ModelRenderer(this);
		ArmL.setRotationPoint(-6.0F, 0.0F, 0.0F);
		ArmL.setTextureOffset(24, 24).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LegL = new ModelRenderer(this);
		LegL.setRotationPoint(-2.0F, 12.0F, 0.0F);
		LegL.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LegR = new ModelRenderer(this);
		LegR.setRotationPoint(2.0F, 12.0F, 0.0F);
		LegR.setTextureOffset(36, 36).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 16).addBox(-4.0F, -24.0F, -1.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		ArmR.render(matrixStack, buffer, packedLight, packedOverlay);
		ArmL.render(matrixStack, buffer, packedLight, packedOverlay);
		LegL.render(matrixStack, buffer, packedLight, packedOverlay);
		LegR.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.LegR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	    this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.LegR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	    this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	}
}