package fr.charoxy.rpconomy.common;

import fr.charoxy.rpconomy.common.capabilities.IMoney;
import fr.charoxy.rpconomy.common.capabilities.defaults.DefaultMoney;
import fr.charoxy.rpconomy.common.capabilities.provider.MoneyProvider;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

import java.io.File;

public class CommonProxy {

    public void preInit(File config) {

        CapabilityManager.INSTANCE.register(IMoney.class, new MoneyStorage(), DefaultMoney::new);

    }

    public void init() {

        System.out.println("CommonProxy init");

    }

}
