package collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        int index = super.items.size() - 1;
        if (index >= 0) {
            return items.remove(index);
        }
        return null;
    }
}
