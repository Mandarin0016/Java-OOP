package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {

    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
           this.repository.removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            return "No such units in repository.";
        }
    }
}
