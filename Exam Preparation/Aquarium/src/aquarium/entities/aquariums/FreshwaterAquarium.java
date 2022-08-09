package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium{

    private static final int INITIAL_CAPACITY = 50;

    public FreshwaterAquarium(String name) {
        super(name, INITIAL_CAPACITY);
    }
}
