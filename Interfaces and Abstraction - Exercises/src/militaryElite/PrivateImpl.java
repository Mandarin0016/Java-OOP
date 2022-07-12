package militaryElite;

public class PrivateImpl extends SoldierImpl implements Private{
    protected double salary;

    protected PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Name: %s %s Id: %d Salary: %.2f", firstName, lastName, id, salary));
        return result.toString();
    }
}
