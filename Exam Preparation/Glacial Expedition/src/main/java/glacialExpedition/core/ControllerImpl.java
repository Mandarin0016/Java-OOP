package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<State> stateRepository;
    private Repository<Explorer> explorerRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.stateRepository = new StateRepository();
        this.explorerRepository = new ExplorerRepository();
        exploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);
        if (explorer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        Mission mission = new MissionImpl();
        State state = this.stateRepository.byName(stateName);
        Collection<Explorer> explorers = new ArrayList<>();
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            if (explorer.getEnergy() > 50){
                explorers.add(explorer);
            }
        }
        if (explorers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        mission.explore(state, explorers);
        exploredStates++;
        int retired = 0;
        for (Explorer explorer : explorers) {
            if (explorer.getEnergy() == 0){
                this.retireExplorer(explorer.getName());
                retired++;
            }
        }
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStates)).append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            String exhibits = String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits());
            if (exhibits.isEmpty()){
                exhibits = "None";
            }
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibits)).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
