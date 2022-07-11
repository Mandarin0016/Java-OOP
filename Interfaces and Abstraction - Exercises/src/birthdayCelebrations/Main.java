package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String[] data = null;
    private static final List<Birthable> subjects = new ArrayList<>();

    public static void main(String[] args) {
        executeCommand();

        while (!data[0].equals("End")) {
            processSubject();
            executeCommand();
        }
        executeCommand();
        printRequiredSubjects();
    }

    private static void printRequiredSubjects() {
        subjects.stream().map(Birthable::getBirthDate).filter(subject -> subject.endsWith(data[0])).forEach(System.out::println);
    }

    private static void processSubject() {
        switch (data[0]) {
            case "Pet":
                addSubject(new Pet(data[1],
                        data[2]));
                break;
            case "Citizen":
                addSubject(new Citizen(data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4]));
                break;
        }
    }

    private static void addSubject(Birthable subject) {
        subjects.add(subject);
    }

    private static void executeCommand() {
        data = scanner.nextLine().split(" ");
    }
}
