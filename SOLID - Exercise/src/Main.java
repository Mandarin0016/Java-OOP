import products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product = new Chips(123);
        Product product2 = new Chocolate(123);
        Product product3 = new Lemonade(8827);
        Product product4 = new Coke(2233);
        Product product5 = new Lemonade(1223);
        Product product6 = new Coke(2123);
        Product product7 = new Chips(123);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);

        Calculator calCalculator = new CalorieCalculator();
        System.out.println(calCalculator.sum(products));
        Printer caloriePrinter = new CaloriePrinter();
        caloriePrinter.printAverage(products);
        caloriePrinter.printSum(products);

        Calculator quantityCalculator = new QuantityCalculator();
        System.out.println(quantityCalculator.sum(products));
        Printer quantityPrinter = new QuantityPrinter();
        quantityPrinter.printAverage(products);
        quantityPrinter.printSum(products);
    }
}
