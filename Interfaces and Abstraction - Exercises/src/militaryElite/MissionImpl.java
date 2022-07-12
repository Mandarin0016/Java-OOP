package militaryElite;

public class MissionImpl implements Mission {
    private final String codeName;
    private States state;

    public MissionImpl(String codeName, String state) throws Exception {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(String state) throws Exception {
        try {
            this.state = States.valueOf(state);
        }catch (Exception e){
            throw new Exception(ExceptionMessages.INVALID_MISSION_STATE);
        }
    }
    @Override
    public void completeMission() {
        state = States.finished;
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public States getState() {
        return state;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Code Name: %s State: %s", codeName, state));
        return result.toString();
    }
}
