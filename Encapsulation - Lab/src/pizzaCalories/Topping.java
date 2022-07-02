package pizzaCalories;

public class Topping {
    private String type;
    private double weight;

    public Topping(String type, double weight) {
        this.setToppingType(type);
        this.setWeight(weight);
    }

    private void setToppingType(String type) {
        Validator.validateToppingType(type);
        this.type = type;
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(this.type, weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;
        switch (this.type) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            case "Sauce":
                calories *= 0.9;
                break;
        }

        return calories;
    }


}
