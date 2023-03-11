package main.question;

import main.Game;
import main.gauge.Gauge;
import main.gauge.GaugeType;

import java.util.List;

public class Effect {
    private final GaugeType gaugeType;
    private final int value;

    public Effect(GaugeType gaugeType, int value) {
        this.gaugeType = gaugeType;
        this.value = value;
    }

    public static String displayEffects(List<Effect> effects) {
        StringBuilder result = new StringBuilder();
        for (Effect effect : effects) {
            result.append(effect.toString()).append("; ");
        }
        return result.toString();
    }

    public void applyEffect() {
        Gauge gauge = Game.getInstance().getGauges().getGauge(gaugeType);
        gauge.setValue(gauge.getValue() + this.value);
    }

    @Override
    public String toString() {
        return "Gauge " + gaugeType.getName() + ": " + ((value > 0) ? "+" : "") + value;
    }
}
