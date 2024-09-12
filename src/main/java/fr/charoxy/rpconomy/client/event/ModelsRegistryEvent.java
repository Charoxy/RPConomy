package fr.charoxy.rpconomy.client.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.ModBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class ModelsRegistryEvent {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlock.init();

    }

}
