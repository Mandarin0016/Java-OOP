package pizzaCalories;

public enum FlourTypeModifier {
    white(1.5),
    wholegrain(1.0);

    private final double modifier;

    FlourTypeModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
