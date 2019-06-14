package io.zipcoder.casino.roulette;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;


public class RoulettePlayer implements GamblingPlayer {

    private Player player;


public RoulettePlayer(Player player) {
    this.player=player;
}

public String getPlayerName() {
    return player.getName();
}

public Integer getWalletBalance() {
    return player.getMoney();
}

public Integer bet() {
    return null;
}







}

