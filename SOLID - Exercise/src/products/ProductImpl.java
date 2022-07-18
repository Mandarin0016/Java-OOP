package products;

public abstract class ProductImpl implements Product {
    protected double calories;

    public ProductImpl(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
