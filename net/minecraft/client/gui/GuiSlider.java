package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.EnumOptions;
import net.zeblock.arouse.gui.ArouseButtonWithBG;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiSlider extends ArouseButtonWithBG
{
    /** The value of this slider control. */
    public float sliderValue = 1.0F;

    /** Is this slider control being dragged. */
    public boolean dragging;

    /** Additional ID for this slider control. */
    private EnumOptions idFloat;

    public GuiSlider(int par1, int par2, int par3, EnumOptions par4EnumOptions, String par5Str, float par6)
    {
        super(par1, par2, par3, 146, 20, par5Str);
        this.idFloat = par4EnumOptions;
        this.sliderValue = par6;
    }

    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    protected int getHoverState(boolean par1)
    {
        return 0;
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            if (this.dragging)
            {
                this.sliderValue = (float)(par2 - (this.xPosition + 4)) / (float)(this.width - 8);

                if (this.sliderValue < 0.0F)
                {
                    this.sliderValue = 0.0F;
                }

                if (this.sliderValue > 1.0F)
                {
                    this.sliderValue = 1.0F;
                }

                par1Minecraft.gameSettings.setOptionFloatValue(this.idFloat, this.sliderValue);
                this.displayString = par1Minecraft.gameSettings.getKeyBinding(this.idFloat);
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            this.drawRect(this.xPosition +2+ (int)(this.sliderValue * (float)(this.width - 8)) ,  this.yPosition, this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4+2, this.yPosition+20, 0x50ffffff);
            this.drawRect(this.xPosition,  this.yPosition, this.xPosition +2+ (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition+20, 0x50000000);
            this.drawRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4+2, this.yPosition, this.xPosition + 146, this.yPosition+20, 0x50000000);
        }
    }

    /**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
    public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
    {
        if (super.mousePressed(par1Minecraft, par2, par3))
        {
            this.sliderValue = (float)(par2 - (this.xPosition + 4)) / (float)(this.width - 8);

            if (this.sliderValue < 0.0F)
            {
                this.sliderValue = 0.0F;
            }

            if (this.sliderValue > 1.0F)
            {
                this.sliderValue = 1.0F;
            }

            par1Minecraft.gameSettings.setOptionFloatValue(this.idFloat, this.sliderValue);
            this.displayString = par1Minecraft.gameSettings.getKeyBinding(this.idFloat);
            this.dragging = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    public void mouseReleased(int par1, int par2)
    {
        this.dragging = false;
    }
}