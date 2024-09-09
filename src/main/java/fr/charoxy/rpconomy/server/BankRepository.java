package fr.charoxy.rpconomy.server;

import fr.charoxy.rpconomy.common.dto.BankDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRepository {

    public static BankRepository instance;

    public BankRepository() {
        instance = this;
    }

    public void addBank(BankDTO BankDto) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO bank (name,player_uuid) VALUES (?, ?)");
            ps.setString(1, BankDto.getName());
            ps.setString(2, BankDto.getPlayer_uuid());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }

    }

    public void addMoney(String player_uuid, int money) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE bank SET money = money + ? WHERE player_uuid = ?");
            ps.setInt(1, money);
            ps.setString(2, player_uuid);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    public void removeMoney(String player_uuid, int money) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("UPDATE bank SET money = money - ? WHERE player_uuid = ?");
            ps.setInt(1, money);
            ps.setString(2, player_uuid);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    public double getBalance(String player_uuid) {
        Connection con = BDDConnexion.instance.getConnexionBDD();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT money FROM bank WHERE player_uuid = ?");
            ps.setString(1, player_uuid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt("money");
            }
            return 0;
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            return 0;
        }
    }

}
