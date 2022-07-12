package collectionHierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        if (!items.isEmpty()) {
            return items.remove(0);
        }
        return null;
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }

}
