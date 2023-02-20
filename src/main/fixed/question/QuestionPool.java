package main.fixed.question;

import com.google.gson.Gson;

import java.util.ArrayList;

public class QuestionPool extends ArrayList<Question> {
    private static QuestionPool instance;

    public QuestionPool() {
    }

    public static QuestionPool getInstance() {
        if (instance == null) {
            instance = new Gson().fromJson("[{\"question\":\"Ma question\",\"left\":[{\"gaugeName\":\"Army\",\"value\":5}],\"right\":[]}]", QuestionPool.class);
            instance.fetchGauges();
        }
        return instance;
    }

    private void fetchGauges() {
        for (Question question : this) {
            question.fetchGauges();
        }
    }
}
