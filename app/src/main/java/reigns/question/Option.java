package reigns.question;

import java.util.List;
import java.util.Objects;

/**
 * <b>Represents a question's option.</b>
 *
 * <p>Each option is a list of effects.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public record Option(List<Effect> effects, String label) {
  public Option {
    Objects.requireNonNull(effects);
    Objects.requireNonNull(label);
  }
}
