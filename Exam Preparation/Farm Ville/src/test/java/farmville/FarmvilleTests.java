package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    public static final Animal ANIMAL = new Animal("Monkey", 2000);
    public static final Animal ANIMAL_TWO = new Animal("Cat", 20);
    public static final Animal ANIMAL_THREE = new Animal("Dog", 10);

    private Farm farm;

    @Before
    public void setup(){
        farm = new Farm("Farmvile", 2);
    }

    @Test
    public void testGetCountGetAnimals(){
        Assert.assertEquals(0, farm.getCount());
        farm.add(ANIMAL);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Farmvile", farm.getName());
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(2, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalExistAnimal(){
        farm.add(ANIMAL);
        farm.add(ANIMAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalMoreThanCapacity(){
        farm.add(ANIMAL);
        farm.add(ANIMAL_TWO);
        farm.add(ANIMAL_THREE);
    }

    @Test
    public void testRemoveAnimalFalse(){
        Assert.assertEquals(0, farm.getCount());
        farm.add(ANIMAL);
        Assert.assertEquals(1, farm.getCount());
        Assert.assertFalse(farm.remove(ANIMAL_TWO.getType()));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveAnimalTrue(){
        Assert.assertEquals(0, farm.getCount());
        farm.add(ANIMAL);
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove(ANIMAL.getType()));
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCapacity(){
        new Farm("Townvile", -12);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidNameNull(){
        new Farm(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidNameWhitespaces(){
        new Farm("    ", 12);
    }

    @Test
    public void testAnimalEnergy(){
        Assert.assertEquals(2000.0, ANIMAL.getEnergy(), 0.0);
    }


}
