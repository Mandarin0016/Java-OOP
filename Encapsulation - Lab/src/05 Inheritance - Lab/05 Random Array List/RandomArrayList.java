package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<String> {
    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.remove(index);
    }
}
