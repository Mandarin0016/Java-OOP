package glacialExpedition.models.states;

import glacialExpedition.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class StateImpl implements State{

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
