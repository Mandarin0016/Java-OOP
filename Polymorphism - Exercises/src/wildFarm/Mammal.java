package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        final StringBuilder sb = new StringBuilder();
        sb.append(animalType).append("[");
        sb.append(animalName).append(", ");
        sb.append(format.format(animalWeight)).append(", ");
        sb.append(livingRegion).append(", ");
        sb.append(foodEaten).append("] ");
        return sb.toString();
    }
}
