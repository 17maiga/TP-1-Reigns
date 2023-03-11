package main;

import main.gauge.Gauge;
import main.gauge.GaugePool;
import main.player.Player;
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
   * <b>Creates a new game.</b>
   *
   * <p>Initialises the player, gauges and questions.
   */
  private Game() {
    System.out.println("Creating character...");
    this.player = Player.getInstance();
    this.gauges = GaugePool.getInstance();
    this.questions = QuestionPool.getInstance();
  }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

  /**
   * <b>Check whether the game should end or not.</b>
   *
   * <p>The game ends when one of the gauges is either empty or full.
   */
  public boolean endOfGame() {
    for (Gauge gauge : gauges) if (gauge.isEmptyOrFull()) return true;
    return false;
  }

  /** <b>Runs the game.</b> */
  public void run() {
    System.out.println(player.getReignMessage());
    int turnCount = 0;
    while (!endOfGame()) {
      turnCount++;
      gauges.displayGauges();
      Question question = questions.getRandomQuestion();
      List<Effect> effects = question.ask();
      for (Effect effect : effects) effect.applyEffect();
    }
    System.out.println(player.getEndgameMessage(turnCount));
  }
}
