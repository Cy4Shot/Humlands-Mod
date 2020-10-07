package com.turtysproductions.humlands.client.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.turtysproductions.humlands.common.entities.CorruptedGolem;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CorruptedGolemModel<T extends CorruptedGolem> extends EntityModel<T> {
	private final ModelRenderer CorruptedGolem;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Spikes;
	private final ModelRenderer Decorations2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Spikes2;
	private final ModelRenderer Body;
	private final ModelRenderer LowerSpikes;
	private final ModelRenderer Decorations;
	private final ModelRenderer RightArm;
	private final ModelRenderer Spikes3;
	private final ModelRenderer LeftArm;
	private final ModelRenderer Spikes4;
	private final ModelRenderer Head;
	private final ModelRenderer Cranium;
	private final ModelRenderer Horns;
	private final ModelRenderer GrowingHorn;
	private final ModelRenderer Horn;
	private final ModelRenderer Halberd;
	private final ModelRenderer Handle;
	private final ModelRenderer Hilt;
	private final ModelRenderer Stick;
	private final ModelRenderer Tip;
	private final ModelRenderer MainBlade;
	private final ModelRenderer BackBlade;

	public CorruptedGolemModel() {
		textureWidth = 128;
		textureHeight = 128;

		CorruptedGolem = new ModelRenderer(this);
		CorruptedGolem.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(RightLeg);
		RightLeg.setTextureOffset(61, 61).addBox(3.0F, -18.0F, -2.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);

		Spikes = new ModelRenderer(this);
		Spikes.setRotationPoint(0.0F, 1.0F, 0.0F);
		RightLeg.addChild(Spikes);
		Spikes.setTextureOffset(35, 18).addBox(5.0F, -13.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(20, 42).addBox(5.0F, -14.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(47, 35).addBox(5.0F, -15.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(60, 33).addBox(5.0F, -16.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(57, 3).addBox(5.0F, -7.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(58, 0).addBox(5.0F, -6.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(60, 14).addBox(5.0F, -8.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes.setTextureOffset(51, 35).addBox(5.0F, -9.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Decorations2 = new ModelRenderer(this);
		Decorations2.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(Decorations2);
		Decorations2.setTextureOffset(10, 21).addBox(-8.0F, -3.0F, -3.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		Decorations2.setTextureOffset(51, 30).addBox(-3.0F, -3.0F, -3.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		Decorations2.setTextureOffset(10, 18).addBox(-8.0F, -3.0F, 3.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		Decorations2.setTextureOffset(24, 24).addBox(-9.0F, -3.0F, -3.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		Decorations2.setTextureOffset(0, 0).addBox(-7.0F, -1.0F, 4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Decorations2.setTextureOffset(46, 0).addBox(-6.0F, -1.0F, 8.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Decorations2.setTextureOffset(42, 35).addBox(-7.0F, -1.0F, 14.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Decorations2.setTextureOffset(12, 32).addBox(-8.0F, -1.0F, 17.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(LeftLeg);
		LeftLeg.setTextureOffset(20, 42).addBox(-8.0F, -18.0F, -2.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);

		Spikes2 = new ModelRenderer(this);
		Spikes2.setRotationPoint(-11.0F, 1.0F, 0.0F);
		LeftLeg.addChild(Spikes2);
		Spikes2.setTextureOffset(56, 14).addBox(5.0F, -7.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes2.setTextureOffset(31, 35).addBox(5.0F, -6.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes2.setTextureOffset(40, 42).addBox(5.0F, -8.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes2.setTextureOffset(60, 42).addBox(5.0F, -9.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(Body);
		Body.setTextureOffset(42, 18).addBox(-5.0F, -23.0F, -3.0F, 10.0F, 5.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-9.0F, -31.0F, -5.0F, 18.0F, 8.0F, 10.0F, 0.0F, false);

		LowerSpikes = new ModelRenderer(this);
		LowerSpikes.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(LowerSpikes);
		LowerSpikes.setTextureOffset(54, 0).addBox(-6.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LowerSpikes.setTextureOffset(61, 46).addBox(-7.0F, -21.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LowerSpikes.setTextureOffset(35, 42).addBox(-6.0F, -21.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		LowerSpikes.setTextureOffset(42, 30).addBox(5.0F, -21.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		LowerSpikes.setTextureOffset(27, 23).addBox(6.0F, -21.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LowerSpikes.setTextureOffset(46, 0).addBox(5.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Decorations = new ModelRenderer(this);
		Decorations.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Decorations);
		Decorations.setTextureOffset(45, 21).addBox(-5.0F, -23.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Decorations.setTextureOffset(18, 31).addBox(-6.0F, -20.0F, -6.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Decorations.setTextureOffset(0, 27).addBox(6.0F, -23.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Decorations.setTextureOffset(24, 24).addBox(7.0F, -19.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(RightArm);
		RightArm.setTextureOffset(0, 42).addBox(-14.0F, -33.0F, -3.0F, 5.0F, 24.0F, 5.0F, 0.0F, false);

		Spikes3 = new ModelRenderer(this);
		Spikes3.setRotationPoint(-9.0F, -22.0F, -6.0F);
		RightArm.addChild(Spikes3);
		setRotationAngle(Spikes3, 0.0F, 1.5708F, 0.0F);
		Spikes3.setTextureOffset(58, 39).addBox(-6.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(60, 30).addBox(-6.0F, -13.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(42, 18).addBox(-6.0F, -9.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(60, 35).addBox(-6.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(46, 7).addBox(-7.0F, -8.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(0, 42).addBox(-6.0F, 4.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(27, 29).addBox(-6.0F, 5.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes3.setTextureOffset(13, 37).addBox(-7.0F, 5.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(0.0F, 0.0F, -1.0F);
		CorruptedGolem.addChild(LeftArm);
		setRotationAngle(LeftArm, 0.0F, 3.1416F, 0.0F);
		LeftArm.setTextureOffset(41, 41).addBox(-14.0F, -33.0F, -3.0F, 5.0F, 24.0F, 5.0F, 0.0F, false);

		Spikes4 = new ModelRenderer(this);
		Spikes4.setRotationPoint(-9.0F, -22.0F, -6.0F);
		LeftArm.addChild(Spikes4);
		setRotationAngle(Spikes4, 0.0F, 1.5708F, 0.0F);
		Spikes4.setTextureOffset(61, 61).addBox(-6.0F, -12.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(39, 35).addBox(-6.0F, -13.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(56, 42).addBox(-6.0F, -14.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(59, 44).addBox(-6.0F, -15.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(50, 30).addBox(-6.0F, -9.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(54, 39).addBox(-6.0F, -8.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(0, 24).addBox(-7.0F, -8.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(46, 39).addBox(-7.0F, -2.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(46, 4).addBox(-6.0F, -2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(6, 0).addBox(-6.0F, -3.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(0, 0).addBox(-6.0F, 4.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(9, 32).addBox(-6.0F, 5.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Spikes4.setTextureOffset(10, 24).addBox(-7.0F, 5.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(Head);
		

		Cranium = new ModelRenderer(this);
		Cranium.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Cranium);
		Cranium.setTextureOffset(56, 0).addBox(-4.0F, -36.0F, -12.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);

		Horns = new ModelRenderer(this);
		Horns.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Horns);
		

		GrowingHorn = new ModelRenderer(this);
		GrowingHorn.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns.addChild(GrowingHorn);
		GrowingHorn.setTextureOffset(9, 27).addBox(-6.0F, -35.0F, -10.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		GrowingHorn.setTextureOffset(24, 35).addBox(-8.0F, -35.0F, -10.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		Horn = new ModelRenderer(this);
		Horn.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns.addChild(Horn);
		Horn.setTextureOffset(24, 18).addBox(4.0F, -35.0F, -10.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		Horn.setTextureOffset(0, 5).addBox(8.0F, -36.0F, -10.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Horn.setTextureOffset(0, 18).addBox(10.0F, -38.0F, -10.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		Halberd = new ModelRenderer(this);
		Halberd.setRotationPoint(0.0F, 0.0F, 0.0F);
		CorruptedGolem.addChild(Halberd);
		

		Handle = new ModelRenderer(this);
		Handle.setRotationPoint(0.0F, 0.0F, 0.0F);
		Halberd.addChild(Handle);
		

		Hilt = new ModelRenderer(this);
		Hilt.setRotationPoint(0.0F, 0.0F, 0.0F);
		Handle.addChild(Hilt);
		Hilt.setTextureOffset(18, 24).addBox(11.0F, -15.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Hilt.setTextureOffset(54, 30).addBox(12.0F, -14.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Hilt.setTextureOffset(36, 27).addBox(10.0F, -14.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Stick = new ModelRenderer(this);
		Stick.setRotationPoint(0.0F, 0.0F, 0.0F);
		Handle.addChild(Stick);
		Stick.setTextureOffset(34, 35).addBox(11.0F, -14.0F, 2.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		Stick.setTextureOffset(0, 18).addBox(11.0F, -14.0F, -26.0F, 1.0F, 2.0F, 22.0F, 0.0F, false);

		Tip = new ModelRenderer(this);
		Tip.setRotationPoint(0.0F, 0.0F, 0.0F);
		Halberd.addChild(Tip);
		Tip.setTextureOffset(5, 36).addBox(10.0F, -14.0F, -27.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Tip.setTextureOffset(33, 23).addBox(11.0F, -15.0F, -27.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Tip.setTextureOffset(3, 31).addBox(11.0F, -14.0F, -28.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		MainBlade = new ModelRenderer(this);
		MainBlade.setRotationPoint(0.0F, 0.0F, 0.0F);
		Halberd.addChild(MainBlade);
		MainBlade.setTextureOffset(15, 42).addBox(11.0F, -12.0F, -21.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		MainBlade.setTextureOffset(0, 27).addBox(11.0F, -10.0F, -23.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		MainBlade.setTextureOffset(56, 30).addBox(11.0F, -6.0F, -26.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		MainBlade.setTextureOffset(24, 18).addBox(11.0F, -7.0F, -28.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
		MainBlade.setTextureOffset(61, 42).addBox(11.0F, -8.0F, -25.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		BackBlade = new ModelRenderer(this);
		BackBlade.setRotationPoint(0.0F, -8.0F, 0.0F);
		Halberd.addChild(BackBlade);
		BackBlade.setTextureOffset(0, 36).addBox(11.0F, -7.0F, -21.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		BackBlade.setTextureOffset(61, 54).addBox(11.0F, -8.0F, -23.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		BackBlade.setTextureOffset(0, 18).addBox(11.0F, -9.0F, -24.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	}
   

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		CorruptedGolem.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) 
	{
		
		
	}

	
}
