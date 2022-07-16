package vehicles;

public abstract class Vehicle {

    protected Double fuelQuantity;
    protected Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    abstract boolean drive(Double distance);
    abstract void refuel(Double liters);

    public void needsRefueling(){
        System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
    }
}
