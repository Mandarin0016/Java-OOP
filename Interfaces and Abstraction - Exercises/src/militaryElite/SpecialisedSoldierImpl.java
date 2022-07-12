package militaryElite;

import java.util.ArrayList;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    protected Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    public void setCorps(String corps) throws Exception {
        try {
            this.corps = Corps.valueOf(corps);
        }catch (Exception e){
            throw new Exception(ExceptionMessages.INVALID_CORPS);
        }
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }
}
