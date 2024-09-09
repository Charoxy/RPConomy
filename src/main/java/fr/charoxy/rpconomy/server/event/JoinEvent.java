package fr.charoxy.rpconomy.server.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.RpConomy;
import fr.charoxy.rpconomy.common.capabilities.IMoney;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import fr.charoxy.rpconomy.common.dto.BankDTO;
import fr.charoxy.rpconomy.common.dto.PlayerDTO;
import fr.charoxy.rpconomy.common.network.money.SyncMoneyPacket;
import fr.charoxy.rpconomy.server.BankRepository;
import fr.charoxy.rpconomy.server.PlayerRepository;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = References.MODID)
public class JoinEvent {

    @SubscribeEvent()
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {

        EntityPlayerMP player = (EntityPlayerMP) event.player;

        //Synchronisation des capacities
        IMoney money = player.getCapability(MoneyStorage.MONEY_CAPABILITY,null);
        RpConomy.network.sendTo(new SyncMoneyPacket(money.getMoney()), player);


        //Creation ou non du personnage dans la bdd
        if(PlayerRepository.instance.isPlayerExist(player.getUniqueID().toString())) {
            player.sendMessage(new TextComponentString("Bon retour parmi nous"));
            return;
        }

        PlayerRepository.instance.addPlayer(new PlayerDTO(player.getUniqueID().toString()));
        BankRepository.instance.addBank(new BankDTO(player.getName(),player.getUniqueID().toString()));
        player.sendMessage(new TextComponentString("Bienvenue sur le serveur RPConomy"));



    }


}
