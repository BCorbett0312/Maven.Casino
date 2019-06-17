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

    //    @Test
//    public void checkBooksTest () {
//        Player player = new Player();
//        GoFishPlayer playerA = new GoFishPlayer(player);
//
//        Card card = new Card(CardSuit.SPADE, CardValue.TWO);
//        Card card1 = new Card(CardSuit.CLUB,CardValue.THREE);
//        Card card2= new Card(CardSuit.SPADE,CardValue.THREE);
//        Card card3=new Card(CardSuit.DIAMOND,CardValue.THREE);
//        Card card4 = new Card(CardSuit.HEART,CardValue.THREE);
//
//        Hand handPlayerA = new Hand ();
//        handPlayerA.add(card);
//        handPlayerA.add(card1);
//        handPlayerA.add(card2);
//        handPlayerA.add(card3);
//        handPlayerA.add(card4);
//
//        Integer expected = 1;
//        Integer actual = handPlayerA.checkBooks();
//
//        Assert.assertEquals(expected,actual);
//
//    }

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