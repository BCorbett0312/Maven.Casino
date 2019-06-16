package io.zipcoder.casino.blackJack;


import io.zipcoder.casino.*;
import io.zipcoder.casino.utilities.Console;


public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer gambler;
    private BlackjackPlayer dealer;

    private Deck deck;
    Console console = new Console(System.in, System.out);

    private Integer endGameState;
    private Integer initialBet;

    private Boolean stay;
    private Boolean bust;
    private Boolean desireToPlay;




    public Blackjack(Player player) {
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
        deck = new DeckBuilder().addSet().build();
        initialBet = 0;


    }

    protected BlackjackPlayer getDealer() {
        return dealer;
    }

    protected BlackjackPlayer getGambler() {
        return gambler;
    }

    public void startBlackjack() {
        String welcome = "Welcome to BlackJack";
        console.println(welcome);
        desireToPlay = true;
        while (desireToPlay) {
            initializeGame();
            desireToPlay = keepPlaying();
        }

    }

    //This checks if the specified player has blackjack when dealt
    protected Boolean checkBlackJack(BlackjackPlayer playerToCheck) {
        Boolean result = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) == 21) {
            result = true;
        }
        return result;}


    //This prepares the table for play
    private void initializeGame() {
        getNewDeck();
        gambler.discardHand();
        dealer.discardHand();
        initialBet = gambler.bet();
        dealInitialHands();
        console.println(showInitialDeal());
        determineIfWinnerAfterDeal();}



    //This starts a round of blackjack if dealer or player doesnt have blackjack
    protected void playRound() {
        playerTurn();
        if(!bust){
            console.println(dealer.getHand().toString());
            dealerTurn();
            checkBust(dealer);
            checkWinner();
            payOut();
        }
        if(bust){
            endGameState = 0;
            String busted = "You bust.  Too Bad.";
            console.println(busted);
        }

    }

    // This gets a fresh deck every game
    private void getNewDeck() {
        this.deck = new DeckBuilder().addSet().build();
    }

    //This is what happens on the dealers Turn;
    protected void dealerTurn() {
        Boolean dealerPlay = true;

        while (dealerPlay) {
            if (dealer.getHandValue(dealer.getHand()) >= 17 && dealer.getHandValue(dealer.getHand()) <=21){
                String output = "The dealer stays at " + dealer.getHandValue(dealer.getHand());
                console.println(output);
                dealerPlay = false;

            }
            else if (dealer.getHandValue(dealer.getHand()) < 17) {
                dealer.hitForPlayer(deck.draw());
                console.println(dealer.getHand().toString());
                dealerPlay = true;

            }
            else{dealerPlay = false;
            String output = "The dealer busts with " + dealer.getHandValue(dealer.getHand());
            console.println(output);
            }
        }
    }
    //This is the players turn
    protected void playerTurn() {
        stay = false;
        bust = false;

        while (!stay && !bust ) {
            if (playerCanDouble()) {
                playerCanDoublePlay();
                checkBust(gambler);
            } else {
                hitOrStay();
            }
            checkBust(gambler);
        }
    }
    //This checks if a player busts and sets the variable
    protected boolean checkBust(BlackjackPlayer playerToCheck){
        bust = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) > 21){
            bust = true;
        }
        return bust;}

    //This is the game action selections based on possible plays
    protected void hitOrStay(){
        switch(nextGameAction()){
            case 1:
                gambler.hitForPlayer(deck.draw());
                console.println(displayTable());
                break;
            case 2:
                stay = true;
                break;
        }
    }



    protected void playerCanDoublePlay(){
        switch(firstGameActionNoSplit()){
            case 1:
                gambler.hitForPlayer(deck.draw());
                console.println(displayTable());
                break;
            case 2:
                stay = true;
                break;
            case 3:
                gambler.hitForPlayer(deck.draw());
                console.println(displayTable());
                gambler.bet(initialBet);
                initialBet += initialBet;
                stay = true;
                break;
        }
    }


    protected Boolean playerCanDouble(){
        Boolean result = false;
        if(initialBet <= gambler.getWalletBalance() && gambler.getHand().size() == 2) {
            result = true;
            }
        return result;
    }


    protected void setInitialBet(Integer amount){
        initialBet = amount;
    }


    protected void determineIfWinnerAfterDeal(){
        if(checkBlackJack(dealer) && checkBlackJack(gambler)){
            String toPrint = "You both have Blackjack.  You push.";
            console.println(toPrint);
            endGameState = initialBet;
            payOut();
        }

        else if(checkBlackJack(dealer) && !checkBlackJack(gambler)){
            String toPrint = "The dealer has Blackjack, you lose";
            console.println(toPrint);
            endGameState = 0;
        }
        else if(!checkBlackJack(dealer) && checkBlackJack(gambler)){
            String toPrint = "You have Blackjack, the dealer loses";
            console.println(toPrint);
            endGameState = initialBet * 2;
            payOut();
        }
        else {
            playRound();
        }
    }

    protected void dealInitialHands(){
        deck.shuffleDeck();
        gambler.hitForPlayer(deck.draw());
        dealer.hitForPlayer(deck.draw());
        gambler.hitForPlayer(deck.draw());
        dealer.hitForPlayer(deck.draw());
    }

    protected String showInitialDeal(){
        String initialHands = "";
        initialHands += "The dealer is showing "+ dealer.getHand().getCardAtIndex(0).getValue()+
                "\nYou have " +"\n" + gambler.getHand().toString() + "\nThe count is " + gambler.getHandValue(gambler.getHand());
                gambler.getHand().getCardAtIndex(1).getValue();
        return initialHands;
    }

    protected void setBust(Boolean toSet){
        bust = toSet;
    }

    protected void checkWinner() {

        if(dealer.getHandValue(dealer.getHand()) > gambler.getHandValue(gambler.getHand()) && dealer.getHandValue(dealer.getHand()) <= 21) {
            endGameState = 0;
        }

        if(dealer.getHandValue(dealer.getHand()) > gambler.getHandValue(gambler.getHand()) && dealer.getHandValue(dealer.getHand()) > 21){
            endGameState = initialBet*2;
        }

        if(dealer.getHandValue(dealer.getHand())< gambler.getHandValue(gambler.getHand()) && gambler.getHandValue(gambler.getHand()) <= 21) {
            endGameState = initialBet*2;
        }
        if(dealer.getHandValue(dealer.getHand()) == gambler.getHandValue(gambler.getHand())) {
            endGameState = initialBet;
        }

    }


    protected Integer getEndGameState(){
        return endGameState;
    }

    protected void setEndGameState(Integer amount){
        endGameState = amount;
    }

    public void payOut() {
        gambler.addToWallet(endGameState);
    }

    @Override
    public Integer payOut(Integer amount) {
        return null;}


    public Integer firstGameActionNoSplit(){
        String toPrint = "What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double";
        return console.getIntegerInput(toPrint);
    }

    public Integer nextGameAction(){
        String toPrint = "What would you like to do?" + "\n 1) Hit" + "\n 2) Stay";
        return console.getIntegerInput(toPrint);
    }

    public Boolean keepPlaying(){
        String toPrint = "You have " + gambler.getWalletBalance()+ "\nWould you like to keep playing?" + "\n1) Yes" + "\n2) No";
        switch(console.getIntegerInput(toPrint)){
            case 1:
                desireToPlay = true;
                break;
            case 2:
                desireToPlay = false;
                break;
        }

        return desireToPlay;
    }


    protected String displayTable(){

        String tableState = "Your hand is as follows "+ "\n"+gambler.getHand().toString() + " and the current count is " +
                gambler.getHandValue(gambler.getHand())+ "\nThe Dealer is showing " +dealer.getHand().getCardAtIndex(0).getValue();

        return tableState;
    }


}
