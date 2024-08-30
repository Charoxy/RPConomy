package fr.charoxy.rpconomy.server;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDDConnexion {

    public static BDDConnexion instance;

    private Connection connexionBDD;
    private final String URL = "jdbc:mysql://localhost:3307/rpconomy";
    private final String USER = "root";

    public BDDConnexion() {

        instance = this;
        try {

            connexionBDD = DriverManager.getConnection(URL, USER, "");
            BankRepository bankRepository = new BankRepository();
            PlayerRepository playerRepository = new PlayerRepository();
            System.out.println("Connexion BDD OK");

        } catch (Exception e) {

            System.out.println("Connexion BDD KO");
            e.printStackTrace();

        }

    }

    public Connection getConnexionBDD() {
        return connexionBDD;
    }

}
