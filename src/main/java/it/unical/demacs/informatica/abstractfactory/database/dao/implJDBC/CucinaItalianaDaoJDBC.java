package it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC;

import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaItalianaDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CucinaItalianaDaoJDBC implements CucinaItalianaDAO {

    private final Connection connection;


    public CucinaItalianaDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getNomeById(int id) {
        String query = "SELECT nome FROM cucina_italiana WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getIngredientiById(int id) {
        String query = "SELECT ingredienti FROM cucina_italiana WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("ingredienti");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getImmagineById(int id) {
        String query = "SELECT immagine FROM cucina_italiana WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("immagine");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getPrezzoById(int id) {
        String query = "SELECT prezzo FROM cucina_italiana WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("prezzo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
