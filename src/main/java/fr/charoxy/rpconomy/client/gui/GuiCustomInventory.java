package fr.charoxy.rpconomy.client.gui;

import fr.charoxy.rpconomy.common.capabilities.IMoney;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;

import java.awt.*;


public class GuiCustomInventory extends GuiInventory {


    public GuiCustomInventory(EntityPlayer player) {
        super(player);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        GlStateManager.pushMatrix();

        Gui.drawRect(this.guiLeft - 60, guiTop, this.guiLeft-10, guiTop + 20, 0x5546A441);
        Gui.drawRect(this.guiLeft - 62, guiTop - 2, this.guiLeft-8, guiTop + 22, 0x5546A441);

        IMoney money = this.mc.player.getCapability(MoneyStorage.MONEY_CAPABILITY, null);

        mc.fontRenderer.drawString(money.getMoney() + "$", this.guiLeft - 45, guiTop + 6, 0xFFFFFF);

        GlStateManager.popMatrix();

    }
}