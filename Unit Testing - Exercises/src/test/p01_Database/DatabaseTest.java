package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {2, 23, 54};
    private static final Integer[] EMPTY_NUMBERS = new Integer[0];
    private static final Integer[] HUGE_NUMBERS = new Integer[17];

    private static final Integer VALID_ELEMENT = 15;
    private static final Integer INVALID_ELEMENT = null;
    private static Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatValidObject() {
        Assert.assertArrayEquals(NUMBERS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForEmptyArray() throws OperationNotSupportedException {
        new Database(EMPTY_NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForHugeArray() throws OperationNotSupportedException {
        new Database(HUGE_NUMBERS);
    }


    @Test
    public void testAddValidElement() throws OperationNotSupportedException {
        database.add(VALID_ELEMENT);
        Assert.assertEquals(NUMBERS.length + 1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddInvalidElement() throws OperationNotSupportedException {
        database.add(INVALID_ELEMENT);
    }

    @Test
    public void testRemoveElementFromValidDatabase() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(NUMBERS.length - 1, database.getElements().length);
        Assert.assertEquals(NUMBERS[NUMBERS.length - 2], database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        int iterations = database.getElements().length;
        for (int i = 1; i <= iterations; i++) {
            database.remove();
        }
        database.remove();
    }

}