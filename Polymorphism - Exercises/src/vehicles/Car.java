package vehicles;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
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
    public void refuel(Double liters) {
        super.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}
