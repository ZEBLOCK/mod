package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class ArouseButtonWithBGW extends GuiButton{

	public ArouseButtonWithBGW(int par1, int par2, int par3, int par4, int par5,
			String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
		// TODO Auto-generated constructor stub
	}
	
	public ArouseButtonWithBGW(int par1, int par2, int par3, String par4Str)
    {
		super(par1, par2, par3, 200, 20, par4Str);
    }
	
	
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            FontRenderer fontrenderer = par1Minecraft.fontRenderer;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = this.getHoverState(this.field_82253_i);
            
            if (k==1){
            	drawRect(this.xPosition, this.yPosition,this.width+this.xPosition, this.height+this.yPosition, 0x50FFFFFF);
            }
            else if(k==2){
            	drawRect(this.xPosition, this.yPosition, this.width+this.xPosition, this.height+this.yPosition, 0x50ffffff);
            }
            this.mouseDragged(par1Minecraft, par2, par3);
            int l = 0xFFFFFF;
            String q = "";
            String h = "";

            if (!this.enabled)
            {
                l = -6250336;
            }
            else if (this.field_82253_i)
            {
                l = 0xFFFFFF;
                q = "> ";
                h = " <";
                
            }
            GL11.glPushMatrix();
    	       
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            this.drawCenteredString(fontrenderer, q+this.displayString+h, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
            GL11.glPopMatrix();

            
        }
    }

	

}
