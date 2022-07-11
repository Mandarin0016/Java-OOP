package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static String[] data = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Buyer> subjects = new HashMap<>();

    public static void main(String[] args) {
        executeCommand();
        createAllSubjects();
        buyFood();
        System.out.println(getTotalFoodResult());
    }

    private static int getTotalFoodResult() {
        return subjects.values().stream().map(Buyer::getFood).mapToInt(Integer::intValue).sum();
    }

    private static void buyFood() {
        executeCommand();
        while (!data[0].equals("End")){
            if (subjects.containsKey(data[0])){
                subjects.get(data[0]).buyFood();
            }
            executeCommand();
        }
    }

    private static void createAllSubjects() {
        int n = Integer.parseInt(data[0]);
        for (int i = 0; i < n; i++) {
            createCurrentSubject();
        }
    }

    private static void createCurrentSubject() {
        executeCommand();
        switch (data.length) {
            case 4:
                createBuyer(data[0], new Citizen(data[0],
                        Integer.parseInt(data[1]),
                        data[2],
                        data[3]));
                break;
            case 3:
                createBuyer(data[0], new Rebel(data[0],
                        Integer.parseInt(data[1]),
                        data[2]));
                break;
        }
    }

    private static void createBuyer(String name, Buyer subject) {
        subjects.put(name, subject);
    }

    private static void executeCommand() {
        data = scanner.nextLine().split(" ");
    }
}
