package hotelReservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private final int pricePerDayIndex;

    Season(int pricePerDayIndex) {
        this.pricePerDayIndex = pricePerDayIndex;
    }

    public int getPricePerDayIndex() {
        return pricePerDayIndex;
    }
}
