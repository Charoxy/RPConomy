package fr.charoxy.rpconomy.client.gui;

import fr.charoxy.rpconomy.RpConomy;
import fr.charoxy.rpconomy.common.network.bank.AtmPacket;
import fr.charoxy.rpconomy.common.network.bank.BankPacketType;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class AtmGui extends GuiScreen {


    public AtmGui() {}

    @Override
    public void initGui() {
        super.initGui();
        GuiButton retirer = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "retirer");
        GuiButton ajouter = new GuiButton(1, this.width / 2 + 100, this.height / 4 + 120, "ajouter");

        this.buttonList.add(retirer);
        this.buttonList.add(ajouter);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        if(button.id == 0) {
            RpConomy.network.sendToServer(new AtmPacket(BankPacketType.WITHDRAW, mc.player.getUniqueID().toString(), 10));
        }else if(button.id == 1) {
            RpConomy.network.sendToServer(new AtmPacket(BankPacketType.DEPOSIT, mc.player.getUniqueID().toString(), 10));
        }
    }
}
