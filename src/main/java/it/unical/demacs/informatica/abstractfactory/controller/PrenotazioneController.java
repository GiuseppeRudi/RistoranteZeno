package it.unical.demacs.informatica.abstractfactory.controller;

import it.unical.demacs.informatica.abstractfactory.dto.PiattoDTO;
import it.unical.demacs.informatica.abstractfactory.factory.CucinaFactory;
import it.unical.demacs.informatica.abstractfactory.factory.FactoryProducer;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PrenotazioneController {


    @PostMapping("/choose-cuisine")
    public @ResponseBody List<PiattoDTO> scegliCucina(@RequestParam String cucina) {
        // Seleziona la Factory in base alla cucina scelta
        CucinaFactory factory = FactoryProducer.getFactory(cucina);
        if (factory != null) {
            List<PiattoDTO> menu = new ArrayList<>();

            // Aggiungi i vari piatti al menu
            PrimoPiatto1 primoPiatto1 = factory.creaPrimoPiatto1();
            PrimoPiatto2 primoPiatto2 = factory.creaPrimoPiatto2();
            PrimoPiatto3 primoPiatto3 = factory.creaPrimoPiatto3();
            SecondoPiatto1 secondoPiatto1 = factory.creaSecondoPiatto1();
            SecondoPiatto2 secondoPiatto2 = factory.creaSecondoPiatto2();
            SecondoPiatto3 secondoPiatto3 = factory.creaSecondoPiatto3();
            Dessert1 dessert1 = factory.creaDessert1();
            Dessert2 dessert2 = factory.creaDessert2();

            // Converte i piatti in oggetti DTO per il front-end
            menu.add(new PiattoDTO(primoPiatto1.getNome(), primoPiatto1.getIngredienti(), primoPiatto1.getPrezzo(), primoPiatto1.getImmagine()));
            menu.add(new PiattoDTO(primoPiatto2.getNome(), primoPiatto2.getIngredienti(), primoPiatto2.getPrezzo(), primoPiatto2.getImmagine()));
            menu.add(new PiattoDTO(primoPiatto3.getNome(), primoPiatto3.getIngredienti(), primoPiatto3.getPrezzo(), primoPiatto3.getImmagine()));
            menu.add(new PiattoDTO(secondoPiatto1.getNome(), secondoPiatto1.getIngredienti(), secondoPiatto1.getPrezzo(), secondoPiatto1.getImmagine()));
            menu.add(new PiattoDTO(secondoPiatto2.getNome(), secondoPiatto2.getIngredienti(), secondoPiatto2.getPrezzo(), secondoPiatto2.getImmagine()));
            menu.add(new PiattoDTO(secondoPiatto3.getNome(), secondoPiatto3.getIngredienti(), secondoPiatto3.getPrezzo(), secondoPiatto3.getImmagine()));
            menu.add(new PiattoDTO(dessert1.getNome(), dessert1.getIngredienti(), dessert1.getPrezzo(), dessert1.getImmagine()));
            menu.add(new PiattoDTO(dessert2.getNome(), dessert2.getIngredienti(), dessert2.getPrezzo(), dessert2.getImmagine()));

            return menu;
        } else {
            return Collections.emptyList(); // Nessun piatto trovato
        }
    }
}
