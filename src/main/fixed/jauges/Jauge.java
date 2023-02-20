package main.fixed.jauges;

/**
 * Représente une jauge avec un nom, une valeur et un type.
 *
 * @author Henri Saudubray / Clément Lardemelle
 * @version 1.0
 */
public abstract class Jauge {
    /**
     * Le nom de la jauge.
     */
    protected String nom;

    /**
     * La valeur de la jauge.
     */
    protected int valeur;

    /**
     * Crée une nouvelle jauge avec le nom et la valeur spécifiés.
     *
     * @param nom    Le nom de la jauge
     */
    public Jauge(String nom) {
        this.nom = nom;
        this.valeur = 15 + (int)(Math.random() * 20);
    }

    /**
     * Retourne le nom de la jauge.
     *
     * @return Le nom de la jauge.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Modifie le nom de la jauge.
     *
     * @param nom Le nouveau nom de la jauge.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la valeur de la jauge.
     *
     * @return la valeur de la jauge.
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la jauge.
     *
     * @param valeur La nouvelle valeur de la jauge
     */
    public void setValeur(int valeur) {
        this.valeur = Math.min(Math.max(valeur, 0), 50);
    }

    @Override
    public String toString() {
        return "[" + "#".repeat(valeur) + "_".repeat(50 - valeur) + "] " + nom;
    }
}
