package fr.charoxy.rpconomy.common.capabilities.storage;

import fr.charoxy.rpconomy.common.capabilities.IMoney;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

import javax.annotation.Nullable;

public class MoneyStorage implements Capability.IStorage<IMoney> {

    @CapabilityInject(IMoney.class)
    public static final Capability<IMoney> MONEY_CAPABILITY = null;


    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IMoney> capability, IMoney instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("money", instance.getMoney());
        return tag;
    }

    @Override
    public void readNBT(Capability<IMoney> capability, IMoney instance, EnumFacing side, NBTBase nbt) {
        if(nbt instanceof NBTTagCompound) {

            instance.setMoney(((NBTTagCompound) nbt).getInteger("money"));

        }
    }

}
