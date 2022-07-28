package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int DUMMY_INITIAL_HEALTH = 10;
    private static final int DUMMY_ZERO_HEALTH = 0;
    private static final int DUMMY_EXP_DROP = 15;
    private static final int ATTACK_POINTS = 5;
    private static Dummy dummy;
    private static Dummy deathDummy;


    @Before
    public void setup() {
        dummy = new Dummy(DUMMY_INITIAL_HEALTH, DUMMY_EXP_DROP);
        deathDummy = new Dummy(DUMMY_ZERO_HEALTH, DUMMY_EXP_DROP);
    }

    @Test
    public void testDummyLosesHealthOnAttack() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_INITIAL_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeathDummyThrowsExceptionOnAttack(){
        deathDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeathDummyGivesEXP(){
        int droppedEXP = deathDummy.giveExperience();
        Assert.assertEquals(15, droppedEXP);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveEXP(){
        dummy.giveExperience();
    }

}