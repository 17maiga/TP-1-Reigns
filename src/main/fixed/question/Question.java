package main.fixed.question;

import com.google.gson.Gson;
import main.fixed.Effect;

import java.util.List;

public class Question {
    private final String question;

    private final List<Effect> left;
    private final List<Effect> right;

    public Question(String question, List<Effect> left, List<Effect> right) {
        this.question = question;
        this.left = left;
        this.right = right;
    }

    public static Question parseQuestion(String json) {
        return new Gson().fromJson(json, Question.class);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void fetchGauges() {
        for (Effect effect : left) {
            effect.fetchGauge();
        }
        for (Effect effect : right) {
            effect.fetchGauge();
        }
    }
}
