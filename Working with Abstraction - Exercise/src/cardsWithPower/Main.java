package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();
        Card myCard = new Card(CardSuit.valueOf(cardSuit), CardRank.valueOf(cardRank));
        System.out.printf("Card name: %s of %s; Card power: %d%n", myCard.getCardRank(), myCard.getCardSuit(), myCard.getPower());
    }
}
