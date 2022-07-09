package needForSpeed;

public class CrossMotorcycle extends Motorcycle {

    public CrossMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);

    }
}
