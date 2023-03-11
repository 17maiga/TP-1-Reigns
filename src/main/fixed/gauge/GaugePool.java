package main.fixed.gauge;

import java.util.ArrayList;
import java.util.List;

public class GaugePool extends ArrayList<Gauge> {
    private static final List<Gauge> GAUGES = List.of(
            new Gauge(GaugeType.ARMY),
            new Gauge(GaugeType.CLERGY),
            new Gauge(GaugeType.FINANCE),
            new Gauge(GaugeType.PEOPLE)
    );

    public GaugePool() {
        addAll(GAUGES);
    }

    public Gauge getGauge(GaugeType type) {
        for (Gauge gauge : this)
            if (gauge.getType().equals(type))
                return gauge;
        return null;
    }

    public void displayGauges() {
        for (Gauge gauge : this)
            System.out.println(gauge);
    }

    /**
     * Check whether the game should end or not.
     */
    public boolean endOfGame() {
        for (Gauge gauge : this)
            if (gauge.isEmptyOrFull())
                return true;
        return false;
    }
}
