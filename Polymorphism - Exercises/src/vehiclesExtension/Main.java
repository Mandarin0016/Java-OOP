package vehiclesExtension;

import java.util.Scanner;

public class Main {
    private static Vehicle car = null;
    private static Vehicle truck = null;
    private static Vehicle bus = null;
    private static String[] data = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        executeCommand();
        createCar();

        executeCommand();
        createTruck();

        executeCommand();
        createBus();

        executeCommand();
        applyVehicleCommands(Integer.parseInt(data[0]));

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void applyVehicleCommands(int n) {
        for (int i = 0; i < n; i++) {
            executeCommand();
            if (data[0].equals("Drive")) {
                driveVehicle();
            } else if (data[0].equals("Refuel")) {
                refuelVehicle();
            } else if (data[0].equals("DriveEmpty")){
                driveBusEmpty();
            }
        }
    }

    private static void driveBusEmpty() {
        if (data[1].equals("Bus")){
            if (bus.driveEmpty(Double.parseDouble(data[2]))){
                bus.traveling("Bus", Double.parseDouble(data[2]));
            }else {
                bus.needsRefueling();
            }
        }
    }

    private static void refuelVehicle() {
        try {
            if (data[1].equals("Car")) {
                car.refuel(Double.parseDouble(data[2]));
            } else if (data[1].equals("Truck")) {
                truck.refuel(Double.parseDouble(data[2]));
            } else if (data[1].equals("Bus")) {
                bus.refuel(Double.parseDouble(data[2]));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void driveVehicle() {
        if (data[1].equals("Car")) {
            driveCar();
        } else if (data[1].equals("Truck")) {
            driveTruck();
        } else if (data[1].equals("Bus")) {
            driveBus();
        }
    }

    private static void driveBus() {
        if (bus.drive(Double.parseDouble(data[2]))) {
            bus.traveling("Bus", Double.parseDouble(data[2]));
        } else {
            bus.needsRefueling();
        }
    }

    private static void driveTruck() {
        if (truck.drive(Double.parseDouble(data[2]))) {
            truck.traveling("Truck", Double.parseDouble(data[2]));
        } else {
            truck.needsRefueling();
        }
    }

    private static void driveCar() {
        if (car.drive(Double.parseDouble(data[2]))) {
            car.traveling("Car", Double.parseDouble(data[2]));
        } else {
            car.needsRefueling();
        }
    }

    private static void createBus() {
        bus = new Bus(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void createCar() {
        car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void createTruck() {
        truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void executeCommand() {
        data = scanner.nextLine().split(" ");
    }


}
