package it.unical.demacs.informatica.abstractfactory.business;


public class Tavolo {
    private String numeroTavolo;
    private String password;

    public Tavolo(String numeroTavolo, String password) {
        this.numeroTavolo = numeroTavolo;
        this.password = password;
    }

    public String getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(String numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
