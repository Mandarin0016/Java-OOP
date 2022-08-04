package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            if (!explorer.canSearch()) {
                continue;
            }
            List<String> exhibits = new ArrayList<>(state.getExhibits());
            for (String exhibit : exhibits) {
                if (!explorer.canSearch()){
                    break;
                }
                explorer.search();
                explorer.getSuitcase().getExhibits().add(exhibit);
                state.getExhibits().remove(exhibit);
            }
        }

    }
}
