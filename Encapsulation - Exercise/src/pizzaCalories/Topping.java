package pizzaCalories;

import java.util.Arrays;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (Arrays.stream(ToppingsModifier.values()).map(ToppingsModifier::toString).anyMatch(validTopic -> validTopic.equals(toppingType.toLowerCase()))) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories() {
        ToppingsModifier toppingsModifier = ToppingsModifier.valueOf(this.toppingType.toLowerCase());
        double modifier = toppingsModifier.getModifier();
        return (2 * this.weight) * modifier;
    }
}
