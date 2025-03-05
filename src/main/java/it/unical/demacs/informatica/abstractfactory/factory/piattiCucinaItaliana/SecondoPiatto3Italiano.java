package it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaItaliana;

import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaItalianaDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.CucinaItalianaDaoJDBC;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.SecondoPiatto3;


public class SecondoPiatto3Italiano implements SecondoPiatto3 {
    private final String nome;
    private final String ingredienti;
    private final String immagine;
    private final double prezzo;

    public SecondoPiatto3Italiano() {
        CucinaItalianaDAO cucinaItalianaDAO = new CucinaItalianaDaoJDBC(DBManager.getInstance().getConnection());
        int id = 6;
        this.nome = cucinaItalianaDAO.getNomeById(id);
        this.ingredienti = cucinaItalianaDAO.getIngredientiById(id);
        this.immagine = cucinaItalianaDAO.getImmagineById(id);
        this.prezzo = cucinaItalianaDAO.getPrezzoById(id);
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

