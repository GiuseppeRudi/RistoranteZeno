package it.unical.demacs.informatica.abstractfactory.dto;

public class PiattoDTO {
    private String nome;
    private String ingredienti;
    private double prezzo;
    private String immagine;

    public PiattoDTO(String nome, String ingredienti, double prezzo, String immagine) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.immagine = immagine;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getIngredienti() { return ingredienti; }
    public void setIngredienti(String ingredienti) { this.ingredienti = ingredienti; }
    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public String getImmagine() { return immagine; }
    public void setImmagine(String immagine) { this.immagine = immagine; }
}
