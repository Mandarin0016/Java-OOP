import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class InstockTest {

    private static final String PRODUCT_NAME = "Mandarins";
    private static final int PRODUCT_QUANTITY = 15;
    private static final Product NULL_PRODUCT = null;
    private static final Product INITIAL_PRODUCT = new Product("Greek Lemons", 5.30, 11);
    private static final Product VALID_PRODUCT_ONE = new Product("Pasta Package", 1.10, 12);
    private static final Product VALID_PRODUCT_TWO = new Product("Apples", 6.30, 12);
    private static final Product VALID_PRODUCT_THREE = new Product("Oranges", 12, 6);
    private static final int INVALID_INDEX = 5;
    private static final int VALID_INDEX = 0;
    private static final int COUNT = 2;
    private static final int COUNT_ZERO = 0;
    private static final double LOWEST_PRICE = 5.00;
    private static final double HIGHEST_PRICE = 6.30;
    private static final int IN_RANGE_COUNT = 2;
    private static final int QUANTITY = 12;
    private ProductStock emptyInstock;
    private ProductStock instock;

    @Before
    public void setup() {
        emptyInstock = new Instock();
        instock = new Instock();
        instock.add(INITIAL_PRODUCT);
    }

    @Test
    public void testContainsAndAdd() {
        Assert.assertFalse(emptyInstock.contains(VALID_PRODUCT_ONE));
        emptyInstock.add(VALID_PRODUCT_ONE);
        Assert.assertTrue(emptyInstock.contains(VALID_PRODUCT_ONE));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testContainsNullProduct() {
        emptyInstock.contains(NULL_PRODUCT);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddInvalidProduct() {
        emptyInstock.add(NULL_PRODUCT);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddExistingProduct() {
        emptyInstock.add(VALID_PRODUCT_ONE);
        emptyInstock.add(VALID_PRODUCT_ONE);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, emptyInstock.getCount());
        emptyInstock.add(VALID_PRODUCT_ONE);
        Assert.assertEquals(1, emptyInstock.getCount());
    }

    @Test
    public void testChangeQuantitySuccessfully() {
        instock.changeQuantity(INITIAL_PRODUCT.getLabel(), 5);
        Assert.assertEquals(5, INITIAL_PRODUCT.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityNonExistingProduct() {
        instock.changeQuantity(PRODUCT_NAME, PRODUCT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityNullProduct() {
        instock.changeQuantity(null, PRODUCT_QUANTITY);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindInvalidIndexProduct() {
        instock.find(INVALID_INDEX);
    }

    @Test
    public void testFindValidIndexProduct() {
        Assert.assertEquals(INITIAL_PRODUCT, instock.find(VALID_INDEX));
    }

    @Test
    public void testFindByValidLabel() {
        Product foundProduct = instock.findByLabel(INITIAL_PRODUCT.getLabel());
        Assert.assertEquals(foundProduct, INITIAL_PRODUCT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNullLabel() {
        instock.findByLabel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByInvalidLabel() {
        instock.findByLabel(PRODUCT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNullAndNotExistingLabel() {
        instock.findByLabel(PRODUCT_NAME);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderEmptyCollection() {
        Iterable<Product> result = emptyInstock.findFirstByAlphabeticalOrder(COUNT);
        Assert.assertEquals(0, getCount(result));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderInvalidCount() {
        Iterable<Product> result = instock.findFirstByAlphabeticalOrder(COUNT);
        Assert.assertEquals(0, getCount(result));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderValidCount() {
        instock.add(VALID_PRODUCT_TWO);
        instock.add(VALID_PRODUCT_THREE);
        Iterable<Product> result = instock.findFirstByAlphabeticalOrder(COUNT);
        Assert.assertEquals(COUNT, getCount(result));
    }

    @Test
    public void testFindAllInRangeReturnEmptyCollection() {
        emptyInstock.add(VALID_PRODUCT_THREE);
        Iterable<Product> productsInRange = emptyInstock.findAllInRange(LOWEST_PRICE, HIGHEST_PRICE);
        Assert.assertEquals(COUNT_ZERO, getCount(productsInRange));
    }

    @Test
    public void testFindAllInRangeReturnValidCollection() {
        instock.add(VALID_PRODUCT_TWO);
        instock.add(VALID_PRODUCT_ONE);
        instock.add(VALID_PRODUCT_THREE);
        Iterable<Product> productsInRange = instock.findAllInRange(LOWEST_PRICE, HIGHEST_PRICE);
        Assert.assertEquals(IN_RANGE_COUNT, getCount(productsInRange));
    }

    @Test
    public void testFindAllByPriceEmptyCollection() {
        Iterable<Product> products = instock.findAllByPrice(VALID_PRODUCT_TWO.getPrice());
        Assert.assertEquals(COUNT_ZERO, getCount(products));
    }

    @Test
    public void testFindAllByPriceValidCollection() {
        instock.add(VALID_PRODUCT_TWO);
        instock.add(VALID_PRODUCT_THREE);
        Iterable<Product> products = instock.findAllByPrice(VALID_PRODUCT_TWO.getPrice());
        Assert.assertEquals(1, getCount(products));
    }

    @Test
    public void testFindFirstMostExpensiveProductsValidCollection() {
        instock.add(VALID_PRODUCT_ONE);
        instock.add(VALID_PRODUCT_TWO);
        instock.add(VALID_PRODUCT_THREE);
        Iterable<Product> products = instock.findFirstMostExpensiveProducts(COUNT);
        Assert.assertEquals(COUNT, getCount(products));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowsException() {
        instock.findFirstMostExpensiveProducts(COUNT);
    }

    @Test
    public void testFindAllByQuantityEmptyCollection() {
        Iterable<Product> products = instock.findAllByQuantity(QUANTITY);
        Assert.assertEquals(COUNT_ZERO, getCount(products));
    }


    @Test
    public void testFindAllByQuantityValidCollection() {
        instock.add(VALID_PRODUCT_ONE);
        instock.add(VALID_PRODUCT_TWO);
        Iterable<Product> products = instock.findAllByQuantity(QUANTITY);
        Assert.assertEquals(COUNT, getCount(products));
    }

    private int getCount(Iterable<Product> products) {
        int count = 0;
        for (Product product : products) {
            count++;
        }
        return count;
    }

}