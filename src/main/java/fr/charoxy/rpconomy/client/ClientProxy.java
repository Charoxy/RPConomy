package fr.charoxy.rpconomy.client;

import fr.charoxy.rpconomy.common.CommonProxy;

import java.io.File;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(File config) {
        super.preInit(config);
    }

    @Override
    public void init() {
        System.out.println("ClientProxy init");
        super.init();

    }
}
