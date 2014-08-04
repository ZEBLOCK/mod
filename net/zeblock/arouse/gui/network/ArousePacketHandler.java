package net.zeblock.arouse.gui.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.nio.charset.Charset;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.zeblock.arouse.gui.ArouseMod;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ArousePacketHandler implements IPacketHandler{

	public void onPacketData(INetworkManager manager, Packet250CustomPayload _packet, Player player)
	{
	    try
	    {
	        //首先装换Packet250CustomPayload到我们自己的封包
	        Apacket packet = Apacket.parse(_packet.data);
	        if(player instanceof EntityPlayerMP)
	        {
	            //如果player参数是EntityPlayerMP的实例，那么调用handlePacketFromClient方法
	            ArouseMod.handlePacketFromClient(packet, (EntityPlayerMP)player);
	        }
	        else
	        {
	            //反之调用handlePacketFromServer方法
	            ArouseMod.handlePacketFromServer(packet);
	        }
	    }
	    catch (Exception e)
	    {
	        
	    }
	}
	}


