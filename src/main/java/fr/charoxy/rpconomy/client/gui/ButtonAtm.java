package fr.charoxy.rpconomy.client.gui;

import fr.charoxy.rpconomy.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ButtonAtm extends GuiButton {

    private static final ResourceLocation buttonTextures = new ResourceLocation(References.MODID, "textures/gui/button_atm.png");
    private static final ResourceLocation buttonTexturesHover = new ResourceLocation(References.MODID, "textures/gui/button_atm_hover.png");

    public ButtonAtm(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, buttonText);
    }

    public ButtonAtm(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        super.drawButton(mc, mouseX, mouseY, partialTicks);

        if(this.visible) {
            boolean hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;

            if(hovered) {
                mc.getTextureManager().bindTexture(buttonTexturesHover);
            }else {
                mc.getTextureManager().bindTexture(buttonTextures);
            }
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Gui.drawScaledCustomSizeModalRect(this.x, this.y, 0, 0, 9, 5, 30, 18, 9, 5);



        }


    }
}
