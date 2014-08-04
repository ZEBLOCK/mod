package net.zeblock.arouse.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;

@SideOnly(Side.CLIENT)
public class OpenGuiHandler
{
	public static OpenGuiHandler instance = new OpenGuiHandler();
	int check = 1;

	  @ForgeSubscribe
	  public void openMenu(GuiOpenEvent event) {
		  if (event.gui instanceof GuiMainMenu){
			  event.gui = new aboutGui();
		  }
	  }
}