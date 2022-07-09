package needForSpeed;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(100, 2);
        Car car = new Car(100, 2);
        System.out.println(vehicle.getFuelConsumption());
        System.out.println(car.getFuelConsumption());
        System.out.println(vehicle.getFuelConsumption());
    }
}
