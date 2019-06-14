package io.zipcoder.casino.craps;

import io.zipcoder.casino.Gamble;
import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import io.zipcoder.casino.utilities.Console;

import java.util.List;
import java.util.regex.Pattern;

public class CrapsGame extends Game implements Gamble {
    private CrapsPlayer player;
    private Console console;
    private List<CrapsBet> betList;
    private CrapsRoll comeOutRoll;
    private Boolean exit;
    private Boolean leaveBets;
    private Phase phase;
    private Pattern p;


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
    public InputResult processBet(String input){
        return null;
    }

    /**
     * Rolls the Come Out Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to move onto the Point phase as the second value
     */
    public Pair<String, Boolean> rollComeOut(CrapsRoll roll){
        return null;
    }

    /**
     * Rolls the Point Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to start a new round as the second value
     */
    public Pair<String, Boolean> rollPoint(CrapsRoll roll){
        return null;
    }

    /**
     * Prints out a list of the player's current outstanding bets
     * @return a concatination of each bet's toString method, separated by a new line
     */
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

    /**
     * Iterates throw betList, removes lost bets, removes and pays out won bets
     * @param currentRoll - the roll that all bets are checked against
     * @return a Triplet with the bet type, the value of the bet, and the amount won
     */
    private Triplet<BetType, Integer, Integer > settleBets(CrapsRoll currentRoll){
        return null;
    }

    public Integer getNumberOfBets(){
        return betList.size();
    }

    // currently used only for testing
    protected Phase getPhase(){
        return phase;
    }

    // DANGEROUS only for testing
    protected void setPhase(Phase phase){
        this.phase = phase;
    }

    // DANGEROUS only for testing
    protected void setComeOutRoll(CrapsRoll comeOutRoll){
        this.comeOutRoll = comeOutRoll;
    }

    // currently used only for testing
    protected Boolean getLeaveBets(){
        return leaveBets;
    }

    // DANGEROUS only for testing
    protected void setLeaveBets(Boolean leaveBets){
        this.leaveBets = leaveBets;
    }

}

enum Phase{
    WALKUP, COMEOUT, POINT;
}

