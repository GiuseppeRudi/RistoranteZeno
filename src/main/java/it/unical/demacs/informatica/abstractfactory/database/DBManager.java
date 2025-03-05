package it.unical.demacs.informatica.abstractfactory.database;

import java.sql.*;

public class DBManager {

    String username = "postgres";
    String password = "postgres";

    private static DBManager instance = null;

    // Connessione al database
    private Connection con = null;


    // Costruttore privato per il Singleton
    private DBManager() {}

    // Metodo per ottenere l'istanza del DBManager (Singleton)
    public static DBManager getInstance(){
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    // Connessione al database (PostgreSQL)
    public Connection getConnection(){
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ristoranteZeno", username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

}