package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;



public class ContinentalPlayer {

    private Player player;
    private Hand hand;
    private Boolean placed;

    public ContinentalPlayer() {
        hand = new Hand();
        placed = false;
        player = new Player();
    }

    public ContinentalPlayer(Player player) {
        hand = new Hand();
        this.player = player;
    }


    public Boolean playableSets() {
        return null;
    }

    public Hand getHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }


}
