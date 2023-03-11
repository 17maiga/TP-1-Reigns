package main.question;

import java.util.List;
import java.util.Scanner;

/**
 * <b>Represents a question.</b>
 *
 * <p>Each question has an associated character and list of options.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class Question {
  /** <b>The question's text.</b> */
  private final String question;
  /** <b>The question's associated character.</b> */
  private final String character;
  /** <b>The question's options.</b> */
  private final List<Option> options;

  /**
   * <b>Creates a new question.</b>
   *
   * @param question The question's text.
   * @param character The question's associated character.
   * @param options The question's options.
   */
  public Question(String question, String character, List<Option> options) {
    this.question = question;
    this.character = character;
    this.options = options;
  }

  /**
   * <b>Represents the question and its options as a string.</b>
   *
   * @return A string representing the question and its options.
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[" + character + "] " + question + " [");
    for (int i = 0; i < options.size() - 1; i++)
      result.append(i + 1).append(": ").append(options.get(i).label()).append(", ");
    result
        .append(options.size())
        .append(": ")
        .append(options.get(options.size() - 1).label())
        .append("]\n");
    for (int i = 0; i < options.size(); i++)
      result
          .append(i + 1)
          .append(": ")
          .append(Effect.displayEffects(options.get(i).effects()))
          .append("\n");
    return result.toString();
  }

  /**
   * <b>Asks the question to the player.</b>
   *
   * @return The list of effects associated with the chosen option.
   */
  public List<Effect> ask() {
    System.out.println(this);
    System.out.flush();
    Scanner scanner = new Scanner(System.in);
    int answer = 0;
    while (answer < 1 || answer > options.size()) {
      System.out.println("Enter your choice (1, 2, ...): ");
      System.out.flush();
      answer = scanner.nextInt();
    }
    return options.get(answer - 1).effects();
  }
}
