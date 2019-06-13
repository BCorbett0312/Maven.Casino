package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void nullConstructorTest(){
        Player thisPlayer = new Player();
        String expected = "Dealer";
        Integer expectedWallet = 0;

        assertEquals(expected, thisPlayer.getName());
        assertEquals(expectedWallet, thisPlayer.getMoney());


    }

    @Test
    public void constructorTest(){
        Player thisPlayer = new Player(500, "Bob");
        String expected = "Bob";
        Integer expectedWallet = 500;

        assertEquals(expected, thisPlayer.getName());
        assertEquals(expectedWallet, thisPlayer.getMoney());

    }


    @Test
    public void getMoney() {
        Player thisPlayer = new Player(null, null);
        Integer expected = null;
        assertEquals(expected, thisPlayer.getMoney());


    }

    @Test
    public void setMoney() {
        Player thisPlayer = new Player(null, null);
        assertTrue(thisPlayer.getMoney() == null);

        thisPlayer.setMoney(701);

        Integer expected = 701;

        assertEquals(expected, thisPlayer.getMoney());
    }

    @Test
    public void getName() {
        Player thisPlayer = new Player(null, "Evan");
        String expected = "Evan";

        assertEquals(expected, thisPlayer.getName());

    }

    @Test
    public void setName() {
        Player thisPlayer = new Player(null, null);
        assertTrue(thisPlayer.getName() == null);

        thisPlayer.setName("Clyde");

        String expected = "Clyde";

        assertEquals(expected, thisPlayer.getName());



    }
}