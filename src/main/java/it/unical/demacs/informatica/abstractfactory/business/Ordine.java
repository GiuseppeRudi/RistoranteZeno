package it.unical.demacs.informatica.abstractfactory.business;

public class Ordine {

    private int id;
    private int numTavolo;
    private String data;
    private double totale;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTavolo() {
        return numTavolo;
    }

    public void setNumTavolo(int numTavolo) {
        this.numTavolo = numTavolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }


}

