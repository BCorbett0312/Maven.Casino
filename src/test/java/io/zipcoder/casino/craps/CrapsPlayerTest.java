package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void getMoneyTest(){
        // Arrange
        Integer expected = 10;
        Player p = new Player(expected, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);

        // Act
        Integer actual = cp.getMoney();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void placeBetTest1(){
        // Arrange
        Player p = new Player(10, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);

        // Act
        Boolean actual = cp.placeBet(20);

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void placeBetTest2(){
        // Arrange
        Player p = new Player(30, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);

        // Act
        Boolean actual = cp.placeBet(20);

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void placeBetTest3(){
        // Arrange
        Player p = new Player(30, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);
        Integer expected = 10;

        // Act
        cp.placeBet(20);
        Integer actual = cp.getMoney();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canBetTest1(){
        // Arrange
        Integer expected = 30;
        Player p = new Player(expected, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);

        // Act
        Boolean result = cp.canBet(20);
        Integer money = cp.getMoney();

        // Assert
        Assert.assertTrue(result);
        Assert.assertEquals(expected, money);
    }

    @Test
    public void canBetTest2(){
        // Arrange
        Integer expected = 30;
        Player p = new Player(expected, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);

        // Act
        Boolean result = cp.canBet(40);
        Integer money = cp.getMoney();

        // Assert
        Assert.assertFalse(result);
        Assert.assertEquals(expected, money);
    }

    @Test
    public void collectWinningsTest(){
        // Arrange
        Player p = new Player(10, "Sulla");
        CrapsPlayer cp = new CrapsPlayer(p);
        Integer expected = 30;

        // Act
        cp.collectWinnings(20);
        Integer actual = cp.getMoney();

        // Assert
        Assert.assertEquals(expected, actual);
    }


}