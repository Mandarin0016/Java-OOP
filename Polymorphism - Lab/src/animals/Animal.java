package animals;

public abstract class Animal {
    protected String name;
    protected String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("I am %s and my favourite food is %s", name, favouriteFood)).append(System.lineSeparator());
        return result.toString();
    }
}
