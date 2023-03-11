package main.gauge;

import java.util.ArrayList;

/**
 * <b>Static class representing a list of gauges.</b>
 *
 * @author Henri Saudubray / Clément Lardemelle
 */
public class GaugePool extends ArrayList<Gauge> {
  /** <b>Singleton instance.</b> */
  private static GaugePool instance;

  /**
   * <b>Creates a new gauge pool.</b>
   *
   * <p>Creates a gauge for each gauge type.
   */
  public GaugePool() {
    for (GaugeType type : GaugeType.values()) add(new Gauge(type));
  }

  /**
   * <b>Gets the singleton instance.</b>
   *
   * @return The singleton instance.
   */
  public static GaugePool getInstance() {
    if (instance == null) instance = new GaugePool();
    return instance;
  }

  /**
   * <b>Gets a gauge from its type.</b>
   *
   * @param type The gauge type.
   * @return The gauge, or null if not found.
   */
  public Gauge getGauge(GaugeType type) {
    for (Gauge gauge : this) if (gauge.getType().equals(type)) return gauge;
    return null;
  }

  /** <b>Displays all the gauges.</b> */
  public void displayGauges() {
    for (Gauge gauge : this) System.out.println(gauge);
  }
}
