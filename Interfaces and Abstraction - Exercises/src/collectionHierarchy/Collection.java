package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected int maxSize;
    protected List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }
}
