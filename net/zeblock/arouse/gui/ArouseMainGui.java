package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;


@SideOnly(Side.CLIENT)
public class ArouseMainGui extends ArouseScreen{
	private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
	private static final ResourceLocation ZEblockLogo = new ResourceLocation("arouse:ZEGUILOGO.png");
	private static final ResourceLocation news = new ResourceLocation("arouse:news.png");
	
	public void initGui(){
		buttonList.clear();
		int r1 = this.height / 30; 
		int lw=256*9/20;
		int lh= lw*159/475;
		this.buttonList.add(new ArouseButton(0, this.width / 2-69,2*r1+60+20, 68, 15, "单人游戏"));
		this.buttonList.add(new ArouseButton(1, this.width / 2-69,2*r1+60+35, 68, 15, "进入ZEblock"));
		this.buttonList.add(new ArouseButton(2, this.width / 2-69,2*r1+60+50, 68, 15, "设置"));
		this.buttonList.add(new ArouseButton(3, this.width / 2-69,2*r1+60+70, 68, 15, "关于"));
		this.buttonList.add(new newsButton(4, this.width / 2+50,r1+30-lh/2, 47/2, 105/2, ""));
		this.buttonList.add(new moneyButton(5, this.width / 2+100,this.height/2-30, 43, 80, ""));
		//this.DEn( 51, 75, 30, (float)( 51) , (float)(75 - 50) , this.mc.thePlayer);
		
    }
	
	public static void DEn(int par0, int par1, int par2, float par3, float par4, EntityLivingBase par5EntityLivingBase)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par0, (float)par1, 50.0F);
        GL11.glScalef((float)(-par2), (float)par2, (float)par2);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = par5EntityLivingBase.renderYawOffset;
        float f3 = par5EntityLivingBase.rotationYaw;
        float f4 = par5EntityLivingBase.rotationPitch;
        float f5 = par5EntityLivingBase.prevRotationYawHead;
        float f6 = par5EntityLivingBase.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par5EntityLivingBase.renderYawOffset = (float)Math.atan((double)(par3 / 40.0F)) * 20.0F;
        par5EntityLivingBase.rotationYaw = (float)Math.atan((double)(par3 / 40.0F)) * 40.0F;
        par5EntityLivingBase.rotationPitch = -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F;
        par5EntityLivingBase.rotationYawHead = par5EntityLivingBase.rotationYaw;
        par5EntityLivingBase.prevRotationYawHead = par5EntityLivingBase.rotationYaw;
        GL11.glTranslatef(0.0F, par5EntityLivingBase.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        par5EntityLivingBase.renderYawOffset = f2;
        par5EntityLivingBase.rotationYaw = f3;
        par5EntityLivingBase.rotationPitch = f4;
        par5EntityLivingBase.prevRotationYawHead = f5;
        par5EntityLivingBase.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
	
	protected void actionPerformed(GuiButton par1GuiButton)
	{
		if (par1GuiButton.id == 2)
        {
			mc.displayGuiScreen(new ArouseOption(this, this.mc.gameSettings));
        }

        if (par1GuiButton.id == 5)
        {
            
        }

        if (par1GuiButton.id == 1)
        {
        	this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }

        if (par1GuiButton.id == 0)
        {
        	mc.displayGuiScreen(new ArouseSelectWorld(this));
        }

        if (par1GuiButton.id == 3)
        {
        	mc.displayGuiScreen(new aboutGui());
        }

        if (par1GuiButton.id == 4)
        {
           
        }

        if (par1GuiButton.id == 6)
        {
            
        }

        
	}
	
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
	
	private void drawTexturedModalRectFre(int x, double d, int u, int v,
			double w, double h, int n, int o) {
		float f = 0.00390625F/n*o;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(d + h), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + w), (double)(d + h), (double)this.zLevel, (double)((float)(u + w) * f), (double)((float)(v + h) * f));
        tessellator.addVertexWithUV((double)(x + w), (double)(d + 0), (double)this.zLevel, (double)((float)(u + w) * f), (double)((float)(v + 0) * f));
        tessellator.addVertexWithUV((double)(x + 0), (double)(d + 0), (double)this.zLevel, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f));
        tessellator.draw();
	}

	public void drawCaidan(){
		int n=9;
		int o=20;
		int w=256*n/o;
		int r1 = this.height / 30; 
		int lh= w*159/475;
		int tw = this.width;
		int th = this.height;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.width / 2-70 ), r1+65, 0.0F);
	       
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        drawString(this.fontRenderer, "今天是Peter生日", 0, -8, 0xC4C4C4);
        GL11.glPopMatrix();
        
	}
	
	public void drawString(FontRenderer par1FontRenderer, String par2Str, int par3, int par4, int par5)
    {
        par1FontRenderer.drawString(par2Str, par3, par4, par5);
    }
	
	private void drawzl(){
		
		int n=9;
		int o=20;
		int w=256*n/o;
		int h= w*159/475;
		int tw = this.width;
		int th = this.height;
		int r1 = this.height / 30; 
		int bgh= 60;
		
		this.mc.getTextureManager().bindTexture(ZEblockLogo);
		
		drawTexturedModalRectFree(tw/2-70, r1+bgh/2-h/2, 0, 0, w, h, n, o);
	}
    
	public void drawScreen(int par1, int par2, float par3){
		
		this.renderSkybox();
		int r1 = this.height / 15;
		//GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		//GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		//GL11.glDisable(GL11.GL_TEXTURE_2D);
		//drawRect(this.width / 2 - 90,r1/2+60,this.width / 2 + 90,r1/2+74,0x70000000);
		drawRect(this.width / 2 ,r1/2+60+15,this.width / 2 + 90,this.height - 40 - r1/2-10,0x70000000);
		drawRect(this.width / 2 - 90,r1/2+60+15,this.width / 2 -70,this.height - 40 - r1/2-10,0x70000000);
		drawRect(this.width / 2 - 69,r1/2+60+15,this.width / 2 - 1,this.height - 40 - r1/2-10,0x85000000);
		drawRect(this.width / 2 + 56,r1/2,this.width / 2 + 90,r1/2+74,0x70000000);
		drawRect(this.width / 2 - 90,r1/2,this.width / 2 + 56,r1/2+74,0x70000000);
		drawRect(this.width / 2 - 90,this.height - 40 - r1/2,this.width / 2 + 90,this.height - r1/2,0x70000000);
		//drawCenteredString(this.fontRenderer,"MINECRAFT 1.6.4",this.width / 2,this.height - 35 - r1/2,16777215);
		//this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
		int mclogoy = 16;
        //this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
        //this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
        this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        
        
        drawTexturedModalRectFree(this.width / 2-70,this.height - 10.5 - r1/2-mclogoy,0,0,mclogoy*155/44,mclogoy,16f,44.0f);
        drawTexturedModalRectFree(mclogoy*155/44 + this.width / 2-70,this.height - 10.7-mclogoy - r1/2,0,16,mclogoy*155/44,mclogoy,16f,44.0f);
        drawzl();
        drawCaidan();
        
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2 ), this.height - 13 - r1/2, 0.0F);
       
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        this.drawCenteredString(this.fontRenderer, "             "/*13SCAPES*/+"_1.6.4", 0, -8, 0xC4C4C4);
        GL11.glPopMatrix();
        //GL11.glPopMatrix();
        
		super.drawScreen(par1, par2, par3);
	}
	
	protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        
    }

}