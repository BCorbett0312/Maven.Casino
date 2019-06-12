package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardValue;

import java.util.Set;

public class ValueSet {

    private Set<Card> set;

    public ValueSet() {

    }

    public CardValue nextLowerValue() { return null; }

    public CardValue nextUpperValue() { return null; }

    public CardValue jokerValue() { return null; }

    public Boolean canAddToSet(Card card) { return null; }

    public void addCard(Card card) {}

    public void replaceJoker(Card card) {}
}
