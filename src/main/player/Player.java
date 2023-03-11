package main.player;

import java.util.Scanner;

public class Player {

  private static Player instance;
  private final Gender gender;
  private final String name;

  public Player() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your character's name: ");
    System.out.flush();
    this.name = scanner.nextLine();

    // Ask the user what gender the character is
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
    System.out.println(this.getReignMessage());
  }

  public static Player getInstance() {
    if (instance == null) instance = new Player();
    return instance;
  }

  public String getReignMessage() {
    return "Long live " + this.gender.getTitle() + " " + this.name;
  }

  public String getEndgameMessage(int turnCount) {
    return gender.getTitle() + " " + name + " lost! Their reign lasted " + turnCount + " turns.";
  }
}
