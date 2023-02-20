package main.fixed.gauge;

/**
 * Represents a gauge with a name and a value
 *
 * @author Henri Saudubray / Clément Lardemelle
 * @version 1.0
 */
public abstract class Gauge {
    /**
     * La longueur maximale d'une jauge.
     */
    public static int gaugeLength = 50;

    /**
     * Le nom de la jauge.
     */
    protected String name;

    /**
     * La valeur de la jauge.
     */
    protected int value;

    /**
     * Creates a new gauge with the specified name
     *
     * @param name    The gauge name
     */
    public Gauge(String name) {
        this.name = name;
        this.value = 15 + (int)(Math.random() * 20);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = Math.min(Math.max(value, 0), 50);
    }

    @Override
    public String toString() {
        return "[" + "#".repeat(value) + "_".repeat(50 - value) + "] " + name;
    }

    public boolean isEmptyOrFull() {
        return value >= 50 || value <= 0;
    }
}
