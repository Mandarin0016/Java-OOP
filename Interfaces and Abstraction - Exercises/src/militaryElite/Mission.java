package militaryElite;

public interface Mission {
    String getCodeName();
    States getState();
    void completeMission();
}
