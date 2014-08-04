package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.stats.StatList;
import net.zeblock.arouse.gui.network.OpenURI;

public class WRONGPASS extends ArouseScreen{
	
    protected void keyTyped(char par1, int par2)
    {
    	
        if (par1 == '\r')
        {
         //在此添加玩家按下回车键后的操作
        }
    	
        
    }
    
    
    
    public void initGui()
    {
    	this.buttonList.add(new ArouseButtonWithBGW(1, this.width/2-70,this.height/2-20, 140, 20, "确定"));
    	
    }
    
    protected void actionPerformed(GuiButton par1GuiButton){
    	if (par1GuiButton.id == 1)
        {
			mc.displayGuiScreen(new LoginGui(0));
            mc.checkZEGui=0;
        }
    	
    	
    }

   
    
    
    
    public void drawScreen(int par1, int par2, float par3)
    {
            this.renderSkybox();
            
            this.drawRect(this.width/2-70, 10,this.width/2+70, this.height-20, 0x80000000);
        	this.drawCenteredString(fontRenderer, "您输入的密码错误", this.width/2, this.height/2-35, 0xff0059);
        	
            super.drawScreen(par1,par2,par3);
            //在这里绘制文本或纹理等非控件内容,这里绘制的东西会盖在控件(即按键)之上.
    }

    public void onGuiClosed()
    {
        
    }
}
