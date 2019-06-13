package io.zipcoder.casino.craps;

import io.zipcoder.casino.Gamble;
import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.List;

public class CrapsGame extends Game implements Gamble {
    private CrapsPlayer player;
    private Console console;
    private List<CrapsBet> betList;
    private CrapsRoll comeOutRoll;
    private Boolean exit;
    private Boolean leaveBets;
    private Phase phase;


    public CrapsGame(CrapsPlayer player){

    }

    public String nextPhase(){
        return null;
    }

    public InputResult processInput(String input){
        return null;
    }

    public String processBet(String input){
        return null;
    }

    public String rollComeOut(){
        return null;
    }

    public String rollPoint(){
        return null;
    }

    public String currentBets(){
        return null;
    }

    public String printBetPayoutTable(){
        return null;}


    public CrapsBet makeNewBet(){
        return null;
    }

    public Boolean getExit(){
        return null;
    }

    private CrapsRoll rollDice(){
        return null;
    }

    private void settleBets(){

    }

}

enum Phase{
    WALKUP, COMEOUT, POINT;
}
