package main;

import main.fixed.jauges.Jauge;

public class Effet {
    private Jauge jauge;
    private int valeur;

    public Effet(Jauge jauge, int valeur) {
        this.jauge = jauge;
        this.valeur = valeur;
    }

    public Jauge getJauge() {
        return jauge;
    }

    public void setJauge(Jauge jauge) {
        this.jauge = jauge;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void appliquerEffet() {
        this.jauge.setValeur(this.jauge.getValeur() + this.valeur);
    }

    @Override
    public String toString() {
        return "Jauge " + jauge.getNom() + ": " + ((valeur > 0) ? "+" : "") + valeur;
    }
}
