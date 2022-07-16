package wildFarm;

public class Tiger extends Felime {


    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_FOOD, this.getClass().getSimpleName()));
        }
        setFoodEaten(food.getQuantity());
    }
}
