package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackPlayer extends Player implements GamblingPlayer {

    private Player player;
    private Player dealer;
    private Hand playerHand;
    private Hand dealerHand;


    public BlackjackPlayer(Player player){

    }

    public ArrayList<Card> getHand(){
        return null;
    }

    public void discardHand(){

    }

    public void hit(Card cardToAdd){
        //adds card from deck to hand
    }

    public void newSplitHand(){

    }


    public Integer getHandValue(){
        return null;
    }

    public Integer bet(){ return null; }





}
