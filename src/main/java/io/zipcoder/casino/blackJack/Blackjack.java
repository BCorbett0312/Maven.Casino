package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;

import java.util.ArrayList;


public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer gambler;
    private BlackjackPlayer dealer;
    private BlackjackMediator mediator;
    private Deck deck;
    private Integer playerHand;
    private Integer playerSplitHand;
    private Integer dealerHand;
    private Integer theBet;



    public Blackjack(Player player){
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
    }

    public void startBlackjack(){
        mediator.welcomeToBJ();
        Boolean desireToPlay = true;
        while (desireToPlay){
            playRound();
        }
    }


    public void checkHand(Hand handToCheck){

    }

    public void playRound(){
        getNewDeck();
        gambler.discardHand();
        dealer.discardHand();
        gambler.bet();
        dealInitialHands();
        showInitialDeal();
        playerTurn();
        dealerTurn();
        keepPlaying();
    }



    public void getNewDeck(){
        this.deck = new Deck();
        deck.shuffleDeck();
    }

    public Boolean keepPlaying(){
        return null;
    }


    public void dealerTurn(){

    }

    public void playerTurn(){


    }

    public void dealInitialHands(){

    }

    public void showInitialDeal(){

    }
    public String hitOrStay(){
        return null;
    }

    public void doubleDown(){
        //doubles bet and a single hit
    }

    public void split(){
        //create a second hand for player using 1 of each card of starting hand and dealing a single card to each hand
    }


    public Integer payOut(Integer amount) {
        return null;
    }
}
