package main.fixed.gauge;

import java.util.ArrayList;
import java.util.List;

public class GaugePool extends ArrayList<Gauge> {
    private static final List<Gauge> GAUGES = List.of(
            new ArmyGauge(),
            new ClergyGauge(),
            new FinanceGauge(),
            new PeopleGauge()
    );

    public GaugePool() {
        addAll(GAUGES);
    }

    public Gauge getGauge(String name) {
        for (Gauge gauge : this) {
            if (gauge.getName().equals(name)) {
                return gauge;
            }
        }
        return null;
    }

    public void printGauges() {
        for (Gauge gauge : this) {
            System.out.println(gauge);
        }
    }

    /**
     * Check whether the game should end or not.
     */
    public boolean endOfGame() {
        for (Gauge gauge : this) {
            if (gauge.isEmptyOrFull()) {
                return true;
            }
        }
        return false;
    }
}
