package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int INITIAL_CAT_KG = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_CAT_KG);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }
}
