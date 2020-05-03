package com.turtysproductions.humlands.common.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.turtysproductions.humlands.common.entities.Humbleweed;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HumbleweedModel<T extends Humbleweed> extends EntityModel<T> {
	private final ModelRenderer TotY1;
	private final ModelRenderer Y4;
	private final ModelRenderer X8;
	private final ModelRenderer GroupX25;
	private final ModelRenderer bone146;
	private final ModelRenderer bone148;
	private final ModelRenderer bone150;
	private final ModelRenderer GroupX26;
	private final ModelRenderer bone152;
	private final ModelRenderer bone154;
	private final ModelRenderer bone156;
	private final ModelRenderer GroupX27;
	private final ModelRenderer bone158;
	private final ModelRenderer bone160;
	private final ModelRenderer bone162;
	private final ModelRenderer GroupX28;
	private final ModelRenderer bone164;
	private final ModelRenderer bone166;
	private final ModelRenderer bone168;
	private final ModelRenderer X9;
	private final ModelRenderer GroupX29;
	private final ModelRenderer bone170;
	private final ModelRenderer bone172;
	private final ModelRenderer bone174;
	private final ModelRenderer GroupX30;
	private final ModelRenderer bone176;
	private final ModelRenderer bone178;
	private final ModelRenderer bone180;
	private final ModelRenderer GroupX31;
	private final ModelRenderer bone182;
	private final ModelRenderer bone184;
	private final ModelRenderer bone186;
	private final ModelRenderer GroupX32;
	private final ModelRenderer bone188;
	private final ModelRenderer bone190;
	private final ModelRenderer bone192;
	private final ModelRenderer Y2;
	private final ModelRenderer X4;
	private final ModelRenderer GroupX9;
	private final ModelRenderer bone50;
	private final ModelRenderer bone52;
	private final ModelRenderer bone54;
	private final ModelRenderer GroupX10;
	private final ModelRenderer bone56;
	private final ModelRenderer bone58;
	private final ModelRenderer bone60;
	private final ModelRenderer GroupX11;
	private final ModelRenderer bone62;
	private final ModelRenderer bone64;
	private final ModelRenderer bone66;
	private final ModelRenderer GroupX12;
	private final ModelRenderer bone68;
	private final ModelRenderer bone70;
	private final ModelRenderer bone72;
	private final ModelRenderer X5;
	private final ModelRenderer GroupX13;
	private final ModelRenderer bone74;
	private final ModelRenderer bone76;
	private final ModelRenderer bone78;
	private final ModelRenderer GroupX14;
	private final ModelRenderer bone80;
	private final ModelRenderer bone82;
	private final ModelRenderer bone84;
	private final ModelRenderer GroupX15;
	private final ModelRenderer bone86;
	private final ModelRenderer bone88;
	private final ModelRenderer bone90;
	private final ModelRenderer GroupX16;
	private final ModelRenderer bone92;
	private final ModelRenderer bone94;
	private final ModelRenderer bone96;
	private final ModelRenderer Y3;
	private final ModelRenderer X6;
	private final ModelRenderer GroupX17;
	private final ModelRenderer bone98;
	private final ModelRenderer bone100;
	private final ModelRenderer bone102;
	private final ModelRenderer GroupX18;
	private final ModelRenderer bone104;
	private final ModelRenderer bone106;
	private final ModelRenderer bone108;
	private final ModelRenderer GroupX19;
	private final ModelRenderer bone110;
	private final ModelRenderer bone112;
	private final ModelRenderer bone114;
	private final ModelRenderer GroupX20;
	private final ModelRenderer bone116;
	private final ModelRenderer bone118;
	private final ModelRenderer bone120;
	private final ModelRenderer X7;
	private final ModelRenderer GroupX21;
	private final ModelRenderer bone122;
	private final ModelRenderer bone124;
	private final ModelRenderer bone126;
	private final ModelRenderer GroupX22;
	private final ModelRenderer bone128;
	private final ModelRenderer bone130;
	private final ModelRenderer bone132;
	private final ModelRenderer GroupX23;
	private final ModelRenderer bone134;
	private final ModelRenderer bone136;
	private final ModelRenderer bone138;
	private final ModelRenderer GroupX24;
	private final ModelRenderer bone140;
	private final ModelRenderer bone142;
	private final ModelRenderer bone144;
	private final ModelRenderer Y1;
	private final ModelRenderer X3;
	private final ModelRenderer GroupX5;
	private final ModelRenderer bone26;
	private final ModelRenderer bone28;
	private final ModelRenderer bone30;
	private final ModelRenderer GroupX6;
	private final ModelRenderer bone32;
	private final ModelRenderer bone34;
	private final ModelRenderer bone36;
	private final ModelRenderer GroupX7;
	private final ModelRenderer bone38;
	private final ModelRenderer bone40;
	private final ModelRenderer bone42;
	private final ModelRenderer GroupX8;
	private final ModelRenderer bone44;
	private final ModelRenderer bone46;
	private final ModelRenderer bone48;
	private final ModelRenderer X2;
	private final ModelRenderer GroupX;
	private final ModelRenderer bone9;
	private final ModelRenderer bone5;
	private final ModelRenderer bone;
	private final ModelRenderer GroupX2;
	private final ModelRenderer bone4;
	private final ModelRenderer bone8;
	private final ModelRenderer bone12;
	private final ModelRenderer GroupX3;
	private final ModelRenderer bone14;
	private final ModelRenderer bone16;
	private final ModelRenderer bone18;
	private final ModelRenderer GroupX4;
	private final ModelRenderer bone20;
	private final ModelRenderer bone22;
	private final ModelRenderer bone24;
	private final ModelRenderer TotY2;
	private final ModelRenderer Y5;
	private final ModelRenderer X10;
	private final ModelRenderer GroupX33;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone6;
	private final ModelRenderer bone193;
	private final ModelRenderer GroupX34;
	private final ModelRenderer bone7;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer GroupX35;
	private final ModelRenderer bone13;
	private final ModelRenderer bone15;
	private final ModelRenderer bone17;
	private final ModelRenderer GroupX36;
	private final ModelRenderer bone19;
	private final ModelRenderer bone21;
	private final ModelRenderer bone23;
	private final ModelRenderer X11;
	private final ModelRenderer GroupX37;
	private final ModelRenderer bone25;
	private final ModelRenderer bone27;
	private final ModelRenderer bone29;
	private final ModelRenderer GroupX38;
	private final ModelRenderer bone31;
	private final ModelRenderer bone33;
	private final ModelRenderer bone35;
	private final ModelRenderer GroupX39;
	private final ModelRenderer bone37;
	private final ModelRenderer bone39;
	private final ModelRenderer bone41;
	private final ModelRenderer GroupX40;
	private final ModelRenderer bone43;
	private final ModelRenderer bone45;
	private final ModelRenderer bone47;
	private final ModelRenderer Y6;
	private final ModelRenderer X12;
	private final ModelRenderer GroupX41;
	private final ModelRenderer bone49;
	private final ModelRenderer bone51;
	private final ModelRenderer bone53;
	private final ModelRenderer GroupX42;
	private final ModelRenderer bone55;
	private final ModelRenderer bone57;
	private final ModelRenderer bone59;
	private final ModelRenderer GroupX43;
	private final ModelRenderer bone61;
	private final ModelRenderer bone63;
	private final ModelRenderer bone65;
	private final ModelRenderer GroupX44;
	private final ModelRenderer bone67;
	private final ModelRenderer bone69;
	private final ModelRenderer bone71;
	private final ModelRenderer X13;
	private final ModelRenderer GroupX45;
	private final ModelRenderer bone73;
	private final ModelRenderer bone75;
	private final ModelRenderer bone77;
	private final ModelRenderer GroupX46;
	private final ModelRenderer bone79;
	private final ModelRenderer bone81;
	private final ModelRenderer bone83;
	private final ModelRenderer GroupX47;
	private final ModelRenderer bone85;
	private final ModelRenderer bone87;
	private final ModelRenderer bone89;
	private final ModelRenderer GroupX48;
	private final ModelRenderer bone91;
	private final ModelRenderer bone93;
	private final ModelRenderer bone95;
	private final ModelRenderer Y7;
	private final ModelRenderer X14;
	private final ModelRenderer GroupX49;
	private final ModelRenderer bone97;
	private final ModelRenderer bone99;
	private final ModelRenderer bone101;
	private final ModelRenderer GroupX50;
	private final ModelRenderer bone103;
	private final ModelRenderer bone105;
	private final ModelRenderer bone107;
	private final ModelRenderer GroupX51;
	private final ModelRenderer bone109;
	private final ModelRenderer bone111;
	private final ModelRenderer bone113;
	private final ModelRenderer GroupX52;
	private final ModelRenderer bone115;
	private final ModelRenderer bone117;
	private final ModelRenderer bone119;
	private final ModelRenderer X15;
	private final ModelRenderer GroupX53;
	private final ModelRenderer bone121;
	private final ModelRenderer bone123;
	private final ModelRenderer bone125;
	private final ModelRenderer GroupX54;
	private final ModelRenderer bone127;
	private final ModelRenderer bone129;
	private final ModelRenderer bone131;
	private final ModelRenderer GroupX55;
	private final ModelRenderer bone133;
	private final ModelRenderer bone135;
	private final ModelRenderer bone137;
	private final ModelRenderer GroupX56;
	private final ModelRenderer bone139;
	private final ModelRenderer bone141;
	private final ModelRenderer bone143;
	private final ModelRenderer Y8;
	private final ModelRenderer X16;
	private final ModelRenderer GroupX57;
	private final ModelRenderer bone145;
	private final ModelRenderer bone147;
	private final ModelRenderer bone149;
	private final ModelRenderer GroupX58;
	private final ModelRenderer bone151;
	private final ModelRenderer bone153;
	private final ModelRenderer bone155;
	private final ModelRenderer GroupX59;
	private final ModelRenderer bone157;
	private final ModelRenderer bone159;
	private final ModelRenderer bone161;
	private final ModelRenderer GroupX60;
	private final ModelRenderer bone163;
	private final ModelRenderer bone165;
	private final ModelRenderer bone167;
	private final ModelRenderer X17;
	private final ModelRenderer GroupX61;
	private final ModelRenderer bone169;
	private final ModelRenderer bone171;
	private final ModelRenderer bone173;
	private final ModelRenderer GroupX62;
	private final ModelRenderer bone175;
	private final ModelRenderer bone177;
	private final ModelRenderer bone179;
	private final ModelRenderer GroupX63;
	private final ModelRenderer bone181;
	private final ModelRenderer bone183;
	private final ModelRenderer bone185;
	private final ModelRenderer GroupX64;
	private final ModelRenderer bone187;
	private final ModelRenderer bone189;
	private final ModelRenderer bone191;

	public HumbleweedModel() {
		textureWidth = 512;
		textureHeight = 512;

		TotY1 = new ModelRenderer(this);
		TotY1.setRotationPoint(0.0F, 16.0F, 0.0F);
		

		Y4 = new ModelRenderer(this);
		Y4.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY1.addChild(Y4);
		setRotationAngle(Y4, 0.0F, 0.0F, 1.5708F);
		

		X8 = new ModelRenderer(this);
		X8.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y4.addChild(X8);
		setRotationAngle(X8, 0.0F, -1.5708F, 0.0F);
		

		GroupX25 = new ModelRenderer(this);
		GroupX25.setRotationPoint(0.0F, -8.0F, 0.0F);
		X8.addChild(GroupX25);
		

		bone146 = new ModelRenderer(this);
		bone146.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX25.addChild(bone146);
		setRotationAngle(bone146, -2.0944F, 0.0F, 0.0F);
		bone146.setTextureOffset(168, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone148 = new ModelRenderer(this);
		bone148.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX25.addChild(bone148);
		setRotationAngle(bone148, -1.0472F, 0.0F, 0.0F);
		bone148.setTextureOffset(120, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone150 = new ModelRenderer(this);
		bone150.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX25.addChild(bone150);
		bone150.setTextureOffset(72, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX26 = new ModelRenderer(this);
		GroupX26.setRotationPoint(0.0F, -8.0F, 0.0F);
		X8.addChild(GroupX26);
		setRotationAngle(GroupX26, 0.0F, -0.5236F, 0.0F);
		

		bone152 = new ModelRenderer(this);
		bone152.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX26.addChild(bone152);
		setRotationAngle(bone152, -2.0944F, 0.0F, 0.0F);
		bone152.setTextureOffset(24, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone154 = new ModelRenderer(this);
		bone154.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX26.addChild(bone154);
		setRotationAngle(bone154, -1.0472F, 0.0F, 0.0F);
		bone154.setTextureOffset(240, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone156 = new ModelRenderer(this);
		bone156.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX26.addChild(bone156);
		bone156.setTextureOffset(240, 204).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX27 = new ModelRenderer(this);
		GroupX27.setRotationPoint(0.0F, -8.0F, 0.0F);
		X8.addChild(GroupX27);
		setRotationAngle(GroupX27, 0.0F, -1.0472F, 0.0F);
		

		bone158 = new ModelRenderer(this);
		bone158.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX27.addChild(bone158);
		setRotationAngle(bone158, -2.0944F, 0.0F, 0.0F);
		bone158.setTextureOffset(240, 180).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone160 = new ModelRenderer(this);
		bone160.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX27.addChild(bone160);
		setRotationAngle(bone160, -1.0472F, 0.0F, 0.0F);
		bone160.setTextureOffset(240, 156).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone162 = new ModelRenderer(this);
		bone162.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX27.addChild(bone162);
		bone162.setTextureOffset(240, 132).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX28 = new ModelRenderer(this);
		GroupX28.setRotationPoint(0.0F, -8.0F, 0.0F);
		X8.addChild(GroupX28);
		setRotationAngle(GroupX28, 0.0F, -1.5708F, 0.0F);
		

		bone164 = new ModelRenderer(this);
		bone164.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX28.addChild(bone164);
		setRotationAngle(bone164, -2.0944F, 0.0F, 0.0F);
		bone164.setTextureOffset(240, 108).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone166 = new ModelRenderer(this);
		bone166.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX28.addChild(bone166);
		setRotationAngle(bone166, -1.0472F, 0.0F, 0.0F);
		bone166.setTextureOffset(240, 84).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone168 = new ModelRenderer(this);
		bone168.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX28.addChild(bone168);
		bone168.setTextureOffset(240, 60).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X9 = new ModelRenderer(this);
		X9.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y4.addChild(X9);
		

		GroupX29 = new ModelRenderer(this);
		GroupX29.setRotationPoint(0.0F, -8.0F, 0.0F);
		X9.addChild(GroupX29);
		

		bone170 = new ModelRenderer(this);
		bone170.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX29.addChild(bone170);
		setRotationAngle(bone170, -2.0944F, 0.0F, 0.0F);
		bone170.setTextureOffset(240, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone172 = new ModelRenderer(this);
		bone172.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX29.addChild(bone172);
		setRotationAngle(bone172, -1.0472F, 0.0F, 0.0F);
		bone172.setTextureOffset(240, 12).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone174 = new ModelRenderer(this);
		bone174.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX29.addChild(bone174);
		bone174.setTextureOffset(240, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX30 = new ModelRenderer(this);
		GroupX30.setRotationPoint(0.0F, -8.0F, 0.0F);
		X9.addChild(GroupX30);
		setRotationAngle(GroupX30, 0.0F, -0.5236F, 0.0F);
		

		bone176 = new ModelRenderer(this);
		bone176.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX30.addChild(bone176);
		setRotationAngle(bone176, -2.0944F, 0.0F, 0.0F);
		bone176.setTextureOffset(192, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone178 = new ModelRenderer(this);
		bone178.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX30.addChild(bone178);
		setRotationAngle(bone178, -1.0472F, 0.0F, 0.0F);
		bone178.setTextureOffset(144, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone180 = new ModelRenderer(this);
		bone180.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX30.addChild(bone180);
		bone180.setTextureOffset(96, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX31 = new ModelRenderer(this);
		GroupX31.setRotationPoint(0.0F, -8.0F, 0.0F);
		X9.addChild(GroupX31);
		setRotationAngle(GroupX31, 0.0F, -1.0472F, 0.0F);
		

		bone182 = new ModelRenderer(this);
		bone182.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX31.addChild(bone182);
		setRotationAngle(bone182, -2.0944F, 0.0F, 0.0F);
		bone182.setTextureOffset(48, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone184 = new ModelRenderer(this);
		bone184.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX31.addChild(bone184);
		setRotationAngle(bone184, -1.0472F, 0.0F, 0.0F);
		bone184.setTextureOffset(0, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone186 = new ModelRenderer(this);
		bone186.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX31.addChild(bone186);
		bone186.setTextureOffset(192, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX32 = new ModelRenderer(this);
		GroupX32.setRotationPoint(0.0F, -8.0F, 0.0F);
		X9.addChild(GroupX32);
		setRotationAngle(GroupX32, 0.0F, -1.5708F, 0.0F);
		

		bone188 = new ModelRenderer(this);
		bone188.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX32.addChild(bone188);
		setRotationAngle(bone188, -2.0944F, 0.0F, 0.0F);
		bone188.setTextureOffset(144, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone190 = new ModelRenderer(this);
		bone190.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX32.addChild(bone190);
		setRotationAngle(bone190, -1.0472F, 0.0F, 0.0F);
		bone190.setTextureOffset(96, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone192 = new ModelRenderer(this);
		bone192.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX32.addChild(bone192);
		bone192.setTextureOffset(48, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y2 = new ModelRenderer(this);
		Y2.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY1.addChild(Y2);
		setRotationAngle(Y2, 0.0F, 0.0F, 0.5236F);
		

		X4 = new ModelRenderer(this);
		X4.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y2.addChild(X4);
		setRotationAngle(X4, 0.0F, -1.5708F, 0.0F);
		

		GroupX9 = new ModelRenderer(this);
		GroupX9.setRotationPoint(0.0F, -8.0F, 0.0F);
		X4.addChild(GroupX9);
		

		bone50 = new ModelRenderer(this);
		bone50.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX9.addChild(bone50);
		setRotationAngle(bone50, -2.0944F, 0.0F, 0.0F);
		bone50.setTextureOffset(216, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX9.addChild(bone52);
		setRotationAngle(bone52, -1.0472F, 0.0F, 0.0F);
		bone52.setTextureOffset(168, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone54 = new ModelRenderer(this);
		bone54.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX9.addChild(bone54);
		bone54.setTextureOffset(120, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX10 = new ModelRenderer(this);
		GroupX10.setRotationPoint(0.0F, -8.0F, 0.0F);
		X4.addChild(GroupX10);
		setRotationAngle(GroupX10, 0.0F, -0.5236F, 0.0F);
		

		bone56 = new ModelRenderer(this);
		bone56.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX10.addChild(bone56);
		setRotationAngle(bone56, -2.0944F, 0.0F, 0.0F);
		bone56.setTextureOffset(72, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone58 = new ModelRenderer(this);
		bone58.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX10.addChild(bone58);
		setRotationAngle(bone58, -1.0472F, 0.0F, 0.0F);
		bone58.setTextureOffset(24, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone60 = new ModelRenderer(this);
		bone60.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX10.addChild(bone60);
		bone60.setTextureOffset(288, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX11 = new ModelRenderer(this);
		GroupX11.setRotationPoint(0.0F, -8.0F, 0.0F);
		X4.addChild(GroupX11);
		setRotationAngle(GroupX11, 0.0F, -1.0472F, 0.0F);
		

		bone62 = new ModelRenderer(this);
		bone62.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX11.addChild(bone62);
		setRotationAngle(bone62, -2.0944F, 0.0F, 0.0F);
		bone62.setTextureOffset(288, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone64 = new ModelRenderer(this);
		bone64.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX11.addChild(bone64);
		setRotationAngle(bone64, -1.0472F, 0.0F, 0.0F);
		bone64.setTextureOffset(288, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone66 = new ModelRenderer(this);
		bone66.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX11.addChild(bone66);
		bone66.setTextureOffset(288, 204).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX12 = new ModelRenderer(this);
		GroupX12.setRotationPoint(0.0F, -8.0F, 0.0F);
		X4.addChild(GroupX12);
		setRotationAngle(GroupX12, 0.0F, -1.5708F, 0.0F);
		

		bone68 = new ModelRenderer(this);
		bone68.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX12.addChild(bone68);
		setRotationAngle(bone68, -2.0944F, 0.0F, 0.0F);
		bone68.setTextureOffset(288, 180).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone70 = new ModelRenderer(this);
		bone70.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX12.addChild(bone70);
		setRotationAngle(bone70, -1.0472F, 0.0F, 0.0F);
		bone70.setTextureOffset(288, 156).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone72 = new ModelRenderer(this);
		bone72.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX12.addChild(bone72);
		bone72.setTextureOffset(288, 132).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X5 = new ModelRenderer(this);
		X5.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y2.addChild(X5);
		

		GroupX13 = new ModelRenderer(this);
		GroupX13.setRotationPoint(0.0F, -8.0F, 0.0F);
		X5.addChild(GroupX13);
		

		bone74 = new ModelRenderer(this);
		bone74.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX13.addChild(bone74);
		setRotationAngle(bone74, -2.0944F, 0.0F, 0.0F);
		bone74.setTextureOffset(288, 108).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone76 = new ModelRenderer(this);
		bone76.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX13.addChild(bone76);
		setRotationAngle(bone76, -1.0472F, 0.0F, 0.0F);
		bone76.setTextureOffset(288, 84).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone78 = new ModelRenderer(this);
		bone78.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX13.addChild(bone78);
		bone78.setTextureOffset(288, 60).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX14 = new ModelRenderer(this);
		GroupX14.setRotationPoint(0.0F, -8.0F, 0.0F);
		X5.addChild(GroupX14);
		setRotationAngle(GroupX14, 0.0F, -0.5236F, 0.0F);
		

		bone80 = new ModelRenderer(this);
		bone80.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX14.addChild(bone80);
		setRotationAngle(bone80, -2.0944F, 0.0F, 0.0F);
		bone80.setTextureOffset(288, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone82 = new ModelRenderer(this);
		bone82.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX14.addChild(bone82);
		setRotationAngle(bone82, -1.0472F, 0.0F, 0.0F);
		bone82.setTextureOffset(288, 12).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone84 = new ModelRenderer(this);
		bone84.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX14.addChild(bone84);
		bone84.setTextureOffset(288, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX15 = new ModelRenderer(this);
		GroupX15.setRotationPoint(0.0F, -8.0F, 0.0F);
		X5.addChild(GroupX15);
		setRotationAngle(GroupX15, 0.0F, -1.0472F, 0.0F);
		

		bone86 = new ModelRenderer(this);
		bone86.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX15.addChild(bone86);
		setRotationAngle(bone86, -2.0944F, 0.0F, 0.0F);
		bone86.setTextureOffset(240, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone88 = new ModelRenderer(this);
		bone88.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX15.addChild(bone88);
		setRotationAngle(bone88, -1.0472F, 0.0F, 0.0F);
		bone88.setTextureOffset(192, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone90 = new ModelRenderer(this);
		bone90.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX15.addChild(bone90);
		bone90.setTextureOffset(144, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX16 = new ModelRenderer(this);
		GroupX16.setRotationPoint(0.0F, -8.0F, 0.0F);
		X5.addChild(GroupX16);
		setRotationAngle(GroupX16, 0.0F, -1.5708F, 0.0F);
		

		bone92 = new ModelRenderer(this);
		bone92.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX16.addChild(bone92);
		setRotationAngle(bone92, -2.0944F, 0.0F, 0.0F);
		bone92.setTextureOffset(96, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone94 = new ModelRenderer(this);
		bone94.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX16.addChild(bone94);
		setRotationAngle(bone94, -1.0472F, 0.0F, 0.0F);
		bone94.setTextureOffset(48, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone96 = new ModelRenderer(this);
		bone96.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX16.addChild(bone96);
		bone96.setTextureOffset(0, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y3 = new ModelRenderer(this);
		Y3.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY1.addChild(Y3);
		setRotationAngle(Y3, 0.0F, 0.0F, 1.0472F);
		

		X6 = new ModelRenderer(this);
		X6.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y3.addChild(X6);
		setRotationAngle(X6, 0.0F, -1.5708F, 0.0F);
		

		GroupX17 = new ModelRenderer(this);
		GroupX17.setRotationPoint(0.0F, -8.0F, 0.0F);
		X6.addChild(GroupX17);
		

		bone98 = new ModelRenderer(this);
		bone98.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX17.addChild(bone98);
		setRotationAngle(bone98, -2.0944F, 0.0F, 0.0F);
		bone98.setTextureOffset(240, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone100 = new ModelRenderer(this);
		bone100.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX17.addChild(bone100);
		setRotationAngle(bone100, -1.0472F, 0.0F, 0.0F);
		bone100.setTextureOffset(192, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone102 = new ModelRenderer(this);
		bone102.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX17.addChild(bone102);
		bone102.setTextureOffset(144, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX18 = new ModelRenderer(this);
		GroupX18.setRotationPoint(0.0F, -8.0F, 0.0F);
		X6.addChild(GroupX18);
		setRotationAngle(GroupX18, 0.0F, -0.5236F, 0.0F);
		

		bone104 = new ModelRenderer(this);
		bone104.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX18.addChild(bone104);
		setRotationAngle(bone104, -2.0944F, 0.0F, 0.0F);
		bone104.setTextureOffset(96, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone106 = new ModelRenderer(this);
		bone106.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX18.addChild(bone106);
		setRotationAngle(bone106, -1.0472F, 0.0F, 0.0F);
		bone106.setTextureOffset(48, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone108 = new ModelRenderer(this);
		bone108.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX18.addChild(bone108);
		bone108.setTextureOffset(0, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX19 = new ModelRenderer(this);
		GroupX19.setRotationPoint(0.0F, -8.0F, 0.0F);
		X6.addChild(GroupX19);
		setRotationAngle(GroupX19, 0.0F, -1.0472F, 0.0F);
		

		bone110 = new ModelRenderer(this);
		bone110.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX19.addChild(bone110);
		setRotationAngle(bone110, -2.0944F, 0.0F, 0.0F);
		bone110.setTextureOffset(264, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone112 = new ModelRenderer(this);
		bone112.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX19.addChild(bone112);
		setRotationAngle(bone112, -1.0472F, 0.0F, 0.0F);
		bone112.setTextureOffset(264, 216).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone114 = new ModelRenderer(this);
		bone114.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX19.addChild(bone114);
		bone114.setTextureOffset(264, 192).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX20 = new ModelRenderer(this);
		GroupX20.setRotationPoint(0.0F, -8.0F, 0.0F);
		X6.addChild(GroupX20);
		setRotationAngle(GroupX20, 0.0F, -1.5708F, 0.0F);
		

		bone116 = new ModelRenderer(this);
		bone116.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX20.addChild(bone116);
		setRotationAngle(bone116, -2.0944F, 0.0F, 0.0F);
		bone116.setTextureOffset(264, 168).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone118 = new ModelRenderer(this);
		bone118.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX20.addChild(bone118);
		setRotationAngle(bone118, -1.0472F, 0.0F, 0.0F);
		bone118.setTextureOffset(264, 144).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone120 = new ModelRenderer(this);
		bone120.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX20.addChild(bone120);
		bone120.setTextureOffset(264, 120).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X7 = new ModelRenderer(this);
		X7.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y3.addChild(X7);
		

		GroupX21 = new ModelRenderer(this);
		GroupX21.setRotationPoint(0.0F, -8.0F, 0.0F);
		X7.addChild(GroupX21);
		

		bone122 = new ModelRenderer(this);
		bone122.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX21.addChild(bone122);
		setRotationAngle(bone122, -2.0944F, 0.0F, 0.0F);
		bone122.setTextureOffset(264, 96).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone124 = new ModelRenderer(this);
		bone124.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX21.addChild(bone124);
		setRotationAngle(bone124, -1.0472F, 0.0F, 0.0F);
		bone124.setTextureOffset(264, 72).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone126 = new ModelRenderer(this);
		bone126.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX21.addChild(bone126);
		bone126.setTextureOffset(264, 48).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX22 = new ModelRenderer(this);
		GroupX22.setRotationPoint(0.0F, -8.0F, 0.0F);
		X7.addChild(GroupX22);
		setRotationAngle(GroupX22, 0.0F, -0.5236F, 0.0F);
		

		bone128 = new ModelRenderer(this);
		bone128.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX22.addChild(bone128);
		setRotationAngle(bone128, -2.0944F, 0.0F, 0.0F);
		bone128.setTextureOffset(264, 24).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone130 = new ModelRenderer(this);
		bone130.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX22.addChild(bone130);
		setRotationAngle(bone130, -1.0472F, 0.0F, 0.0F);
		bone130.setTextureOffset(264, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone132 = new ModelRenderer(this);
		bone132.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX22.addChild(bone132);
		bone132.setTextureOffset(240, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX23 = new ModelRenderer(this);
		GroupX23.setRotationPoint(0.0F, -8.0F, 0.0F);
		X7.addChild(GroupX23);
		setRotationAngle(GroupX23, 0.0F, -1.0472F, 0.0F);
		

		bone134 = new ModelRenderer(this);
		bone134.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX23.addChild(bone134);
		setRotationAngle(bone134, -2.0944F, 0.0F, 0.0F);
		bone134.setTextureOffset(192, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone136 = new ModelRenderer(this);
		bone136.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX23.addChild(bone136);
		setRotationAngle(bone136, -1.0472F, 0.0F, 0.0F);
		bone136.setTextureOffset(144, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone138 = new ModelRenderer(this);
		bone138.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX23.addChild(bone138);
		bone138.setTextureOffset(96, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX24 = new ModelRenderer(this);
		GroupX24.setRotationPoint(0.0F, -8.0F, 0.0F);
		X7.addChild(GroupX24);
		setRotationAngle(GroupX24, 0.0F, -1.5708F, 0.0F);
		

		bone140 = new ModelRenderer(this);
		bone140.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX24.addChild(bone140);
		setRotationAngle(bone140, -2.0944F, 0.0F, 0.0F);
		bone140.setTextureOffset(48, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone142 = new ModelRenderer(this);
		bone142.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX24.addChild(bone142);
		setRotationAngle(bone142, -1.0472F, 0.0F, 0.0F);
		bone142.setTextureOffset(0, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone144 = new ModelRenderer(this);
		bone144.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX24.addChild(bone144);
		bone144.setTextureOffset(216, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y1 = new ModelRenderer(this);
		Y1.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY1.addChild(Y1);
		

		X3 = new ModelRenderer(this);
		X3.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y1.addChild(X3);
		setRotationAngle(X3, 0.0F, -1.5708F, 0.0F);
		

		GroupX5 = new ModelRenderer(this);
		GroupX5.setRotationPoint(0.0F, -8.0F, 0.0F);
		X3.addChild(GroupX5);
		

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX5.addChild(bone26);
		setRotationAngle(bone26, -2.0944F, 0.0F, 0.0F);
		bone26.setTextureOffset(312, 72).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX5.addChild(bone28);
		setRotationAngle(bone28, -1.0472F, 0.0F, 0.0F);
		bone28.setTextureOffset(312, 48).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX5.addChild(bone30);
		bone30.setTextureOffset(312, 24).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX6 = new ModelRenderer(this);
		GroupX6.setRotationPoint(0.0F, -8.0F, 0.0F);
		X3.addChild(GroupX6);
		setRotationAngle(GroupX6, 0.0F, -0.5236F, 0.0F);
		

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX6.addChild(bone32);
		setRotationAngle(bone32, -2.0944F, 0.0F, 0.0F);
		bone32.setTextureOffset(312, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX6.addChild(bone34);
		setRotationAngle(bone34, -1.0472F, 0.0F, 0.0F);
		bone34.setTextureOffset(288, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX6.addChild(bone36);
		bone36.setTextureOffset(240, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX7 = new ModelRenderer(this);
		GroupX7.setRotationPoint(0.0F, -8.0F, 0.0F);
		X3.addChild(GroupX7);
		setRotationAngle(GroupX7, 0.0F, -1.0472F, 0.0F);
		

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX7.addChild(bone38);
		setRotationAngle(bone38, -2.0944F, 0.0F, 0.0F);
		bone38.setTextureOffset(192, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX7.addChild(bone40);
		setRotationAngle(bone40, -1.0472F, 0.0F, 0.0F);
		bone40.setTextureOffset(144, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX7.addChild(bone42);
		bone42.setTextureOffset(96, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX8 = new ModelRenderer(this);
		GroupX8.setRotationPoint(0.0F, -8.0F, 0.0F);
		X3.addChild(GroupX8);
		setRotationAngle(GroupX8, 0.0F, -1.5708F, 0.0F);
		

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX8.addChild(bone44);
		setRotationAngle(bone44, -2.0944F, 0.0F, 0.0F);
		bone44.setTextureOffset(48, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX8.addChild(bone46);
		setRotationAngle(bone46, -1.0472F, 0.0F, 0.0F);
		bone46.setTextureOffset(0, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX8.addChild(bone48);
		bone48.setTextureOffset(264, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X2 = new ModelRenderer(this);
		X2.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y1.addChild(X2);
		

		GroupX = new ModelRenderer(this);
		GroupX.setRotationPoint(0.0F, -8.0F, 0.0F);
		X2.addChild(GroupX);
		

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX.addChild(bone9);
		setRotationAngle(bone9, -2.0944F, 0.0F, 0.0F);
		bone9.setTextureOffset(24, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX.addChild(bone5);
		setRotationAngle(bone5, -1.0472F, 0.0F, 0.0F);
		bone5.setTextureOffset(72, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX.addChild(bone);
		bone.setTextureOffset(120, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX2 = new ModelRenderer(this);
		GroupX2.setRotationPoint(0.0F, -8.0F, 0.0F);
		X2.addChild(GroupX2);
		setRotationAngle(GroupX2, 0.0F, -0.5236F, 0.0F);
		

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX2.addChild(bone4);
		setRotationAngle(bone4, -2.0944F, 0.0F, 0.0F);
		bone4.setTextureOffset(312, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX2.addChild(bone8);
		setRotationAngle(bone8, -1.0472F, 0.0F, 0.0F);
		bone8.setTextureOffset(312, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX2.addChild(bone12);
		bone12.setTextureOffset(312, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX3 = new ModelRenderer(this);
		GroupX3.setRotationPoint(0.0F, -8.0F, 0.0F);
		X2.addChild(GroupX3);
		setRotationAngle(GroupX3, 0.0F, -1.0472F, 0.0F);
		

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX3.addChild(bone14);
		setRotationAngle(bone14, -2.0944F, 0.0F, 0.0F);
		bone14.setTextureOffset(312, 216).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX3.addChild(bone16);
		setRotationAngle(bone16, -1.0472F, 0.0F, 0.0F);
		bone16.setTextureOffset(312, 192).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX3.addChild(bone18);
		bone18.setTextureOffset(312, 168).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX4 = new ModelRenderer(this);
		GroupX4.setRotationPoint(0.0F, -8.0F, 0.0F);
		X2.addChild(GroupX4);
		setRotationAngle(GroupX4, 0.0F, -1.5708F, 0.0F);
		

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX4.addChild(bone20);
		setRotationAngle(bone20, -2.0944F, 0.0F, 0.0F);
		bone20.setTextureOffset(312, 144).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX4.addChild(bone22);
		setRotationAngle(bone22, -1.0472F, 0.0F, 0.0F);
		bone22.setTextureOffset(312, 120).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX4.addChild(bone24);
		bone24.setTextureOffset(312, 96).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		TotY2 = new ModelRenderer(this);
		TotY2.setRotationPoint(0.0F, 16.0F, 0.0F);
		

		Y5 = new ModelRenderer(this);
		Y5.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY2.addChild(Y5);
		setRotationAngle(Y5, 0.0F, 0.0F, 1.5708F);
		

		X10 = new ModelRenderer(this);
		X10.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y5.addChild(X10);
		setRotationAngle(X10, 0.0F, -1.5708F, 0.0F);
		

		GroupX33 = new ModelRenderer(this);
		GroupX33.setRotationPoint(0.0F, -8.0F, 0.0F);
		X10.addChild(GroupX33);
		

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX33.addChild(bone2);
		setRotationAngle(bone2, -2.0944F, 0.0F, 0.0F);
		bone2.setTextureOffset(168, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX33.addChild(bone3);
		setRotationAngle(bone3, -1.0472F, 0.0F, 0.0F);
		bone3.setTextureOffset(120, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX33.addChild(bone6);
		bone6.setTextureOffset(72, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);
		bone6.setTextureOffset(72, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone193 = new ModelRenderer(this);
		bone193.setRotationPoint(6.0F, 2.0F, -6.0F);
		bone6.addChild(bone193);
		

		GroupX34 = new ModelRenderer(this);
		GroupX34.setRotationPoint(0.0F, -8.0F, 0.0F);
		X10.addChild(GroupX34);
		setRotationAngle(GroupX34, 0.0F, -0.5236F, 0.0F);
		

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX34.addChild(bone7);
		setRotationAngle(bone7, -2.0944F, 0.0F, 0.0F);
		bone7.setTextureOffset(24, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX34.addChild(bone10);
		setRotationAngle(bone10, -1.0472F, 0.0F, 0.0F);
		bone10.setTextureOffset(240, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX34.addChild(bone11);
		bone11.setTextureOffset(240, 204).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX35 = new ModelRenderer(this);
		GroupX35.setRotationPoint(0.0F, -8.0F, 0.0F);
		X10.addChild(GroupX35);
		setRotationAngle(GroupX35, 0.0F, -1.0472F, 0.0F);
		

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX35.addChild(bone13);
		setRotationAngle(bone13, -2.0944F, 0.0F, 0.0F);
		bone13.setTextureOffset(240, 180).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX35.addChild(bone15);
		setRotationAngle(bone15, -1.0472F, 0.0F, 0.0F);
		bone15.setTextureOffset(240, 156).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX35.addChild(bone17);
		bone17.setTextureOffset(240, 132).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX36 = new ModelRenderer(this);
		GroupX36.setRotationPoint(0.0F, -8.0F, 0.0F);
		X10.addChild(GroupX36);
		setRotationAngle(GroupX36, 0.0F, -1.5708F, 0.0F);
		

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX36.addChild(bone19);
		setRotationAngle(bone19, -2.0944F, 0.0F, 0.0F);
		bone19.setTextureOffset(240, 108).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX36.addChild(bone21);
		setRotationAngle(bone21, -1.0472F, 0.0F, 0.0F);
		bone21.setTextureOffset(240, 84).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX36.addChild(bone23);
		bone23.setTextureOffset(240, 60).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X11 = new ModelRenderer(this);
		X11.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y5.addChild(X11);
		

		GroupX37 = new ModelRenderer(this);
		GroupX37.setRotationPoint(0.0F, -8.0F, 0.0F);
		X11.addChild(GroupX37);
		

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX37.addChild(bone25);
		setRotationAngle(bone25, -2.0944F, 0.0F, 0.0F);
		bone25.setTextureOffset(240, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX37.addChild(bone27);
		setRotationAngle(bone27, -1.0472F, 0.0F, 0.0F);
		bone27.setTextureOffset(240, 12).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX37.addChild(bone29);
		bone29.setTextureOffset(240, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX38 = new ModelRenderer(this);
		GroupX38.setRotationPoint(0.0F, -8.0F, 0.0F);
		X11.addChild(GroupX38);
		setRotationAngle(GroupX38, 0.0F, -0.5236F, 0.0F);
		

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX38.addChild(bone31);
		setRotationAngle(bone31, -2.0944F, 0.0F, 0.0F);
		bone31.setTextureOffset(192, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX38.addChild(bone33);
		setRotationAngle(bone33, -1.0472F, 0.0F, 0.0F);
		bone33.setTextureOffset(144, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX38.addChild(bone35);
		bone35.setTextureOffset(96, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX39 = new ModelRenderer(this);
		GroupX39.setRotationPoint(0.0F, -8.0F, 0.0F);
		X11.addChild(GroupX39);
		setRotationAngle(GroupX39, 0.0F, -1.0472F, 0.0F);
		

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX39.addChild(bone37);
		setRotationAngle(bone37, -2.0944F, 0.0F, 0.0F);
		bone37.setTextureOffset(48, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX39.addChild(bone39);
		setRotationAngle(bone39, -1.0472F, 0.0F, 0.0F);
		bone39.setTextureOffset(0, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX39.addChild(bone41);
		bone41.setTextureOffset(192, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX40 = new ModelRenderer(this);
		GroupX40.setRotationPoint(0.0F, -8.0F, 0.0F);
		X11.addChild(GroupX40);
		setRotationAngle(GroupX40, 0.0F, -1.5708F, 0.0F);
		

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX40.addChild(bone43);
		setRotationAngle(bone43, -2.0944F, 0.0F, 0.0F);
		bone43.setTextureOffset(144, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX40.addChild(bone45);
		setRotationAngle(bone45, -1.0472F, 0.0F, 0.0F);
		bone45.setTextureOffset(96, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX40.addChild(bone47);
		bone47.setTextureOffset(48, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y6 = new ModelRenderer(this);
		Y6.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY2.addChild(Y6);
		setRotationAngle(Y6, 0.0F, 0.0F, 0.5236F);
		

		X12 = new ModelRenderer(this);
		X12.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y6.addChild(X12);
		setRotationAngle(X12, 0.0F, -1.5708F, 0.0F);
		

		GroupX41 = new ModelRenderer(this);
		GroupX41.setRotationPoint(0.0F, -8.0F, 0.0F);
		X12.addChild(GroupX41);
		

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX41.addChild(bone49);
		setRotationAngle(bone49, -2.0944F, 0.0F, 0.0F);
		bone49.setTextureOffset(216, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone51 = new ModelRenderer(this);
		bone51.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX41.addChild(bone51);
		setRotationAngle(bone51, -1.0472F, 0.0F, 0.0F);
		bone51.setTextureOffset(168, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone53 = new ModelRenderer(this);
		bone53.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX41.addChild(bone53);
		bone53.setTextureOffset(120, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX42 = new ModelRenderer(this);
		GroupX42.setRotationPoint(0.0F, -8.0F, 0.0F);
		X12.addChild(GroupX42);
		setRotationAngle(GroupX42, 0.0F, -0.5236F, 0.0F);
		

		bone55 = new ModelRenderer(this);
		bone55.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX42.addChild(bone55);
		setRotationAngle(bone55, -2.0944F, 0.0F, 0.0F);
		bone55.setTextureOffset(72, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone57 = new ModelRenderer(this);
		bone57.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX42.addChild(bone57);
		setRotationAngle(bone57, -1.0472F, 0.0F, 0.0F);
		bone57.setTextureOffset(24, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone59 = new ModelRenderer(this);
		bone59.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX42.addChild(bone59);
		bone59.setTextureOffset(288, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX43 = new ModelRenderer(this);
		GroupX43.setRotationPoint(0.0F, -8.0F, 0.0F);
		X12.addChild(GroupX43);
		setRotationAngle(GroupX43, 0.0F, -1.0472F, 0.0F);
		

		bone61 = new ModelRenderer(this);
		bone61.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX43.addChild(bone61);
		setRotationAngle(bone61, -2.0944F, 0.0F, 0.0F);
		bone61.setTextureOffset(288, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone63 = new ModelRenderer(this);
		bone63.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX43.addChild(bone63);
		setRotationAngle(bone63, -1.0472F, 0.0F, 0.0F);
		bone63.setTextureOffset(288, 228).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone65 = new ModelRenderer(this);
		bone65.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX43.addChild(bone65);
		bone65.setTextureOffset(288, 204).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX44 = new ModelRenderer(this);
		GroupX44.setRotationPoint(0.0F, -8.0F, 0.0F);
		X12.addChild(GroupX44);
		setRotationAngle(GroupX44, 0.0F, -1.5708F, 0.0F);
		

		bone67 = new ModelRenderer(this);
		bone67.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX44.addChild(bone67);
		setRotationAngle(bone67, -2.0944F, 0.0F, 0.0F);
		bone67.setTextureOffset(288, 180).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone69 = new ModelRenderer(this);
		bone69.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX44.addChild(bone69);
		setRotationAngle(bone69, -1.0472F, 0.0F, 0.0F);
		bone69.setTextureOffset(288, 156).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone71 = new ModelRenderer(this);
		bone71.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX44.addChild(bone71);
		bone71.setTextureOffset(288, 132).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X13 = new ModelRenderer(this);
		X13.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y6.addChild(X13);
		

		GroupX45 = new ModelRenderer(this);
		GroupX45.setRotationPoint(0.0F, -8.0F, 0.0F);
		X13.addChild(GroupX45);
		

		bone73 = new ModelRenderer(this);
		bone73.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX45.addChild(bone73);
		setRotationAngle(bone73, -2.0944F, 0.0F, 0.0F);
		bone73.setTextureOffset(288, 108).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone75 = new ModelRenderer(this);
		bone75.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX45.addChild(bone75);
		setRotationAngle(bone75, -1.0472F, 0.0F, 0.0F);
		bone75.setTextureOffset(288, 84).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone77 = new ModelRenderer(this);
		bone77.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX45.addChild(bone77);
		bone77.setTextureOffset(288, 60).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX46 = new ModelRenderer(this);
		GroupX46.setRotationPoint(0.0F, -8.0F, 0.0F);
		X13.addChild(GroupX46);
		setRotationAngle(GroupX46, 0.0F, -0.5236F, 0.0F);
		

		bone79 = new ModelRenderer(this);
		bone79.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX46.addChild(bone79);
		setRotationAngle(bone79, -2.0944F, 0.0F, 0.0F);
		bone79.setTextureOffset(288, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone81 = new ModelRenderer(this);
		bone81.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX46.addChild(bone81);
		setRotationAngle(bone81, -1.0472F, 0.0F, 0.0F);
		bone81.setTextureOffset(288, 12).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone83 = new ModelRenderer(this);
		bone83.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX46.addChild(bone83);
		bone83.setTextureOffset(288, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX47 = new ModelRenderer(this);
		GroupX47.setRotationPoint(0.0F, -8.0F, 0.0F);
		X13.addChild(GroupX47);
		setRotationAngle(GroupX47, 0.0F, -1.0472F, 0.0F);
		

		bone85 = new ModelRenderer(this);
		bone85.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX47.addChild(bone85);
		setRotationAngle(bone85, -2.0944F, 0.0F, 0.0F);
		bone85.setTextureOffset(240, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone87 = new ModelRenderer(this);
		bone87.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX47.addChild(bone87);
		setRotationAngle(bone87, -1.0472F, 0.0F, 0.0F);
		bone87.setTextureOffset(192, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone89 = new ModelRenderer(this);
		bone89.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX47.addChild(bone89);
		bone89.setTextureOffset(144, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX48 = new ModelRenderer(this);
		GroupX48.setRotationPoint(0.0F, -8.0F, 0.0F);
		X13.addChild(GroupX48);
		setRotationAngle(GroupX48, 0.0F, -1.5708F, 0.0F);
		

		bone91 = new ModelRenderer(this);
		bone91.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX48.addChild(bone91);
		setRotationAngle(bone91, -2.0944F, 0.0F, 0.0F);
		bone91.setTextureOffset(96, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone93 = new ModelRenderer(this);
		bone93.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX48.addChild(bone93);
		setRotationAngle(bone93, -1.0472F, 0.0F, 0.0F);
		bone93.setTextureOffset(48, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone95 = new ModelRenderer(this);
		bone95.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX48.addChild(bone95);
		bone95.setTextureOffset(0, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y7 = new ModelRenderer(this);
		Y7.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY2.addChild(Y7);
		setRotationAngle(Y7, 0.0F, 0.0F, 1.0472F);
		

		X14 = new ModelRenderer(this);
		X14.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y7.addChild(X14);
		setRotationAngle(X14, 0.0F, -1.5708F, 0.0F);
		

		GroupX49 = new ModelRenderer(this);
		GroupX49.setRotationPoint(0.0F, -8.0F, 0.0F);
		X14.addChild(GroupX49);
		

		bone97 = new ModelRenderer(this);
		bone97.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX49.addChild(bone97);
		setRotationAngle(bone97, -2.0944F, 0.0F, 0.0F);
		bone97.setTextureOffset(240, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone99 = new ModelRenderer(this);
		bone99.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX49.addChild(bone99);
		setRotationAngle(bone99, -1.0472F, 0.0F, 0.0F);
		bone99.setTextureOffset(192, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone101 = new ModelRenderer(this);
		bone101.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX49.addChild(bone101);
		bone101.setTextureOffset(144, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX50 = new ModelRenderer(this);
		GroupX50.setRotationPoint(0.0F, -8.0F, 0.0F);
		X14.addChild(GroupX50);
		setRotationAngle(GroupX50, 0.0F, -0.5236F, 0.0F);
		

		bone103 = new ModelRenderer(this);
		bone103.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX50.addChild(bone103);
		setRotationAngle(bone103, -2.0944F, 0.0F, 0.0F);
		bone103.setTextureOffset(96, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone105 = new ModelRenderer(this);
		bone105.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX50.addChild(bone105);
		setRotationAngle(bone105, -1.0472F, 0.0F, 0.0F);
		bone105.setTextureOffset(48, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone107 = new ModelRenderer(this);
		bone107.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX50.addChild(bone107);
		bone107.setTextureOffset(0, 276).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX51 = new ModelRenderer(this);
		GroupX51.setRotationPoint(0.0F, -8.0F, 0.0F);
		X14.addChild(GroupX51);
		setRotationAngle(GroupX51, 0.0F, -1.0472F, 0.0F);
		

		bone109 = new ModelRenderer(this);
		bone109.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX51.addChild(bone109);
		setRotationAngle(bone109, -2.0944F, 0.0F, 0.0F);
		bone109.setTextureOffset(264, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone111 = new ModelRenderer(this);
		bone111.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX51.addChild(bone111);
		setRotationAngle(bone111, -1.0472F, 0.0F, 0.0F);
		bone111.setTextureOffset(264, 216).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone113 = new ModelRenderer(this);
		bone113.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX51.addChild(bone113);
		bone113.setTextureOffset(264, 192).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX52 = new ModelRenderer(this);
		GroupX52.setRotationPoint(0.0F, -8.0F, 0.0F);
		X14.addChild(GroupX52);
		setRotationAngle(GroupX52, 0.0F, -1.5708F, 0.0F);
		

		bone115 = new ModelRenderer(this);
		bone115.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX52.addChild(bone115);
		setRotationAngle(bone115, -2.0944F, 0.0F, 0.0F);
		bone115.setTextureOffset(264, 168).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone117 = new ModelRenderer(this);
		bone117.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX52.addChild(bone117);
		setRotationAngle(bone117, -1.0472F, 0.0F, 0.0F);
		bone117.setTextureOffset(264, 144).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone119 = new ModelRenderer(this);
		bone119.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX52.addChild(bone119);
		bone119.setTextureOffset(264, 120).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X15 = new ModelRenderer(this);
		X15.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y7.addChild(X15);
		

		GroupX53 = new ModelRenderer(this);
		GroupX53.setRotationPoint(0.0F, -8.0F, 0.0F);
		X15.addChild(GroupX53);
		

		bone121 = new ModelRenderer(this);
		bone121.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX53.addChild(bone121);
		setRotationAngle(bone121, -2.0944F, 0.0F, 0.0F);
		bone121.setTextureOffset(264, 96).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone123 = new ModelRenderer(this);
		bone123.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX53.addChild(bone123);
		setRotationAngle(bone123, -1.0472F, 0.0F, 0.0F);
		bone123.setTextureOffset(264, 72).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone125 = new ModelRenderer(this);
		bone125.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX53.addChild(bone125);
		bone125.setTextureOffset(264, 48).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX54 = new ModelRenderer(this);
		GroupX54.setRotationPoint(0.0F, -8.0F, 0.0F);
		X15.addChild(GroupX54);
		setRotationAngle(GroupX54, 0.0F, -0.5236F, 0.0F);
		

		bone127 = new ModelRenderer(this);
		bone127.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX54.addChild(bone127);
		setRotationAngle(bone127, -2.0944F, 0.0F, 0.0F);
		bone127.setTextureOffset(264, 24).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone129 = new ModelRenderer(this);
		bone129.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX54.addChild(bone129);
		setRotationAngle(bone129, -1.0472F, 0.0F, 0.0F);
		bone129.setTextureOffset(264, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone131 = new ModelRenderer(this);
		bone131.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX54.addChild(bone131);
		bone131.setTextureOffset(240, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX55 = new ModelRenderer(this);
		GroupX55.setRotationPoint(0.0F, -8.0F, 0.0F);
		X15.addChild(GroupX55);
		setRotationAngle(GroupX55, 0.0F, -1.0472F, 0.0F);
		

		bone133 = new ModelRenderer(this);
		bone133.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX55.addChild(bone133);
		setRotationAngle(bone133, -2.0944F, 0.0F, 0.0F);
		bone133.setTextureOffset(192, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone135 = new ModelRenderer(this);
		bone135.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX55.addChild(bone135);
		setRotationAngle(bone135, -1.0472F, 0.0F, 0.0F);
		bone135.setTextureOffset(144, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone137 = new ModelRenderer(this);
		bone137.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX55.addChild(bone137);
		bone137.setTextureOffset(96, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX56 = new ModelRenderer(this);
		GroupX56.setRotationPoint(0.0F, -8.0F, 0.0F);
		X15.addChild(GroupX56);
		setRotationAngle(GroupX56, 0.0F, -1.5708F, 0.0F);
		

		bone139 = new ModelRenderer(this);
		bone139.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX56.addChild(bone139);
		setRotationAngle(bone139, -2.0944F, 0.0F, 0.0F);
		bone139.setTextureOffset(48, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone141 = new ModelRenderer(this);
		bone141.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX56.addChild(bone141);
		setRotationAngle(bone141, -1.0472F, 0.0F, 0.0F);
		bone141.setTextureOffset(0, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone143 = new ModelRenderer(this);
		bone143.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX56.addChild(bone143);
		bone143.setTextureOffset(216, 252).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		Y8 = new ModelRenderer(this);
		Y8.setRotationPoint(0.0F, 0.0F, 0.0F);
		TotY2.addChild(Y8);
		

		X16 = new ModelRenderer(this);
		X16.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y8.addChild(X16);
		setRotationAngle(X16, 0.0F, -1.5708F, 0.0F);
		

		GroupX57 = new ModelRenderer(this);
		GroupX57.setRotationPoint(0.0F, -8.0F, 0.0F);
		X16.addChild(GroupX57);
		

		bone145 = new ModelRenderer(this);
		bone145.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX57.addChild(bone145);
		setRotationAngle(bone145, -2.0944F, 0.0F, 0.0F);
		bone145.setTextureOffset(312, 72).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone147 = new ModelRenderer(this);
		bone147.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX57.addChild(bone147);
		setRotationAngle(bone147, -1.0472F, 0.0F, 0.0F);
		bone147.setTextureOffset(312, 48).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone149 = new ModelRenderer(this);
		bone149.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX57.addChild(bone149);
		bone149.setTextureOffset(312, 24).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX58 = new ModelRenderer(this);
		GroupX58.setRotationPoint(0.0F, -8.0F, 0.0F);
		X16.addChild(GroupX58);
		setRotationAngle(GroupX58, 0.0F, -0.5236F, 0.0F);
		

		bone151 = new ModelRenderer(this);
		bone151.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX58.addChild(bone151);
		setRotationAngle(bone151, -2.0944F, 0.0F, 0.0F);
		bone151.setTextureOffset(312, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone153 = new ModelRenderer(this);
		bone153.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX58.addChild(bone153);
		setRotationAngle(bone153, -1.0472F, 0.0F, 0.0F);
		bone153.setTextureOffset(288, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone155 = new ModelRenderer(this);
		bone155.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX58.addChild(bone155);
		bone155.setTextureOffset(240, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX59 = new ModelRenderer(this);
		GroupX59.setRotationPoint(0.0F, -8.0F, 0.0F);
		X16.addChild(GroupX59);
		setRotationAngle(GroupX59, 0.0F, -1.0472F, 0.0F);
		

		bone157 = new ModelRenderer(this);
		bone157.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX59.addChild(bone157);
		setRotationAngle(bone157, -2.0944F, 0.0F, 0.0F);
		bone157.setTextureOffset(192, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone159 = new ModelRenderer(this);
		bone159.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX59.addChild(bone159);
		setRotationAngle(bone159, -1.0472F, 0.0F, 0.0F);
		bone159.setTextureOffset(144, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone161 = new ModelRenderer(this);
		bone161.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX59.addChild(bone161);
		bone161.setTextureOffset(96, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX60 = new ModelRenderer(this);
		GroupX60.setRotationPoint(0.0F, -8.0F, 0.0F);
		X16.addChild(GroupX60);
		setRotationAngle(GroupX60, 0.0F, -1.5708F, 0.0F);
		

		bone163 = new ModelRenderer(this);
		bone163.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX60.addChild(bone163);
		setRotationAngle(bone163, -2.0944F, 0.0F, 0.0F);
		bone163.setTextureOffset(48, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone165 = new ModelRenderer(this);
		bone165.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX60.addChild(bone165);
		setRotationAngle(bone165, -1.0472F, 0.0F, 0.0F);
		bone165.setTextureOffset(0, 312).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone167 = new ModelRenderer(this);
		bone167.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX60.addChild(bone167);
		bone167.setTextureOffset(264, 300).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		X17 = new ModelRenderer(this);
		X17.setRotationPoint(0.0F, 8.0F, 0.0F);
		Y8.addChild(X17);
		

		GroupX61 = new ModelRenderer(this);
		GroupX61.setRotationPoint(0.0F, -8.0F, 0.0F);
		X17.addChild(GroupX61);
		

		bone169 = new ModelRenderer(this);
		bone169.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX61.addChild(bone169);
		setRotationAngle(bone169, -2.0944F, 0.0F, 0.0F);
		bone169.setTextureOffset(24, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone171 = new ModelRenderer(this);
		bone171.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX61.addChild(bone171);
		setRotationAngle(bone171, -1.0472F, 0.0F, 0.0F);
		bone171.setTextureOffset(72, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone173 = new ModelRenderer(this);
		bone173.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX61.addChild(bone173);
		bone173.setTextureOffset(120, 324).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX62 = new ModelRenderer(this);
		GroupX62.setRotationPoint(0.0F, -8.0F, 0.0F);
		X17.addChild(GroupX62);
		setRotationAngle(GroupX62, 0.0F, -0.5236F, 0.0F);
		

		bone175 = new ModelRenderer(this);
		bone175.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX62.addChild(bone175);
		setRotationAngle(bone175, -2.0944F, 0.0F, 0.0F);
		bone175.setTextureOffset(312, 288).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone177 = new ModelRenderer(this);
		bone177.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX62.addChild(bone177);
		setRotationAngle(bone177, -1.0472F, 0.0F, 0.0F);
		bone177.setTextureOffset(312, 264).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone179 = new ModelRenderer(this);
		bone179.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX62.addChild(bone179);
		bone179.setTextureOffset(312, 240).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX63 = new ModelRenderer(this);
		GroupX63.setRotationPoint(0.0F, -8.0F, 0.0F);
		X17.addChild(GroupX63);
		setRotationAngle(GroupX63, 0.0F, -1.0472F, 0.0F);
		

		bone181 = new ModelRenderer(this);
		bone181.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX63.addChild(bone181);
		setRotationAngle(bone181, -2.0944F, 0.0F, 0.0F);
		bone181.setTextureOffset(312, 216).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone183 = new ModelRenderer(this);
		bone183.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX63.addChild(bone183);
		setRotationAngle(bone183, -1.0472F, 0.0F, 0.0F);
		bone183.setTextureOffset(312, 192).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone185 = new ModelRenderer(this);
		bone185.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX63.addChild(bone185);
		bone185.setTextureOffset(312, 168).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		GroupX64 = new ModelRenderer(this);
		GroupX64.setRotationPoint(0.0F, -8.0F, 0.0F);
		X17.addChild(GroupX64);
		setRotationAngle(GroupX64, 0.0F, -1.5708F, 0.0F);
		

		bone187 = new ModelRenderer(this);
		bone187.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX64.addChild(bone187);
		setRotationAngle(bone187, -2.0944F, 0.0F, 0.0F);
		bone187.setTextureOffset(312, 144).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone189 = new ModelRenderer(this);
		bone189.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX64.addChild(bone189);
		setRotationAngle(bone189, -1.0472F, 0.0F, 0.0F);
		bone189.setTextureOffset(312, 120).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);

		bone191 = new ModelRenderer(this);
		bone191.setRotationPoint(0.0F, 0.0F, 0.0F);
		GroupX64.addChild(bone191);
		bone191.setTextureOffset(312, 96).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		TotY1.render(matrixStack, buffer, packedLight, packedOverlay);
		TotY2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}
}
