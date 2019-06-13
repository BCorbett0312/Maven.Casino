package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DontPassBetTest {

    @Test
    public void constructorTestWon(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);

        // Act
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void constructorTestLost(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);

        // Act
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest1(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(4,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest2(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(6,5);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest3(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(1,1);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest4(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(1,2);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest5(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(6,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest6(){
        // Arrange
        DontPassBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(2,2);

        // Act
        bet.checkRoll(roll);
        CrapsRoll point = bet.getPoint();

        // Assert
        Assert.assertEquals(roll, point);
    }

    @Test
    public void checkRollTest7(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(5,4);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest8(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(5,4);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest9(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(5,4);

        // Act
        bet.checkRoll(roll);
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest10(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);

        // Act
        bet.checkRoll(new CrapsRoll(4,5));
        bet.checkRoll(new CrapsRoll(3,4));
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkPayoutTest1(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void checkPayoutTest2(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(5,2);

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void checkPayoutTest3(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        CrapsRoll roll = new CrapsRoll(1,1);
        Integer expected = 10;

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPayoutTest4(){
        // Arrange
        Integer expected = 5;
        CrapsBet bet = new DontPassBet(expected);
        CrapsRoll roll = new CrapsRoll(6,6);

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPayoutTest5(){
        // Arrange
        CrapsBet bet = new DontPassBet(5);
        Integer expected = 10;

        // Act
        bet.checkRoll(new CrapsRoll(4,4));
        bet.checkRoll(new CrapsRoll(4,3));
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }




}