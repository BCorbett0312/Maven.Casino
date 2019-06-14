package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardValue;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Player;
import org.junit.Test;



import static io.zipcoder.casino.CardSuit.HEART;
import static io.zipcoder.casino.CardSuit.SPADE;
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
    public void getHandValue() {
        Player genPlayer = new Player(500, "Edward");
        BlackjackPlayer player1 = new BlackjackPlayer(genPlayer);
        Card jSpades = new Card(SPADE, CardValue.JACK);
        Card jHearts = new Card(HEART, CardValue.JACK);
        player1.hitForPlayer(jSpades);
        player1.hitForPlayer(jHearts);


        Integer expected = 20;

        assertEquals(expected, player1.getHandValue());
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
        player.hitForPlayer(jSpades);
        player.hitForPlayer(jHearts);
        Hand playerSplitHand = player.getSplitHand();
        assertEquals(playerSplitHand, player.getSplitHand());
    }
}