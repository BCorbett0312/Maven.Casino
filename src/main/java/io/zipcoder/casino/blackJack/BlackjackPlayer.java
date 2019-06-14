package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;



public class BlackjackPlayer implements GamblingPlayer {

    private Player player;
    private Hand playerHand;
    private Hand playerHandSplit;


    public BlackjackPlayer(Player player){
        this.player = player;
        this.playerHand = new Hand();
        this.playerHandSplit = new Hand();
    }
    public BlackjackPlayer(){
        this.player = new Player();
        this.playerHand = new Hand();
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

    public void discardHand() {
        playerHand.clear();
        if (playerHandSplit != null) {
            playerHandSplit.clear();
        }
    }

    public void hitForPlayer(Card cardToAdd){
        this.playerHand.add(cardToAdd);


    }
    public void hitForSplitHand(Card cardToAdd){
        this.playerHandSplit.add(cardToAdd);

    }
    public void newSplitHand(){
        this.playerHandSplit.add(playerHand.removeByIndex(1));
    }


    public Integer getHandValue(){
        return null;
    }


    @Override
    public Integer bet() {
        return null;
    }
}
