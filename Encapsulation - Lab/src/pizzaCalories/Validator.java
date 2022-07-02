package pizzaCalories;

import java.util.Arrays;

public class Validator {
    public static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new
                    IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateNumberOfTopings(int numberOfTopings) {
        if (numberOfTopings < 0 || numberOfTopings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void validateFlourType(String type) {
        if (!type.equals("White") && !type.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateBakingTechnique(String technique) {
        if (!technique.equals("Crispy") &&
                !technique.equals("Chewy") &&
                !technique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateToppingType(String type) {
        String[] table = {"Meat", "Veggies", "Cheese", "Sauce"};
        if (!Arrays.asList(table).contains(type)) {
            throw new IllegalArgumentException("Cannot place " + type + " on top of your pizza.");
        }
    }

    public static void validateToppingWeight(String type, double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(type + " weight should be in the range [1..50].");
        }
    }
}
