package io.zipcoder.casino.craps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputResultTest {


    @Test
    public void constructorTest1(){
        // Arrange
        String expected = "Cathago delenda est";
        InputResult inRes = new InputResult(expected, false);

        // Act
        String actual = inRes.getPrintOut();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        // Arrange
        Boolean expected = true;
        InputResult inRes = new InputResult("Fides punica", expected);

        // Act
        Boolean actual = inRes.moveOn();

        // Assert
        Assert.assertEquals(expected, actual);
    }
}