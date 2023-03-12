package reigns;

import com.google.gson.Gson;
import java.io.*;
import reigns.question.QuestionPool;

/**
 * <b>Static class representing local operating system utils.</b>
 *
 * <p>Provides methods to access the config folder and extract questions from the JSON file.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class OS {
  /**
   * <b>Gets the config folder path.</b>
   *
   * @return The config folder path.
   */
  public static String getConfigFolder() {
    return System.getProperty("user.home") + "/.reigns/";
  }

  /**
   * <b>Extracts questions from the JSON file.</b>
   *
   * @return The question pool.
   */
  public static QuestionPool extractQuestions() {
    File questionFile = new File(getConfigFolder() + "questions.json");
    if (!questionFile.exists()) {
      if (questionFile.getParentFile().mkdirs()) {
        InputStream resource = OS.class.getResourceAsStream("/questions.json");
        if (resource == null) throw new RuntimeException("Could not find questions.json");
        try (FileOutputStream writer = new FileOutputStream(questionFile)) {
          byte[] questions = resource.readAllBytes();
          writer.write(questions);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

    QuestionPool instance = null;
    try (FileReader reader = new FileReader(questionFile)) {
      instance = new Gson().fromJson(reader, QuestionPool.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return instance;
  }
}
