package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public int sumEnergy() {

        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() >= this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    //"{fieldName} ({fieldType}):
    //Player: {playerName1} {playerName2} {playerName3} (…) / Player: none
    //Supplement: {supplementsCount}
    //Energy: {sumEnergy}"
    @Override
    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(" (").append(this.getClass().getSimpleName()).append("):").append(System.lineSeparator());
        String textToBeAppended = "none";
        if (this.players.size() > 0){
            textToBeAppended = String.join(" ", this.players.stream().map(Player::getName).collect(Collectors.toList()));
        }
        result.append("Player: ").append(textToBeAppended).append(System.lineSeparator());
        result.append("Supplement: ").append(this.supplements.size()).append(System.lineSeparator());
        result.append("Energy: ").append(this.sumEnergy()).append(System.lineSeparator());
        return result.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
