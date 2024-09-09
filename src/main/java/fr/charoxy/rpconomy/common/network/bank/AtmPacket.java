package fr.charoxy.rpconomy.common.network.bank;

import fr.charoxy.rpconomy.RpConomy;
import fr.charoxy.rpconomy.common.capabilities.IMoney;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import fr.charoxy.rpconomy.common.network.money.SyncMoneyPacket;
import fr.charoxy.rpconomy.server.BankRepository;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class AtmPacket implements IMessage, IMessageHandler<AtmPacket,IMessage> {

    private BankPacketType type;
    private String player_uuid;
    private int money;

    public AtmPacket() {}

    public AtmPacket(BankPacketType type, String player_uuid, int money) {
        this.type = type;
        this.player_uuid = player_uuid;
        this.money = money;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.player_uuid = ByteBufUtils.readUTF8String(buf);
        this.type = BankPacketType.valueOf(ByteBufUtils.readUTF8String(buf));
        this.money = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, player_uuid);
        ByteBufUtils.writeUTF8String(buf, type.toString());
        buf.writeInt(money);
    }

    @Override
    public IMessage onMessage(AtmPacket message, MessageContext ctx) {

        EntityPlayerMP player = ctx.getServerHandler().player;
        IMoney money = player.getCapability(MoneyStorage.MONEY_CAPABILITY,null);

        if(message.type == BankPacketType.WITHDRAW) {

            double balance = BankRepository.instance.getBalance(message.player_uuid);
            if(balance < message.money) {
                player.sendMessage(new TextComponentString("Vous n'avez pas assez d'argent en banque"));
                return null;
            }
            money.setMoney(money.getMoney() + message.money);
            BankRepository.instance.removeMoney(message.player_uuid, message.money);
            player.sendMessage(new net.minecraft.util.text.TextComponentString("Vous avez retiré de l'argent " + message.money));

        }else if(message.type == BankPacketType.DEPOSIT) {

            if(message.money > money.getMoney()) {
                player.sendMessage(new TextComponentString("Vous n'avez pas assez d'argent dans votre portefeuille"));
                return null;
            }

            BankRepository.instance.addMoney(message.player_uuid, message.money);
            money.setMoney(money.getMoney() - message.money);
            player.sendMessage(new net.minecraft.util.text.TextComponentString("Vous avez ajouté de l'argent en banque " + message.money));

        }

        RpConomy.network.sendTo(new SyncMoneyPacket(money.getMoney()), player);

        return null;
    }
}
