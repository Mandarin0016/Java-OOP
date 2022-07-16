package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected Double fuelQuantity;
    protected Double fuelConsumption;
    protected Double tankCapacity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    abstract boolean drive(Double distance);
    abstract boolean driveEmpty(Double distance);

    abstract void refuel(Double liters) throws Exception;

    public void traveling(String className, Double kilometers) {
        DecimalFormat dm = new DecimalFormat("#.##");
        System.out.printf("%s travelled %s km%n",className, dm.format(kilometers));
    }

    public void needsRefueling() {
        System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
    }

    protected void checkGiveLiters(Double liters) throws Exception {
        if (liters <= 0) {
            throw new Exception("Fuel must be a positive number");
        } else if (liters + fuelQuantity > this.tankCapacity) {
            throw new Exception("Cannot fit fuel in tank");
        }
    }
}
