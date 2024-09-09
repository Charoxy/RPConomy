package fr.charoxy.rpconomy;

import fr.charoxy.rpconomy.common.CommonProxy;
import fr.charoxy.rpconomy.common.network.bank.AtmPacket;
import fr.charoxy.rpconomy.common.network.money.SyncMoneyPacket;
import fr.charoxy.rpconomy.server.BDDConnexion;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION )
public class RpConomy {

    @Mod.Instance(value = References.MODID)
    public static RpConomy instance;

    public static SimpleNetworkWrapper network;


    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event.getSuggestedConfigurationFile());
        network = NetworkRegistry.INSTANCE.newSimpleChannel(References.MODID);
        network.registerMessage(AtmPacket.class, AtmPacket.class, 0, Side.SERVER);
        network.registerMessage(SyncMoneyPacket.class, SyncMoneyPacket.class, 1, Side.CLIENT);
    }

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        proxy.init();
    }



}
