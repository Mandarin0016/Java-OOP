package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 100;
    private static final int AXE_DURABILITY = 10;
    private static final int AXE_BROKEN_DURABILITY = 0;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXP = 15;
    private static Axe axe;
    private static Axe brokenAxe;
    private static Dummy dummy;

    @Before
    public void setup() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        brokenAxe = new Axe(AXE_ATTACK, AXE_BROKEN_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXP);
    }

    @Test
    public void testAxeLoseDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenWeapon() {
        brokenAxe.attack(dummy);
    }

}