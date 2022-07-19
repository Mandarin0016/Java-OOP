package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumSoftness() {
        return getToys().stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.getCats().size() >= this.getCapacity()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.getCats().add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.getCats().remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.getToys().add(toy);
    }

    @Override
    public void feeding() {
        this.getCats().forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        result.append("Cats: ");
        if (this.getCats().isEmpty()){
            result.append("none").append(System.lineSeparator());
        }else {
            result.append(this.getCats().stream().map(Cat::getName).collect(Collectors.joining(" ")).trim()).append(System.lineSeparator());
        }
        result.append(String.format("Toys: %d Softness: %d", this.getToys().size(), this.sumSoftness()));
        return result.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
