package vehiclesExtension;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        increaseFuelConsumption();
    }

    private void increaseFuelConsumption() {
        super.fuelConsumption = super.fuelConsumption + 0.9;
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
        super.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
