package it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC;


import it.unical.demacs.informatica.abstractfactory.business.Ordine;
import it.unical.demacs.informatica.abstractfactory.business.Piatto;
import it.unical.demacs.informatica.abstractfactory.database.dao.OrdineDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineDaoJDBC implements OrdineDAO {

    private final Connection connection;

    public OrdineDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int salvaOrdine(int numeroTavolo, double totale) {
        String query = "INSERT INTO ordini (num_tavolo, totale) VALUES (?, ?) RETURNING id";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, numeroTavolo);
            ps.setDouble(2, totale);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Errore nel salvataggio
    }

    @Override
    public void salvaPiattoOrdine(int ordineId, String piattoNome, double prezzo) {
        String query = "INSERT INTO ordine_piatto (ordine_id, piatto_nome, prezzo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ordineId);
            ps.setString(2, piattoNome);
            ps.setDouble(3, prezzo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Ordine> getOrdiniByCucina(String tipoCucina) {
        List<Ordine> ordiniFiltrati = new ArrayList<>();

        String query = "SELECT DISTINCT o.* " +
                "FROM ordini o " +
                "JOIN ordine_piatto op ON o.id = op.ordine_id " +
                "JOIN cucina_" + tipoCucina + " c ON op.piatto_nome = c.nome";


        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setId(rs.getInt("id"));
                ordine.setNumTavolo(rs.getInt("num_tavolo"));
                ordine.setData(rs.getString("data"));
                ordine.setTotale(rs.getDouble("totale"));
                ordiniFiltrati.add(ordine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ordiniFiltrati;
    }

    @Override
    public List<Piatto> getDettagliOrdine(int ordineId, String tipoCucina) {
        List<Piatto> piatti = new ArrayList<>();
        String query = "SELECT op.piatto_nome, op.prezzo " +
                "FROM ordine_piatto op " +
                "JOIN cucina_" + tipoCucina + " c ON op.piatto_nome = c.nome " +
                "WHERE op.ordine_id = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setInt(1, ordineId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Piatto piatto = new Piatto();
                    piatto.setNome(rs.getString("piatto_nome"));
                    piatto.setPrezzo(rs.getDouble("prezzo"));
                    piatti.add(piatto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piatti;
    }


}
