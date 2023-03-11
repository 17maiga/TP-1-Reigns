package main.question;

import java.util.List;
import java.util.Objects;

public record Option(List<Effect> effects, String label) {
    public Option {
        Objects.requireNonNull(effects);
        Objects.requireNonNull(label);
    }
}
