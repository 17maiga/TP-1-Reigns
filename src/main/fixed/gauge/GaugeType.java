package main.fixed.gauge;

public enum GaugeType {
    ARMY("Army"),
    CLERGY("Clergy"),
    FINANCE("Finance"),
    PEOPLE("People");

    private final String name;

    GaugeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
