package reigns.question;

import java.util.ArrayList;
import reigns.OS;

/**
 * <b>Static class representing a list of questions.</b>
 *
 * <p>Questions are loaded from the "questions.json" file in the config folder.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class QuestionPool extends ArrayList<Question> {
  /** <b>Singleton instance.</b> */
  private static QuestionPool instance;

  /** <b>Creates a new question pool.</b> */
  public QuestionPool() {}

  /**
   * <b>Gets the singleton instance.</b>
   *
   * <p>Loads the questions from the JSON file if the instance is null.
   *
   * @return The singleton instance.
   */
  public static QuestionPool getInstance() {
    if (instance == null) {
      instance = OS.extractQuestions();
    }
    return instance;
  }

  /**
   * <b>Gets a random question.</b>
   *
   * @return A random question.
   */
  public Question getRandomQuestion() {
    int questionIndex = (int) (Math.random() * this.size());
    return this.get(questionIndex);
  }
}
