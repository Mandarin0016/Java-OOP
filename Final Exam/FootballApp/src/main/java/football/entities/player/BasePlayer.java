package football.entities.player;

import football.common.ExceptionMessages;

public abstract class BasePlayer implements Player{

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, int strength) {
        setName(name);
        setNationality(nationality);
        setStrength(strength);
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = nationality;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public void setStrength(int strength) {
        if (strength <= 0){
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getKg() {
        return this.kg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
