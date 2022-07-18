package products;

public abstract class Drink extends ProductImpl {
    protected double density;
    protected double milliliters;

    public Drink(double milliliters, double density, double calories) {
        super(calories);
        this.milliliters = milliliters;
        this.density = density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public double getDensity() {
        return density;
    }

    public double getGrams() {
        return getDensity() * getMilliliters();
    }

    @Override
    public double getKilograms() {
        return getDensity() * (getMilliliters() / 1000);
    }

}
