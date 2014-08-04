package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

public class afterJoinMSG extends GuiScreen{
	public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    public EntityClientPlayerMP thePlayer;

    /**
     * The Entity from which the renderer determines the render viewpoint. Currently is always the parent Minecraft
     * class's 'thePlayer' instance. Modification of its location, rotation, or other settings at render time will
     * modify the camera likewise, with the caveat of triggering chunk rebuilds as it moves, making it unsuitable for
     * changing the viewpoint mid-render.
     */
    public EntityLivingBase renderViewEntity;
    public EntityLivingBase pointedEntityLiving;
    public EffectRenderer effectRenderer;
    
    private boolean isGamePaused;
	public void initGui()
    {
		buttonList.clear();
		int r1 = this.height / 30; 
		int lw=256*9/20;
		int lh= lw*159/475;
		this.buttonList.add(new ArouseButton(0, this.width / 2-69,2*r1+60+20, 68, 15, "返回"));
		
		//EntityClientPlayerMP s = new EntityClientPlayerMP(mc, theWorld,mc.session, null);
        
		//DEn( 51, 75, 30, 0 , 0 , s);
    }

	protected void actionPerformed(GuiButton par1GuiButton)
	{
		if (par1GuiButton.id == 0)
        {
			
        }
		else if (par1GuiButton.id == 1)
        {
			
        }
		else if (par1GuiButton.id == 2)
        {
			
        }
		else if (par1GuiButton.id == 3)
        {
			
        }
		else if (par1GuiButton.id == 4)
        {
			
        }
	}
	
    public void drawScreen(int par1, int par2, float par3)
    {
    	
            //在这里绘制文本或纹理等非控件内容,这里绘制的东西会被控件(即按键)盖住.
    	
        super.drawScreen(par1,par2,par3);
            //在这里绘制文本或纹理等非控件内容,这里绘制的东西会盖在控件(即按键)之上.
    }
}
