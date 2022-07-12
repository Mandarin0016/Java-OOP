package militaryElite;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{
    private ArrayList<Private> privates;
    private List<String> privatesIds;

    protected LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
        this.privates.sort((priv1, priv2) -> Integer.compare(priv2.getId(), priv1.getId()));
    }

    @Override
    public ArrayList<Private> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Name: %s %s Id: %d Salary: %.2f", firstName, lastName, id, salary));
        result.append(System.lineSeparator());
        result.append("Privates: ");
        getPrivates().forEach(priv -> result.append(System.lineSeparator()).append("  ").append(priv));
        return result.toString();
    }
}
