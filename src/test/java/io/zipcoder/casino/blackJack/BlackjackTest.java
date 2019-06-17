package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;
import org.junit.Test;

import static io.zipcoder.casino.CardSuit.SPADE;
import static io.zipcoder.casino.CardValue.THREE;
import static org.junit.Assert.*;

public class BlackjackTest {

    @Test
    public void startBlackjack() {
    }

    @Test
    public void checkBlackJackTest() {
        Player player = new Player(500, "Testy McTesterFace");

        BlackjackPlayer dealer = new BlackjackPlayer();
        Card card1 = new Card (SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Blackjack table = new Blackjack(player);

        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        assertTrue(table.checkBlackJack(dealer));

    }

    @Test
    public void checkBlackJackTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer dealer = new BlackjackPlayer();
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Blackjack table = new Blackjack(player);

        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card5);



        assertFalse(table.checkBlackJack(dealer));
    }


    @Test
    public void checkBlackJackTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer gambler = new BlackjackPlayer(player);


        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Blackjack table = new Blackjack(player);

        gambler.hitForPlayer(card5);
        gambler.hitForPlayer(card3);

        assertFalse(table.checkBlackJack(gambler));

    }

    @Test
    public void checkBlackJackTest4(){
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer gambler = new BlackjackPlayer(player);
        Card card1 = new Card (SPADE, CardValue.KING);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Blackjack table = new Blackjack(player);

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);



        assertTrue(table.checkBlackJack(gambler));

    }



    @Test
    public void playerCanDoubleTest1(){
        Player player = new Player(0, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);



        BlackjackPlayer gambler = table.getGambler();


        gambler.hitForPlayer(card2);
        gambler.hitForPlayer(card2);

        assertTrue(table.playerCanDouble());
    }

    @Test
    public void playerCanDoubleTest2(){
        Player player = new Player(100, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);

        Card card4 = new Card(CardSuit.HEART, THREE);

        BlackjackPlayer gambler = table.getGambler();

        gambler.hitForPlayer(card2);
        gambler.hitForPlayer(card4);

        assertTrue(table.playerCanDouble());
    }





    @Test
    public void dealerTurnTest(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();

        Hand dealerHand = dealer.getHand();


        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card5);

        table.dealerTurn();

        assertTrue(dealerHand.size()> 2);
    }

    @Test
    public void dealerTurnTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();


        Hand dealerHand = dealer.getHand();


        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        table.dealerTurn();

        assertTrue(dealerHand.size() == 2);
    }

    @Test
    public void dealerTurnTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);


        BlackjackPlayer dealer = table.getDealer();



        Hand dealerHand = dealer.getHand();


        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card1);

        table.dealerTurn();

        assertTrue(dealerHand.size() == 3);
    }


    @Test
    public void checkBustTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);

        BlackjackPlayer dealer = table.getDealer();




        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card1);

        assertTrue(table.checkBust(dealer));
    }

    @Test
    public void checkBustTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        BlackjackPlayer dealer = table.getDealer();


        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card2);
        dealer.hitForPlayer(card2);

        assertFalse(table.checkBust(dealer));
    }






    @Test
    public void determineWinnerAfterDealTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        table.setInitialBet(200);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Integer expected= 200;

        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();

        assertEquals(expected, table.getEndGameState());

    }

    @Test
    public void determineWinnerAfterDealTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        table.setInitialBet(200);

        Integer expected = 0;

        BlackjackPlayer dealer = table.getDealer();

        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();

        assertEquals(expected, table.getEndGameState());
    }

    @Test
    public void determineWinnerAfterDealTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        table.setInitialBet(500);

        BlackjackPlayer gambler = table.getGambler();

        Integer expected= 1000;


        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();

        assertEquals(expected, table.getEndGameState());

    }









    @Test
    public void hitTest(){
        Deck bjDeck = new DeckBuilder().addClubs().addDiamonds().addHearts().addSpades().build();
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer dealer = new BlackjackPlayer();

        Hand myHand = dealer.getHand();

        assertTrue(myHand.isEmpty());

        dealer.hitForPlayer(bjDeck.draw());

        assertFalse(myHand.isEmpty());


    }


    @Test
    public void dealInitialHandTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        assertTrue(gamblerHand.isEmpty());
        assertTrue(dealerHand.isEmpty());

        table.dealInitialHands();

        assertEquals(2, gamblerHand.size());
        assertEquals(2, dealerHand.size());
    }

    @Test
    public void dealInitialHandTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        assertTrue(gamblerHand.isEmpty());
        assertTrue(dealerHand.isEmpty());

        table.dealInitialHands();

        assertFalse(gamblerHand.isEmpty());
        assertFalse(dealerHand.isEmpty());
    }

    @Test
    public void showInitialDealTest(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        assertTrue(gamblerHand.isEmpty());
        assertTrue(dealerHand.isEmpty());

        table.dealInitialHands();

        assertEquals(2, gamblerHand.size());
        assertEquals(2, dealerHand.size());


        String expected = "The dealer is showing ";

        assertTrue(table.showInitialDeal().contains(expected));

    }



    @Test
    public void displayTableTest(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);

        BlackjackPlayer gambler = table.getGambler();
        BlackjackPlayer dealer = table.getDealer();

        gambler.hitForPlayer(card1);
        dealer.hitForPlayer(card1);

        String expected = "Your hand is as follows \n" +
                "KING OF SPADES\n" +
                " and the current count is 10\n" +
                "The Dealer is showing KING";


        assertEquals(expected, table.displayTable());



    }

    @Test
    public void displayTableTest2(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (SPADE, CardValue.KING);
        Card card2 = new Card (SPADE, THREE);

        BlackjackPlayer gambler = table.getGambler();
        BlackjackPlayer dealer = table.getDealer();

        gambler.hitForPlayer(card1);
        dealer.hitForPlayer(card2);


        String expected = "Your hand is as follows \n" +
                "KING OF SPADES\n" +
                " and the current count is 10\n" +
                "The Dealer is showing THREE";


        assertEquals(expected, table.displayTable());
    }



    @Test
    public void payOutNull(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        table.setEndGameState(0);
        Integer expected = 400;

        assertNull(table.payOut(400));

    }

}