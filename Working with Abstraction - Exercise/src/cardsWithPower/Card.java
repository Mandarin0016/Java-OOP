package cardsWithPower;

public class Card {

    //suit
    private CardSuit cardSuit;
    //rank
    private CardRank cardRank;
    //power = rank + suit
    private final int power;

    public Card(CardSuit suit, CardRank rank){
        this.cardRank = rank;
        this.cardSuit = suit;
        this.power = this.cardRank.getValue() + this.cardSuit.getValue();
    }

    public int getPower() {
        return power;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }
}
