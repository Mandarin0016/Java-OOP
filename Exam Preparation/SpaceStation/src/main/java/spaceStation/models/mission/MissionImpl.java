package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    public MissionImpl() {
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            if (!astronaut.canBreath()) {
                continue;
            }
            List<String> itemsFromThisPlanet = new ArrayList<>(planet.getItems());
            for (String item : itemsFromThisPlanet) {
                astronaut.getBag().getItems().add(item);
                astronaut.breath();
                planet.getItems().remove(item);
                if (!astronaut.canBreath()) {
                    break;
                }
            }
        }

    }
}
