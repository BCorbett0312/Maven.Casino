package io.zipcoder.casino;

import java.util.ArrayList;

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
     * Removes all cards from the deck
     * @return this
     */
    public DeckBuilder clear() { return this; }

    /**
     * Returns a Boolean depending on if there are any cards in the deck
     * @return True or False
     */
    public Boolean isEmpty() { return null; }

    /**
     * Add a set of cards not including jokers
     * @return this
     */
    public DeckBuilder addSet() { return this; }


    /**
     * Adds multiple sets of cards to the deck
     * @param numOfSets the number of sets you want to add
     * @return this
     */
    public DeckBuilder addSet(int numOfSets) { return this; }


    /**
     * Adds a set of cards with jokers to the deck
     * @return this
     */
    public DeckBuilder addSetWithJokers() { return this; }


    /**
     * Adds multiple sets of cards with jokers to the deck
     * @param numOfSets
     * @return this
     */
    public DeckBuilder addSetWithJokers(int numOfSets) { return this; }

    public DeckBuilder addJokers() { return this; }

    public DeckBuilder addHearts() { return this; }

    public DeckBuilder addDiamonds() { return this; }

    public DeckBuilder addClubs() { return this; }

    public DeckBuilder addSpades() { return this; }

    public DeckBuilder addAces() { return this; }

    public DeckBuilder addTwos() { return this; }

    public DeckBuilder addThrees() { return this; }

    public DeckBuilder addFours() { return this; }

    public DeckBuilder addFives() { return this; }

    public DeckBuilder addSixes() { return this; }

    public DeckBuilder addSevens() { return this; }

    public DeckBuilder addEights() { return this; }

    public DeckBuilder addNines() { return this; }

    public DeckBuilder addTens() { return this; }

    public DeckBuilder addJacks() { return this; }

    public DeckBuilder addQueens() { return this; }

    public DeckBuilder addKings() { return this; }


}
