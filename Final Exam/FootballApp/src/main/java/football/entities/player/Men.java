package football.entities.player;

public class Men extends BasePlayer{

    private static final double INITIAL_KILOGRAMS = 85.50;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        this.setKg(INITIAL_KILOGRAMS);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + 145);
    }
}
