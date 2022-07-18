package products;

public abstract class Food extends ProductImpl {
    protected double grams;

    public Food(double grams, double calories) {
        super(calories);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
    @Override
    public double getKilograms() {
        return this.grams / 1000;
    }
}
