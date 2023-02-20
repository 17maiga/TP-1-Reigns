package main.fixed;

import main.Genre;
import main.fixed.jauges.*;

public class Game {
    /**
     * Le nom du personnage
     */
    protected String nom;
    /**
     * Le genre du personnage
     */
    protected Genre genre;
    /**
     * La jauge de Clergé
     */
    protected JaugeClerge jaugeClerge;
    /**
     * La jauge de Peuple
     */
    protected JaugePeuple jaugePeuple;
    /**
     * La jauge d'Armée
     */
    protected JaugeArmee jaugeArmee;
    /**
     * La jauge de Finances
     */
    protected JaugeFinance jaugeFinance;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Game(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;

        // Initialisation des jauges
        jaugeClerge = new JaugeClerge();
        jaugePeuple = new JaugePeuple();
        jaugeArmee = new JaugeArmee();
        jaugeFinance = new JaugeFinance();
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void printGauge() {
        System.out.println(jaugeClerge);
        System.out.println(jaugePeuple);
        System.out.println(jaugeArmee);
        System.out.println(jaugeFinance);
        System.out.println();
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean endOfGame(){
        return jaugeArmee.isEmptyOrFull()
                || jaugePeuple.isEmptyOrFull()
                || jaugeArmee.isEmptyOrFull()
                || jaugeFinance.isEmptyOrFull();
    }
}
