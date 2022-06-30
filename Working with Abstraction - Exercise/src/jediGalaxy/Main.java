package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = initializeMatrix(scanner);

        long sum = 0;

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            int[] heroCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinatesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int evilRow = evilCoordinatesInput[0];
            int evilCol = evilCoordinatesInput[1];
            applyEvilMovement(matrix, evilRow, evilCol);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];
            sum = getHeroSum(matrix, sum, heroRow, heroCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static void applyEvilMovement(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isInBounds(evilRow, matrix, evilCol)) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long getHeroSum(int[][] matrix, long sum, int heroRow, int heroCol) {
        while (heroRow >= 0 && heroCol < matrix[1].length) {
            if (isInBounds(heroRow, matrix, heroCol)) {
                sum += matrix[heroRow][heroCol];
            }
            heroCol++;
            heroRow--;
        }
        return sum;
    }

    private static boolean isInBounds(int row, int[][] matrix, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static int[][] initializeMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }

        return matrix;
    }
}
