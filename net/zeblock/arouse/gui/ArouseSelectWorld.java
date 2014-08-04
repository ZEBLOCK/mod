package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;

public class ArouseSelectWorld extends GuiSelectWorld {
	
	ArouseMainGui ag;
	private static final ResourceLocation bg= new ResourceLocation("arouse:bg.png");

	public ArouseSelectWorld(GuiScreen par1GuiScreen) {
		super(par1GuiScreen);
		// TODO Auto-generated constructor stub
	}
	
	private void renderSkybox(int par1, int par2, float par3)
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
        	ag.de(0,           -nimgh/2+h/2, 0, 0    , w     ,nimgh    ,w ,256);
        }
        else if(w <= h*imgw/imgh){
        	ag.de(-nimgw/2+w/2,           0, 0, 0    , h     ,nimgw    ,h ,imgh);
        }
        GL11.glColorMask(true, true, true, true);
    }
	
	public void drawScreen(int par1, int par2, float par3)
    {
		super.drawScreen(par1, par2, par3);
		//renderSkybox(par2, par2, par3);
    }

}
