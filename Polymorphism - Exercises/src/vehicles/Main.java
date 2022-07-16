package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static Vehicle car = null;
    private static Vehicle truck = null;
    private static String[] data = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat dm = new DecimalFormat("#.##");

    public static void main(String[] args) {
        executeCommand();
        createCar();

        executeCommand();
        createTruck();

        executeCommand();
        applyVehicleCommands(Integer.parseInt(data[0]));

        System.out.println(car);
        System.out.println(truck);
    }

    private static void applyVehicleCommands(int n) {
        for (int i = 0; i < n; i++) {
            executeCommand();
            if (data[0].equals("Drive")) {
                driveVehicle();
            } else {
                refuelVehicle();
            }
        }
    }

    private static void refuelVehicle() {
        if (data[1].equals("Car")) {
            car.refuel(Double.parseDouble(data[2]));
        } else {
            truck.refuel(Double.parseDouble(data[2]));
        }
    }

    private static void driveVehicle() {
        if (data[1].equals("Car")) {
            driveCar();
        } else {
            driveTruck();
        }
    }

    private static void driveTruck() {
        if (truck.drive(Double.parseDouble(data[2]))) {
            System.out.printf("Truck travelled %s km%n", dm.format(Double.parseDouble(data[2])));
        } else {
            truck.needsRefueling();
        }
    }

    private static void driveCar() {
        if (car.drive(Double.parseDouble(data[2]))) {
            System.out.printf("Car travelled %s km%n", dm.format(Double.parseDouble(data[2])));
        } else {
            car.needsRefueling();
        }
    }

    private static void createCar() {
        car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    private static void createTruck() {
        truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    private static void executeCommand() {
        data = scanner.nextLine().split(" ");
    }


}
