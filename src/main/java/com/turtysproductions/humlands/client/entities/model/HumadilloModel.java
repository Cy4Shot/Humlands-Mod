package com.turtysproductions.humlands.client.entities.model;

import com.turtysproductions.humlands.common.entities.Humadillo;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class HumadilloModel<T extends Humadillo> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public HumadilloModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-6.0f, -12.0f, -8.0f, 12, 8, 16, 0.0f, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -6.25F, -8.0F);
		body.addChild(head);
		head.setTextureOffset(0, 24).addBox(-3.0f, -2.75f, -5.0f, 6, 5, 5, 0.0f, false);
		head.setTextureOffset(0, 8).addBox(-2.0f, -0.75f, -8.0f, 4, 2, 3, 0.0f, false);
		head.setTextureOffset(0, 13).addBox(2.0f, -3.75f, -2.0f, 2, 2, 1, 0.0f, false);
		head.setTextureOffset(0, 13).addBox(-4.0f, -3.75f, -2.0f, 2, 2, 1, 0.0f, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -5.0F, 8.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 0).addBox(-2.0f, 0.0f, 0.0f, 4, 0, 4, 0.0f, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, -5.0F, 12.0F);
		setRotationAngle(tail2, 0.4363F, 0.0F, 0.0F);
		body.addChild(tail2);
		tail2.setTextureOffset(0, 0).addBox(-2.0f, 0.0f, 0.0f, 4, 0, 4, 0.0f, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, -4.0F, -5.0F);
		body.addChild(leg1);
		leg1.setTextureOffset(0, 34).addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, -4.0F, -5.0F);
		body.addChild(leg2);
		leg2.setTextureOffset(20, 32).addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(4.0F, -4.0F, 5.0F);
		body.addChild(leg3);
		leg3.setTextureOffset(28, 28).addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f, false);
		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-4.0F, -4.0F, 5.0F);
		body.addChild(leg4);
		leg4.setTextureOffset(22, 24).addBox(-1.0f, 0.0f, -1.0f, 2, 4, 2, 0.0f, false);
	}

	public ModelRenderer getBody() {
		return body;
	}

	public ModelRenderer getHead() {
		return head;
	}

	public ModelRenderer getLeg1() {
		return leg1;
	}

	public ModelRenderer getLeg2() {
		return leg2;
	}

	public ModelRenderer getLeg3() {
		return leg3;
	}

	public ModelRenderer getLeg4() {
		return leg4;
	}

	public ModelRenderer getTail() {
		return tail;
	}

	public ModelRenderer getTail2() {
		return tail2;

	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		if (entityIn.isClosed() == true)
			;
		{
			leg1.rotateAngleX = -180;
			leg2.rotateAngleX = -180;
			leg3.rotateAngleX = 180;
			leg4.rotateAngleX = 180;
			head.showModel = false;
			tail2.showModel = false;
			tail.rotateAngleX = 19;
		}

		if (entityIn.isClosed() == false) {
			leg1.rotateAngleX = 0;
			leg2.rotateAngleX = 0;
			leg3.rotateAngleX = 0;
			leg4.rotateAngleX = 0;
			head.showModel = true;
			tail.rotateAngleX = 0;
			tail2.showModel = true;

			this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
			this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
					* 0.5F;

			this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
			this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
					* 0.5F;

			this.tail2.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		}

	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

		this.tail2.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
