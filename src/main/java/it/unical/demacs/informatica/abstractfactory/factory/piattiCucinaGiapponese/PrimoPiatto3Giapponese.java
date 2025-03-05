package it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaGiapponese;

import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaGiapponeseDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.CucinaGiapponeseDaoJDBC;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.PrimoPiatto3;

public class PrimoPiatto3Giapponese implements PrimoPiatto3 {
    private final String nome;
    private final String ingredienti;
    private final String immagine;
    private final double prezzo;

    public PrimoPiatto3Giapponese() {
        CucinaGiapponeseDAO cucinagiapponesedao = new CucinaGiapponeseDaoJDBC(DBManager.getInstance().getConnection());
        int id = 3;
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
