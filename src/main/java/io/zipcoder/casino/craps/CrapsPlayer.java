package io.zipcoder.casino.craps;

import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;

public class CrapsPlayer implements GamblingPlayer {
    private Player player;

    public CrapsPlayer(Player player) {

    }
    

    @Override
    public Integer bet() {
        return null;
    }

    public Boolean placeBet(Integer bet){
        return null;
    }

    public void collectWinnings(Integer winnings){

    }

    // needed for testing
    public Integer getMoney(){
        return null;
    }
}


