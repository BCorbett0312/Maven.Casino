package io.zipcoder.casino.blackJack;


import io.zipcoder.casino.*;
import io.zipcoder.casino.utilities.Console;


public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer gambler;
    private BlackjackPlayer dealer;
    private BlackJackMediator mediator;
    private Deck deck;
    private Console console;

    private Integer endGameState;
    private Integer initialBet;

    private Boolean stay;
    private Boolean bust;
    private Boolean desireToPlay;





    public Blackjack(Player player) {
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
        deck = new DeckBuilder().addSet().build();
        console = new Console(System.in, System.out);
        mediator = new BlackJackMediator();
        initialBet = 0;


    }

    public Blackjack(Player player, Console console){
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
        deck = new DeckBuilder().addSet().build();
        this.console = console;
        mediator = new BlackJackMediator();
        initialBet = 0;
    }

    protected BlackjackPlayer getDealer() {
        return dealer;
    }

    protected BlackjackPlayer getGambler() {
        return gambler;
    }

    public void startBlackjack() {
        mediator.welcomeToBlackJack();
        desireToPlay = true;
        while (desireToPlay) {
            initializeGame();
            desireToPlay = keepPlaying(mediator.askKeepPlaying(gambler));
        }

    }

    protected Deck getNewDeck() {
        this.deck = new DeckBuilder().addSet().build();
        return deck;
    }

    protected Boolean getStay(){
        return stay;
    }

    protected void setStay(Boolean setTo){
        stay = setTo;
    }
    protected void setBust(Boolean toSet){
        bust = toSet;
    }

    protected Boolean getBust(){return bust;
    }

    protected Integer getEndGameState(){
        return endGameState;
    }

    protected void setEndGameState(Integer amount){
        endGameState = amount;
    }

    protected void setInitialBet(Integer amount){
        initialBet = amount;
    }



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
        if(bust) {
            endGameState = 0;
            mediator.playerBust();
        }

    }

    //This is the players turn
    protected void playerTurn() {
        stay = false;
        bust = false;

        while (!stay && !bust ) {
            if (playerCanDouble()) {
                playerCanDoublePlay(mediator.firstGameActionNoSplit());
                console.println(displayTable());
                checkBust(gambler);
            } else {
                hitOrStay(mediator.nextGameAction());
                console.println(displayTable());
            }
            checkBust(gambler);
        }
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


    //This checks if the specified player has blackjack when dealt
    protected Boolean checkBlackJack(BlackjackPlayer playerToCheck) {
        Boolean result = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) == 21) {
            result = true;}
        return result;}




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




    protected void determineIfWinnerAfterDeal(){
        if(checkBlackJack(dealer) && checkBlackJack(gambler)){
            mediator.blackJackPush();
            endGameState = initialBet;
            payOut();
        }
        else if(checkBlackJack(dealer) && !checkBlackJack(gambler)){
            mediator.blackJackDealerWin();
            endGameState = 0;
        }
        else if(!checkBlackJack(dealer) && checkBlackJack(gambler)){
            mediator.blackJackGamblerWin();
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



    protected void checkWinner() {

        if(dealer.getHandValue(dealer.getHand()) > gambler.getHandValue(gambler.getHand()) && dealer.getHandValue(dealer.getHand()) <= 21) {
            endGameState = 0;
            mediator.printDealerWins();
        }

        if(dealer.getHandValue(dealer.getHand()) > gambler.getHandValue(gambler.getHand()) && dealer.getHandValue(dealer.getHand()) > 21){
            endGameState = initialBet*2;
            mediator.printGamblerWins(endGameState);
        }

        if(dealer.getHandValue(dealer.getHand())< gambler.getHandValue(gambler.getHand()) && gambler.getHandValue(gambler.getHand()) <= 21) {
            endGameState = initialBet*2;
            mediator.printGamblerWins(endGameState);
        }
        if(dealer.getHandValue(dealer.getHand()) == gambler.getHandValue(gambler.getHand())) {
            endGameState = initialBet;
            mediator.printPush();
        }

    }




    protected void payOut() {
        gambler.addToWallet(endGameState);
    }


    public Integer payOut(Integer amount) {
        return null;}



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
