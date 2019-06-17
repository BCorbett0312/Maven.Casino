package io.zipcoder.casino.continental;

import io.zipcoder.casino.*;
import io.zipcoder.casino.utilities.Console;

import java.util.*;


public class Continental extends CardGame{

    private LinkedList<ContinentalPlayer> order;

    private ContinentalMediator mediator;
    private Console console;

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
        console = new Console(System.in, System.out);

        DeckBuilder builder = new DeckBuilder();
        deck = builder.addSetWithJokers().shuffle().build();
        pile = new Stack<>();

        sets = new LinkedList<>();

        round = 6;
        gameOver = false;
    }

    public Continental (Player player, Console console) {
        this.player = new ContinentalPlayer(player);
        computer = new Hand();

        this.console = console;


        DeckBuilder builder = new DeckBuilder();
        deck = builder.addSetWithJokers().shuffle().build();
        pile = new Stack<>();

        sets = new LinkedList<>();

        round = 6;
        gameOver = false;

    }




    public void startGame() {

        deal();
        discard(drawFromDeck());
        while(!gameOver) {
            playerTurn();
            if(gameOver) break;
            computerTurn();
        }

    }

    public void playerTurn() {
        ContinentalMediator.println("YOUR TURN" , console);
        ContinentalMediator.println("Top of Pile: " + showTopCardOnPile(), console);

        ContinentalMediator.println("Your Hand: \n" + player.getHand().toString(), console);

        if(ContinentalMediator.deckOrPileDraw(console)){
            player.addToHand(drawFromDeck());
        }
        else {
            player.addToHand(drawFromPile());
        }
        ContinentalMediator.println("Your Hand: \n" + player.getHand().toString(), console);

        discard(ContinentalMediator.selectCard(player.getHand(), console));
        if(isWinningHand(player.getHand())){
            ContinentalMediator.println("You Win", console);
            gameOver = true;
        }



    }

    public void computerTurn() {

        Random random = new Random();

        ContinentalMediator.println("COMPUTER TURN", console);


        if(random.nextBoolean()){
            computer.add(drawFromDeck());
        }
        else {
            computer.add(drawFromPile());
        }


        discard(computer.removeByIndex(random.nextInt(computer.size())));
        if(isWinningHand(computer)){
            ContinentalMediator.println("You Lost", console);
            gameOver = true;
        }

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

    protected Boolean isWinningHand(Hand hand) {

        HashMap<CardValue, Integer> sets = new HashMap<>();

        for(int i = 0; i < hand.size(); i++) {
            CardValue key = hand.getValueAtIndex(i);
            if(sets.containsKey(key)) {
                sets.replace(key, sets.get(key) + 1);
            }
            else {
                sets.put(key, 1);
            }
        }

        LinkedList<CardValue> keys = new LinkedList<>(sets.keySet());
        Integer numOfSets = 0;
        for(CardValue key : keys) {
            if(sets.get(key).equals(3)) numOfSets++;
        }

        if (numOfSets.equals(2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public ContinentalPlayer getPlayer() {
        return player;
    }

    public Hand getComputer() {
        return computer;
    }

}
