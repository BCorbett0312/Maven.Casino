package io.zipcoder.casino.craps;

import io.zipcoder.casino.Gamble;
import io.zipcoder.casino.Game;
import io.zipcoder.casino.Player;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Iterator;
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
        StringBuilder sbuild = new StringBuilder();
        switch(phase){
            case WALKUP:
                String marque = "XXXXX  XXXX    XXX   XXXXX  XXXXX \n" +
                                "XX     X   X  X   X  X   X  XX    \n" +
                                "XX     XXXX   XXXXX  XXXXX  XXXXX \n" +
                                "XX     X  X   X   X  XX        XX \n" +
                                "XXXXX  X   X  X   X  XX     XXXXX \n";

                phase = Phase.COMEOUT;
                return marque + "\n\n" + printBetPayoutTable() + "\n\n" + printInstructions() + "\n";
            case COMEOUT:
                CrapsRoll comeRoll = rollDice();
                sbuild.append("Shooter rolled ").append(comeRoll.getValue()).append("\n\n");

                String comeResult = rollComeOut(comeRoll);
                sbuild.append(comeResult).append("\n");

                String comeReport = settleBets(comeRoll);
                if(!comeReport.equals("")){
                    sbuild.append(comeReport).append("\n\n");
                }

                return sbuild.toString();
            case POINT:
                CrapsRoll pointRoll = rollDice();
                sbuild.append("Shooter rolled ").append(pointRoll.getValue()).append("\n\n");

                String pointResult = rollPoint(pointRoll);
                sbuild.append(pointResult).append("\n");

                String pointReport = settleBets(pointRoll);
                if(!pointReport.equals("")){
                    sbuild.append(pointReport).append("\n\n");
                }

                return sbuild.toString();
            default:
                throw new IllegalArgumentException("Enum type phase not in enum Phase, somehow");
        }
    }

    /**
     * Parses user input
     * @param input The input that CrapsRunner gets from the user
     * @return an InputResult with the response to the user's input and whether CrapsRunner should move on
     */
    public Pair<String, Boolean> processInput(String input){
        input = input.toLowerCase().trim();
        Matcher betMatcher = betPattern.matcher(input);
        if(betMatcher.matches()){
            return new Pair<>(processBet(input),false);
        }

        if(leaveBets && !input.equals("exit")){
            leaveBets = false;
            return new Pair<>("\n", false);
        }

        switch(input){
            case "show bets":
                return new Pair<>(currentBets(), false);
            case "payout":
                return new Pair<>(printBetPayoutTable(), false);
            case "help":
                return new Pair<>(printInstructions(), false);
            case "exit":
                if(betList.size()!=0 && !leaveBets){
                    leaveBets = true;
                    return new Pair<>("You have open bets. Enter \"Exit\" again if you really want to leave\n", false);
                }
                else{
                    exit = true;
                    return new Pair<>("Goodbye\n", true);
                }
            case "roll":
                return new Pair<>("Rolling... \n",true);
            case "wallet":
                return new  Pair<>(playerFunds(), false);
            default:
                return new Pair<>("Invalid command\n", false);
        }
    }

    /**
     * Processes a users request to bet. If the amount is valid, makes a new bet of the appropriate type and adds
     *   it to betList
     * @param input user input
     * @return Returns a string with the result. Confirmation of the bet if all was in order, an error message
     *   otherwise
     */
    public String processBet(String input){
        String str = input.toLowerCase().substring(0,9);
        Matcher digitMatcher = digitPattern.matcher(input);
        digitMatcher.find();
        Integer value = Integer.parseInt(digitMatcher.group());
        CrapsBet bet;

        switch(str){
            case "pass line":
                if(phase != Phase.COMEOUT){ return "You can only place a Pass Line bet in the Come Out phase"; }
                bet = makeNewBet(BetType.PASS, value);
                break;
            case "don't pas":
                if(phase != Phase.COMEOUT){ return "You can only place a Don't Pass bet in the Come Out phase"; }
                bet = makeNewBet(BetType.DONTPASS, value);
                break;
            case "field bet":
                bet = makeNewBet(BetType.FIELD, value);
                break;
            default:
                throw new IllegalArgumentException("Not a valid BetType");
        }

        if(bet == null){
            return "You've not enough minerals\n";
        }
        else{
            StringBuilder sbuild = new StringBuilder("Placed a ");
            sbuild.append(bet.getType());
            sbuild.append(" bet for $");
            sbuild.append(bet.getValue());
            sbuild.append("\n\n");
            addBet(bet);
            return sbuild.toString();
        }
    }

    /**
     * Rolls the Come Out Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to move onto the Point phase as the second value
     */
    public String rollComeOut(CrapsRoll roll){
        if(roll.getValue() == 7 || roll.getValue() == 11){
            return "Natural\n";
        }
        else if(roll.getValue() == 2 || roll.getValue() == 3 || roll.getValue() == 12){
            return "Shooter craps out\n";
        }
        else{
            phase = Phase.POINT;
            return "The Point is " + roll.getValue() +"\n";
        }
    }

    /**
     * Rolls the Point Phase
     * @param roll - the roll that was made
     * @return A Pair containing a string summarizing the result of the roll as the first value and a boolean indicating
     *   whether or not to start a new round as the second value
     */
    public String rollPoint(CrapsRoll roll){
        if(roll.getValue() == 7){
            phase = Phase.COMEOUT;
            return "7. Pass Line loses\n";
        }
        else if(roll.getValue().equals(comeOutRoll.getValue())){
            phase = Phase.COMEOUT;
            return "Shooter hits. Pass Line wins\n";
        }
        else{
            return "Play continues\n";
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
            sbuild.append(bet.printBet());
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
                "To place a Field bet, enter \"Field bet\"        and the wager amount\n" +
                "If you've placed as many bets as you want, enter \"Roll\"\n" +
                "To see your current bets, enter \"Show Bets\"\n" +
                "To print the payout table, enter \"Payout\"\n" +
                "To see your available funds, enter \"Wallet\"\n" +
                "To leave, enter \"exit\"\n";
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
        return exit;
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
    public String settleBets(CrapsRoll currentRoll){
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        Iterator itr = betList.iterator();
        while(itr.hasNext()){
            CrapsBet bet = (CrapsBet)itr.next();
            bet.checkRoll(currentRoll);
            if(bet.hasWon()){
                report.add(new Triplet<>(bet.getType(),bet.getValue(),bet.payout()));
                player.collectWinnings(bet.payout());
                itr.remove();
            }
            else if(bet.hasLost()){
                report.add(new Triplet<>(bet.getType(),bet.getValue(),0));
                itr.remove();
            }
        }

        return reportSettledBets(report);
    }

    public String reportSettledBets(List<Triplet<BetType, Integer, Integer>> settleOutcomes){
        StringBuilder sbuild = new StringBuilder();
        for(Triplet trip : settleOutcomes){
            if(trip.getValue2().equals(0)){
                sbuild.append("Your ").append(trip.getValue0()).append(" bet for $").append(trip.getValue1()).append(" lost\n");
            }
            else if(trip.getValue2().equals(trip.getValue1())){
                sbuild.append("Your ").append(trip.getValue0()).append(" bet for $").append(trip.getValue1()).append(" pushed\n");
            }
            else{
                sbuild.append("Your ").append(trip.getValue0()).append(" bet for $").append(trip.getValue1());
                sbuild.append(" payed out $").append(trip.getValue2()).append("\n");
            }

        }
        return sbuild.toString();
    }

    public String playerFunds(){
        return "You have $" + player.getMoney() + " in your wallet\n\n";
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



    @Override
    public Integer payOut(Integer amount) {
        return null;
    }

}

enum Phase{
    WALKUP, COMEOUT, POINT;
}

