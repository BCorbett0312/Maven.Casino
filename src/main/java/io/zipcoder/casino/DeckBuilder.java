package io.zipcoder.casino;

import java.util.ArrayList;

/**
 * DeckBuilder helps with the construction of Deck for various deck games.
 * Each method returns this object so the methods can be chained together
 * IMPORTANT: Remember to shuffle the deck once it is constructed and before you build it otherwise it will be made in set order.
 */
public class DeckBuilder {

    private Deck deck;


    /**
     * Creates an empty deck in which to put cards
     */
    public DeckBuilder() {

        deck = new Deck();

    }

    /**
     * Builds deck from aready created deck
     * @param deck the deck to be built on
     */
    public DeckBuilder(Deck deck){

        this.deck = deck;

    }

    /**
     * Builds the current version of the deck in the builder
     * @return the deck
     */
    public Deck build() { return deck; }


    /**
     * Shuffles the deck
     * @return this
     */
    public DeckBuilder shuffle() {

        deck.shuffleDeck();
        return this;

    }

    /**
     * Removes all cards from the deck
     * @return this
     */
    public DeckBuilder clear() {

        deck.clear();
        return this;

    }

    /**
     * Returns a Boolean depending on if there are any cards in the deck
     * @return True or False
     */
    public Boolean isEmpty() {
        return deck.isEmpty();
    }

    /**
     * Add a set of cards not including jokers
     * @return this
     */
    public DeckBuilder addSet() {

        addHearts();
        addDiamonds();
        addClubs();
        addSpades();

        return this;

    }


    /**
     * Adds multiple sets of cards to the deck
     * @param numOfSets the number of sets you want to add
     * @return this
     */
    public DeckBuilder addSet(int numOfSets) {

        for(int i = 0; i < numOfSets; i++) addSet();

        return this;

    }


    /**
     * Adds a set of cards with jokers to the deck
     * @return this
     */
    public DeckBuilder addSetWithJokers() {

        addSet();
        addJokers();

        return this;

    }


    /**
     * Adds multiple sets of cards with jokers to the deck
     * @param numOfSets
     * @return this
     */
    public DeckBuilder addSetWithJokers(int numOfSets) {

        for(int i = 0; i < numOfSets; i++) addSetWithJokers();

        return this;

    }

    public DeckBuilder addJokers() {

        Card[] cards = {
                new Card(CardSuit.NONE, CardValue.JOKER),
                new Card(CardSuit.NONE, CardValue.JOKER)
        };

        deck.add(cards);

        return this; }

    public DeckBuilder addHearts() {

        Card[] cards = {
                new Card(CardSuit.HEART, CardValue.ACE),
                new Card(CardSuit.HEART, CardValue.TWO),
                new Card(CardSuit.HEART, CardValue.THREE),
                new Card(CardSuit.HEART, CardValue.FOUR),
                new Card(CardSuit.HEART, CardValue.FIVE),
                new Card(CardSuit.HEART, CardValue.SIX),
                new Card(CardSuit.HEART, CardValue.SEVEN),
                new Card(CardSuit.HEART, CardValue.EIGHT),
                new Card(CardSuit.HEART, CardValue.NINE),
                new Card(CardSuit.HEART, CardValue.TEN),
                new Card(CardSuit.HEART, CardValue.JACK),
                new Card(CardSuit.HEART, CardValue.QUEEN),
                new Card(CardSuit.HEART, CardValue.KING)
        };

        deck.add(cards);

        return this; }

    public DeckBuilder addDiamonds() {

        Card[] cards = {
                new Card(CardSuit.DIAMOND, CardValue.ACE),
                new Card(CardSuit.DIAMOND, CardValue.TWO),
                new Card(CardSuit.DIAMOND, CardValue.THREE),
                new Card(CardSuit.DIAMOND, CardValue.FOUR),
                new Card(CardSuit.DIAMOND, CardValue.FIVE),
                new Card(CardSuit.DIAMOND, CardValue.SIX),
                new Card(CardSuit.DIAMOND, CardValue.SEVEN),
                new Card(CardSuit.DIAMOND, CardValue.EIGHT),
                new Card(CardSuit.DIAMOND, CardValue.NINE),
                new Card(CardSuit.DIAMOND, CardValue.TEN),
                new Card(CardSuit.DIAMOND, CardValue.JACK),
                new Card(CardSuit.DIAMOND, CardValue.QUEEN),
                new Card(CardSuit.DIAMOND, CardValue.KING)
        };

        deck.add(cards);

        return this;
    }

    public DeckBuilder addClubs() {

        Card[] cards = {
                new Card(CardSuit.CLUB, CardValue.ACE),
                new Card(CardSuit.CLUB, CardValue.TWO),
                new Card(CardSuit.CLUB, CardValue.THREE),
                new Card(CardSuit.CLUB, CardValue.FOUR),
                new Card(CardSuit.CLUB, CardValue.FIVE),
                new Card(CardSuit.CLUB, CardValue.SIX),
                new Card(CardSuit.CLUB, CardValue.SEVEN),
                new Card(CardSuit.CLUB, CardValue.EIGHT),
                new Card(CardSuit.CLUB, CardValue.TEN),
                new Card(CardSuit.CLUB, CardValue.NINE),
                new Card(CardSuit.CLUB, CardValue.JACK),
                new Card(CardSuit.CLUB, CardValue.QUEEN),
                new Card(CardSuit.CLUB, CardValue.KING)
        };

        deck.add(cards);

        return this;

    }

    public DeckBuilder addSpades() {

        Card[] cards = {
                new Card(CardSuit.SPADE, CardValue.ACE),
                new Card(CardSuit.SPADE, CardValue.TWO),
                new Card(CardSuit.SPADE, CardValue.THREE),
                new Card(CardSuit.SPADE, CardValue.FOUR),
                new Card(CardSuit.SPADE, CardValue.FIVE),
                new Card(CardSuit.SPADE, CardValue.SIX),
                new Card(CardSuit.SPADE, CardValue.SEVEN),
                new Card(CardSuit.SPADE, CardValue.EIGHT),
                new Card(CardSuit.SPADE, CardValue.NINE),
                new Card(CardSuit.SPADE, CardValue.TEN),
                new Card(CardSuit.SPADE, CardValue.JACK),
                new Card(CardSuit.SPADE, CardValue.QUEEN),
                new Card(CardSuit.SPADE, CardValue.KING)
        };

        deck.add(cards);

        return this;
    }



}
