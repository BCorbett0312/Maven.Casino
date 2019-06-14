package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSuit;
import io.zipcoder.casino.CardValue;
import io.zipcoder.casino.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

    @Test
    public void startBlackjack() {
    }

    @Test
    public void checkHand() {
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer gambler = new BlackjackPlayer(player);
        BlackjackPlayer dealer = new BlackjackPlayer();
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card2);

        dealer.hitForPlayer(card3);
        dealer.hitForPlayer(card4);
        dealer.hitForPlayer(card5);





    }



    @Test
    public void getNewDeck() {
    }

    @Test
    public void keepPlaying() {
    }

    @Test
    public void hitOrStay() {
    }

    @Test
    public void dealerTurn() {
    }

    @Test
    public void playerTurn() {
    }

    @Test
    public void doubleDown() {
    }

    @Test
    public void split() {
    }
}