package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class CrapsMediator {

    private CrapsPlayer player;
    private Console consul;

    public CrapsMediator(Player player, Console consul){
        this.player = new CrapsPlayer(player);
        this.consul = consul;

    }

    public Player play(){

        CrapsGame game = new CrapsGame(player);
        CrapsRunner runner = new CrapsRunner(game, consul);
        runner.runGame();
        return player.getPlayer();
    }
}
