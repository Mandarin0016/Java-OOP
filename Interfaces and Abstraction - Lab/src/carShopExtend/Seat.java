package carShopExtend;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("This is %s produced in %s and have %d tires", super.getModel(), super.countryProduced(), TIRES));
        result.append(System.lineSeparator()).append(String.format("%s sells for %f", super.getModel(), this.price));
        return result.toString();
    }
}
