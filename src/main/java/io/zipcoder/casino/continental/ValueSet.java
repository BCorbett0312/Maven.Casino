package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardValue;

import java.util.Set;
import java.util.TreeSet;

public class ValueSet implements ContinentalSet{

    private Set<Card> set;

    public ValueSet() {

        set = new TreeSet<>();

    }

    public CardValue nextLowerValue() { return null; }

    public CardValue nextUpperValue() { return null; }

    public CardValue jokerValue() { return null; }

    public Boolean canAddToSet(Card card) { return null; }

    public void addCard(Card card) {}

    public void replaceJoker(Card card) {}
}
