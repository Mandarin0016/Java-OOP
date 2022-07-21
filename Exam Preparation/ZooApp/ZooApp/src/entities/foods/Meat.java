package zoo.entities.foods;

public class Meat extends BaseFood{

    private static final int FOOD_CALORIES = 70;
    private static final double FOOD_PRICE = 10;

    public Meat() {
        super(FOOD_CALORIES, FOOD_PRICE);
    }

}
