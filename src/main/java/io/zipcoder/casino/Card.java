package io.zipcoder.casino;

import java.util.Comparator;

public class Card implements Comparable<Card> {

    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }


    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }


    public int compareTo(Card card) {
        return 0;
    }
}
