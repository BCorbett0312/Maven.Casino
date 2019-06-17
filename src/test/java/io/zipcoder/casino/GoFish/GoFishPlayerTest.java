package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishPlayerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void gofishPlayerConstructorTest() {
        Player player = new Player(0,"Kris");
        GoFishPlayer gf = new GoFishPlayer(player);

        String expected = "Kris";
        String actual = gf.getPlayerName();

        Assert.assertEquals(expected,actual);
    }

}