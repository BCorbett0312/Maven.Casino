package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class GoFishPlayer {
    private final Player player;
    private final Hand handPlayer;
    private Console console = new Console(System.in, System.out);

    public GoFishPlayer(Player player) {
        this.player = player;
        this.handPlayer = new Hand ();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public Hand getHand() {
        return this.handPlayer;
    }
}
