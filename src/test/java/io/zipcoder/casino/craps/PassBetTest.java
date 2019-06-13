package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassBetTest {

    @Test
    public void payoutTest1(){
        // Arrange
        CrapsBet bet = new PassBet(1);
        Integer expected = 2;

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest2(){
        // Arrange
        CrapsBet bet = new PassBet(10);
        Integer expected = 20;

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest3(){
        // Arrange
        CrapsBet bet = new PassBet(6);
        Integer expected = 12;

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorWinTest(){
        // Arrange
        CrapsBet bet = new PassBet(2);

        // Act
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void constructorLoseTest(){
        // Arrange
        CrapsBet bet = new PassBet(2);

        // Act
        Boolean actual = bet.hasLost();

        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest1(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(1,1);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest2(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(2,1);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest3(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(6,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest4(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(6,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest5(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(4,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest6(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(5,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest7(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(5,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest8(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest9(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest10(){
        // Arrange
        PassBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        CrapsRoll actual = bet.getPoint();

        // Assert
        Assert.assertEquals(roll.getValue(), actual.getValue());
    }

    @Test
    public void checkRollTest11(){
        // Arrange
        CrapsBet bet = new PassBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest12(){
        // Arrange
        CrapsBet bet = new PassBet(5);

        // Act
        bet.checkRoll(new CrapsRoll(3,3));
        bet.checkRoll(new CrapsRoll(4,3));
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }





}