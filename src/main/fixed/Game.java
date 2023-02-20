package main.fixed;

import main.Genre;
import main.fixed.gauge.GaugePool;
import main.fixed.question.QuestionPool;

public class Game {

    private static Game instance;
    protected String name;
    protected Genre genre;

    private final GaugePool gauges;
    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param name   Le nom du personnage
     * @param genre  Le genre du personnage
     */
    private Game(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
        this.gauges = new GaugePool();
    }

    public GaugePool getGauges() {
        return gauges;
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game("", Genre.REINE);
        return instance;
    }

    public static void main(String[] args) {
        Game game = getInstance();



        QuestionPool questionPool = QuestionPool.getInstance();
        System.out.println(questionPool);
    }
}
