package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar{

    private static final double CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HORSEPOWER = 400;
    private static final int MAX_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
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
