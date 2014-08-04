package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class eyeButton extends GuiButton{
	
	boolean textChange=true;
	
	public eyeButton(int par1, int par2, int par3, int par4, int par5,
			String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
		// TODO Auto-generated constructor stub
	}
	
protected static final ResourceLocation money = new ResourceLocation("arouse:news.png");
	
	public void drawTexturedModalRectFree(int x, double y, int u, int v, int w, int h, float n, float o){
		float f = 0.00390625F/n*o;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + h), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + w), (double)(y + h), (double)this.zLevel, (double)((float)(u + w) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + w), (double)(y + 0), (double)this.zLevel, (double)((float)(u + w) * f), (double)((float)(v + 0) * f));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f));
        tessellator.draw();
    }
	
	
	
	
	
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            par1Minecraft.getTextureManager().bindTexture(money);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            if(textChange){
            	
            	drawTexturedModalRectFree(this.xPosition, this.yPosition, 94, 0, this.width, this.height, 1, 1);
            }
            if(textChange == false){
            	drawTexturedModalRectFree(this.xPosition, this.yPosition, 114, 0, this.width, this.height, 1, 1);
            }
        }
    }
	
	

}
