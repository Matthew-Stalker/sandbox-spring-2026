package org.example.sandbox.cards;

public interface Deck {

    void shuffle();
    void cut(int index);
    Card deal();
    Card turnOver();
    int search(Card card);
    void newOrder();
    int size();


    default int newSize() {
        throw new UnsupportedOperationException();
    }

}
