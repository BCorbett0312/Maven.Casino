package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {


    private Stack<Card> stack;

    public Deck(){

        stack = new Stack<>();

    }

    public Deck(Card... cards) {

        stack = new Stack<>();
        for(Card card : cards) {
            stack.add(card);
        }
    }


    /**
     * Gets the top card of the deck and removes it from the deck
     */
    public Card draw(){

        return null;
    }

    /**
     * Adds a card to the top of the Deck
     * @param card the Card to put on top of the deck
     */
    public void add(Card card){

    }

    /**
     * Adds an array of cards to the top of the deck
     * @param cards an array of Cards
     */
    public void add(Card[] cards) {}

    /**
     * Randomly shuffles the deck
     */
    public void shuffleDeck(){
        //shuffle and return deck

    }

    /**
     * Removes all cards within the deck
     */
    public void clear() {

    }

    /**
     * Check to see if there are any cards in the deck
     * @return
     */
    public Boolean isEmpty(){
        return null;
    }


    public Card[] toArray() { return null; }


}
