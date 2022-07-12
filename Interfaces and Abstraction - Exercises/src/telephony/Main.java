package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> numbers = Arrays.stream(executeCommand()).collect(Collectors.toList());
        List<String> urls = Arrays.stream(executeCommand()).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }

    private static String[] executeCommand() {
        return scanner.nextLine().split("\\s+");
    }
}
