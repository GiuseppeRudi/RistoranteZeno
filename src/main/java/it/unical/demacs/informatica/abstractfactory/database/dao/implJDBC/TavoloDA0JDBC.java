package it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC;


import it.unical.demacs.informatica.abstractfactory.business.Tavolo;
import it.unical.demacs.informatica.abstractfactory.database.dao.TavoloDA0;

import java.sql.*;

public class TavoloDA0JDBC implements TavoloDA0 {

    private Connection conn;

    public TavoloDA0JDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean verificaCredenziali(String numeroTavolo, String password) {
        String query = "SELECT COUNT(*) FROM tavoli WHERE numero_tavolo = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, numeroTavolo);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Se il conteggio è maggiore di 0, le credenziali sono valide
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Tavolo getTavoloByNumero(String numeroTavolo) {
        String query = "SELECT * FROM tavoli WHERE numero_tavolo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, numeroTavolo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tavolo(rs.getString("numero_tavolo"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void inserisciTavolo(Tavolo tavolo) {
        String query = "INSERT INTO tavoli (numero_tavolo, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tavolo.getNumeroTavolo());
            stmt.setString(2, tavolo.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aggiornaTavolo(Tavolo tavolo) {
        String query = "UPDATE tavoli SET password = ? WHERE numero_tavolo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tavolo.getPassword());
            stmt.setString(2, tavolo.getNumeroTavolo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaTavolo(String numeroTavolo) {
        String query = "DELETE FROM tavoli WHERE numero_tavolo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, numeroTavolo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
