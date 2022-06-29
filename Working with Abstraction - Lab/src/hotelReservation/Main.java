package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        double discount = DiscountType.valueOf(input[3]).getDiscountAmount() / 100.0;

        System.out.printf("%.2f%n", PriceCalculator.calculateHolidayPrice(pricePerDay, numberOfDays, season, discount));
    }
}
