package militaryElite;

import java.util.ArrayList;

public interface Commando {
    void addMission(Mission mission);

    ArrayList<Mission> getMissions();
}
