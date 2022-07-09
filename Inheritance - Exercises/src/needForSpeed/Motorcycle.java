package needForSpeed;

public class Motorcycle extends Vehicle {
    public Motorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
