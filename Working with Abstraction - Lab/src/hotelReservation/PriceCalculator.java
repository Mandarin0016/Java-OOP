package hotelReservation;

public class PriceCalculator {
    public static double calculateHolidayPrice(double pricePerDay, int numberOfDays, Season season, double discount) {
        return ((pricePerDay * season.getPricePerDayIndex()) * numberOfDays) - (((pricePerDay * season.getPricePerDayIndex()) * numberOfDays) * discount);
    }
}
