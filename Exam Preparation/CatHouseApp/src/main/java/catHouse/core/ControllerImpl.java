package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        //If the given type isn't one of these two: "ShortHouse" and "LongHouse"
        if (!type.equals("ShortHouse") && !type.equals("LongHouse")) {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
        }
        this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, house.getClass().getSimpleName());
    }

    @Override
    public String buyToy(String type) {
        //If the given type isn't one of these two: "Ball" and "Mouse"
        if (!type.equals("Ball") && !type.equals("Mouse")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        Toy toy = null;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, toy.getClass().getSimpleName());
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = getHouseByName(houseName);
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        } else {
            house.buyToy(toy);
            toys.removeToy(toy);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
        }
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        //"ShorthairCat", "LonghairCat"
        if (!catType.equals("ShorthairCat") && !catType.equals("LonghairCat")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        Cat cat = null;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
        }
        House house = getHouseByName(houseName);
        if ((cat.getClass().getSimpleName().startsWith("Short")
                && house.getClass().getSimpleName().startsWith("Short")) ||
                (cat.getClass().getSimpleName().startsWith("Long")
                        && house.getClass().getSimpleName().startsWith("Long"))) {
            house.addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, cat.getClass().getSimpleName(), house.getName());
        } else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouseByName(houseName);
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double priceCats = getHouseByName(houseName).getCats().stream().mapToDouble(Cat::getPrice).sum();
        double priceToys = getHouseByName(houseName).getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, priceCats + priceToys);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        houses.forEach(house -> result.append(house.getStatistics()).append(System.lineSeparator()));
        return result.toString().trim();
    }

    private House getHouseByName(String name) {
        for (House house : this.houses) {
            if (house.getName().equals(name)) {
                return house;
            }
        }
        return null;
    }
}
