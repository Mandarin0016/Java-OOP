package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

public class GiftFactoryTests {

    private static final Gift GIFT = new Gift("Christmas Gift", 3.14);
    private GiftFactory giftFactory;

    @Before
    public void setup(){
        giftFactory = new GiftFactory();
    }

    @Test
    public void testCreateGiftSuccessfully(){
        String result = giftFactory.createGift(GIFT);
        Assert.assertEquals(1, giftFactory.getCount());
        Assert.assertEquals(String.format("Successfully added gift %s with magic %.2f.", GIFT.getType(), GIFT.getMagic()), result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftThrowsException(){
        giftFactory.createGift(GIFT);
        giftFactory.createGift(GIFT);
    }

    @Test
    public void testGetMinMagicGift(){
        giftFactory.createGift(GIFT);
        Gift gift = giftFactory.getPresentWithLeastMagic();
        Assert.assertEquals(GIFT, gift);
    }

    @Test
    public void testGetPresentByName(){
        giftFactory.createGift(GIFT);
        Gift resultGift = giftFactory.getPresent(GIFT.getType());
        Assert.assertEquals(GIFT, resultGift);
    }

    @Test
    public void testRemoveGiftSuccessfully(){
        giftFactory.createGift(GIFT);
        Assert.assertEquals(1, giftFactory.getCount());
        Assert.assertTrue(giftFactory.removeGift(GIFT.getType()));
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftNullArgument(){
        giftFactory.removeGift(null);
    }

    @Test
    public void testGetGifts(){
        Collection<Gift> gifts = giftFactory.getPresents();
        Assert.assertTrue(gifts.isEmpty());
    }

}
