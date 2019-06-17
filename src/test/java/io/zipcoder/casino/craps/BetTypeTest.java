package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BetTypeTest {

    @Test
    public void BetTypeToStringTest1(){
        // Arrange
        BetType type = BetType.PASS;
        String expected = "Pass Line";

        // Act
        String actual = type.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BetTypeToStringTest2(){
        // Arrange
        BetType type = BetType.DONTPASS;
        String expected = "Don't Pass";

        // Act
        String actual = type.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void BetTypeToStringTest3(){
        // Arrange
        BetType type = BetType.FIELD;
        String expected = "Field";

        // Act
        String actual = type.toString();

        // Assert
        Assert.assertEquals(expected, actual);
    }

}