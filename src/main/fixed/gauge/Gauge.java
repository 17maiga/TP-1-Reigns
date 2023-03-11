package main.fixed.gauge;

/**
 * Represents a gauge with a name and a value
 *
 * @author Henri Saudubray / Clément Lardemelle
 * @version 1.0
 */
public class Gauge {
    /**
     * La longueur maximale d'une jauge.
     */
    public static int gaugeLength = 50;

    /**
     * Le type de la jauge.
     */
    private final GaugeType type;

    /**
     * La valeur de la jauge.
     */
    private int value;

    /**
     * Creates a new gauge with the specified type
     *
     * @param type The gauge type
     */
    public Gauge(GaugeType type) {
        this.type = type;
        this.value = ((gaugeLength - 20) / 2) + (int) (Math.random() * 20);
    }

    public GaugeType getType() {
        return this.type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Math.min(Math.max(value, 0), gaugeLength);
    }

    @Override
    public String toString() {
        return "[" + "#".repeat(value) + "_".repeat(gaugeLength - value) + "] " + type.getName();
    }

    public boolean isEmptyOrFull() {
        return value >= gaugeLength || value <= 0;
    }
}
