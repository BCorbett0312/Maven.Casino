package io.zipcoder.casino.craps;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import io.zipcoder.casino.Gamble;
import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrapsGame extends Game implements Gamble {
    private CrapsPlayer player; //
    private Console console;
    private List<CrapsBet> betList; //
    private CrapsRoll comeOutRoll; //
    private Boolean exit;
    private Boolean leaveBets;
    private Phase phase;
    private Pattern betPattern;
    private Pattern digitPattern;
    private Random random;


    public CrapsGame(CrapsPlayer player){
        this.player = player;
        this.betList = new ArrayList<>();
        this.comeOutRoll = null;
        this.exit = false;
        this.leaveBets = false;
        this.phase = Phase.WALKUP;
        this.betPattern = Pattern.compile("(pass line \\d+)|(don't pass \\d+)|(field bet \\d+)");
        this.digitPattern = Pattern.compile("\\d+");
        this.random = new Random();
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
    public InputResult processInput(String input){ return null; }

    /**
     * Processes a users request to bet. If the amount is valid, makes a new bet of the appropriate type and adds
     *   it to betList
     * @param input user input
     * @return Returns a string with the result. Confirmation of the bet if all was in order, an error message
     *   otherwise
     */
    public Pair<String, Boolean> processBet(String input){
        String str = input.toLowerCase().substring(0,9);
        Matcher digitMatcher = digitPattern.matcher(input);
        digitMatcher.find();
        Integer value = Integer.parseInt(digitMatcher.group());
        CrapsBet bet;

        switch(str){
            case "pass line":
                if(phase != Phase.COMEOUT){ return new Pair<String,Boolean>("You can only place a Pass Line bet in the Come Out phase", false); }
                bet = makeNewBet(BetType.PASS, value);
                break;
            case "don't pas":
                if(phase != Phase.COMEOUT){ return new Pair<String,Boolean>("You can only place a Don't Pass bet in the Come Out phase", false); }
                bet = makeNewBet(BetType.DONTPASS, value);
                break;
            case "field bet":
                bet = makeNewBet(BetType.FIELD, value);
                break;
            default:
                throw new IllegalArgumentException("Not a valid BetType");
        }

        if(bet == null){
            return new Pair<String, Boolean>("You've not enough minerals", false);
        }
        else{
            StringBuilder sbuild = new StringBuilder("Placed a ");
            sbuild.append(bet.getType());
            sbuild.append(" bet for $");
            sbuild.append(bet.getValue());
            sbuild.append("\nPlace another bet? ");
            addBet(bet);
            return new Pair<String, Boolean>(sbuild.toString(), true);
        }
    }

    /**
     * Rolls the Come Out Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to move onto the Point phase as the second value
     */
    public Pair<String, Boolean> rollComeOut(CrapsRoll roll){
        if(roll.getValue() == 7 || roll.getValue() == 11){
            return new Pair<>("Natural\n", false);
        }
        else if(roll.getValue() == 2 || roll.getValue() == 3 || roll.getValue() == 12){
            return new Pair<>("Shooter craps out\n", false);
        }
        else{
            return new Pair<>("The Point is " + roll.getValue() +"\n", true);
        }
    }

    /**
     * Rolls the Point Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to start a new round as the second value
     */
    public Pair<String, Boolean> rollPoint(CrapsRoll roll){
        if(roll.getValue() == 7){
            return new Pair<>("7. Pass Line loses\n", true);
        }
        else if(roll.getValue().equals(comeOutRoll.getValue())){
            return new Pair<>("Shooter hits. Pass Line wins\n", true);
        }
        else{
            return new Pair<>("Shooter rolls a " + roll.getValue() + "\n", false);
        }
    }

    /**
     * Prints out a list of the player's current outstanding bets
     * @return a concatination of each bet's toString method, separated by a new line
     */
    public String currentBets(){
        if(betList.size() == 0){
            return "You don't have any bets placed\n";
        }

        StringBuilder sbuild = new StringBuilder("Your current bets are:\n");
        for(CrapsBet bet : betList){
            sbuild.append(bet.toString());
            sbuild.append("\n");
        }
        return sbuild.toString();
    }

    /**
     * Prints out a table of the bets allowed and their payout value
     */
    public String printBetPayoutTable(){
        return  " ------------------------------------------------ \n" +
                "| Pass Line bets  pay out 1:1                    |\n" +
                "| Don't Pass bets pay out 1:1                    |\n" +
                "| Field bets      pay out 1:1 on 3, 4, 9, 10, 11 |\n" +
                "|                         2:1 on 2, 12           |\n" +
                " ------------------------------------------------";
    }

    /**
     * Prints out instructions on how to interact with the program
     */
    public String printInstructions(){
        return  "To place a Pass Line bet, enter  \"Pass Line \"  and the wager amount\n" +
                "To place a Don't Pass bet, enter \"Don't Pass \" and the wager amount\n" +
                "To place a Field bet, enter \"Field\"            and the wager amount\n" +
                "If you've placed as many bets as you want, enter \"Roll\"\n" +
                "To see your current bets, enter \"Show Bets\"\n" +
                "To print the payout table, enter \"Payout\"\n" +
                "To leave, enter \"exit\"";
    }

    /**
     * Creates a new CrapsBet object
     * @param type - the type of bet
     * @param value - how much is wagered
     * @return
     */
    public CrapsBet makeNewBet(BetType type, Integer value){
        if(!player.canBet(value)){
            return null;
        }

        player.placeBet(value);
        switch(type){
            case PASS:
                return new PassBet(value);
            case DONTPASS:
                return new DontPassBet(value);
            case FIELD:
                return new FieldBet(value);
            default:
                throw(new IllegalArgumentException());
        }
    }


    /**
     * Adds a bet to betList
     * @param bet
     */
    protected void addBet(CrapsBet bet){
        betList.add(bet);
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
        Integer die1 = random.nextInt(5) + 1;
        Integer die2 = random.nextInt(5) + 2;
        return new CrapsRoll(die1, die2);
    }

    /**
     * Iterates throw betList, removes lost bets, removes and pays out won bets
     * @param currentRoll - the roll that all bets are checked against
     * @return a Triplet with the bet type, the value of the bet, and the amount won
     */
    private List<Triplet<BetType, Integer, Integer >> settleBets(CrapsRoll currentRoll){
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

