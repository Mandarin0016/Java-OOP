package vehiclesExtension;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        increaseFuelConsumption();
    }

    private void increaseFuelConsumption() {
        super.fuelConsumption = super.fuelConsumption + 1.6;
    }

    @Override
    public boolean drive(Double distance) {
        if (distance * super.fuelConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            return true;
        }
        return false;
    }

    @Override
    boolean driveEmpty(Double distance) {
        return false;
    }

    @Override
    public void refuel(Double liters) throws Exception {
        super.checkGiveLiters(liters);
        super.fuelQuantity += liters * 0.95;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
