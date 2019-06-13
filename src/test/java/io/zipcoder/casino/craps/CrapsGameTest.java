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
                          "| Pass Line bets pay out  1:1                    |\n" +
                          "| Don't Pass bets pay out 1:1                    |\n" +
                          "| Field bets pay out      1:1 on 3, 4, 9, 10, 11 |\n" +
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
                          "To place a Field bet, enter \"Field\"            and the wager amount";

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



}