package numberInRange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rangeData = scanner.nextLine().split(" ");
        System.out.printf("Range: [%s...%s]%n", rangeData[0], rangeData[1]);
        executeCommand(Integer.parseInt(rangeData[0]), Integer.parseInt(rangeData[1]), scanner);
    }

    private static void executeCommand(int start, int end, Scanner scanner) {
        String number = scanner.nextLine();
        try {
            if (Integer.parseInt(number) >= start && Integer.parseInt(number) <= end) {
                System.out.printf("Valid number: %s", number);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.printf("Invalid number: %s%n", number);
            executeCommand(start, end, scanner);
        }
    }
}
