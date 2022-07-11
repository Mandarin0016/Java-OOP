package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String[] input = null;
    private final static Scanner scanner = new Scanner(System.in);
    private final static List<Identifiable> individuals = new ArrayList<>();
    public static void main(String[] args) {
        executeCommand();
        while (!input[0].equals("End")){
            registerIndividual();
            executeCommand();
        }
        executeCommand();
        listFakeSubjects();
    }

    private static void listFakeSubjects() {
        individuals.forEach(individual -> {
            if (individual.getId().endsWith(input[0])){
                System.out.println(individual.getId());
            }
        });
    }

    private static void registerIndividual() {
        switch (input.length){
            case 2:
                String robotModel = input[0];
                String robotId = input[1];
                individuals.add(new Robot(robotModel, robotId));
                break;
            case 3:
                String humanoidName = input[0];
                int humanoidAge = Integer.parseInt(input[1]);
                String humanoidId = input[2];
                individuals.add(new Citizen(humanoidName, humanoidAge, humanoidId));
                break;
        }
    }

    private static void executeCommand() {
        input = scanner.nextLine().split(" ");
    }
}
