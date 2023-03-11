package main.gauge;

import java.util.ArrayList;
import java.util.List;

public class GaugePool extends ArrayList<Gauge> {
  /** <b>Singleton instance.</b> */
  private static GaugePool instance;

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

  public Gauge getGauge(GaugeType type) {
    for (Gauge gauge : this) if (gauge.getType().equals(type)) return gauge;
    return null;
  }

  public void displayGauges() {
    for (Gauge gauge : this) System.out.println(gauge);
  }
}
