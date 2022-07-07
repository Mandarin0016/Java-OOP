package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaInputData = scanner.nextLine().split("\\s+");

        try {
            String pizzaName = pizzaInputData[1];
            int numberOfToppings = Integer.parseInt(pizzaInputData[2]);

            Pizza myPizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInputData = scanner.nextLine().split("\\s+");
            String flourType = doughInputData[1];
            String bakingTechnique = doughInputData[2];
            double weightInGrams = Double.parseDouble(doughInputData[3]);

            Dough pizzaDough = new Dough(flourType, bakingTechnique, weightInGrams);

            myPizza.setDough(pizzaDough);

            String[] toppingInputData = scanner.nextLine().split("\\s+");
            while (!toppingInputData[0].equals("END")){
                String toppingType = toppingInputData[1];
                double toppingWeight = Double.parseDouble(toppingInputData[2]);

                Topping myCurrentTopping = new Topping(toppingType, toppingWeight);

                myPizza.addTopping(myCurrentTopping);

                toppingInputData = scanner.nextLine().split("\\s+");
            }
            System.out.printf("%s - %.2f%n", myPizza.getName(), myPizza.getOverallCalories());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
