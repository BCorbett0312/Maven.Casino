package io.zipcoder.casino.craps;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

public class CrapsPlayer implements GamblingPlayer {
    private Player player;

    public CrapsPlayer(Player player) {
        this.player = player;
    }
    

    @Override
    public Integer bet() {
        return null;
    }

    public Boolean placeBet(Integer bet){
        if(bet > player.getMoney()){
            return false;
        }
        else
        {
            player.setMoney(player.getMoney() - bet);
            return true;
        }
    }

    public void collectWinnings(Integer winnings){
        player.setMoney(player.getMoney() + winnings);
    }

    // needed for testing
    public Integer getMoney(){
        return player.getMoney();
    }
}


