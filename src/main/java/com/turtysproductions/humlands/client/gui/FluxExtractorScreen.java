package com.turtysproductions.humlands.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.container.FluxExtractorContainer;
import com.turtysproductions.humlands.common.tileentities.FluxExtractorTileEntity;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FluxExtractorScreen extends ContainerScreen<FluxExtractorContainer> {

	private FluxExtractorTileEntity te;
	private static final ResourceLocation FLUX_EXTRACTOR_GUI = new ResourceLocation(HumlandsMod.MOD_ID,
			"textures/gui/flux_extractor_gui.png");

	public FluxExtractorScreen(FluxExtractorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 201;
		this.te = screenContainer.tileEntity;
	}

	@Override
	public void render(final int mouseX, final int mouseY, final float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 0xE3FFFF);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 71.0f, 0xE3FFFF);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(FLUX_EXTRACTOR_GUI);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.blit(x, y, 0, 0, this.xSize, this.ySize);
		this.blit(this.guiLeft + 79, this.guiTop + 34, 176, 14, (int) (this.te.pseudoProgressTime / 200.0f * 24.0f), 16);
	}
}
