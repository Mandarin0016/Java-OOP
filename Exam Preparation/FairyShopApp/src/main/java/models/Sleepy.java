package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        this.setEnergy(this.getEnergy() - 15);
        if (this.getEnergy() < 0){
            this.setEnergy(0);
        }
    }
}
