package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public class BlackjackPlayer implements GamblingPlayer {

    private Player player;
    private Player dealer;
    private Hand playerHand;
    private Hand dealerHand;
    private Hand playerHandSplit;


    public BlackjackPlayer(Player player){
        this.player = player;
        this.playerHand = new Hand();
    }

    public BlackjackPlayer(){
        this.player = new Player();
        this.dealerHand = new Hand();



    }



    public String getPlayerName(){
        return player.getName();
    }

    public Integer getWalletBalance(){
        return player.getMoney();
    }


    public Hand getHand(){
        return this.playerHand;
    }

    public Hand getSplitHand(){
        return this.playerHandSplit;
    }

    public Hand getDealerHand(){
        return this.dealerHand;
    }

    public void discardHand(){
        playerHand.clear();
        dealerHand.clear();
        playerHandSplit.clear();


    }

    public void hitForPlayer(Card cardToAdd){
        this.playerHand.add(cardToAdd);

        //adds card from deck to hand
    }

    public void hitForSplitHand(Card cardToAdd){
        this.playerHandSplit.add(cardToAdd);

    }

    public void hitForDealer(Card cardToAdd){
        this.dealerHand.add(cardToAdd);
    }

    public void newSplitHand(){
        this.playerHandSplit = new Hand();
        this.playerHandSplit.add(playerHand.removeByIndex(1));


    }


    public Integer getHandValue(){
        return null;
    }

    public Integer bet(){ return null; }





}
