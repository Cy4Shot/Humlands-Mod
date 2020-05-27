package com.turtysproductions.humlands.client.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.turtysproductions.humlands.common.entities.Centipede;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class CentipedeModel<T extends Centipede> extends EntityModel<T> {
	private final ModelRenderer Centipede;
	private final ModelRenderer CentipedeBody;
	private final ModelRenderer BackPart;
	private final ModelRenderer FakeAntennae;
	private final ModelRenderer BodyPart2;
	private final ModelRenderer Legs2;
	private final ModelRenderer BodyPart3;
	private final ModelRenderer Legs3;
	private final ModelRenderer BodyPart4;
	private final ModelRenderer Legs4;
	private final ModelRenderer BodyPart5;
	private final ModelRenderer Legs5;
	private final ModelRenderer BodyPart6;
	private final ModelRenderer Legs6;
	private final ModelRenderer HeadPart;
	private final ModelRenderer Antennae;
	private final ModelRenderer Mandible;

	public CentipedeModel() {
		textureWidth = 128;
		textureHeight = 128;

		Centipede = new ModelRenderer(this);
		Centipede.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		CentipedeBody = new ModelRenderer(this);
		CentipedeBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		Centipede.addChild(CentipedeBody);
		

		BackPart = new ModelRenderer(this);
		BackPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(BackPart);
		BackPart.setTextureOffset(35, 49).addBox(-5.0F, -7.0F, 33.0F, 10.0F, 5.0F, 9.0F, 0.0F, false);
		BackPart.setTextureOffset(44, 22).addBox(-4.0F, -8.0F, 34.0F, 8.0F, 1.0F, 7.0F, 0.0F, false);
		BackPart.setTextureOffset(76, 11).addBox(-6.0F, -6.0F, 34.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		BackPart.setTextureOffset(58, 75).addBox(5.0F, -6.0F, 34.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		BackPart.setTextureOffset(32, 0).addBox(-4.0F, -6.0F, 42.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);

		FakeAntennae = new ModelRenderer(this);
		FakeAntennae.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackPart.addChild(FakeAntennae);
		FakeAntennae.setTextureOffset(0, 11).addBox(-5.0F, -13.0F, 42.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);
		FakeAntennae.setTextureOffset(0, 28).addBox(5.0F, -13.0F, 41.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);

		BodyPart2 = new ModelRenderer(this);
		BodyPart2.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(BodyPart2);
		BodyPart2.setTextureOffset(0, 37).addBox(-5.0F, -7.0F, 20.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);
		BodyPart2.setTextureOffset(64, 0).addBox(-4.0F, -8.0F, 21.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		BodyPart2.setTextureOffset(84, 33).addBox(-6.0F, -6.0F, 21.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart2.setTextureOffset(12, 71).addBox(5.0F, -6.0F, 21.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart2.setTextureOffset(24, 68).addBox(-3.0F, -6.0F, 32.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		Legs2 = new ModelRenderer(this);
		Legs2.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyPart2.addChild(Legs2);
		Legs2.setTextureOffset(32, 26).addBox(5.0F, -3.0F, 20.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(80, 67).addBox(8.0F, -2.0F, 20.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(64, 37).addBox(6.0F, -3.0F, 22.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(80, 80).addBox(8.0F, -2.0F, 22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(64, 55).addBox(6.0F, -3.0F, 24.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(71, 79).addBox(8.0F, -2.0F, 24.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(0, 70).addBox(6.0F, -3.0F, 27.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(78, 44).addBox(8.0F, -2.0F, 27.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(0, 56).addBox(6.0F, -3.0F, 29.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(78, 11).addBox(8.0F, -2.0F, 29.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(28, 34).addBox(5.0F, -3.0F, 31.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(49, 78).addBox(8.0F, -2.0F, 31.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(32, 37).addBox(-8.0F, -3.0F, 20.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(27, 78).addBox(-9.0F, -2.0F, 20.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(54, 63).addBox(-8.0F, -3.0F, 22.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(61, 77).addBox(-9.0F, -2.0F, 22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(64, 0).addBox(-8.0F, -3.0F, 24.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(8, 40).addBox(-9.0F, -2.0F, 24.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(64, 7).addBox(-8.0F, -3.0F, 27.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(39, 76).addBox(-9.0F, -2.0F, 27.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(64, 33).addBox(-8.0F, -3.0F, 29.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(24, 76).addBox(-9.0F, -2.0F, 29.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(0, 42).addBox(-8.0F, -3.0F, 31.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs2.setTextureOffset(67, 75).addBox(-9.0F, -2.0F, 31.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		BodyPart3 = new ModelRenderer(this);
		BodyPart3.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(BodyPart3);
		BodyPart3.setTextureOffset(32, 5).addBox(-5.0F, -7.0F, 7.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);
		BodyPart3.setTextureOffset(64, 22).addBox(-4.0F, -8.0F, 8.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		BodyPart3.setTextureOffset(68, 75).addBox(-6.0F, -6.0F, 8.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart3.setTextureOffset(80, 80).addBox(5.0F, -6.0F, 8.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart3.setTextureOffset(64, 11).addBox(-3.0F, -6.0F, 19.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		Legs3 = new ModelRenderer(this);
		Legs3.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyPart3.addChild(Legs3);
		Legs3.setTextureOffset(0, 46).addBox(-8.0F, -3.0F, 7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(18, 73).addBox(-9.0F, -2.0F, 7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(67, 22).addBox(-8.0F, -3.0F, 9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(6, 71).addBox(-9.0F, -2.0F, 9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(67, 26).addBox(-8.0F, -3.0F, 11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(70, 4).addBox(-9.0F, -2.0F, 11.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(12, 68).addBox(-8.0F, -3.0F, 14.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(60, 69).addBox(-9.0F, -2.0F, 14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(54, 69).addBox(-8.0F, -3.0F, 16.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(60, 66).addBox(-9.0F, -2.0F, 16.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(52, 30).addBox(-8.0F, -3.0F, 18.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(46, 22).addBox(-9.0F, -2.0F, 18.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(32, 6).addBox(5.0F, -3.0F, 7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(8, 43).addBox(8.0F, -2.0F, 7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(54, 71).addBox(6.0F, -3.0F, 9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(40, 7).addBox(8.0F, -2.0F, 9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(12, 72).addBox(6.0F, -3.0F, 11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(76, 15).addBox(8.0F, -2.0F, 11.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(45, 25).addBox(6.0F, -3.0F, 14.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(40, 40).addBox(8.0F, -2.0F, 14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(0, 74).addBox(6.0F, -3.0F, 16.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(40, 4).addBox(8.0F, -2.0F, 16.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(0, 72).addBox(6.0F, -3.0F, 18.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs3.setTextureOffset(40, 37).addBox(8.0F, -2.0F, 18.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		BodyPart4 = new ModelRenderer(this);
		BodyPart4.setRotationPoint(0.0F, 1.0F, 0.0F);
		CentipedeBody.addChild(BodyPart4);
		BodyPart4.setTextureOffset(32, 32).addBox(-5.0F, -8.0F, -6.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);
		BodyPart4.setTextureOffset(28, 63).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		BodyPart4.setTextureOffset(0, 68).addBox(-6.0F, -7.0F, -5.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart4.setTextureOffset(12, 84).addBox(5.0F, -7.0F, -5.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart4.setTextureOffset(29, 54).addBox(-3.0F, -7.0F, -7.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		BodyPart4.setTextureOffset(50, 0).addBox(-3.0F, -7.0F, 6.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		Legs4 = new ModelRenderer(this);
		Legs4.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyPart4.addChild(Legs4);
		Legs4.setTextureOffset(18, 68).addBox(-8.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(18, 70).addBox(-9.0F, -3.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(0, 68).addBox(-8.0F, -4.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(70, 7).addBox(-9.0F, -3.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(67, 24).addBox(-8.0F, -4.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(24, 72).addBox(-9.0F, -3.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(54, 67).addBox(-8.0F, -4.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(6, 74).addBox(-9.0F, -3.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(27, 74).addBox(8.0F, -3.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(29, 58).addBox(6.0F, -4.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(64, 53).addBox(6.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(58, 75).addBox(8.0F, -3.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(64, 41).addBox(6.0F, -4.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(71, 75).addBox(8.0F, -3.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(64, 35).addBox(6.0F, -4.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(30, 76).addBox(8.0F, -3.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(32, 41).addBox(5.0F, -4.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(52, 76).addBox(8.0F, -3.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(0, 40).addBox(5.0F, -4.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(45, 77).addBox(8.0F, -3.0F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(39, 27).addBox(-8.0F, -4.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(74, 77).addBox(-9.0F, -3.0F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(32, 4).addBox(-8.0F, -4.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs4.setTextureOffset(36, 78).addBox(-9.0F, -3.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		BodyPart5 = new ModelRenderer(this);
		BodyPart5.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(BodyPart5);
		BodyPart5.setTextureOffset(0, 17).addBox(-5.0F, -7.0F, -19.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);
		BodyPart5.setTextureOffset(54, 64).addBox(-4.0F, -8.0F, -18.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		BodyPart5.setTextureOffset(24, 74).addBox(-6.0F, -6.0F, -18.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart5.setTextureOffset(80, 65).addBox(5.0F, -6.0F, -18.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart5.setTextureOffset(85, 11).addBox(-3.0F, -6.0F, -20.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		Legs5 = new ModelRenderer(this);
		Legs5.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyPart5.addChild(Legs5);
		Legs5.setTextureOffset(12, 34).addBox(-8.0F, -3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(58, 79).addBox(-9.0F, -2.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(66, 30).addBox(-8.0F, -3.0F, -10.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(52, 80).addBox(-9.0F, -2.0F, -10.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(64, 51).addBox(-8.0F, -3.0F, -12.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(80, 64).addBox(-9.0F, -2.0F, -12.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(64, 15).addBox(-8.0F, -3.0F, -15.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(80, 70).addBox(-9.0F, -2.0F, -15.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(63, 3).addBox(-8.0F, -3.0F, -17.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(4, 81).addBox(-9.0F, -2.0F, -17.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(32, 10).addBox(-8.0F, -3.0F, -19.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(81, 46).addBox(-9.0F, -2.0F, -19.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(32, 8).addBox(5.0F, -3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(83, 82).addBox(8.0F, -2.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(4, 84).addBox(8.0F, -2.0F, -10.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(64, 5).addBox(6.0F, -3.0F, -10.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(29, 60).addBox(6.0F, -3.0F, -12.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(16, 84).addBox(8.0F, -2.0F, -12.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(12, 74).addBox(6.0F, -3.0F, -15.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(84, 67).addBox(8.0F, -2.0F, -15.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(0, 54).addBox(6.0F, -3.0F, -17.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(78, 41).addBox(8.0F, -2.0F, -17.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(20, 34).addBox(5.0F, -3.0F, -19.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs5.setTextureOffset(67, 78).addBox(8.0F, -2.0F, -19.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		BodyPart6 = new ModelRenderer(this);
		BodyPart6.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(BodyPart6);
		BodyPart6.setTextureOffset(0, 0).addBox(-5.0F, -7.0F, -32.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);
		BodyPart6.setTextureOffset(63, 53).addBox(-4.0F, -8.0F, -31.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		BodyPart6.setTextureOffset(46, 75).addBox(-6.0F, -6.0F, -31.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart6.setTextureOffset(0, 81).addBox(5.0F, -6.0F, -31.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		BodyPart6.setTextureOffset(32, 22).addBox(-3.0F, -6.0F, -33.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		Legs6 = new ModelRenderer(this);
		Legs6.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyPart6.addChild(Legs6);
		Legs6.setTextureOffset(35, 35).addBox(-8.0F, -3.0F, -21.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(45, 74).addBox(-9.0F, -2.0F, -21.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(68, 2).addBox(-8.0F, -3.0F, -23.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(6, 68).addBox(-9.0F, -2.0F, -23.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(69, 42).addBox(-8.0F, -3.0F, -25.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(60, 63).addBox(-9.0F, -2.0F, -25.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(12, 70).addBox(-8.0F, -3.0F, -28.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(8, 46).addBox(-9.0F, -2.0F, -28.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(54, 65).addBox(-8.0F, -3.0F, -30.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(36, 74).addBox(-9.0F, -2.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(44, 30).addBox(-8.0F, -3.0F, -32.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(49, 74).addBox(-9.0F, -2.0F, -32.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(0, 44).addBox(5.0F, -3.0F, -21.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(0, 81).addBox(8.0F, -2.0F, -21.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(60, 30).addBox(6.0F, -3.0F, -23.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(74, 81).addBox(8.0F, -2.0F, -23.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(0, 60).addBox(6.0F, -3.0F, -25.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(83, 78).addBox(8.0F, -2.0F, -25.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(0, 58).addBox(6.0F, -3.0F, -28.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(0, 84).addBox(8.0F, -2.0F, -28.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(70, 15).addBox(6.0F, -3.0F, -30.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(12, 84).addBox(8.0F, -2.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(32, 39).addBox(5.0F, -3.0F, -32.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Legs6.setTextureOffset(84, 64).addBox(8.0F, -2.0F, -32.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		HeadPart = new ModelRenderer(this);
		HeadPart.setRotationPoint(0.0F, 0.0F, 0.0F);
		CentipedeBody.addChild(HeadPart);
		HeadPart.setTextureOffset(0, 54).addBox(-5.0F, -7.0F, -42.0F, 10.0F, 5.0F, 9.0F, 0.0F, false);
		HeadPart.setTextureOffset(64, 33).addBox(-4.0F, -8.0F, -41.0F, 8.0F, 1.0F, 7.0F, 0.0F, false);
		HeadPart.setTextureOffset(69, 42).addBox(-6.0F, -6.0F, -41.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		HeadPart.setTextureOffset(36, 74).addBox(5.0F, -6.0F, -41.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);

		Antennae = new ModelRenderer(this);
		Antennae.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadPart.addChild(Antennae);
		Antennae.setTextureOffset(0, 17).addBox(-5.0F, -13.0F, -48.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);
		Antennae.setTextureOffset(0, 0).addBox(5.0F, -13.0F, -48.0F, 0.0F, 6.0F, 6.0F, 0.0F, false);

		Mandible = new ModelRenderer(this);
		Mandible.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadPart.addChild(Mandible);
		Mandible.setTextureOffset(0, 3).addBox(0.0F, -3.0F, -45.0F, 4.0F, 0.0F, 3.0F, 0.0F, false);
		Mandible.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -45.0F, 4.0F, 0.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		Centipede.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) 
	{
		
		
	}
}