package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        final StringBuilder sb = new StringBuilder();
        sb.append(animalType).append("[");
        sb.append(animalName).append(", ");
        sb.append(breed).append(", ");
        sb.append(format.format(animalWeight)).append(", ");
        sb.append(livingRegion).append(", ");
        sb.append(foodEaten).append("] ");
        return sb.toString();
    }
}
