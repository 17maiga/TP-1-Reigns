package main.question;

import java.util.List;

public class Option {
    private final List<Effect> effects;
    private final String label;

    public Option(List<Effect> effects, String label) {
        this.effects = effects;
        this.label = label;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public String getLabel() {
        return label;
    }
}
