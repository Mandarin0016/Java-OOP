package fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper{

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void work() {
        this.setEnergy(this.getEnergy() - 10);
        if (this.getEnergy() < 0){
            this.setEnergy(0);
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.getInstruments().add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.getEnergy() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
