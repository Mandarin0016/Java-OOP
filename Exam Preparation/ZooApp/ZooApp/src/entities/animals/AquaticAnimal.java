package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{

    private static final double ANIMAL_INITIAL_KG = 2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, ANIMAL_INITIAL_KG, price);
    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + 7.50);
    }
}
