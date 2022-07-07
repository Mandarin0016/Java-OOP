package pizzaCalories;

public enum BackingTechniqueModifier {
    crispy(0.9),
    chewy(1.1),
    homemade(1.0);

    private final double modifier;

    BackingTechniqueModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
