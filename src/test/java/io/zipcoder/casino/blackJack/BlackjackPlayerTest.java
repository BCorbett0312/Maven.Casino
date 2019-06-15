package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardValue;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;
import org.junit.Test;


import static io.zipcoder.casino.CardSuit.*;
import static org.junit.Assert.*;


public class BlackjackPlayerTest {



    @Test
    public void BlackJackPlayerConstructorTest(){
        Player player1 = new Player(500, "Charles");
        BlackjackPlayer bjPlayer = new BlackjackPlayer(player1);

        String expected = "Charles";

        assertEquals(expected, bjPlayer.getPlayerName());


    }



    @Test
    public void BlackJackPlayerConstructorTest2(){
        Player player1 = new Player( null, null);
        BlackjackPlayer thisBJPlayer = new BlackjackPlayer(player1);

        String expected = null;
        Integer expectedWallet = null;

        assertEquals(expected, thisBJPlayer.getPlayerName());
        assertEquals(expectedWallet, thisBJPlayer.getWalletBalance());
    }


    @Test
    public void BlackJackPlayerDealerConstructorTest(){
        BlackjackPlayer bjPlayer = new BlackjackPlayer();
        String expectedName = "Dealer";
        Integer expectedWallet = 0;


        assertEquals(expectedWallet, bjPlayer.getWalletBalance());
        assertEquals(expectedName, bjPlayer.getPlayerName());
        assertTrue(bjPlayer.getHand().isEmpty());


    }


    @Test
    public void discardHandTest() {
        Card kHearts = new Card(HEART, CardValue.KING);
        Card jSpades = new Card(SPADE, CardValue.JACK);
        BlackjackPlayer player = new BlackjackPlayer();
        player.hitForPlayer(kHearts);
        player.hitForPlayer(jSpades);
        Hand testHand = player.getHand();

        assertFalse(testHand.isEmpty());

        player.discardHand();

        assertTrue(testHand.isEmpty());


    }

    @Test
    public void discardHandTest2(){
        Card card1 = new Card(HEART, CardValue.KING);
        Card card2 = new Card(SPADE, CardValue.JACK);
        Player testPlayer = new Player(300, "g");
        BlackjackPlayer player = new BlackjackPlayer(testPlayer);
        player.hitForSplitHand(card1);
        player.hitForSplitHand(card2);



        assertFalse(player.getSplitHand().isEmpty());

        player.discardHand();

        assertTrue(player.getSplitHand().isEmpty());

    }

    @Test
    public void hitForPlayerTest() {
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Player player1 = new Player(33, "Clive");
        BlackjackPlayer player = new BlackjackPlayer(player1);
        Hand myHand = player.getHand();

        assertTrue(myHand.isEmpty());
        player.hitForPlayer(jSpades);

        assertFalse(myHand.isEmpty());

    }

    @Test
    public void hitForPlayerTest2(){
        Card nullCard = new Card(null, null);
        Player player1 = new Player(33, "Clive");
        BlackjackPlayer player = new BlackjackPlayer(player1);
        Hand myHand = player.getHand();
        assertTrue(myHand.isEmpty());



        player.hitForPlayer(nullCard);
        assertFalse(myHand.isEmpty());
        assertEquals(1, myHand.size());
    }



    @Test
    public void hitForSplitHandTest(){
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Player player1 = new Player();
        BlackjackPlayer player = new BlackjackPlayer(player1);
        Hand myHand = player.getSplitHand();
        assertTrue(myHand.isEmpty());
        player.hitForSplitHand(jSpades);
        assertFalse(myHand.isEmpty());
    }

    @Test
    public void newSplitHand() {
        Player userPlayer = new Player(300, "George");
        BlackjackPlayer player1 = new BlackjackPlayer(userPlayer);
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Card jHearts = new Card(HEART, CardValue.JACK);
        player1.hitForPlayer(jSpades);
        player1.hitForPlayer(jHearts);

        player1.newSplitHand();

        Hand expectedHand1AfterSplit = player1.getHand();
        Hand expectedHand2AfterSplit = player1.getSplitHand();

        Card expected1 = jSpades;
        Card expected2 = jHearts;

        assertEquals(expected1, expectedHand1AfterSplit.getCardAtIndex(0));
        assertEquals(expected2, expectedHand2AfterSplit.getCardAtIndex(0));



    }

    @Test
    public void getHandValue1() {
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card card1 = new Card(SPADE, CardValue.JACK);
        Card card2 = new Card(HEART, CardValue.JACK);
        player1.hitForPlayer(card1);
        player1.hitForPlayer(card2);

        Integer expected = 20;

        assertEquals(expected, player1.getHandValue(player1.getHand()));
    }

    @Test
    public void getHandValueTest2(){
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card card1 = new Card(SPADE, CardValue.ACE);
        Card card2 = new Card(HEART, CardValue.ACE);
        player1.hitForPlayer(card1);
        player1.hitForPlayer(card2);

        Integer expected = 12;
        assertEquals(expected, player1.getHandValue(player1.getHand()));
    }

    @Test
    public void getHandValueTest3(){
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card card1 = new Card(CLUB, CardValue.KING);
        Card card2 = new Card(DIAMOND, CardValue.QUEEN);
        player1.hitForPlayer(card1);
        player1.hitForPlayer(card2);


        Integer expected = 20;
        assertEquals(expected, player1.getHandValue(player1.getHand()));

    }

    @Test
    public void getHandValueTest4(){
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card card1 = new Card(SPADE, CardValue.FIVE);
        Card card2 = new Card(HEART, CardValue.THREE);
        player1.hitForPlayer(card1);
        player1.hitForPlayer(card2);

        Integer expected = 8;
        assertEquals(expected, player1.getHandValue(player1.getHand()));
    }


    @Test
    public void getHandValueTest5(){
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card card1 = new Card(SPADE, CardValue.ACE);
        Card card2 = new Card(HEART, CardValue.FOUR);
        player1.hitForPlayer(card1);
        player1.hitForPlayer(card2);

        Integer expected = 15;

        assertEquals(expected, player1.getHandValue(player1.getHand()));
    }

    @Test
    public void bet() {
    }

    @Test
    public void getHand() {
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Player testPlayer = new Player(300, "Elroy");
        BlackjackPlayer player = new BlackjackPlayer(testPlayer);
        player.hitForPlayer(jSpades);
        Hand playerHand = player.getHand();
        assertEquals(playerHand, player.getHand());

    }



    @Test
    public void getSplitHandTest(){
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Card jHearts = new Card(HEART, CardValue.JACK);
        Player player1 = new Player (null, "Gregory");
        BlackjackPlayer player = new BlackjackPlayer(player1);
        player.hitForSplitHand(jSpades);
        player.hitForSplitHand(jHearts);
        Hand playerSplitHand = player.getSplitHand();
        assertEquals(playerSplitHand, player.getSplitHand());
    }

    @Test
    public void bet1() {
        BlackjackPlayer player1 = new BlackjackPlayer();
        assertNull(player1.bet());
    }

    @Test
    public void bet2() {
        Player thisPlayer = new Player(600, "Ben");
        BlackjackPlayer test = new BlackjackPlayer(thisPlayer);

        Integer toBet = 200;
        Integer expected = 400;
        test.bet(toBet);


        assertEquals(expected, test.getWalletBalance());

    }
}