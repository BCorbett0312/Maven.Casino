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
        if (playerHand!= null){
            playerHand.clear();
        }
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


    public Integer getHandValue(Hand handToEvaluate){
        int handValue = 0;
        int aces = 0;

        for(int i = 0; i < handToEvaluate.size(); i++){
            if(handToEvaluate.getCardAtIndex(i).getBlackJackValue(handToEvaluate.getCardAtIndex(i)) > 10){
                handValue += 10;
            }
            else if(handToEvaluate.getCardAtIndex(i).getBlackJackValue(handToEvaluate.getCardAtIndex(i)) == 1){
                aces++;
                handValue += 11;
            }
            else {handValue += handToEvaluate.getCardAtIndex(i).getBlackJackValue(handToEvaluate.getCardAtIndex(i));}

        }

        while(handValue > 21 && aces > 0){
            handValue -= 10;
            aces--;
        }

        return handValue;
    }

    @Override
    public Integer bet() {
        return null;
    }

}
