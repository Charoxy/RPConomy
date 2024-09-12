package fr.charoxy.rpconomy.client.event;

import fr.charoxy.rpconomy.References;
import fr.charoxy.rpconomy.client.gui.AtmGui;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = References.MODID)
public class BlockEvent {


    @SubscribeEvent()
    @SideOnly(Side.CLIENT)
    public static void onBlockBreak(PlayerInteractEvent.RightClickBlock event) {
        Minecraft mc = Minecraft.getMinecraft();

        EntityPlayer player = event.getEntityPlayer();
        Block block = player.getEntityWorld().getBlockState(event.getPos()).getBlock();

        if(block.getRegistryName().toString().equals("rpconomy:atm")){
            if(event.getHand() == EnumHand.OFF_HAND) return;
            mc.displayGuiScreen(new AtmGui());
        }

    }
}
