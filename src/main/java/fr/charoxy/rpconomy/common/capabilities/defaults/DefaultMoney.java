package fr.charoxy.rpconomy.common.capabilities.defaults;

import fr.charoxy.rpconomy.common.capabilities.IMoney;

public class DefaultMoney implements IMoney {

    private int money = 0;

    public DefaultMoney() {

    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }
}
