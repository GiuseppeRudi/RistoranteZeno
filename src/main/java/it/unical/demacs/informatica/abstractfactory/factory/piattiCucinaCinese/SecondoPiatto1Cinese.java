package it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaCinese;


import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaCineseDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.CucinaCineseDaoJDBC;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.SecondoPiatto1;


public class SecondoPiatto1Cinese implements SecondoPiatto1 {
    private final String nome;
    private final String ingredienti;
    private final String immagine;
    private final double prezzo;

    public SecondoPiatto1Cinese() {
        CucinaCineseDAO cucinacinesedao = new CucinaCineseDaoJDBC(DBManager.getInstance().getConnection());
        // Recupera i dati direttamente dal database
        int id = 4;
        this.nome = cucinacinesedao.getNomeById(id);
        this.ingredienti = cucinacinesedao.getIngredientiById(id);
        this.immagine = cucinacinesedao.getImmagineById(id);
        this.prezzo = cucinacinesedao.getPrezzoById(id);
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


