package cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRank[] decks = CardRank.values();
        String input = scanner.nextLine();
        System.out.println("Card Ranks:");
        for (CardRank deck : decks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", deck.ordinal(), deck.name());
        }
    }
}
