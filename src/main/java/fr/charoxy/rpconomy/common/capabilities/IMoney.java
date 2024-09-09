package fr.charoxy.rpconomy.common.capabilities;

public interface IMoney {

    default public void addMoney(int money){

        setMoney(getMoney() + money);

    }

    default public void removeMoney(int money){

        setMoney(getMoney() - money);

    }

    public int getMoney();

    public void setMoney(int money);


}