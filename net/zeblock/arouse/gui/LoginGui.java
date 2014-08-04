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
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.stats.StatList;
import net.zeblock.arouse.gui.network.OpenURI;

public class LoginGui extends ArouseScreen{
	int loginType;
	ArouseTF textBox;
	ArouseButtonWithBGW login;
	eyeButton eye;
	String Pass;
	public boolean PassWRONG=false;

	//GuiTextField textBo;
    public LoginGui(int logintype)
    {
    	this.loginType = logintype;
    }

    public LoginGui(int logintype,boolean par2)
    {
    	this.loginType = logintype;
    	this.PassWRONG=par2;
    }
    
    protected void keyTyped(char par1, int par2)
    {
    	if (this.loginType == 0){
    		//textBox是你之前添加的文本框,有多个文本框
        //下面这个代码是向文本框追加文本,如果你有多个文本框,就为每一个文本框都调用一次
        //别担心,方法会自动判断此文本框是否被设为焦点的
    	//textBo.textboxKeyTyped(par1, par2);
        textBox.textboxKeyTyped(par1, par2);
        if (par1 == '\r')
        {
         //在此添加玩家按下回车键后的操作
        }
    	}
        
    }
    
    protected void mouseClicked(int par1, int par2, int par3)
    {
    	if (this.loginType == 0){
        super.mouseClicked(par1, par2, par3);
        textBox.mouseClicked(par1, par2, par3);
        //同样,如果你有多个文本框,则每个都要来一遍
        //textBo.mouseClicked(par1, par2, par3);
        }
    }
    
    protected void actionReleased(GuiButton par1GuiButton) {
    	if (par1GuiButton.id == 6)
        {
    		eye.textChange=true;
    		this.textBox.ispassword=true;
        }
    }
    
    public void updateScreen()
    {
    	if (this.loginType == 0){
    		this.textBox.updateCursorCounter();
        	
        	if(textBox.getText().length()>5&&textBox.getText()!="输入密码..."){
        		Pass=textBox.getText();
        		login.displayString="和小伙伴们去玩咯！";
        		eye.drawButton=true;
        	}else if(textBox.getText().length()<6||textBox.getText()=="输入密码..."){
        		Pass=null;
        		login.displayString="密码长度至少为六！";
        		eye.drawButton=false;
        	}
        }
    	
        
    }

    
    
    public void initGui()
    {
    	if (this.loginType == 0){
    		this.buttonList.clear();
    		this.buttonList.add(login =new ArouseButtonWithBGW(3, this.width/2-70,this.height/2+70, 140, 20, "密码长度至少为六！"));
    		this.buttonList.add(new registerButton(4, this.width/2-70,this.height/2+92, 140, 15, "忘记密码了？"));
    		this.buttonList.add(new ArouseButtonWithBG(5, this.width/2+80,this.height/2+70, 60, 20, "返回"));
    		this.buttonList.add(eye=new eyeButton(6, this.width/2+50,this.height/2+50, 20, 20, ""));
    		/*if(textBox.getText().length()>5){
    			eye.displayString="和小伙伴们去玩咯！";
    		}*/
    		eye.drawButton=false;
    		
    		Keyboard.enableRepeatEvents(true);
    		textBox = new ArouseTF(fontRenderer, width / 2 - 70, this.height/2+50, 120, 20);
    		//fontRenderer是文本渲染器,后面的4个参数分别对应X,Y,宽,高(高建议为20)
    		textBox.setFocused(false);  //设置是否已被设为焦点
    		//设为焦点,相当于玩家左键一个文本框,即准备往里输入
    		//如果有多个文本框,不要同时都设为焦点
    		if (Pass==null){
    		textBox.setText("输入密码...");}else{
    			textBox.setText(this.Pass);
    		} //设置文本框默认文本}
    		textBox.setMaxStringLength(20);  //此为设置最大长度,可以省略
    		
    		/*textBo = new GuiTextField(fontRenderer, width / 2 - 100, 76, 200, 20);
    		//fontRenderer是文本渲染器,后面的4个参数分别对应X,Y,宽,高(高建议为20)
    		textBo.setFocused(true);  //设置是否已被设为焦点
    		//设为焦点,相当于玩家左键一个文本框,即准备往里输入文字
    		//如果有多个文本框,不要同时都设为焦点
    		textBo.setText(""); //设置文本框默认文本
    		textBo.setMaxStringLength(128);  //此为设置最大长度,可以省略*/

    	}
    	
    	if (this.loginType == 2){
    		
    		this.buttonList.add(new ArouseButtonWithBGW(1, this.width/2-70,this.height/2-20, 140, 20, "确定"));
    	}
    	
    	
    	//this.DEn( 51, 75, 30, (float)( 51) , (float)(75 - 50) , this.mc.thePlayer);
            //这里部署控件
    }
    
    protected void actionPerformed(GuiButton par1GuiButton){
    	if (par1GuiButton.id == 1)
        {
			OpenURI.openURL("http://www.baidu.com/");
			
			par1GuiButton.enabled = false;
            this.mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
            this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld((WorldClient)null);
            this.mc.displayGuiScreen(new ArouseMainGui());
            mc.checkZEGui=0;
        }
    	
    	if (par1GuiButton.id == 2){
			par1GuiButton.enabled = false;
			this.mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
			this.mc.theWorld.sendQuittingDisconnectingPacket();
			this.mc.loadWorld((WorldClient)null);
			this.mc.displayGuiScreen(new ArouseMainGui());
			mc.checkZEGui=0;
		}
    	
    	if (par1GuiButton.id == 3){
    		if (this.textBox.getText().length()>5){
    			this.mc.thePlayer.sendChatMessage("/login "+this.textBox.getText());
    		}
    	}
    	if (par1GuiButton.id == 4){
    		OpenURI.openURL("http://www.baidu.com/");
    	}
    	if (par1GuiButton.id == 5)
        {
    		par1GuiButton.enabled = false;
            this.mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
            this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld((WorldClient)null);
            this.mc.displayGuiScreen(new ArouseMainGui());
            mc.checkZEGui=0;
        }
    	if (par1GuiButton.id == 6)
        {
    		this.textBox.ispassword=false;
    		eye.textChange=false;
        }
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
        par5EntityLivingBase.renderYawOffset = (float)Math.atan((double)(par3 / 40.0F)) * 50.0F;
        par5EntityLivingBase.rotationYaw = (float)Math.atan((double)(par3 / 40.0F)) * 50.0F;
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
    
    public void drawScreen(int par1, int par2, float par3)
    {
            this.renderSkybox();
            
            if (this.loginType == 0){
            	
            	float i = Mouse.getEventX() * this.width / this.mc.displayWidth;
            	this.drawRect(this.width/2+50,this.height/2+50,this.width/2+70, this.height/2+70, 0x50000000);
            	this.drawRect(this.width/2-70, this.height/2-128,this.width/2+70, this.height/2+45, 0x50000000);
            	this.drawRect(this.width/2-70, this.height/2+45,this.width/2+70, this.height/2+47, 0x50000000);
            	this.drawRect(this.width/2-70, this.height/2+90,this.width/2+70, this.height/2+128, 0x50000000);
            	this.DEn( this.width / 2,this.height/2+35, 60, -(float)i+this.width/2, 0,mc.thePlayer);
            	
            	GL11.glPushMatrix();
                GL11.glTranslatef((float)(this.width / 2 ), this.height/2-105, 0.0F);
                GL11.glScalef(2.0f, 2.0f, 2.0f);
                this.drawCenteredString(fontRenderer, mc.thePlayer.username,0, 0, 0xffffff);
                GL11.glPopMatrix();
            	textBox.drawTextBox();
            	//textBo.drawTextBox();
        	}
        	
        	if (this.loginType == 2){
        		this.drawRect(this.width/2-70, 10,this.width/2+70, this.height-20, 0x80000000);
        		this.drawCenteredString(fontRenderer, "系统检测到您还未注册帐号", this.width/2, this.height/2-50, 0xff0059);
        		this.drawCenteredString(fontRenderer, "请前往官网注册", this.width/2, this.height/2-35, 0xff0059);
        		
        	}
        	
        	
            super.drawScreen(par1,par2,par3);
            //在这里绘制文本或纹理等非控件内容,这里绘制的东西会盖在控件(即按键)之上.
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }
}
