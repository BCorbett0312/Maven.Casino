package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSuit;
import io.zipcoder.casino.CardValue;

import java.util.Set;

public class StraightSet implements ContinentalSet{

    private Set<Card> set;
    private CardSuit suit;

    public StraightSet() {


    }

    public Card nextLowerValue() { return null; }

    public Card nextUpperValue() { return null; }

    public Card jokerValue() { return null; }

    public Boolean canAddToSet(Card card) { return null; }

    public void addCard(Card card) {}

    public void replaceJoker(Card card) {}
}
