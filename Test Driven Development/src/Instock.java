

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> stockProducts;

    public Instock() {
        stockProducts = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.getStockProducts().size();
    }

    @Override
    public boolean contains(Product product) {
        if (product == null) {
            throw new UnsupportedOperationException();
        }
        for (Product stockProduct : this.getStockProducts()) {
            if (stockProduct.getLabel().equals(product.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        if (product == null) {
            throw new UnsupportedOperationException();
        }

        if (contains(product)) {
            throw new UnsupportedOperationException();
        }
        stockProducts.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (product == null || this.getStockProducts().stream().noneMatch(prd -> prd.getLabel().equals(product))) {
            throw new IllegalArgumentException();
        }
        this.findByLabel(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= this.getStockProducts().size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.getStockProducts().get(index);
    }

    @Override
    public Product findByLabel(String label) {
        if (label == null || this.getStockProducts().stream().noneMatch(prd -> prd.getLabel().equals(label))) {
            throw new IllegalArgumentException();
        }
        return getStockProducts().stream().filter(prd -> prd.getLabel().equals(label)).findFirst().get();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (this.getStockProducts().isEmpty() || count < 1 || count > this.getStockProducts().size()) {
            return new ArrayList<>();
        }
        return this.getStockProducts().stream().limit(count).sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.getStockProducts().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).filter(product -> product.getPrice() > lo && product.getPrice() <= hi).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.getStockProducts().stream().filter(product -> product.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.getStockProducts().size()){
            throw new IllegalArgumentException();
        }
        return this.getStockProducts().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.getStockProducts().stream().filter(product -> product.getQuantity() == quantity).collect(Collectors.toList());
    }

    public List<Product> getStockProducts() {
        return stockProducts;
    }

}
