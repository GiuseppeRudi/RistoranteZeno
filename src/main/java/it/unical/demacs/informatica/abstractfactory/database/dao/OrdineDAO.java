package it.unical.demacs.informatica.abstractfactory.database.dao;

import it.unical.demacs.informatica.abstractfactory.business.Ordine;
import it.unical.demacs.informatica.abstractfactory.business.Piatto;

import java.util.List;

public interface OrdineDAO {
    int salvaOrdine(int numeroTavolo, double totale);
    void salvaPiattoOrdine(int ordineId, String piattoNome, double prezzo);
    List<Ordine> getOrdiniByCucina(String tipoCucina);
    List<Piatto> getDettagliOrdine(int ordineId, String tipoCucina);
}
