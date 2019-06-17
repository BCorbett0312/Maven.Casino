package io.zipcoder.casino.continental;

import io.zipcoder.casino.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Continental extends CardGame{

    private LinkedList<ContinentalPlayer> order;


    private ContinentalPlayer player;
    private Hand computer;

    private Deck deck;
    private Stack<Card> pile;

    private LinkedList<ContinentalSet> sets;

    private Integer round;
    private Boolean gameOver;

    public Continental () {

        player = new ContinentalPlayer();
        computer = new Hand();

        DeckBuilder builder = new DeckBuilder();
        deck = builder.addSetWithJokers().shuffle().build();
        pile = new Stack<>();

        sets = new LinkedList<>();

        round = 6;
        gameOver = false;
    }

    public Continental (Player player) {
        this.player = new ContinentalPlayer(player);
        computer = new Hand();

        DeckBuilder builder = new DeckBuilder();
        deck = builder.addSetWithJokers().shuffle().build();
        pile = new Stack<>();

        sets = new LinkedList<>();

        round = 6;
        gameOver = false;
    }




    public void startGame() {

        deal();
        while(!gameOver) {
            playerTurn();
            if(gameOver) break;
            computerTurn();
        }

    }

    public void playerTurn() {
        if(ContinentalMediator.deckOrPileDraw()){
            drawFromDeck();
        }
        else {
            drawFromPile();
        }
        isWinningHand();
        discard(ContinentalMediator.selectCard(player.getHand()));


    }

    public void computerTurn() {

    }

    /**
     * Deals six cards to the player and the computer
     */
    public void deal() {

        for (int i = 0; i < 6; i++) {
            player.addToHand(drawFromDeck());
            computer.add(drawFromDeck());
        }

    }

    /**
     * Takes a card from the top of the Deck
     * @return
     */
    public Card drawFromDeck() {
        return deck.draw();
    }

    /**
     * Takes a card from the top of the Pile
     * @return
     */
    public Card drawFromPile() {
        return pile.pop();
    }

    /**
     * Gets the string representation of the top card on the pile
     * @return
     */
    public String showTopCardOnPile() {
        return pile.peek().toString();
    }


    /**
     * sends a selected card to the Pile
     * @param card the selected card
     */
    public void discard(Card card) {
        pile.push(card);
    }

    protected Boolean isThreeOfAKind(Card card1, Card card2, Card card3) {

        if(card1.getValue() == CardValue.JOKER) {
            if(card2.compareValueTo(card3) == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        Boolean isSame = true;

        if((card2.getValue() != CardValue.JOKER) && (card1.compareValueTo(card2) != 0)) isSame = false;
        if((card3.getValue() != CardValue.JOKER) && (card1.compareValueTo(card3) != 0)) isSame = false;

        return isSame;
    }

    protected Boolean isWinningHand() {
        return null;
    }

    public ContinentalPlayer getPlayer() {
        return player;
    }

    public Hand getComputer() {
        return computer;
    }

}
