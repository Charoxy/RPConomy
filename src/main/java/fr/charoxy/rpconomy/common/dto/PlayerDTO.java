package fr.charoxy.rpconomy.common.dto;

public class PlayerDTO {

    String player_uuid;

    public PlayerDTO(String player_uuid) {
        this.player_uuid = player_uuid;
    }

    public String getPlayer_uuid() {
        return player_uuid;
    }

    public void setPlayer_uuid(String player_uuid) {
        this.player_uuid = player_uuid;
    }
}
