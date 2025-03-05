package it.unical.demacs.informatica.abstractfactory.database.dao;

public interface CucinaCineseDAO {
    // Funzione che restituisce solo i dati del primo piatto
    String getNomeById(int id);
    String getIngredientiById(int id);
    String getImmagineById(int id);
    double getPrezzoById(int id);
}

