package zoo.entities.foods;

public class Vegetable extends BaseFood{

    private static final int FOOD_CALORIES = 50;
    private static final double FOOD_PRICE = 5;


    public Vegetable() {
        super(FOOD_CALORIES, FOOD_PRICE);
    }
}
