package fr.charoxy.rpconomy.client.gui;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.RpConomy;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import fr.charoxy.rpconomy.common.network.bank.AtmPacket;
import fr.charoxy.rpconomy.common.network.bank.BankPacketType;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class AtmGui extends GuiScreen {

    private static final ResourceLocation background = new ResourceLocation(References.MODID, "textures/gui/atm1.png");
    private AtmGuiType type;


    public AtmGui() {}

    @Override
    public void initGui() {
        super.initGui();
        this.type = AtmGuiType.HOME;
        ButtonAtm button1 = new ButtonAtm(0, this.width / 2 - 97, this.height / 2 - 88, 25, 18, "");
        ButtonAtm button2 = new ButtonAtm(1, this.width / 2 - 97, this.height / 2 - 65, 25, 18, "");
        ButtonAtm button3 = new ButtonAtm(2, this.width / 2 - 97, this.height / 2 - 42, 25, 18, "");
        ButtonAtm button4 = new ButtonAtm(3, this.width / 2 - 97, this.height / 2 - 20, 25, 18, "");

        ButtonAtm button5 = new ButtonAtm(4, this.width / 2 + 82, this.height / 2 - 88, 25, 18, "");
        ButtonAtm button6 = new ButtonAtm(5, this.width / 2 + 82, this.height / 2 - 65, 25, 18, "");
        ButtonAtm button7 = new ButtonAtm(6, this.width / 2 + 82, this.height / 2 - 42, 25, 18, "");
        ButtonAtm button8 = new ButtonAtm(7, this.width / 2 + 82, this.height / 2 - 20, 25, 18, "");

        this.buttonList.add(button1);
        this.buttonList.add(button2);
        this.buttonList.add(button3);
        this.buttonList.add(button4);

        this.buttonList.add(button5);
        this.buttonList.add(button6);
        this.buttonList.add(button7);
        this.buttonList.add(button8);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(this.width / 2 - 120, this.height / 2 - 120 , 0, 0, 85*3, 83*3);

        if(this.type == AtmGuiType.HOME) {
            mc.fontRenderer.drawString("Deposer", this.width / 2 - 40, this.height / 2 - 81, 0xFFFFFF);
            mc.fontRenderer.drawString("Retirer", this.width / 2 + 20, this.height / 2 - 81, 0xFFFFFF);
        } else {
            mc.fontRenderer.drawString("10€", this.width / 2 - 40, this.height / 2 - 81, 0xFFFFFF);
            mc.fontRenderer.drawString("20€", this.width / 2 - 40, this.height / 2 - 60, 0xFFFFFF);
            mc.fontRenderer.drawString("50€", this.width / 2 - 40, this.height / 2 - 38, 0xFFFFFF);
            mc.fontRenderer.drawString("100€", this.width / 2 - 40, this.height / 2 - 16, 0xFFFFFF);
            mc.fontRenderer.drawString("200€", this.width / 2 + 20, this.height / 2 - 81, 0xFFFFFF);
            mc.fontRenderer.drawString("500€", this.width / 2 + 20, this.height / 2 - 59, 0xFFFFFF);

            mc.fontRenderer.drawString("Quitter", this.width / 2 + 20, this.height / 2 - 16, 0xFFFFFF);

        }

        super.drawScreen(mouseX, mouseY, partialTicks);


    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if(this.type == AtmGuiType.HOME) {

            if(button.id == 0) {
                this.type = AtmGuiType.DEPOSIT;
            }else if(button.id == 4) {
                this.type = AtmGuiType.WITHDRAW;
            }

        } else {

            if(button.id == 0) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 10));
            }else if(button.id == 1) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 20));
            }else if(button.id == 2) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 50));
            }else if(button.id == 3) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 100));
            }else if(button.id == 4) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 200));
            }else if(button.id == 5) {
                RpConomy.network.sendToServer(new AtmPacket(BankPacketType.valueOf(this.type.toString()), mc.player.getUniqueID().toString(), 500));
            }else if(button.id == 7) {
                this.type = AtmGuiType.HOME;
            }

        }

    }
}
