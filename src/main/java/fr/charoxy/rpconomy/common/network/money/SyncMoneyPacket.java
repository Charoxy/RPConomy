package fr.charoxy.rpconomy.common.network.money;

import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SyncMoneyPacket implements IMessage, IMessageHandler<SyncMoneyPacket, IMessage> {

    private int money;

    public SyncMoneyPacket() {

    }

    public SyncMoneyPacket(int money) {
        this.money = money;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        money = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(money);
    }

    @Override
    public IMessage onMessage(SyncMoneyPacket message, MessageContext ctx) {
        Minecraft.getMinecraft().player.getCapability(MoneyStorage.MONEY_CAPABILITY,null).setMoney(message.money);
        return null;
    }
}
