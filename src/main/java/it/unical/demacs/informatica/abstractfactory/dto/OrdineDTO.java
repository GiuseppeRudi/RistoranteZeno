package it.unical.demacs.informatica.abstractfactory.dto;

import java.util.List;


public class OrdineDTO {
    private int numTavolo;
    private List<PiattoDTO> piatti;

    public int getNumTavolo() {
        return numTavolo;
    }

    public void setNumTavolo(int numTavolo) {
        this.numTavolo = numTavolo;
    }

    public List<PiattoDTO> getPiatti() {
        return piatti;
    }

    public void setPiatti(List<PiattoDTO> piatti) {
        this.piatti = piatti;
    }
}
