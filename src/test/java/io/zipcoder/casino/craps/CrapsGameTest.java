package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CrapsGameTest {

    private CrapsGame makeBetTester = new CrapsGame(new CrapsPlayer(new Player()));

    @Test
    public void makeNewBetTest1(){
        // Arrange
        Integer value = 5;
        BetType type = BetType.PASS;
        CrapsBet expected = new PassBet(5);

        // Act
        CrapsBet actual = makeBetTester.makeNewBet(type, value);

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void makeNewBetTest2(){
        // Arrange
        Integer value = 5;
        BetType type = BetType.DONTPASS;
        CrapsBet expected = new DontPassBet(5);

        // Act
        CrapsBet actual = makeBetTester.makeNewBet(type, value);

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void makeNewBetTest3(){
        // Arrange
        Integer value = 5;
        BetType type = BetType.FIELD;
        CrapsBet expected = new FieldBet(5);

        // Act
        CrapsBet actual = makeBetTester.makeNewBet(type, value);

        // Assert
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void printBetPayoutTableTest() {
        // Arrange
        String expected = " ------------------------------------------------ \n" +
                          "| Pass Line bets  pay out 1:1                    |\n" +
                          "| Don't Pass bets pay out 1:1                    |\n" +
                          "| Field bets      pay out 1:1 on 3, 4, 9, 10, 11 |\n" +
                          "|                         2:1 on 2, 12           |\n" +
                          " ------------------------------------------------";

        // Act
        String actual = makeBetTester.printBetPayoutTable();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printInstructionsTest(){
        // Arrange
        String expected = "To place a Pass Line bet, enter  \"Pass Line \"  and the wager amount\n" +
                          "To place a Don't Pass bet, enter \"Don't Pass \" and the wager amount\n" +
                          "To place a Field bet, enter \"Field\"            and the wager amount\n" +
                          "If you've placed as many bets as you want, enter \"Roll\"\n" +
                          "To see your current bets, enter \"Show Bets\"\n" +
                          "To print the payout table, enter \"Payout\"\n" +
                          "To leave, enter \"exit\"";

        // Act
        String actual = makeBetTester.printInstructions();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDiceTest(){
        // Arrange
        Boolean allGood = true;
        Pattern p = Pattern.compile("\\d, \\d");

        // Act
        for(int i = 0; i < 10000; i++){
            CrapsRoll roll = makeBetTester.rollDice();
            if(roll.getValue() < 2 || roll.getValue() > 12){
                allGood = false;
                break;
            }
            Matcher m = p.matcher(roll.toString());
            if(!m.matches()){
                allGood = false;
                break;
            }
        }

        // Assert
        Assert.assertTrue(allGood);
    }

    @Test
    public void addBetTest1(){
        // Arrange
        CrapsGame addBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsBet bet = new PassBet(5);
        Integer expected = 1;

        // Act
        addBetTester.addBet(bet);
        Integer actual = addBetTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addBetTest2(){
        // Arrange
        CrapsGame addBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsBet dontPass = new DontPassBet(5);
        CrapsBet field = new FieldBet(8);
        Integer expected = 2;

        // Act
        addBetTester.addBet(dontPass);
        addBetTester.addBet(field);
        Integer actual = addBetTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void processBetTest1(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "field bet 5";

        // Act
        processBetTester.setPhase(Phase.POINT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
    }

    @Test
    public void processBetTest2(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "field bet 15";
        String expected = "You've not enough minerals";

        // Act
        processBetTester.setPhase(Phase.POINT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();


        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result.getPrintOut());
        Assert.assertFalse(result.moveOn());
    }

    @Test
    public void processBetTest3(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "field bet 5";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
    }

    @Test
    public void processBetTest4(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "Pass line 5";
        String expected = "You can only place a Pass Line bet in the Come Out phase";

        // Act
        processBetTester.setPhase(Phase.POINT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result.getPrintOut());
        Assert.assertFalse(result.moveOn());

    }

    @Test
    public void processBetTest5(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "Pass line 5";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertFalse(result.moveOn());
    }

    @Test
    public void processBetTest6(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "Don't Pass 5";
        String expected = "You can only place a Don't Pass bet in the Come Out phase";

        // Act
        processBetTester.setPhase(Phase.POINT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result.getPrintOut());
        Assert.assertFalse(result.moveOn());

    }

    @Test
    public void processBetTest7(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "Don't pass 5";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        InputResult result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertFalse(result.moveOn());
    }

    @Test
    public void currentBetsTest1(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame currentBetsTester = new CrapsGame(new CrapsPlayer(new Player()));
        String expected = "You don't have any bets placed\n";

        // Act
        String actual = currentBetsTester.currentBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void nextPhaseTest1(){
//        // Arrange
//        CrapsGame phaseTester = new CrapsGame(new CrapsPlayer(new Player()));
//        String expected = phaseTester.printBetPayoutTable() + "\n" + phaseTester.printInstructions();
//
//        // Act
//        String actual = phaseTester.nextPhase();
//
//        // Assert
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void nextPhaseTest2(){
//        // Arrange
//        CrapsGame phaseTester = new CrapsGame(new CrapsPlayer(new Player()));
//        phaseTester.nextPhase();
//
//    }



}