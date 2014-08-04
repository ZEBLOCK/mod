package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class ArouseScreen extends GuiScreen{
	
	protected static final ResourceLocation bg= new ResourceLocation("arouse:bg.png");
	
	public void de(double d, double y, int u, double w, double nimgh, double w2, double w3, double imgw){
		double f = 0.00390625F/w3*imgw;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.addVertexWithUV((double)(d + 0), (double)(y + w2), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(w + w2) * f));
        tessellator.addVertexWithUV((double)(d + nimgh), (double)(y + w2), (double)this.zLevel, (double)((float)(u + nimgh) * f), (double)((float)(w + w2) * f));
        tessellator.addVertexWithUV((double)(d + nimgh), (double)(y + 0), (double)this.zLevel, (double)((float)(u + nimgh) * f), (double)((float)(w + 0) * f));
        tessellator.addVertexWithUV((double)(d + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(w + 0) * f));
        tessellator.draw();
    }
	
	public void renderSkybox()
    {
    	
        this.mc.getTextureManager().bindTexture(bg);
        
        //这里开始的是我辛辛苦苦自创的
        double w = this.width;//k
        double h = this.height;//l
        double imgw = 256;
        double imgh = 256;
        double nimgh = w*imgh/imgw;
        double nimgw = h*imgw/imgh;
        
        if(w>h*imgw/imgh){
        	de(0,           -nimgh/2+h/2, 0, 0    , w     ,nimgh    ,w ,256);
        }
        else if(w <= h*imgw/imgh){
        	de(-nimgw/2+w/2,           0, 0, 0    , h     ,nimgw    ,h ,imgh);
        }
        GL11.glColorMask(true, true, true, true);
    }
}
