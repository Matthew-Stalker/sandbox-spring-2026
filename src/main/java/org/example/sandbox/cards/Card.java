package org.example.sandbox.cards;

import java.util.Objects;

public class Card implements Comparable<Card>{

    private final Suit suit;
    private final FaceValue faceValue;

    public Card(Suit suit, FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getfaceValue() {
        return faceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && faceValue == card.faceValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, faceValue);
    }

    @Override
    public String toString() {
        return faceValue + " of " + suit;
    }

    @Override
    public int compareTo(Card that) {
        if (this.suit.ordinal() < that.suit.ordinal()) {
            return 1;
        } else if (this.suit.ordinal() > that.suit.ordinal()) {
            return -1;
        } else {
            return Integer.compare(this.faceValue.ordinal(), that.faceValue.ordinal());
        }
    }
}
