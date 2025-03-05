package it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CucinaDaoJDBC implements CucinaDao {

    private final Connection conn;

    public CucinaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean verificaCredenziali(String tipCucina, String password) {
        String query = "SELECT COUNT(*) FROM cucina WHERE cucina = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tipCucina);
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


}
