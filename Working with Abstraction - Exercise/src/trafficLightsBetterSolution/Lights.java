package trafficLightsBetterSolution;

public enum Lights {
    RED, GREEN, YELLOW;

    static {
        RED.nextLight = GREEN;
        GREEN.nextLight = YELLOW;
        YELLOW.nextLight = RED;
    }

    private Lights nextLight;

    public Lights getNextLight() {
        return nextLight;
    }
}
