package fr.charoxy.rpconomy.common.dto;

public class BankDTO {

    String name;
    int id;
    double money;
    String player_uuid;

    public BankDTO(String name, int id, double money, String player_uuid) {
        this.name = name;
        this.id = id;
        this.money = money;
        this.player_uuid = player_uuid;
    }

    /**
     * Constructeur de la classe BankDTO Pour la création d'un compte bancaire
     * @param name
     * @param player_uuid
     */
    public BankDTO(String name ,String player_uuid) {
        this.name = name;
        this.id = id;
        this.money = money;
        this.player_uuid = player_uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPlayer_uuid() {
        return player_uuid;
    }

    public void setPlayer_uuid(String player_uuid) {
        this.player_uuid = player_uuid;
    }
}
