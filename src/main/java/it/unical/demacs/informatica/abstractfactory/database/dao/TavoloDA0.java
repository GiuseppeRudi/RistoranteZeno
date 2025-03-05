package it.unical.demacs.informatica.abstractfactory.database.dao;

import it.unical.demacs.informatica.abstractfactory.business.Tavolo;

public interface TavoloDA0 {

    boolean verificaCredenziali(String numeroTavolo, String password);

    Tavolo getTavoloByNumero(String numeroTavolo);

    void inserisciTavolo(Tavolo tavolo);

    void aggiornaTavolo(Tavolo tavolo);

    void eliminaTavolo(String numeroTavolo);
}
