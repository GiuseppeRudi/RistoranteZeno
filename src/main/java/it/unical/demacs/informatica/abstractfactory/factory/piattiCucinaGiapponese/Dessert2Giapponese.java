package it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaGiapponese;

import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaGiapponeseDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.CucinaGiapponeseDaoJDBC;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.Dessert2;

public class Dessert2Giapponese implements Dessert2 {
    private final String nome;
    private final String ingredienti;
    private final String immagine;
    private final double prezzo;

    public Dessert2Giapponese() {
        CucinaGiapponeseDAO cucinagiapponesedao = new CucinaGiapponeseDaoJDBC(DBManager.getInstance().getConnection());
        // Recupera i dati direttamente dal database
        int id = 8;
        this.nome = cucinagiapponesedao.getNomeById(id);
        this.ingredienti = cucinagiapponesedao.getIngredientiById(id);
        this.immagine = cucinagiapponesedao.getImmagineById(id);
        this.prezzo = cucinagiapponesedao.getPrezzoById(id);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public String getImmagine() {
        return immagine;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
