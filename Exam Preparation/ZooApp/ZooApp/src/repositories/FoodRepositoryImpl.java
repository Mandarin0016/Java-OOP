package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{

    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        foods = new ArrayList<>();
    }

    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public void add(Food food) {
        this.getFoods().add(food);
    }

    @Override
    public boolean remove(Food food) {
        return this.getFoods().remove(food);
    }

    //TODO: CHECK THIS METHOD IF IT'S WORKING CORRECTLY
    @Override
    public Food findByType(String type) {
        return this.getFoods().stream().filter(food -> food.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
