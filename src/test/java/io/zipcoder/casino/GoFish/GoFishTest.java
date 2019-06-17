package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deal() {
        Deck deck = new Deck();

        Player player = new Player ();

        GoFishPlayer playerA = new GoFishPlayer(player);
        GoFish game = new GoFish(playerA);

        game.deal();

        Integer expected =7;
        Integer actual = (playerA.getHand()).size();


        Assert.assertEquals(expected,actual);
    }




}