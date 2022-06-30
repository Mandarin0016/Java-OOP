package trafficLightsBetterSolution;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Lights> myLights = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Lights::valueOf).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            myLights = myLights.stream().map(Lights::getNextLight).collect(Collectors.toList());
            System.out.println(String.join(" ", myLights.toString().replaceAll("[\\[\\],]+", "")));
        }
    }
}
