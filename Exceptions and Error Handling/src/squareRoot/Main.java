package squareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0){
                throw new IllegalArgumentException();
            }
            System.out.printf("%.2f%n", Math.sqrt(number));
        }catch (IllegalArgumentException e){
            System.out.println("Invalid");
        }
        System.out.println("Goodbye");
    }
}
