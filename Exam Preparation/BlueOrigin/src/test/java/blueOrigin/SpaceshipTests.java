package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private static final Astronaut ASTRONAUT = new Astronaut("Mandarin", 5000.0);
    private Spaceship spaceship;

    @Before
    public void setup() {
        spaceship = new Spaceship("Freya", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative() {
        new Spaceship("Goddard", -2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidNameNull() {
        new Spaceship(null, 4);
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidNameWhitespaces() {
        new Spaceship("          ", 4);
    }

    @Test
    public void testAddAstronautSuccessfully() {
        Assert.assertEquals("Freya", spaceship.getName());
        Assert.assertEquals(0, spaceship.getCount());
        spaceship.add(ASTRONAUT);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautThrowsExceptionAstronautExists() {
        spaceship.add(ASTRONAUT);
        spaceship.add(ASTRONAUT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautThrowsExceptionSpaceshipFull() {
        spaceship.add(ASTRONAUT);
        spaceship.add(new Astronaut("Floyd", 982));
        spaceship.add(new Astronaut("Kartofa", 2324));
    }

    @Test
    public void testRemoveAstronautSuccessfully(){
        Assert.assertEquals(0, spaceship.getCount());
        spaceship.add(ASTRONAUT);
        Assert.assertEquals(1, spaceship.getCount());
        boolean result = spaceship.remove(ASTRONAUT.getName());
        Assert.assertEquals(0, spaceship.getCount());
        Assert.assertTrue(result);
    }



}
