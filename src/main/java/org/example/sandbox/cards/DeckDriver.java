package org.example.sandbox.cards;

public class DeckDriver {

    public static void main(String[] args) {

        Deck cards = new StandardDeck();
        displayDeck(cards);

        cards.shuffle();
        displayDeck(cards);

        cards.shuffle();
        displayDeck(cards);

        Card card = cards.deal();
        System.out.print("\nTop card dealt: ");
        System.out.println(card);
        displayDeck(cards);

        System.out.println("Top card displayed: ");
        System.out.println(cards.turnOver());

        cards.cut(cards.size() / 2);
        System.out.print("\nCut deck: ");
        displayDeck(cards);

    }

    private static void displayDeck(Deck cards) {
        System.out.println(cards);
    }
}
