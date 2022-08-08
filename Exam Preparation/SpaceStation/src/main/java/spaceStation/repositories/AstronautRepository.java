package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AstronautRepository implements Repository<Astronaut> {

    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : this.astronauts) {
            if (astronaut.getName().equals(name)){
                return astronaut;
            }
        }
        return null;
    }
}
