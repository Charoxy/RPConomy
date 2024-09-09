package fr.charoxy.rpconomy.client.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class HudEvent {


    @SubscribeEvent()
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {

        Minecraft mc = Minecraft.getMinecraft();
        if(event.getType() == RenderGameOverlayEvent.ElementType.ALL) {

            mc.fontRenderer.drawStringWithShadow("Money : " + mc.player.getCapability(MoneyStorage.MONEY_CAPABILITY,null).getMoney(), 0, 0, 0xFFFFFF);

        }

    }

}
