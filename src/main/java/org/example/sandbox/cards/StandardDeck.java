package org.example.sandbox.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {

    List<Card> cards;

    public StandardDeck() {
        this.cards = newDeck();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StandardDeck{");
        sb.append(cards);
        sb.append('}');
        return sb.toString();
    }

    private List<Card> newDeck() {

        List<Card> cards = new ArrayList<>();

        Arrays.stream(Suit.values()).forEach(suit -> {
            Arrays.stream(FaceValue.values())
                    .map(faceValue -> new Card(suit, faceValue))
                    .forEach(cards::add);
        });
        return cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void cut(int index) {


        List<Card> top = cards.subList(cards.subList(0, index));
        List<Card> bottom = cards.subList(cards.subList(index, cards.size()));
        bottom.addAll(top);
        this.cards = bottom;

        "Hello".substring(0, index + 1);

    }

    @Override
    public Card deal() {
        return this.cards.removeFirst();
    }

    @Override
    public Card turnOver() {
        return this.cards.getFirst();
    }

    @Override
    public int search(Card card) {
        return this.cards.indexOf(card);
    }

    @Override
    public void newOrder() {
        Collections.sort(this.cards);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

}
