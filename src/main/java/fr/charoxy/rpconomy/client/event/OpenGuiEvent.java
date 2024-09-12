package fr.charoxy.rpconomy.client.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.client.gui.GuiCustomInventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = References.MODID)
public class OpenGuiEvent {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent()
    public static void onGuiOpen(GuiOpenEvent event) {

        if(event.getGui() instanceof GuiInventory){
            event.setGui(new GuiCustomInventory(Minecraft.getMinecraft().player));
        }

    }


}
