import products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum(List<Product> products) {
        return products.stream().map(Product::getKilograms).mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public double average(List<Product> products) {
        return products.stream().map(Product::getKilograms).mapToDouble(Double::doubleValue).average().orElse(0);
    }
}
