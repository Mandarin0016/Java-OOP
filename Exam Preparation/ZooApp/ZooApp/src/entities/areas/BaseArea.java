package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        foods = new ArrayList<>();
        animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        return this.getFoods().stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.getAnimals().size() >= this.getCapacity()) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.getAnimals().add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.getAnimals().remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.getFoods().add(food);
    }

    @Override
    public void feed() {
        this.getAnimals().forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        if (this.getAnimals().isEmpty()) {
            result.append("Animals: none").append(System.lineSeparator());
        } else {
            result.append("Animals: ").append(this.getAnimals().stream().map(Animal::getName).collect(Collectors.joining(" ")).trim()).append(System.lineSeparator());
        }
        result.append(String.format("Foods: %d", this.getFoods().size())).append(System.lineSeparator());
        result.append(String.format("Calories: %d", this.sumCalories())).append(System.lineSeparator());
        return result.toString().trim();
    }
}
