package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CrapsGameTest {

    private CrapsGame makeBetTester = new CrapsGame(new CrapsPlayer(new Player(1000, "Sulla")));

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
        Pattern p = Pattern.compile("[123456], [123456]");

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
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "field bet 5";
        String expected = "Placed a Field bet for $5\n: ";

        // Act
        processBetTester.setPhase(Phase.POINT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void processBetTest2(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "field bet 15";
        String expected = "You've not enough minerals";

        // Act
        processBetTester.setPhase(Phase.POINT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();


        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void processBetTest3(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "field bet 5";
        String expected = "Placed a Field bet for $5\n: ";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertEquals(expected, result);

    }

    @Test
    public void processBetTest4(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "Pass line 5";
        String expected = "You can only place a Pass Line bet in the Come Out phase";

        // Act
        processBetTester.setPhase(Phase.POINT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result);

    }

    @Test
    public void processBetTest5(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "Pass line 5";
        String expected = "Placed a Pass Line bet for $5\n: ";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void processBetTest6(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "Don't Pass 5";
        String expected = "You can only place a Don't Pass bet in the Come Out phase";

        // Act
        processBetTester.setPhase(Phase.POINT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(0, betNum);
        Assert.assertEquals(10, wallet);
        Assert.assertEquals(expected, result);

    }

    @Test
    public void processBetTest7(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame processBetTester = new CrapsGame(cp);
        String input = "Don't pass 5";
        String expected = "Placed a Don't Pass bet for $5\n: ";

        // Act
        processBetTester.setPhase(Phase.COMEOUT);
        String result = processBetTester.processBet(input);
        int betNum = processBetTester.getNumberOfBets();
        int wallet = cp.getMoney();

        // Assert
        Assert.assertEquals(1, betNum);
        Assert.assertEquals(5, wallet);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void currentBetsTest1(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame currentBetsTester = new CrapsGame(cp);
        String expected = "You don't have any bets placed\n";

        // Act
        String actual = currentBetsTester.currentBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentBetsTest2(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame currentBetsTester = new CrapsGame(cp);
        CrapsBet bet1 = new PassBet(5);
        String expected = "Your current bets are:\n" + bet1.printBet() + "\n";

        // Act
        currentBetsTester.addBet(bet1);
        String actual = currentBetsTester.currentBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentBetsTest3(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(10, "Sulla"));
        CrapsGame currentBetsTester = new CrapsGame(cp);
        CrapsBet bet1 = new PassBet(5);
        CrapsBet bet2 = new DontPassBet(6);
        String expected = "Your current bets are:\n" + bet1.printBet() + "\n" + bet2.printBet() + "\n";

        // Act
        currentBetsTester.addBet(bet1);
        currentBetsTester.addBet(bet2);
        String actual = currentBetsTester.currentBets();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollComeOutTest1(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(1,1);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "Shooter craps out\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest2(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(2,1);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "Shooter craps out\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest3(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(3,4);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "Natural\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest4(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(5,6);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "Natural\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest5(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(6,6);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "Shooter craps out\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
    }

    @Test
    public void rollComeOutTest6(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(3,1);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 4\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest7(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(3,2);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 5\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest8(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(3,3);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 6\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest9(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(3,5);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 8\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest10(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(6,3);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 9\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollComeOutTest11(){
        // Arrange
        CrapsGame comeTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll roll = new CrapsRoll(4,6);
        comeTester.setPhase(Phase.COMEOUT);
        String expected = "The Point is 10\n";

        // Act
        Pair<String, Boolean> result = comeTester.rollComeOut(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollPointTest1(){
        // Arrange
        CrapsGame pointTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll comeOut = new CrapsRoll(5,3);
        CrapsRoll roll = new CrapsRoll(3,4);
        pointTester.setPhase(Phase.POINT);
        pointTester.setComeOutRoll(comeOut);
        String expected = "7. Pass Line loses\n";

        // Act
        Pair<String, Boolean> result = pointTester.rollPoint(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollPointTest2(){
        // Arrange
        CrapsGame pointTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll comeOut = new CrapsRoll(5,3);
        CrapsRoll roll = new CrapsRoll(6,2);
        pointTester.setPhase(Phase.POINT);
        pointTester.setComeOutRoll(comeOut);
        String expected = "Shooter hits. Pass Line wins\n";

        // Act
        Pair<String, Boolean> result = pointTester.rollPoint(roll);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void rollPointTest3(){
        // Arrange
        CrapsGame pointTester = new CrapsGame(new CrapsPlayer(new Player()));
        CrapsRoll comeOut = new CrapsRoll(5,3);
        CrapsRoll roll = new CrapsRoll(3,2);
        pointTester.setPhase(Phase.POINT);
        pointTester.setComeOutRoll(comeOut);
        String expected = "Shooter rolls a 5\n";

        // Act
        Pair<String, Boolean> result = pointTester.rollPoint(roll);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void processInputTest1(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player(10, "Sulla")));
        processTester.setPhase(Phase.COMEOUT);
        String input = "pass line 2";
        String expected = "Placed a Pass Line bet for $2\n: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void processInputTest2(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player(100, "Sulla")));
        processTester.setPhase(Phase.COMEOUT);
        String input = "don't pass 22";
        String expected = "Placed a Don't Pass bet for $22\n: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void processInputTest3(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player(10000000, "Crassus")));
        String input = "field bet 322";
        String expected = "Placed a Field bet for $322\n: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void processInputTest4(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "pass line";
        String expected = "Invalid command\nTry again: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }


    @Test
    public void processInputTest5(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "show bets";
        String expected = processTester.currentBets();

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
    }

    @Test
    public void processInputTest6(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "payout";
        String expected = processTester.printBetPayoutTable();

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
    }

    @Test
    public void processInputTest7(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "help";
        String expected = processTester.printInstructions();

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
    }

    @Test
    public void processInputTest8(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "exit";
        String expected = "Goodbye\n";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
        Assert.assertTrue(processTester.getExit());
    }

    @Test
    public void processInputTest9(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "roll";
        String expected = "Rolling... \n";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
    }

    @Test
    public void processInputTest10(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        String input = "blargle";
        String expected = "Invalid command\nTry again: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected, result.getValue0());
    }

    @Test
    public void processInputTest11(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        processTester.addBet(new PassBet(1));
        String input = "exit";
        String expected = "You have open bets, enter \"Exit\" again if you really want to leave\n: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
        Assert.assertTrue(processTester.getLeaveBets());
        Assert.assertFalse(processTester.getExit());
    }

    @Test
    public void processInputTest12(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        processTester.setLeaveBets(true);
        String input = "exit";
        String expected = "Goodbye\n";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertTrue(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
        Assert.assertTrue(processTester.getExit());
    }

    @Test
    public void processInputTest13(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        processTester.setLeaveBets(true);
        String input = "";
        String expected = "Enter a command: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
        Assert.assertFalse(processTester.getExit());
        Assert.assertFalse(processTester.getLeaveBets());
    }

    @Test
    public void processInputTest14(){
        // Arrange
        CrapsGame processTester = new CrapsGame(new CrapsPlayer(new Player()));
        processTester.setLeaveBets(true);
        String input = "anything besides exit";
        String expected = "Enter a command: ";

        // Act
        Pair<String, Boolean> result = processTester.processInput(input);

        // Assert
        Assert.assertFalse(result.getValue1());
        Assert.assertEquals(expected,result.getValue0());
        Assert.assertFalse(processTester.getExit());
        Assert.assertFalse(processTester.getLeaveBets());
    }

    @Test
    public void reportSettledBetsTest1(){
        // Arrange
        CrapsGame reportTester = new CrapsGame(new CrapsPlayer((new Player(100, "Sulla"))));
        Triplet<BetType, Integer, Integer> bet1 = new Triplet<>(BetType.PASS, 5, 10);
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(bet1);
        String expected = "Your Pass Line bet for $5 payed out $10\n";

        // Act
        String actual = reportTester.reportSettledBets(report);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reportSettledBetsTest2(){
        // Arrange
        CrapsGame reportTester = new CrapsGame(new CrapsPlayer((new Player(100, "Sulla"))));
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        String expected = "";

        // Act
        String actual = reportTester.reportSettledBets(report);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reportSettledBetsTest3(){
        // Arrange
        CrapsGame reportTester = new CrapsGame(new CrapsPlayer((new Player(100, "Sulla"))));
        Triplet<BetType, Integer, Integer> bet1 = new Triplet<>(BetType.PASS, 5, 0);
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(bet1);
        String expected = "Your Pass Line bet for $5 lost\n";

        // Act
        String actual = reportTester.reportSettledBets(report);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reportSettledBetsTest4(){
        // Arrange
        CrapsGame reportTester = new CrapsGame(new CrapsPlayer((new Player(100, "Sulla"))));
        Triplet<BetType, Integer, Integer> bet1 = new Triplet<>(BetType.DONTPASS, 5, 5);
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(bet1);
        String expected = "Your Don't Pass bet for $5 pushed\n";

        // Act
        String actual = reportTester.reportSettledBets(report);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reportSettledBetsTest5(){
        // Arrange
        CrapsGame reportTester = new CrapsGame(new CrapsPlayer((new Player(100, "Sulla"))));
        Triplet<BetType, Integer, Integer> bet1 = new Triplet<>(BetType.PASS, 5, 10);
        Triplet<BetType, Integer, Integer> bet2 = new Triplet<>(BetType.FIELD, 30, 0);
        Triplet<BetType, Integer, Integer> bet3 = new Triplet<>(BetType.DONTPASS, 15, 15);
        Triplet<BetType, Integer, Integer> bet4 = new Triplet<>(BetType.FIELD, 20 ,40);
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(bet1);
        report.add(bet2);
        report.add(bet3);
        report.add(bet4);
        String expected = "Your Pass Line bet for $5 payed out $10\n" +
                          "Your Field bet for $30 lost\n" +
                          "Your Don't Pass bet for $15 pushed\n" +
                          "Your Field bet for $20 payed out $40\n";

        // Act
        String actual = reportTester.reportSettledBets(report);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSettleBets1(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new PassBet(5);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(3,4);

        Integer expectedFunds = 110;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.PASS, 5, 10));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets2(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new PassBet(5);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(1,1);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.PASS, 5, 0));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets3(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new PassBet(5);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(3,5);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 1;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets4(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new DontPassBet(15);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(6,5);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.DONTPASS, 15, 0));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets5(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new DontPassBet(15);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(6,6);

        Integer expectedFunds = 115;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.DONTPASS, 15, 15));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets6(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new DontPassBet(15);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(6,5);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.DONTPASS, 15, 0));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets7(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new FieldBet(20);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(6,5);

        Integer expectedFunds = 140;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.FIELD, 20, 40));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets8(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new FieldBet(20);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(2,5);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.FIELD, 20, 0));
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 0;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets9(){
        // Assert
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new FieldBet(20);
        CrapsBet bet2 = new PassBet(10);
        settleTester.addBet(bet);
        settleTester.addBet(bet2);
        CrapsRoll roll = new CrapsRoll(6,4);

        Integer expectedFunds = 140;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        report.add(new Triplet<>(BetType.FIELD, 20, 40));
        //report.add(new Trip)
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 1;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);
    }

    @Test
    public void testSettleBets10() {
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsBet bet = new PassBet(50);
        settleTester.addBet(bet);
        CrapsRoll roll = new CrapsRoll(3, 5);

        Integer expectedFunds = 100;
        List<Triplet<BetType, Integer, Integer>> report = new ArrayList<>();
        String expectedReport = settleTester.reportSettledBets(report);
        Integer expectedBets = 1;

        // Act
        String actualReport = settleTester.settleBets(roll);
        Integer actualFunds = cp.getMoney();
        Integer actualBets = settleTester.getNumberOfBets();

        // Assert
        Assert.assertEquals(expectedBets, actualBets);
        Assert.assertEquals(expectedFunds, actualFunds);
        Assert.assertEquals(expectedReport, actualReport);

        // Arrange II
        Integer expectedBets2 = 0;
        Integer expectedFunds2 = 200;
        report.add(new Triplet<>(BetType.PASS, 50, 100));
        String expectedReport2 = settleTester.reportSettledBets(report);

        // Act II
        String actualReport2 = settleTester.settleBets(roll);
        Integer actualFunds2 = cp.getMoney();
        Integer actualBets2 = settleTester.getNumberOfBets();

        // Assert II
        Assert.assertEquals(expectedBets2, actualBets2);
        Assert.assertEquals(expectedFunds2, actualFunds2);
        Assert.assertEquals(expectedReport2, actualReport2);
    }

    @Test
    public void testSettleBets11(){
        // Arrange
        CrapsPlayer cp = new CrapsPlayer(new Player(100, "Sulla"));
        CrapsGame settleTester = new CrapsGame(cp);
        CrapsRoll roll = new CrapsRoll(6,4);

        CrapsBet bet1 = new FieldBet(5);
        CrapsBet bet2 = new FieldBet(5);
        CrapsBet bet3 = new PassBet(50);
        CrapsBet bet4 = new FieldBet(5);
        CrapsBet bet5 = new FieldBet(5);
        CrapsBet bet6 = new FieldBet(5);
        CrapsBet bet7 = new DontPassBet(15);
        CrapsBet bet8 = new FieldBet(5);
        CrapsBet bet9 = new FieldBet(5);
        CrapsBet bet10 = new FieldBet(5);
        CrapsBet bet11 = new FieldBet(500);

        settleTester.addBet(bet1);
        settleTester.addBet(bet2);
        settleTester.addBet(bet3);
        settleTester.addBet(bet4);
        settleTester.addBet(bet5);
        settleTester.addBet(bet6);
        settleTester.addBet(bet7);
        settleTester.addBet(bet8);
        settleTester.addBet(bet9);
        settleTester.addBet(bet10);
        settleTester.addBet(bet11);

        Integer moneyExpected = 1180;
        String expected = "Your current bets are:\n" +
                          "Pass Line for $50\n" +
                          "Point: 10\n" +
                          "Don't Pass for $15\n" +
                          "Point: 10\n";

        // Act
        settleTester.settleBets(roll);
        Integer moneyActual = cp.getMoney();
        String actual = settleTester.currentBets();

        // Assert
        Assert.assertEquals(moneyExpected,moneyActual);
        Assert.assertEquals(expected,actual);
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
//        phaseTester.setPhase(Phase.COMEOUT);
//        CrapsRoll roll = new CrapsRoll(1,1);
//        Phase expected = Phase.COMEOUT;
//
//        // Act
//        phaseTester.nextPhase();
//    }



}