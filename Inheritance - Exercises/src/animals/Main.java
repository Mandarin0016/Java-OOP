package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static List<Animal> animals = new ArrayList<>();
    private static String[] inputFirstLine = null;
    private static String[] inputSecondLine = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        executeFirstLine();
        while (!inputFirstLine[0].equals("Beast!")) {
            executeSecondLine();
            try {
                createNewAnimal();
            } catch (Exception e) {
                System.out.println(ExceptionMessages.INVALID_INPUT);
            }
            executeFirstLine();
        }
        iterateOverAnimals();
    }

    private static void iterateOverAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void createNewAnimal() {
        switch (inputFirstLine[0]) {
            case "Dog":
                Dog dog = new Dog(inputSecondLine[0], Integer.parseInt(inputSecondLine[1]), inputSecondLine[2]);
                addToTheList(dog);
                break;
            case "Cat":
                Cat cat = new Cat(inputSecondLine[0], Integer.parseInt(inputSecondLine[1]), inputSecondLine[2]);
                addToTheList(cat);
                break;
            case "Frog":
                Frog frog = new Frog(inputSecondLine[0], Integer.parseInt(inputSecondLine[1]), inputSecondLine[2]);
                addToTheList(frog);
                break;
            case "Kitten":
                Kitten kitten = new Kitten(inputSecondLine[0], Integer.parseInt(inputSecondLine[1]));
                addToTheList(kitten);
                break;
            case "Tomcat":
                Tomcat tomcat = new Tomcat(inputSecondLine[0], Integer.parseInt(inputSecondLine[1]));
                addToTheList(tomcat);
                break;
        }
    }

    private static void addToTheList(Animal animal) {
        animals.add(animal);
    }

    private static void executeFirstLine() {
        inputFirstLine = scanner.nextLine().split(" ");
    }

    private static void executeSecondLine() {
        inputSecondLine = scanner.nextLine().split(" ");
    }
}
