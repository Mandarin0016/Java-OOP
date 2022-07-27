package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void testAxeLoseDurabilityAfterAttack(){
        Axe axe = new Axe(100, 10);
        axe.attack(new Dummy(100, 50));
        Assert.assertEquals(9 , axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenWeapon(){
        Axe axe = new Axe(10, 0);
        axe.attack(new Dummy(10, 10));
    }

}