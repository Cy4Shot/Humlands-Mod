package com.turtysproductions.humlands.common.client.gui;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.container.TimeCapsuleContainer;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TimeCapsuleScreen extends ContainerScreen<TimeCapsuleContainer>
{
  

        private static final ResourceLocation TIME_CAPSULE_GUI = new ResourceLocation(HumlandsMod.MOD_ID, "textures/gui/time_capsule_gui.png");

        public TimeCapsuleScreen(TimeCapsuleContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) 
        {
	    super(screenContainer, inv, titleIn);
	    this.guiLeft = 0;
	    this.guiTop = 0;
	    this.xSize = 175;
	    this.ySize = 201;
        }
        
        @Override
        public void render(final int mouseX, final int mouseY, final float partialTicks) {
        // TODO Auto-generated method stub
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        
        }
        
        @Override
        protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
        {
        
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        //drawString takes in the startX and startY of the text by using float values, together with the color of the text.
        this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 0xE3FFFF);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 107.0f, 0xE3FFFF);
        
        }
        
        @Override
        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
        {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(TIME_CAPSULE_GUI);
        int x = (this.width - this.xSize) /2;
        int y = (this.height - this.ySize) /2;
        this.blit(x, y, 0, 0,  this.xSize, this.ySize);
        
        }
   
}
