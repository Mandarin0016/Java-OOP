package pizzaCalories;

public enum ToppingsModifier {
    meat(1.2),
    veggies(0.8),
    cheese(1.1),
    sauce(0.9);

    private final double modifier;

    ToppingsModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
