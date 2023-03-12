package reigns.question;

import java.util.List;
import reigns.gauge.Gauge;
import reigns.gauge.GaugePool;
import reigns.gauge.GaugeType;

/**
 * <b>Represents an effect on a gauge.</b>
 *
 * <p>Each effect is a change on a gauge's value.
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class Effect {
  /** <b>The target gauge's type.</b> */
  private final GaugeType gaugeType;
  /** <b>The effect's value.</b> */
  private final int value;

  /**
   * <b>Creates a new effect.</b>
   *
   * @param gaugeType The target gauge's type.
   * @param value The effect's value.
   */
  public Effect(GaugeType gaugeType, int value) {
    this.gaugeType = gaugeType;
    this.value = value;
  }

  /**
   * <b>Displays a list of effects.</b>
   *
   * @param effects The list of effects.
   * @return The list of effects as a string.
   */
  public static String displayEffects(List<Effect> effects) {
    StringBuilder result = new StringBuilder();
    for (Effect effect : effects) {
      result.append(effect.toString()).append("; ");
    }
    return result.toString();
  }

  /** <b>Applies the effect on the target gauge.</b> */
  public void applyEffect() {
    Gauge gauge = GaugePool.getInstance().getGauge(gaugeType);
    gauge.setValue(gauge.getValue() + this.value);
  }

  /**
   * <b>Represents the effect as a string.</b>
   *
   * <p>Example: "Gauge People: +10".
   *
   * @return A string representing the effect.
   */
  @Override
  public String toString() {
    return gaugeType.getName() + ": " + ((value > 0) ? "+" : "") + value;
  }
}
