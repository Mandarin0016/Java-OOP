package vehicles;

public class Truck extends Vehicle {

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
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
    public void refuel(Double liters) {
        super.fuelQuantity += liters * 0.95;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
