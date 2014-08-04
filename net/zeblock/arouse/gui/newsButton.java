package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class newsButton extends GuiButton{

	public newsButton(int par1, int par2, int par3, int par4, int par5,
			String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
		// TODO Auto-generated constructor stub
	}
	
	protected static final ResourceLocation buttonTextures = new ResourceLocation("arouse:news.png");
	
	public void drawTexturedModalRectFree(int x, double y, double e, int v, double d, int h, float n, float o){
		float f = 0.00390625F/n*o;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + h), (double)this.zLevel, (double)((float)(e + 0) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + d), (double)(y + h), (double)this.zLevel, (double)((float)(e + d) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + d), (double)(y + 0), (double)this.zLevel, (double)((float)(e + d) * f), (double)((float)(v + 0) * f));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(e + 0) * f), (double)((float)(v + 0) * f));
        tessellator.draw();
    }

	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(buttonTextures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = this.getHoverState(this.field_82253_i);
            if (k==1){
            	drawTexturedModalRectFree(this.xPosition, this.yPosition, 0, 0, this.width+0.5, this.height,1, 2);
            }
            else if(k==2){
            	drawTexturedModalRectFree(this.xPosition, this.yPosition, 47/2+0.5, 0, this.width+1, this.height,1, 2);
            }
            
            //this.drawTexturedModalRect(this.xPosition, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.mouseDragged(par1Minecraft, par2, par3);
        }
    }

}
