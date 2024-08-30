package fr.charoxy.rpconomy.server.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.dto.BankDTO;
import fr.charoxy.rpconomy.common.dto.PlayerDTO;
import fr.charoxy.rpconomy.server.BankRepository;
import fr.charoxy.rpconomy.server.PlayerRepository;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class JoinEvent {

    @SubscribeEvent()
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {

        if(PlayerRepository.instance.isPlayerExist(event.player.getUniqueID().toString())) {
            event.player.sendMessage(new TextComponentString("Bon retour parmi nous"));
            return;
        }

        PlayerRepository.instance.addPlayer(new PlayerDTO(event.player.getUniqueID().toString()));
        event.player.sendMessage(new TextComponentString("Bienvenue sur le serveur RPConomy"));

    }


}
