package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument{

    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    public void setPower(int power) {
        if (power < 0){
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.power -= 10;
        if (this.getPower() < 0){
            this.setPower(0);
        }
    }

    @Override
    public boolean isBroken() {
        return this.getPower() == 0;
    }
}
