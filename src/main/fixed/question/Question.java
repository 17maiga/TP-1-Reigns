package main.fixed.question;

import java.util.List;
import java.util.Scanner;

public class Question {
    private final String question;
    private final String character;
    private final List<Effect> left;
    private final List<Effect> right;

    public Question(String question, String character, List<Effect> left, List<Effect> right) {
        this.question = question;
        this.character = character;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String result = "[" + character + "] " + question + " [L: " + left + ", R: " + right + "]\n";
        result += "Left:  " + Effect.displayEffects(left) + "\n";
        result += "Right: " + Effect.displayEffects(right) + "\n";
        return result;
    }

    public void fetchGauges() {
        for (Effect effect : left) {
            effect.fetchGauge();
        }
        for (Effect effect : right) {
            effect.fetchGauge();
        }
    }

    public List<Effect> ask() {
        System.out.println(this);
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        while (!answer.equals("L") && !answer.equals("R")) {
            System.out.println("Enter your choice (L or R): ");
            System.out.flush();
            answer = scanner.nextLine();
        }
        return answer.equals("L") ? left : right;
    }
}
