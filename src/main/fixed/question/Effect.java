package main.fixed.question;

import main.fixed.Game;
import main.fixed.gauge.Gauge;

import java.util.List;

public class Effect {
    private final String gaugeName;
    private transient Gauge gauge;
    private final int value;

    public Effect(Gauge gauge, int value) {
        this.gaugeName = gauge.getName();
        this.gauge = gauge;
        this.value = value;
    }

    public Gauge getGauge() {
        return gauge;
    }

    public int getValue() {
        return value;
    }

    public void applyEffect() {
        gauge.setValue(gauge.getValue() + this.value);
    }

    public void fetchGauge() {
        this.gauge = Game.getInstance().getGauges().getGauge(this.gaugeName);
    }

    @Override
    public String toString() {
        return "Gauge " + gauge.getName() + ": " + ((value > 0) ? "+" : "") + value;
    }

    public static String displayEffects(List<Effect> effects) {
        StringBuilder result = new StringBuilder();
        for (Effect effect : effects) {
            result.append(effect.toString()).append("; ");
        }
        return result.toString();
    }
}
