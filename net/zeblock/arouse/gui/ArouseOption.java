package net.zeblock.arouse.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.gui.GuiSnooper;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.client.resources.GuiScreenTemporaryResourcePackSelect;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;

public class ArouseOption extends ArouseScreen{
	/**
     * An array of options that can be changed directly from the options GUI.
     */
    private static final EnumOptions[] relevantOptions = new EnumOptions[] {EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.FOV, EnumOptions.DIFFICULTY};

    /**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    private final GuiScreen parentScreen;

    /** Reference to the GameSettings object. */
    private final GameSettings options;

    /** The title string that is displayed in the top-center of the screen. */
    protected String screenTitle = "Options";

    public ArouseOption(GuiScreen par1GuiScreen, GameSettings par2GameSettings)
    {
        this.parentScreen = par1GuiScreen;
        this.options = par2GameSettings;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        int i = 0;
        this.screenTitle = I18n.getString("options.title");
        EnumOptions[] aenumoptions = relevantOptions;
        int j = aenumoptions.length;

        for (int k = 0; k < j; ++k)
        {
            EnumOptions enumoptions = aenumoptions[k];

            if (enumoptions.getEnumFloat())
            {
                this.buttonList.add(new GuiSlider(enumoptions.returnEnumOrdinal(), this.width / 2 - 155 + i % 2 * 160, this.height / 6 +10 + 24 * (i >> 1), enumoptions, this.options.getKeyBinding(enumoptions), this.options.getOptionFloatValue(enumoptions)));
            }
            else
            {
                GuiSmallButton guismallbutton = new GuiSmallButton(enumoptions.returnEnumOrdinal(), this.width / 2 - 155 + i % 2 * 160, this.height / 6 +10 + 24 * (i >> 1), enumoptions, this.options.getKeyBinding(enumoptions));

                if (enumoptions == EnumOptions.DIFFICULTY && this.mc.theWorld != null && this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
                {
                    guismallbutton.enabled = false;
                    guismallbutton.displayString = I18n.getString("options.difficulty") + ": " + I18n.getString("options.difficulty.hardcore");
                }

                this.buttonList.add(guismallbutton);
            }

            ++i;
        }

        
        
        this.buttonList.add(new ArouseButtonWithBG(102, this.width / 2 - 152, this.height / 6 + 120 - 6, 150, 20, I18n.getString("options.language")));
        this.buttonList.add(new ArouseButtonWithBG(101, this.width / 2 + 2, this.height / 6 + 120 - 6, 150, 20, I18n.getString("options.video")));
        this.buttonList.add(new ArouseButtonWithBG(105, this.width / 2 - 152, this.height / 6 + 144 - 6, 150, 20, I18n.getString("options.resourcepack")));
        this.buttonList.add(new ArouseButtonWithBG(100, this.width / 2 + 2, this.height / 6 + 144 - 6, 150, 20, I18n.getString("options.controls")));
        this.buttonList.add(new ArouseButtonWithBG(200, this.width / 2 - 100, this.height / 6 + 168,I18n.getString("gui.done")));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id < 100 && par1GuiButton instanceof GuiSmallButton)
            {
                this.options.setOptionValue(((GuiSmallButton)par1GuiButton).returnEnumOptions(), 1);
                par1GuiButton.displayString = this.options.getKeyBinding(EnumOptions.getEnumOptions(par1GuiButton.id));
            }

            if (par1GuiButton.id == 101)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiVideoSettings(this, this.options));
            }

            if (par1GuiButton.id == 100)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiControls(this, this.options));
            }

            if (par1GuiButton.id == 102)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiLanguage(this, this.options, this.mc.getLanguageManager()));
            }

            /*if (par1GuiButton.id == 103)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new ScreenChatOptions(this, this.options));
            }*/

            /*if (par1GuiButton.id == 104)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiSnooper(this, this.options));
            }*/

            if (par1GuiButton.id == 200)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }

            if (par1GuiButton.id == 105)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(new GuiScreenTemporaryResourcePackSelect(this, this.options));
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.renderSkybox();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2 ),15, 0.0F);
        
        GL11.glScalef(1.2f, 1.2f, 1.2f);
        this.drawCenteredString(this.fontRenderer, "设置", 0, 0, 16777215);
        GL11.glPopMatrix();
        
        super.drawScreen(par1, par2, par3);
    }

}
