package it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaCineseDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CucinaCineseDaoJDBC implements CucinaCineseDAO {

    private final Connection connection;

//    private static CucinaItalianaDaoJDBC instance;
//
//    public static CucinaItalianaDaoJDBC getInstance() {
//        if (instance == null) {
//            synchronized (CucinaItalianaDaoJDBC.class) {
//                if (instance == null) {
//                    instance = new CucinaItalianaDaoJDBC(DBManager.getInstance().getConnection());
//                }
//            }
//        }
//        return instance;
//    }


    public CucinaCineseDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getNomeById(int id) {
        String query = "SELECT nome FROM cucina_cinese WHERE id = ?";
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
        String query = "SELECT ingredienti FROM cucina_cinese WHERE id = ?";
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
        String query = "SELECT immagine FROM cucina_cinese WHERE id = ?";
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
        String query = "SELECT prezzo FROM cucina_cinese WHERE id = ?";
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
