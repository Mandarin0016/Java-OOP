package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private Repository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    private Aquarium findAquariumByName(String aquariumName) {
        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)){
                return aquarium;
            }
        }
        return null;
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }
        Aquarium aquarium = findAquariumByName(aquariumName);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = findAquariumByName(aquariumName);
        Fish fish;
        switch (fishType){
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }
        boolean firstPossibility = aquarium.getClass().getSimpleName().startsWith("Fresh") && fish.getClass().getSimpleName().startsWith("Fresh");
        boolean secondPossibility = aquarium.getClass().getSimpleName().startsWith("Salt") && fish.getClass().getSimpleName().startsWith("Salt");
        String result;
        if (firstPossibility || secondPossibility){
            try {
                aquarium.addFish(fish);
                result = String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
            }catch (Exception e){
                result = e.getMessage();
            }
        }else {
            result = ConstantMessages.WATER_NOT_SUITABLE;
        }
        return result;
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = findAquariumByName(aquariumName);
        aquarium.feed();
        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = findAquariumByName(aquariumName);
        double price = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum() + aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, price);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
