package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public boolean hasPlayer(String name) {
        boolean result = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void removePlayer(String name) {
        if (hasPlayer(name)) {
            this.players.removeIf(player -> player.getName().equals(name));
        } else {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName() + " team.");
        }

    }

    public double getRating() {
        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .sum() / this.players.size();
    }
}
