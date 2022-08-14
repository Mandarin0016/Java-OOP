package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private static final Footballer FOOTBALLER = new Footballer("Mandarin");

    private FootballTeam footballTeam;

    @Before
    public void setup(){
        this.footballTeam = new FootballTeam("Goddard", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionNullTeamName(){
        new FootballTeam(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionInvalidPositions(){
        new FootballTeam("Aden", -23);
    }

    @Test
    public void testGetPositions(){
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Goddard", footballTeam.getName());
    }

    @Test
    public void testGetCount(){
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test
    public void testAddPlayer(){
        footballTeam.addFootballer(FOOTBALLER);
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerThroesException(){
        footballTeam.addFootballer(FOOTBALLER);
        footballTeam.addFootballer(new Footballer("Floyd"));
        footballTeam.addFootballer(new Footballer("Eowyna"));
    }

    @Test
    public void testRemovePlayer(){
        footballTeam.addFootballer(FOOTBALLER);
        Assert.assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer(FOOTBALLER.getName());
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerThrowsExceptionNonExistingPlayer(){
        footballTeam.removeFootballer("Eowyna");
    }

    @Test
    public void testFootballerForSale(){
        footballTeam.addFootballer(FOOTBALLER);
        footballTeam.footballerForSale(FOOTBALLER.getName());
        Assert.assertFalse(FOOTBALLER.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNonExistingPlayer(){
        footballTeam.footballerForSale("Eowyna");
    }

    @Test
    public void testGetStatistics(){
        footballTeam.addFootballer(FOOTBALLER);
        Assert.assertEquals(String.format("The footballer Mandarin is in the team %s.", footballTeam.getName()), footballTeam.getStatistics());
    }

}
