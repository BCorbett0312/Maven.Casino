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
            desireToPlay = keepPlaying(askKeepPlaying());
        }

    }

    //This checks if the specified player has blackjack when dealt
    protected Boolean checkBlackJack(BlackjackPlayer playerToCheck) {
        Boolean result = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) == 21) {
            result = true;}
        return result;}



    private void initializeGame() {
        getNewDeck();
        gambler.discardHand();
        dealer.discardHand();
        initialBet = gambler.bet();
        dealInitialHands();
        console.println(showInitialDeal());
        determineIfWinnerAfterDeal();}



    private void playRound() {
        playerTurn();
        if(!bust){
            console.println(dealer.getHand().toString());
            dealerTurn();
            checkWinner();
            payOut();}
        if(bust){
            endGameState = 0;
            String busted = "You bust.  Too Bad.";
            console.println(busted);}
    }


    protected Deck getNewDeck() {
        this.deck = new DeckBuilder().addSet().build();
        return deck;
    }

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
                playerCanDoublePlay(firstGameActionNoSplit());
                console.println(displayTable());
                checkBust(gambler);
            } else {
                hitOrStay(nextGameAction());
                console.println(displayTable());
            }
            checkBust(gambler);
        }
    }

    protected boolean checkBust(BlackjackPlayer playerToCheck){
        bust = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) > 21){
            bust = true;}
        return bust;}



    protected void hitOrStay(Integer gameAction){
        switch(gameAction){
            case 1:
                gambler.hitForPlayer(deck.draw());
                break;
            case 2:
                stay = true;
                break;
        }
    }
    protected Boolean getStay(){
        return stay;
    }

    protected void setStay(Boolean setTo){
        stay = setTo;
    }

    protected void playerCanDoublePlay(Integer gameAction){
        switch(gameAction){
            case 1:
                gambler.hitForPlayer(deck.draw());
                break;
            case 2:
                stay = true;
                break;
            case 3:
                gambler.hitForPlayer(deck.draw());
                gambler.bet(initialBet);
                initialBet += initialBet;
                stay = true;
                break;
        }
    }


    protected Boolean playerCanDouble(){
        Boolean result = false;
        if(initialBet <= gambler.getWalletBalance() && gambler.getHand().size() == 2) {
            result = true;}
        return result;}


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
            playRound();}
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

    protected Boolean getBust(){return bust;}

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

    protected void payOut() {
        gambler.addToWallet(endGameState);
    }


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

    public Integer askKeepPlaying() {
        String toPrint = "You have " + gambler.getWalletBalance() + "\nWould you like to keep playing?" + "\n1) Yes" + "\n2) No";
        return console.getIntegerInput(toPrint);
    }


    public Boolean keepPlaying(Integer gameAction){
        switch(gameAction){
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
        return tableState;}
}
