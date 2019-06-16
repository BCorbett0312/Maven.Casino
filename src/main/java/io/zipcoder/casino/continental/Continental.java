package io.zipcoder.casino.continental;

import io.zipcoder.casino.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Continental extends CardGame{

    private Deck deck;
    private Stack<Card> pile;
    private ContinentalPlayer player;
    private ContinentalMediator mediator;
    private Hand dealerHand;
    private List<ValueSet> valueSets;
    private List<StraightSet> straightSets;
    private PlayerOrder<ContinentalPlayer> playerOrder;
    private Integer round;

    public Continental() {
        DeckBuilder builder = new DeckBuilder();
        deck = builder.addSetWithJokers(2).shuffle().build();
        pile = new Stack<>();
        player = new ContinentalPlayer();
        valueSets = new LinkedList<>();
        straightSets = new LinkedList<>();
        playerOrder = new PlayerOrder<>();
        round = 6;
    }

    public Continental(Player player) {

    }


    private void startGame() {}

    public void deal() {}
    /**
     * @return gets card from top of Deck.
     */
    public Card drawFromDeck() {
        return null;
    }

    /**
     *
     * @return gets card from the top of the Pile
     */
    public Card drawFromPile() { return null; }

    public void addToPile(Card card) { }

    /**
     * This method compares all cards see if they have the same value.
     * @param card1 This is a card from a Hand
     * @param card2 This is a card from a Hand
     * @param card3 This is a card from a Hand
     * @return True or False depending if the values match or not
     */
    public Boolean isThreeOfAKind(Card card1, Card card2, Card card3){
        return null;
    }

    public Boolean isStraight(Card card1, Card card2, Card card3, Card card4) {
        return null;
    }

    public void peformSteal() {}


    public String displaySets() {
        return null;
    }

    public void makeValueSet(Card card1, Card card2, Card card3) {}

    public void makeStraightSet(Card card1, Card card2, Card card3, Card card4) {}

    public Boolean addToSet(ContinentalSet set) {
        return null;
    }

    public void nextTurn() {}


}
