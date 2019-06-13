package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;

import java.util.ArrayList;


public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private BlackjackMediator mediator;



    public Blackjack(Player player){

    }

    public void startBlackjack(){

    }


    public void checkHand(ArrayList<Hand> handToCheck){
        //check hand is bust or blackjack will be called after every hit
    }


    public void offerInsurance(){
        //gives player chance for insurance if dealer has Ace showing
    }


    public void getNewDeck(){
        //called when deck item has 10 or less cards
    }

    public Boolean keepPlaying(){
        return null;
    }

    public String hitOrStay(){
        return null;
    }

    public void dealerTurn(){

    }

    public void playerTurn(){

    }

    public void doubleDown(){
        //doubles bet and a single hit
    }

    public void split(){
        //create a second hand for player using 1 of each card of starting hand and dealing a single card to each hand
    }

}
