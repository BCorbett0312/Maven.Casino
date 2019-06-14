package io.zipcoder.casino;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;
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
        return stack.pop();
    }

    /**
     * Adds a card to the top of the Deck
     * @param card the Card to put on top of the deck
     */
    public void add(Card card){
        stack.push(card);
    }

    /**
     * Adds an array of cards to the top of the deck
     * @param cards an array of Cards
     */
    public void add(Card[] cards) {
        for(Card card : cards) stack.push(card);
    }

    /**
     * Randomly shuffles the deck
     */
    public void shuffleDeck(){

        ArrayList<Card> list = new ArrayList<>(stack);
        stack.clear();
        Random random = new Random();

        while(list.size() > 0) {
            int randomNum = random.nextInt(list.size());
            stack.push(list.get(randomNum));
            list.remove(randomNum);
        }

    }

    /**
     * Removes all cards within the deck
     */
    public void clear() {
        stack.clear();
    }

    /**
     * Check to see if there are any cards in the deck
     * @return
     */
    public Boolean isEmpty(){
        return stack.isEmpty();
    }


    public Card[] toArray() {

        ArrayList<Card> cards = new ArrayList<>(stack);
        Card[] array = new Card[cards.size()];
        int i = 0;

        for(Card card : cards) {
            array[i] = card;
            i++;
        }

        return array;

    }


}
