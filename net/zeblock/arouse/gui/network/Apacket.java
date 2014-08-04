package net.zeblock.arouse.gui.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;



public class Apacket {
	public int packetType;
	public String[] dataString;
	public int[] dataInt;
	public byte[] dataByte;
	
	public Apacket(){
	    this.packetType = 0;
	    this.dataString = null;
	    this.dataInt = null;
	    this.dataByte = null;
	}
	
	public Packet toPacket()
	{
	    //因为最终我们需要Byte数组，所以使用ByteArrayOutputStream。
	    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	    //因为我们要写入其他类型的数据，所以使用DataOutputStream。
	    DataOutputStream data = new DataOutputStream(bytes);
	    //新建一个MC的封包。
	    Packet250CustomPayload pkt = new Packet250CustomPayload();
	    try
	    {
	        //通过这个函数来写入数据，等会再实现。
	        writeData(data);
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    //封包使用的管道
	    pkt.channel = "ArouseX";
	    //数据
	    pkt.data = bytes.toByteArray();
	    //封包大小 
	    pkt.length = pkt.data.length;
	    return pkt;
	}
	
	public static Apacket parse(byte[] bytes) throws IOException
	{
	    //我们需要DataInputStream作为输入。
	    DataInputStream data = new DataInputStream(new ByteArrayInputStream(bytes));
	    //新建一个我们自己的封包。
	    Apacket pkt = new Apacket();
	    //通过这个函数来读取数据，等会再实现。
	    pkt.readData(data);
	    return pkt;
	}
	
	private void writeData(DataOutputStream data) throws IOException
	{
	    //首先写入封包类型
	    data.writeInt(this.packetType);
	    if (this.dataString != null)
	    {
	        //dataString不为null则写入其长度
	        data.writeByte(this.dataString.length);
	    }
	    else
	    {
	        //dataString为null则写入0
	        data.writeByte(0);
	    }
	    if (this.dataInt != null)
	    {
	        //dataInt不为null则写入其长度
	        data.writeByte(this.dataInt.length);
	    }
	    else
	    {
	        //dataInt为null则写入0
	        data.writeByte(0);
	    }
	     if (this.dataByte != null)
	    {
	        //dataByte不为null则写入其长度
	        data.writeByte(this.dataByte.length);
	    }
	    else
	    {
	        //dataByte为null则写入0
	        data.writeByte(0);
	    }
	    //写入dataString数组的所有内容
	    if (this.dataString != null)
	    {
	        for (String s : this.dataString)
	        {
	            data.writeUTF(s);
	        }
	    }
	    //写入dataInt数组的所有内容
	    if (this.dataInt != null)
	    {
	        for (int i : this.dataInt)
	        {
	            data.writeInt(i);
	        }
	    }
	    //写入dataByte数组的所有内容
	    if (this.dataByte != null)
	    {
	        for (byte b : this.dataByte)
	        {
	            data.writeByte(b);
	        }
	    }
	}
	
	private void readData(DataInputStream data) throws IOException
	{
	    //首先读取封包类型
	    this.packetType = data.readInt();
	    //读取String数组长度
	    byte nString = data.readByte();
	    //读取int数组长度
	    byte nInt = data.readByte();
	    //读取byte数组长度
	    byte nByte = data.readByte();
	    if ((nString > 128) || (nInt > 128) || (nByte > 128) || (nString < 0) || (nInt < 0) || (nByte < 0))
	    {
	        //如果其中任何一个长度大于128或小于0，则抛出IOException异常
	        throw new IOException("");
	    }
	    if (nString == 0)
	    {
	        //如果String长度为0，则dataString为null
	        this.dataString = null;
	    }
	    else
	    {
	        //如果String长度不为0，则创建一个String数组，长度为nString
	        this.dataString = new String[nString];
	        //读取String数据
	        for (int k = 0; k < nString; k++)
	        {
	            this.dataString[k] = data.readUTF();
	        }
	    }
	    if (nInt == 0)
	    {
	        //如果int长度为0，则dataInt为null
	        this.dataInt = null;
	    }
	    else
	    {
	        //如果int长度不为0，则创建一个int数组，长度为nInt
	        this.dataInt = new int[nInt];
	        //读取int数据
	        for (int k = 0; k < nInt; k++)
	        {
	            this.dataInt[k] = data.readInt();
	        }
	    }
	    if (nByte == 0)
	    {
	        //如果byte长度为0，则dataByte为null
	        this.dataByte = null;
	    }
	    else
	    {
	        //如果byte长度不为0，则创建一个byte数组，长度为nByte
	        this.dataByte = new byte[nByte];
	        //读取byte数据
	        for (int k = 0; k < nByte; k++)
	        {
	            this.dataByte[k] = data.readByte();
	        }
	    }
	}
}
