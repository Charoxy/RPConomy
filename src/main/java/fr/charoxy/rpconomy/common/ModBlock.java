package fr.charoxy.rpconomy.common;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.common.block.OBJBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlock {

    @GameRegistry.ObjectHolder(References.MODID + ":" + "atm")
    public static OBJBlock ATM = new OBJBlock("atm");

    public static void init() {
        ATM.initModel();
    }


}
