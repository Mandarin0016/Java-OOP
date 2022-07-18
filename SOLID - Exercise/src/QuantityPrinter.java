import products.Product;

import java.util.List;

public class QuantityPrinter implements Printer{
    @Override
    public void printSum(List<Product> products) {
        System.out.printf(Formats.SUM_FORMAT, new QuantityCalculator().sum(products));
    }

    @Override
    public void printAverage(List<Product> products) {
        System.out.printf(Formats.AVERAGE_FORMAT, new QuantityCalculator().sum(products));
    }
}
