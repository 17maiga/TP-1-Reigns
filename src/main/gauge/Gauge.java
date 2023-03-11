package main.gauge;

/**
 * <b>Represents a gauge with a name and value.</b>
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class Gauge {
  /** Maximum length of the gauge. */
  public static int gaugeLength = 50;

  /** The gauge type. */
  private final GaugeType type;

  /** The gauge value. */
  private int value;

  /**
   * <b>Creates a new gauge and randomly sets its initial value.</b>
   *
   * <p>The initial value is half of the gauge length, plus or minus 10.
   *
   * @param type The gauge type.
   */
  public Gauge(GaugeType type) {
    this.type = type;
    this.value = ((gaugeLength - 20) / 2) + (int) (Math.random() * 20);
  }

  public GaugeType getType() {
    return type;
  }

  public int getValue() {
    return value;
  }

  /**
   * <b>Sets the gauge value.</b>
   *
   * <p>The value is clamped between 0 and the gauge length.
   *
   * @param value The new value.
   */
  public void setValue(int value) {
    this.value = Math.min(Math.max(value, 0), gaugeLength);
  }

  /**
   * <b>Represents the gauge as a string.</b>
   *
   * @return A string representing the gauge.
   */
  @Override
  public String toString() {
    return "[" + "#".repeat(value) + "_".repeat(gaugeLength - value) + "] " + type.getName();
  }

  /**
   * <b>Checks whether the gauge is empty or full.</b>
   *
   * @return True if the gauge is empty or full, false otherwise.
   */
  public boolean isEmptyOrFull() {
    return value >= gaugeLength || value <= 0;
  }
}
