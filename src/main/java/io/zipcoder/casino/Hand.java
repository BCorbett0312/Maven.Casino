package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    private ArrayList<Card> cards;

    /**
     * Creates a new Hand with no cards in it.
     */
    public Hand(){

        cards = new ArrayList<>();

    }

    /**
     * Creates a new Hand with cards
     * @param cards an Array of cards
     */
    public Hand(Card... cards){

        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    /**
     *
     * @return An array of Cards in the Hand
     */
    public Card[] getCards() {
        Card[] handAsArray = new Card[cards.size()];
        handAsArray = cards.toArray(handAsArray);


        return handAsArray;
        //get hand and send to console for display
    }

    /**
     * Gets the index of a card in the Hand
     * @param card The card being checked for
     * @return the index of the card being checked for
     */
    public Integer indexOf(Card card) { return cards.indexOf(card); }


    /**
     * Remove the card from the hand and is returned to be used by the game
     * @param card the Card being remove.
     * @return the removed card.
     */

    public Boolean removeByCard(Card card) {

        return cards.remove(card); }

    /**
     * Remove the card from the hand at the index selected.
     * Is returned to be used by the game if need.
     * @param index the index of the card being removed.
     * @return the removed card.
     */
    public Card removeByIndex(int index){


        return cards.remove(index);
    }

    /**
     * Returns the Card at the index without removing it
     * @param index the position of the Card in the Hand
     * @return The Card at the indexed position.
     */
    public Card getCardAtIndex(int index) { return cards.get(index); }

    /**
     * Returns the CardValue at the index
     * @param index the position of the Card in the hand.
     * @return The CardValue of the Card at the index
     */
    public CardValue getValueAtIndex(int index) {

        return cards.get(index).getValue(); }

    /**
     * Returns the CardSuit at the index
     * @param index the position of the Card in the index
     * @return The CardSuit of the Card at the index
     */
    public CardSuit getSuitAtIndex(int index) { return cards.get(index).getSuit(); }

    /**
     * Checks to see if a hand contains a specific card
     * @param card the card being checked for
     * @return True or false.
     */
    public Boolean contains(Card card) { return cards.contains(card); }

    /**
     * Add a card to the Arraylist in the Hand
     * @param card the Card to be added
     */
    public void add(Card card) {
        cards.add(card);
    }
    /**
     * @return a formatted representaion of the hand with the Cards and the position they are in
     *
     */
    public Boolean isEmpty(){
        return cards.isEmpty();}

    public void clear(){
        cards.clear();
    }

    public int size() {
        return cards.size();
    }



    @Override
    public String toString() {
        String result = "";

        for(int i = 0; i < cards.size(); i++){
            result += cards.get(i).toString() + "\n";
        }

        return result; }

}
