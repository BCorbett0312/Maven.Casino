package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.continental.Continental;


public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck theDeck;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;



    public Blackjack(){

    }


    public void checkHand(){
        //check hand is bust or blackjack will be called after every hit
    }


    public void offerInsurance(){
        //gives player chance for insurance if dealer has Ace showing
    }


    public void getNewDeck(){
        //called when deck item has 10 or less cards
    }



}
