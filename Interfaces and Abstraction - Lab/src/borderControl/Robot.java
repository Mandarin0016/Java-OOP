package borderControl;

public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot(String model, String id) {
        setId(id);
        setModel(model);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}
