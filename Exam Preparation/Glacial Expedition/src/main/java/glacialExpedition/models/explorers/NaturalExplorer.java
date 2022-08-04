package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    public static final double INITIAL_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        double newEnergy = this.getEnergy() - 7;
        if (newEnergy < 0){
            newEnergy = 0;
        }
        setEnergy(newEnergy);
    }
}
