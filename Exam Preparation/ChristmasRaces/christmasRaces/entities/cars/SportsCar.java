package christmasRaces.entities.cars;

public class SportsCar extends BaseCar{
    private static final double CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected int getMinHorsepower() {
        return MIN_HORSEPOWER;
    }

    @Override
    protected int getMaxHorsepower() {
        return MAX_HORSEPOWER;
    }
}
