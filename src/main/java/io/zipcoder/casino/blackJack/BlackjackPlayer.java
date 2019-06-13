package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackPlayer implements GamblingPlayer {

    private Player player;
    private Player dealer;
    private Hand playerHand;
    private Hand dealerHand;

    public BlackjackPlayer(Player ascendToBlackJackPlayer){

    }

    public ArrayList<Hand> getDealt(){
        return null;
    }

    public void hit(ArrayList<Hand> hands){
        //adds card from deck to hand
    }

    public void stay(ArrayList<Hand> hands){
        //passes priority to dealer to play
    }

    public void doubleDown(ArrayList<Hand> hands){
        //doubles bet and a single hit
    }

    public void split(ArrayList<Hand> hands){
        //create a second hand for player using 1 of each card of starting hand and dealing a single card to each hand
    }

    public Integer bet(){ return null; }



}
