package militaryElite;

import java.util.ArrayList;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private final ArrayList<Repair> repairs;

    protected EngineerImpl(int id, String firstName, String lastName, double salary, String corps) throws Exception {
        super(id, firstName, lastName, salary);
        super.setCorps(corps);
        repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public ArrayList<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Name: %s %s Id: %d Salary: %.2f", firstName, lastName, id, salary));
        result.append(System.lineSeparator());
        result.append(String.format("Corps: %s", corps));
        result.append(System.lineSeparator());
        result.append("Repairs: ");
        this.repairs.forEach(repair -> result.append(System.lineSeparator()).append("  ").append(repair));
        return result.toString();
    }
}
