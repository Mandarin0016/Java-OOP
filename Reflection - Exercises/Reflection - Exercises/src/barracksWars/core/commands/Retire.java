package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            super.getRepository().removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            return "No such units in repository.";
        }
    }
}
