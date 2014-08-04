package net.zeblock.arouse.gui;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.zeblock.arouse.gui.network.Apacket;

@Mod(modid="y")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

@SideOnly(Side.CLIENT)

public class ArouseMod
{
    //private Minecraft mc;
	public static ArouseMod instance;
	public int check;
	
	@EventHandler
	public void preload(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(OpenGuiHandler.instance);
	}
	@EventHandler
	public void load(FMLInitializationEvent event){
		//mc.displayGuiScreen(new aboutGui());
	}
	@EventHandler
	public void postload(FMLPostInitializationEvent event){
		//MinecraftForge.EVENT_BUS.unregister(n);
    
	}
	
	public void setcheck(int par1){
		this.check= par1;
	}
	
	public static void handlePacketFromClient(Apacket packet, EntityPlayerMP player)
	{
	    
	}
	@SideOnly(Side.CLIENT)
	public static void handlePacketFromServer(Apacket packet)
	{
	    
	}
}
