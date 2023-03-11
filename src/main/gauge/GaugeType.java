package main.gauge;

/**
 * <b>Represents a gauge type.</b>
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public enum GaugeType {
  /** <b>Army gauge.</b> */
  ARMY("Army"),
  /** <b>Clergy gauge.</b> */
  CLERGY("Clergy"),
  /** <b>Finance gauge.</b> */
  FINANCE("Finance"),
  /** <b>People gauge.</b> */
  PEOPLE("People");

  /** <b>The gauge name.</b> */
  private final String name;

  GaugeType(String name) {
    this.name = name;
  }

  /**
   * <b>Gets the gauge name.</b>
   *
   * @return The gauge name.
   */
  public String getName() {
    return name;
  }
}
