package it.unical.demacs.informatica.abstractfactory.database.dao;

public interface CucinaGiapponeseDAO {

    String getNomeById(int id);
    String getIngredientiById(int id);
    String getImmagineById(int id);
    double getPrezzoById(int id);
}
