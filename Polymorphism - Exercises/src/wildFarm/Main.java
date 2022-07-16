package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String[] animalData = null;
    private static String[] foodData = null;
    private static Animal animal = null;
    private static Food food = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        executeAnimalDataCommand();
        while (!animalData[0].equals("End")) {
            executeFoodDataCommand();
            try {
                getSubjects(animalData[0], foodData[0]);
                animal.makeSound();
                feedMe();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);
            executeAnimalDataCommand();
        }
        animals.forEach(animal1 -> System.out.println(animal1));
    }

    private static void feedMe() {
        animal.eat(food);
    }

    private static void getSubjects(String typeOfAnimal, String typeOfFood) {
        createFood(typeOfFood);
        createAnimal(typeOfAnimal);
    }

    private static void createAnimal(String typeOfAnimal) {
        switch (typeOfAnimal) {
            case "Cat":
                animal = new Cat(typeOfAnimal, animalData[1], Double.parseDouble(animalData[2]), animalData[3], animalData[4]);
                break;
            case "Tiger":
                animal = new Tiger(typeOfAnimal, animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Zebra":
                animal = new Zebra(typeOfAnimal, animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                break;
            case "Mouse":
                animal = new Mouse(typeOfAnimal, animalData[1], Double.parseDouble(animalData[2]), animalData[3]);
                break;
        }
    }

    private static void createFood(String typeOfFood) {
        switch (typeOfFood) {
            case "Vegetable":
                food = new Vegetable(Integer.parseInt(foodData[1]));
                break;
            case "Meat":
                food = new Meat(Integer.parseInt(foodData[1]));
                break;
        }
    }

    private static void executeFoodDataCommand() {
        foodData = scanner.nextLine().split("\\s+");
    }

    private static void executeAnimalDataCommand() {
        animalData = scanner.nextLine().split("\\s+");
    }
}
