package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{

    private static final double ANIMAL_INITIAL_KG = 5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, ANIMAL_INITIAL_KG, price);
    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + 5.70);
    }
}
