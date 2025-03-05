package it.unical.demacs.informatica.abstractfactory.controller;

import it.unical.demacs.informatica.abstractfactory.business.Ordine;
import it.unical.demacs.informatica.abstractfactory.business.Piatto;
import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.OrdineDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.OrdineDaoJDBC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CucinaController {

    private final OrdineDAO ordinedao = new OrdineDaoJDBC(DBManager.getInstance().getConnection());

    @GetMapping("/api/ordini")
    public List<Ordine> getOrdini(@RequestParam String cucina) {
        // Passa il tipo di cucina a un metodo personalizzato nel DAO
        return ordinedao.getOrdiniByCucina(cucina);
    }

    @GetMapping("/api/ordini/{ordineId}/dettagli")
    public List<Piatto> getDettagliOrdine(@PathVariable int ordineId, @RequestParam String cucina) {
        return ordinedao.getDettagliOrdine(ordineId, cucina);
    }
}
