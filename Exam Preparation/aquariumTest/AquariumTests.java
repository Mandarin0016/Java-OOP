package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private static final Fish FISH = new Fish("Queenie");
    private Aquarium aquarium;

    @Before
    public void setup() {
        aquarium = new Aquarium("Goddard", 2);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Goddard", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameException() {
        new Aquarium(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetWhitespaceNameException() {
        new Aquarium("       ", 2);
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity() {
        new Aquarium("Aden", -1);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, aquarium.getCount());
        aquarium.add(FISH);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsException() {
        new Aquarium("Gludio", 0).add(FISH);
    }

    @Test
    public void testRemoveSuccessfully() {
        aquarium.add(FISH);
        Assert.assertEquals(1, aquarium.getCount());
        aquarium.remove("Queenie");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsException() {
        aquarium.remove("Goldie");
    }

    @Test
    public void testSellFishSuccessfully() {
        Assert.assertTrue(FISH.isAvailable());
        aquarium.add(FISH);
        aquarium.sellFish(FISH.getName());
        Assert.assertFalse(FISH.isAvailable());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowsException() {
        aquarium.sellFish("Goldie");
    }

    @Test
    public void testReport() {
        aquarium.add(FISH);
        String result = aquarium.report();
        Assert.assertEquals("Fish available at Goddard: Queenie", result);
    }
}

