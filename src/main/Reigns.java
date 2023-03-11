package main;

/**
 * <b>Represents the main class of the Reigns game.</b>
 *
 * <p>Creates a new game and runs it.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class Reigns {
  public static void main(String[] args) {
    System.out.println("Welcome to Reigns");
    Game game = Game.getInstance();
    game.run();
  }
}
