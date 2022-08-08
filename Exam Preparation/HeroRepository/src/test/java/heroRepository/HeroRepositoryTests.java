package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeroRepositoryTests {
    private static final Hero HERO = new Hero("Mandarin", 113);
    private HeroRepository heroRepository;

    @Before
    public void setup(){
        heroRepository = new HeroRepository();
    }

    @Test
    public void testGetCount(){
        Assert.assertEquals(0, heroRepository.getCount());
        heroRepository.create(HERO);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsExceptionAlreadyExistHere(){
        heroRepository.create(HERO);
        heroRepository.create(HERO);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsNullHeroException(){
        heroRepository.create(null);
    }

    @Test
    public void testSuccessfullyRemoveHero(){
        heroRepository.create(HERO);
        Assert.assertEquals(1, heroRepository.getCount());
        heroRepository.remove(HERO.getName());
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemovesHeroException(){
        heroRepository.remove(null);
    }

    @Test
    public void testGetHeroWithHighestLevel(){
        heroRepository.create(new Hero("Assasin", 17));
        heroRepository.create(new Hero("TalantBG", 23));
        heroRepository.create(new Hero("Kartofa", 65));
        heroRepository.create(new Hero("Redeemed", 113));
        Hero hero = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(113, hero.getLevel());
        Assert.assertEquals("Redeemed", hero.getName());
    }

    @Test
    public void testGetHero(){
        heroRepository.create(HERO);
        Hero hero = heroRepository.getHero(HERO.getName());
        Assert.assertEquals(hero, HERO);
    }

    @Test
    public void testGetHeroes(){
        heroRepository.create(HERO);
        Collection<Hero> heroes = heroRepository.getHeroes();
        Assert.assertEquals(1, heroes.size());
    }
}
