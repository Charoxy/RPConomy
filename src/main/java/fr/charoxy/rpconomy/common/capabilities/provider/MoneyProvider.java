package fr.charoxy.rpconomy.common.capabilities.provider;

import fr.charoxy.rpconomy.common.capabilities.IMoney;
import fr.charoxy.rpconomy.common.capabilities.storage.MoneyStorage;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MoneyProvider implements ICapabilitySerializable {

    protected IMoney money;

    public MoneyProvider() {
        this.money = MoneyStorage.MONEY_CAPABILITY.getDefaultInstance();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == MoneyStorage.MONEY_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return this.hasCapability(capability, facing) ? MoneyStorage.MONEY_CAPABILITY.cast(this.money) : null;
    }

    @Override
    public NBTBase serializeNBT() {

        return MoneyStorage.MONEY_CAPABILITY.writeNBT(money,null);

    }


    @Override
    public void deserializeNBT(NBTBase nbt) {

        MoneyStorage.MONEY_CAPABILITY.readNBT(money,null,nbt);

    }

}
