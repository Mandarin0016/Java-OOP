package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double INITIAL_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        double newOxygenValue = this.getOxygen() - 5;
        if (newOxygenValue < 0){
            newOxygenValue = 0;
        }
        this.setOxygen(newOxygenValue);
    }
}
