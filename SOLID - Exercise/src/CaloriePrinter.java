import products.Product;

import java.util.List;

public class CaloriePrinter implements Printer{

    @Override
    public void printSum(List<Product> products) {
        System.out.printf(Formats.SUM_FORMAT, new CalorieCalculator().sum(products));
    }

    @Override
    public void printAverage(List<Product> products) {
        System.out.printf(Formats.AVERAGE_FORMAT, new CalorieCalculator().sum(products));
    }
}
