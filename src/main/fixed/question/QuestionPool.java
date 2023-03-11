package main.fixed.question;

import com.google.gson.Gson;
import main.fixed.utils.OS;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionPool extends ArrayList<Question> {

    private static final String JSON_FILE_PATH = OS.getConfigFolder() + "questions.json";

    private static QuestionPool instance;

    public QuestionPool() {
    }

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

    public Question getRandomQuestion() {
        int questionIndex = (int) (Math.random() * this.size());
        return this.get(questionIndex);
    }
}
