package classBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box myCurrentBox = new Box(length, width, height);
            System.out.println("Surface Area - " + myCurrentBox.calculateSurfaceArea());
            System.out.println("Lateral Surface Area - " + myCurrentBox.calculateLateralSurfaceArea());
            System.out.println("Volume – " + myCurrentBox.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
