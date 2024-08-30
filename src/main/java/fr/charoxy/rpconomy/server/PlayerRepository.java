package fr.charoxy.rpconomy.server;

import fr.charoxy.rpconomy.common.dto.PlayerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerRepository {

    public static PlayerRepository instance;

    public PlayerRepository() {
        instance = this;
    }

    public boolean isPlayerExist(String player_uuid) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM player WHERE player_uuid = ?");
            ps.setString(1, player_uuid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            return false;
        }
    }

    public void addPlayer(PlayerDTO player) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT IGNORE INTO player (player_uuid) VALUES (?)");
            ps.setString(1, player.getPlayer_uuid());
            ps.execute();
        } catch (Exception e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }


    }


}
