package io.zipcoder.casino.continental;

import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;



public class ContinentalPlayer {

    private Player player;
    private Hand hand;
    private Boolean steal;
    private Integer points;

    public ContinentalPlayer() {
        player = new Player();
        hand = new Hand();
    }

    public Player getPlayer() {
        return player;
    }

    public Hand getHand() {
        return hand;
    }

    public Boolean getSteal() {
        return steal;
    }

    public void setSteal(Boolean steal) {
        this.steal = steal;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
