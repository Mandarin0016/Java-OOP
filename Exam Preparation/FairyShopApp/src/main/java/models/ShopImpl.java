package fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {
        for (Instrument instrument : helper.getInstruments()) {
            while (!instrument.isBroken()) {
                if (!helper.canWork()) {
                    break;
                }
                helper.work();
                instrument.use();
                present.getCrafted();
                if (present.isDone()) {
                    break;
                }
            }
            if (!helper.canWork() || present.isDone()) {
                break;
            }
        }

    }
}
