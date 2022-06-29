package hotelReservation;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    private final int discountAmount;

    DiscountType(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
