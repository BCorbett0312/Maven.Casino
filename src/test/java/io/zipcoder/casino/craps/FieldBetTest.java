package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldBetTest {

    @Test
    public void constructorWonTest(){
        // Assert
        CrapsBet bet = new FieldBet(5);

        // Act
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void constructorLostTest(){
        // Assert
        CrapsBet bet = new FieldBet(5);

        // Act
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void checkRollTest1(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(1,1);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest2(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(2,1);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest3(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(1,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest4(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(6,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest5(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(5,5);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest6(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
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
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(6,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasWon();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest8(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(3,2);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest9(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest10(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(4,3);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void checkRollTest11(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(2,6);

        // Act
        bet.checkRoll(roll);
        Boolean actual = bet.hasLost();

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void payoutTest1(){
        // Arrange
        CrapsBet bet = new FieldBet(5);

        // Act
        Integer actual = bet.payout();

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void payoutTest2(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(1,1);
        Integer expected = 15;

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest3(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(6,6);
        Integer expected =15;

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest4(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(4,5);
        Integer expected = 10;

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest5(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(2,2);
        Integer expected = 10;

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest6(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        CrapsRoll roll = new CrapsRoll(3,3);

        // Act
        bet.checkRoll(roll);
        Integer actual = bet.payout();

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void printBetTest1(){
        // Arrange
        CrapsBet bet = new FieldBet(5);
        String expected = "Field bet for $5";

        // Act
        String actual = bet.printBet();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test public void printBetTest2(){
        // Arrange
        CrapsBet bet = new FieldBet(8);
        String expected = "Field bet for $8";

        // Act
        String actual = bet.printBet();

        // Assert
        Assert.assertEquals(expected, actual);
    }


}