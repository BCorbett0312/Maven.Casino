package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardValue;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class ValueSet implements ContinentalSet {

    private LinkedList<Card> set;
    private CardValue nextLower;
    private CardValue nextUpper;

    public ValueSet() {

        set = new LinkedList<>();

    }

    public ValueSet(Card card) {

        set = new LinkedList<>();
        set.add(card);
    }

    public CardValue nextLowerValue() { return null; }

    public CardValue nextUpperValue() { return null; }

    public CardValue jokerValue() { return null; }

    public Boolean canAddToSet(Card card) { return null; }

    public void addCard() {}

    public void addCardToFront(Card card) {}

    public void addCardToBack(Card card) {}

    public void replaceJoker(Card card) {}

    protected Boolean contains(CardValue value) { return null; }

    private void setNextLowerValue() {}

    private void setNextUpperValue() {}

    @Override
    public String toString() { return null; }
}
