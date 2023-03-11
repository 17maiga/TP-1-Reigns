package reigns.question;

import com.google.gson.Gson;
import reigns.utils.OS;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <b>Static class representing a list of questions.</b>
 *
 * <p>Questions are loaded from the "questions.json" file in the config folder.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class QuestionPool extends ArrayList<Question> {
  /** <b>Path to the JSON file containing the questions.</b> */
  private static final String JSON_FILE_PATH = OS.getConfigFolder() + "questions.json";

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
      try (FileReader reader = new FileReader(JSON_FILE_PATH)) {
        instance = new Gson().fromJson(reader, QuestionPool.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
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
