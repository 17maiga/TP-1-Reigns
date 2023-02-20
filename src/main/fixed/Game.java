package main.fixed;

import main.Genre;
import main.fixed.gauge.ArmyGauge;
import main.fixed.gauge.ClergyGauge;
import main.fixed.gauge.FinanceGauge;
import main.fixed.gauge.PeopleGauge;

public class Game {
    protected String name;
    protected Genre genre;

    protected ClergyGauge clergyGauge;
    protected PeopleGauge peopleGauge;
    protected ArmyGauge armyGauge;
    protected FinanceGauge financeGauge;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param name  Le nom du personnage
     * @param genre Le genre du personnage
     */
    public Game(String name, Genre genre) {
        this.name = name;
        this.genre = genre;

        // Initialisation des jauges
        clergyGauge = new ClergyGauge();
        peopleGauge = new PeopleGauge();
        armyGauge = new ArmyGauge();
        financeGauge = new FinanceGauge();
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void printGauge() {
        System.out.println(clergyGauge);
        System.out.println(peopleGauge);
        System.out.println(armyGauge);
        System.out.println(financeGauge);
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean endOfGame() {
        return armyGauge.isEmptyOrFull() || peopleGauge.isEmptyOrFull() || armyGauge.isEmptyOrFull() || financeGauge.isEmptyOrFull();
    }
}
