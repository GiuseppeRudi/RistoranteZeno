package it.unical.demacs.informatica.abstractfactory.controller;

import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.OrdineDAO;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.OrdineDaoJDBC;
import it.unical.demacs.informatica.abstractfactory.dto.OrdineDTO;
import it.unical.demacs.informatica.abstractfactory.dto.PiattoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdineController {

    private final OrdineDAO ordineDao;

    public OrdineController() {
        this.ordineDao = new OrdineDaoJDBC(DBManager.getInstance().getConnection());
    }

    @PostMapping("/submit-order")
    public ResponseEntity<String> submitOrder(@RequestBody OrdineDTO ordineDTO) {
        try {
            // Calcolo del totale
            double totale = ordineDTO.getPiatti().stream()
                    .mapToDouble(PiattoDTO::getPrezzo)
                    .sum();

            // Salva l'ordine nel database
            int ordineId = ordineDao.salvaOrdine(ordineDTO.getNumTavolo(), totale);

            // Salva i dettagli dei piatti dell'ordine
            ordineDTO.getPiatti().forEach(piatto -> ordineDao.salvaPiattoOrdine(ordineId, piatto.getNome(), piatto.getPrezzo()));

            return ResponseEntity.ok("Ordine salvato con successo!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Errore nel salvataggio dell'ordine.");
        }
    }
}
