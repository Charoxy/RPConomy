package fr.charoxy.rpconomy.server;

import fr.charoxy.rpconomy.common.CommonProxy;

import java.io.File;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(File config) {
        super.preInit(config);
        BDDConnexion connexion = new BDDConnexion();
    }

    @Override
    public void init() {
        System.out.println("ServerProxy init");
        super.init();
    }
}
