package footballTeamGenerator;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        if (!players.removeIf(player -> player.getName().equals(playerName))){
            throw new IllegalArgumentException(String.format(ExceptionMessages.PLAYER_MISSING, playerName, this.name));
        }
    }

    public double getRating() {
        return this.players.stream().map(Player::overallSkillLevel).mapToDouble(Double::doubleValue).average().orElse(0);
    }

}
