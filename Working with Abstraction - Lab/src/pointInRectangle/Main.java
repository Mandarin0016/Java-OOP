package pointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rectangleCoordinates = scanner.nextLine().split("\\s+");

        Point bottomLeft = new Point(Integer.parseInt(rectangleCoordinates[0]), Integer.parseInt(rectangleCoordinates[1]));
        Point topRight = new Point(Integer.parseInt(rectangleCoordinates[2]), Integer.parseInt(rectangleCoordinates[3]));

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int checkCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < checkCount; i++) {
            System.out.println(currentCheck(rectangle, scanner));
        }
    }

    private static boolean currentCheck(Rectangle rectangle, Scanner scanner) {
        String input = scanner.nextLine();

        Point currentPoint = new Point(Integer.parseInt(input.split("\\s+")[0]), Integer.parseInt(input.split("\\s+")[1]));

        return rectangle.contains(currentPoint);
    }
}
