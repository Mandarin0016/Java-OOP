package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest{

    private static final String[] DATA = {"Peter", "Lucy", "Edmund"};
    private static final String[] SINGLE_DATA = {"Peter"};
    private static final String[] NULL_DATA = null;
    private static final String[] EMPTY_DATA = {};

    private ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorInvalidElements() throws OperationNotSupportedException {
        new ListIterator(NULL_DATA);
    }

    @Test
    public void testHasNextAndMove() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(new ListIterator(SINGLE_DATA).move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyData() throws OperationNotSupportedException {
        new ListIterator(EMPTY_DATA).print();
    }

    @Test
    public void testPrintElementCorrectly(){
        Assert.assertEquals(DATA[0], listIterator.print());
    }
}