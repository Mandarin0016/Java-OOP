package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private static final Cat CAT = new Cat("Pooh");
    private House house;

    @Before
    public void setup(){
        house = new House("Sofia", 10);
    }

    @Test
    public void testIsNotHungry(){
        house.addCat(CAT);
        house.catForSale(CAT.getName());
        Assert.assertFalse(CAT.isHungry());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Sofia", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsException(){
        new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptyThrowException(){
        new House("    ", 17);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsException(){
        new House("Plld", -1);
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(10, house.getCapacity());
    }

    @Test
    public void testGetCount(){
        Assert.assertEquals(0, house.getCount());
    }

    @Test
    public void testAddCatSuccessfully(){
        house.addCat(CAT);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowsSuccessfully(){
        House house1 = new House("sdsdsd", 2);
        house1.addCat(new Cat("kjlasdjklasd"));
        house1.addCat(new Cat("Sdsd"));
        house1.addCat(new Cat("kjsd"));
        house1.addCat(new Cat("ksbc"));
    }

    @Test
    public void testRemoveCatSuccessfully(){
        house.addCat(CAT);
        Assert.assertEquals(1, house.getCount());
        house.removeCat(CAT.getName());
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowsException(){
        house.addCat(CAT);
        house.removeCat("Mimi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowsException(){
        house.addCat(CAT);
        house.catForSale("Pesho");
    }

    @Test
    public void testCatForSaleSuccessfully(){
        house.addCat(CAT);
        Cat catResult = house.catForSale(CAT.getName());
        Assert.assertEquals(CAT, catResult);
    }

    @Test
    public void testStatistics(){
        house.addCat(CAT);
        String result =  house.statistics();
        Assert.assertEquals(String.format("The cat %s is in the house %s!", CAT.getName(), house.getName()), result);
    }

    @Test
    public void testStatisticsMoreThanOneCat(){
        house.addCat(CAT);
        house.addCat(new Cat("Pep"));
        String result =  house.statistics();
        Assert.assertEquals(String.format("The cat Pooh, Pep is in the house %s!", house.getName()), result);
    }






}
