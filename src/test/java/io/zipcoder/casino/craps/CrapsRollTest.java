package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsRollTest {

    @Test
    public void getValueTest1(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(6,6);
        Integer expected = 12;

        // Act
        Integer actual = roll.getValue();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest2(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(3,4);
        Integer expected = 7;

        // Act
        Integer actual = roll.getValue();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest3(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(1,1);
        Integer expected = 2;

        // Act
        Integer actual = roll.getValue();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest4(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(3,2);
        Integer expected = 5;

        // Act
        Integer actual = roll.getValue();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest1(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(6,6);
        String expected = "6, 6";

        // Act
        String actual = roll.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest2(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(3,4);
        String expected = "3, 4";

        // Act
        String actual = roll.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest3(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(1,1);
        String expected = "1, 1";

        // Act
        String actual = roll.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest4(){
        // Arrange
        CrapsRoll roll = new CrapsRoll(3,2);
        String expected = "3, 2";

        // Act
        String actual = roll.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

}