package vehiclesExtension;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public boolean driveEmpty(Double distance) {
        if (distance * super.fuelConsumption <= super.fuelQuantity) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            return true;
        }
        return false;
    }

    @Override
    boolean drive(Double distance) {
        if (distance * (super.fuelConsumption + 1.4) <= super.fuelQuantity) {
            super.fuelQuantity -= distance * (super.fuelConsumption + 1.4);
            return true;
        }
        return false;
    }

    @Override
    void refuel(Double liters) throws Exception {
        super.checkGiveLiters(liters);
        super.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
