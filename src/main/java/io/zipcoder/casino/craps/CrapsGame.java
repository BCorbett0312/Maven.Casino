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

    /**
     * Rolls the dice and returns a string that describes the result of the roll
     *
     * If phase is WALKUP, will instead print the payout table and list of instructions
     */
    public String nextPhase(){
        return null;
    }

    /**
     * Parses user input
     * @param input The input that CrapsRunner gets from the user
     * @return an InputResult with the response to the user's input and whether CrapsRunner should move on
     */
    public InputResult processInput(String input){
        return null;
    }

    /**
     * Processes a users request to bet. If the amount is valid, makes a new bet of the appropriate type and adds
     *   it to betList
     * @param input user input
     * @return Returns a string with the result. Confirmation of the bet if all was in order, an error message
     *   otherwise
     */
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

    /**
     * Prints out a table of the bets allowed and their payout value
     */
    public String printBetPayoutTable(){
        return null;
    }

    /**
     * Prints out instructions on how to interact with the program
     */
    public String printInstructions(){
        return null;
    }

    /**
     * Creates a new CrapsBet object
     * @param type - the type of bet
     * @param value - how much is wagered
     * @return
     */
    public CrapsBet makeNewBet(BetType type, Integer value){
        return null;
    }

    /**
     * Adds a bet to betList
     * @param bet
     */
    protected void addBet(CrapsBet bet){

    }

    /**
     * Check whether the user is finished playing
     * @return true if yes, false if not
     */
    public Boolean getExit(){
        return null;
    }

    /**
     * Roll the dice and return the result
     * @return a new CrapsRoll object
     */
    protected CrapsRoll rollDice(){
        return null;
    }

    private void settleBets(CrapsRoll currentRoll){

    }

    // currently used only for testing
    protected Integer getNumberOfBets(){
        return betList.size();
    }

}

enum Phase{
    WALKUP, COMEOUT, POINT;
}

