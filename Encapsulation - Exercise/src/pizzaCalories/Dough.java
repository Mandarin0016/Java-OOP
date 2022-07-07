package pizzaCalories;

import java.util.Arrays;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (Arrays.stream(FlourTypeModifier.values()).map(FlourTypeModifier::toString).anyMatch(type -> type.equals(flourType.toLowerCase()))) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (Arrays.stream(BackingTechniqueModifier.values()).map(BackingTechniqueModifier::toString).anyMatch(technique -> technique.equals(bakingTechnique.toLowerCase()))) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        return (2 * this.weight) * FlourTypeModifier.valueOf(this.flourType.toLowerCase()).getModifier() * BackingTechniqueModifier.valueOf(this.bakingTechnique.toLowerCase()).getModifier();
    }
}
