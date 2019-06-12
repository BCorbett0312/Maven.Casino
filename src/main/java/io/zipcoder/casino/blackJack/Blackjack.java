package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;

import java.util.ArrayList;


public class Blackjack implements CardGame, GamblingGame {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck theDeck;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;



    public Blackjack(Player player){

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



}
