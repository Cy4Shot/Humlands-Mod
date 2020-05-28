package com.turtysproductions.humlands.client.ter;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.turtysproductions.humlands.common.blocks.ShaperBlock;
import com.turtysproductions.humlands.common.tileentities.ShaperTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

@SuppressWarnings("deprecation")
public class ShaperTileEntityRenderer extends TileEntityRenderer<ShaperTileEntity> {

	public ShaperTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(ShaperTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ItemStack itemstack = tileEntityIn.getInventory().get(0);
		Direction facing = tileEntityIn.getBlockState().get(ShaperBlock.FACING);
		if (itemstack != ItemStack.EMPTY) {
			matrixStackIn.push();
			if (facing == Direction.SOUTH) {
				matrixStackIn.translate(0.5D, 0.3125D, 0.625D);
			}
			if (facing == Direction.NORTH) {
				matrixStackIn.translate(0.5D, 0.3125D, 0.375D);
			}
			if (facing == Direction.EAST) {
				matrixStackIn.translate(0.625D, 0.3125D, 0.5D);
			}
			if (facing == Direction.WEST) {
				matrixStackIn.translate(0.375D, 0.3125D, 0.5D);
			}
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-Direction
					.byHorizontalIndex((tileEntityIn.getBlockState().get(ShaperBlock.FACING).getHorizontalIndex()) % 4)
					.getHorizontalAngle()));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			matrixStackIn.scale(0.375F, 0.375F, 0.375F);
			Minecraft.getInstance().getItemRenderer().renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED,
					combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
			matrixStackIn.pop();
		}

		ItemStack itemstack2 = tileEntityIn.getInventory().get(1);
		if (itemstack2 != ItemStack.EMPTY) {
			matrixStackIn.push();
			if (facing == Direction.SOUTH) {
				matrixStackIn.translate(0.5D, 1.0625D, 0.6875D);
			}
			if (facing == Direction.NORTH) {
				matrixStackIn.translate(0.5D, 1.0625D, 0.3125D);
			}
			if (facing == Direction.EAST) {
				matrixStackIn.translate(0.6875D, 1.0625D, 0.5D);
			}
			if (facing == Direction.WEST) {
				matrixStackIn.translate(0.3125D, 1.0625D, 0.5D);
			}
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-Direction
					.byHorizontalIndex((tileEntityIn.getBlockState().get(ShaperBlock.FACING).getHorizontalIndex()) % 4)
					.getHorizontalAngle()));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
			matrixStackIn.scale(0.375F, 0.375F, 0.375F);
			Minecraft.getInstance().getItemRenderer().renderItem(itemstack2, ItemCameraTransforms.TransformType.FIXED,
					combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
			matrixStackIn.pop();
		}
	}
}