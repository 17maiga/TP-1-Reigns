package main;

import main.gauge.GaugePool;
import main.question.Effect;
import main.question.Question;
import main.question.QuestionPool;

import java.util.List;

public class Game {

    private static Game instance;
    private final Player player;
    private final GaugePool gauges;
    private final QuestionPool questions;

    /**
     * Creates a new player and initialises the gauges and questions.
     */
    private Game() {
        System.out.println("Creating character...");
        this.player = Player.getInstance();
        this.gauges = new GaugePool();
        this.questions = QuestionPool.getInstance();
    }

    public GaugePool getGauges() {
        return gauges;
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void run() {
        int turnCount = 0;
        while (!gauges.endOfGame()) {
            turnCount++;
            gauges.displayGauges();
            Question question = questions.getRandomQuestion();
            List<Effect> effects = question.ask();
            for (Effect effect : effects)
                effect.applyEffect();
        }
        System.out.println(player.getName() + " lost! Their reign lasted " + turnCount + " turns.");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Reigns");
        Game game = getInstance();
        game.run();
    }
}
