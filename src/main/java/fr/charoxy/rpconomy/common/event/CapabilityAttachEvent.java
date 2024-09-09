package fr.charoxy.rpconomy.common.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.capabilities.provider.MoneyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class CapabilityAttachEvent {


    public static final ResourceLocation MONEY = new ResourceLocation(References.MODID, "money");


    @SubscribeEvent()
    public static void onAttachCapability(AttachCapabilitiesEvent event) {

        if(event.getObject() instanceof EntityPlayer) {
            event.addCapability(MONEY, new MoneyProvider());
        }

    }


}
