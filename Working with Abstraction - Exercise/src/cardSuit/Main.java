package cardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuit[] decks = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit deck : decks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", deck.ordinal(), deck.name());
        }
    }
}
