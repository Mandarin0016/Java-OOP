import products.Product;

import java.util.List;

public interface Printer {
    void printSum(List<Product> products);
    void printAverage(List<Product> products);
}
