package main.fixed.question;

import java.util.List;
import java.util.Scanner;

public class Question {
    private final String question;
    private final String character;
    private final List<Option> options;

    public Question(String question, String character, List<Option> options) {
        this.question = question;
        this.character = character;
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + character + "] " + question + " [");
        for (int i = 0; i < options.size() - 1; i++)
            result.append(i + 1).append(": ").append(options.get(i).getLabel()).append(", ");
        result.append(options.size()).append(": ").append(options.get(options.size() - 1).getLabel()).append("]\n");
        for (int i = 0; i < options.size(); i++)
            result.append(i + 1).append(": ").append(Effect.displayEffects(options.get(i).getEffects())).append("\n");
        return result.toString();
    }

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
        return options.get(answer - 1).getEffects();
    }
}
