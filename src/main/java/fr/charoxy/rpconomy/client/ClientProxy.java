package fr.charoxy.rpconomy.client;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.CommonProxy;
import net.minecraftforge.client.model.obj.OBJLoader;

import java.io.File;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(File config) {

        super.preInit(config);
        OBJLoader.INSTANCE.addDomain(References.MODID);

    }

    @Override
    public void init() {
        System.out.println("ClientProxy init");
        super.init();

    }
}
