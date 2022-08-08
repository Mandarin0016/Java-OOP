package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanetCount;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
        exploredPlanetCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> validAstronauts = astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if (validAstronauts.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet, validAstronauts);
        int deadAstronauts = 0;
        for (Astronaut validAstronaut : validAstronauts) {
            if (!validAstronaut.canBreath()){
                deadAstronauts++;
            }
        }
        this.exploredPlanetCount++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanetCount)).append(System.lineSeparator());
        result.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut model : astronautRepository.getModels()) {
            result.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, model.getName())).append(System.lineSeparator());
            result.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, model.getOxygen())).append(System.lineSeparator());
            String bagItems = "none";
            if (model.getBag().getItems().size() != 0){
                bagItems = String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, model.getBag().getItems());
            }
            result.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bagItems)).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
