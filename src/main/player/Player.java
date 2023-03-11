package main.player;

import java.util.Scanner;

/**
 * <b>Static class representing the player.</b>
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class Player {
  /** <b>Singleton instance.</b> */
  private static Player instance;
  /** <b>The player's gender.</b> */
  private final Gender gender;
  /** <b>The player's name.</b> */
  private final String name;

  /**
   * <b>Creates a new player.</b>
   *
   * <p>Prompts the user for a name and gender.
   */
  public Player() {
    Scanner scanner = new Scanner(System.in);

    // Ask the user for the character's name
    System.out.println("Enter your character's name: ");
    System.out.flush();
    this.name = scanner.nextLine();

    // Ask the user what gender the character is, and validate the answer
    StringBuilder genderQuestion = new StringBuilder("Is " + name);
    for (int i = 0; i < Gender.values().length - 1; i++) {
      genderQuestion
          .append(" a ")
          .append(Gender.values()[i].getTitle())
          .append(" (")
          .append(i + 1)
          .append("),");
    }
    genderQuestion
        .append(" or a ")
        .append(Gender.values()[Gender.values().length - 1].getTitle())
        .append(" (")
        .append(Gender.values().length)
        .append(") ?");
    int answer = 0;
    while (answer < 1 || answer > Gender.values().length) {
      System.out.println(genderQuestion);
      answer = scanner.nextInt();
    }
    gender = Gender.values()[answer - 1];
  }

  /**
   * <b>Gets the singleton instance.</b>
   *
   * @return The singleton instance.
   */
  public static Player getInstance() {
    if (instance == null) instance = new Player();
    return instance;
  }

  /**
   * <b>Gets a player's reign message.</b>
   *
   * <p>This is displayed at the start of the game. Example: "Long live King Bob"
   *
   * @return The reign message.
   */
  public String getReignMessage() {
    return "Long live " + this.gender.getTitle() + " " + this.name;
  }

  /**
   * <b>Gets a player's endgame message.</b>
   *
   * <p>This is displayed at the end of the game. Example: "King Bob lost! Their reign lasted 10
   * turns."
   *
   * @param turnCount The number of turns the player survived.
   * @return The endgame message.
   */
  public String getEndgameMessage(int turnCount) {
    return gender.getTitle() + " " + name + " lost! Their reign lasted " + turnCount + " turns.";
  }
}
