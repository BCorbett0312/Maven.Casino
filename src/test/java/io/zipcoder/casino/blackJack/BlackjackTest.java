package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

    @Test
    public void startBlackjack() {
    }

    @Test
    public void checkBlackJackTest() {
        Player player = new Player(500, "Testy McTesterFace");
        BlackjackPlayer gambler = new BlackjackPlayer(player);
        BlackjackPlayer dealer = new BlackjackPlayer();
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Blackjack table = new Blackjack(player);

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);



        assertTrue(table.checkBlackJack(gambler));

    }


    @Test
    public void getNewDeck() {




    }

    @Test
    public void keepPlaying() {
        Boolean test = true;
        Boolean test2 = false;





    }

    @Test
    public void hitOrStay() {



    }

    @Test
    public void dealerTurn() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();


        //dealer.hitForPlayer();




    }

    @Test
    public void dealerActionSelectionTest(){
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.EIGHT);
        Card card5 = new Card(CardSuit.HEART, CardValue.TEN);
        Hand testHand = new Hand (card2, card5);
        Player testPlayer = new Player();
        Blackjack table = new Blackjack(testPlayer);


        Integer expected = 2;

        assertEquals(expected, table.dealerActionSelection(testHand));



    }

    @Test
    public void dealerActionSelectionTest2(){
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Hand testHand = new Hand (card2, card5);
        Player testPlayer = new Player();
        Blackjack table = new Blackjack(testPlayer);


        Integer expected = 1;

        assertEquals(expected, table.dealerActionSelection(testHand));

    }


    @Test
    public void dealerActionSelectionTest3(){
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand (card1, card2, card3);
        Player testPlayer = new Player();
        Blackjack table = new Blackjack(testPlayer);


        Integer expected = 3;

        assertEquals(expected, table.dealerActionSelection(testHand));
    }

    @Test
    public void playerTurn() {


    }


    @Test
    public void determineWinnerAfterDealTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();
        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();


    }

    @Test
    public void determineWinnerAfterDealTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();
        dealer.hitForPlayer(card1);
        dealer.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();

    }

    @Test
    public void determineWinnerAfterDealTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();


    }

    @Test
    public void determineWinnerAfterDealTest4() {
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        table.determineIfWinnerAfterDeal();

    }


    @Test
    public void determineIfPlayerCanSplitTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card1);

        assertTrue(table.playerCanSplit());

    }

    @Test
    public void determineIfPlayerCanSplitTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card2);

        assertFalse(table.playerCanSplit());

    }

    @Test
    public void determineIfPlayerCanSplitTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card5);
        gambler.hitForPlayer(card5);

        assertTrue(table.playerCanSplit());

    }

    @Test
    public void determineIfPlayerCanSplitTest4(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card4);
        gambler.hitForPlayer(card3);

        assertFalse(table.playerCanSplit());

    }

    @Test
    public void determineIfPlayerCanSplitTest5(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);

        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand dealerHand = dealer.getHand();

        gambler.hitForPlayer(card3);
        gambler.hitForPlayer(card3);

        assertTrue(table.playerCanSplit());

    }



    @Test
    public void payOut() {
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

        assertEquals(expected, table.showInitialDeal());

    }

    @Test
    public void checkWinnerTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card1);
        dealerHand.add(card3);

        gamblerHand.add(card2);

        String expected = "The Dealer Wins";

        assertEquals(expected, table.checkWinner());



    }

    @Test
    public void checkWinnerTest2(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        gamblerHand.add(card1);
        gamblerHand.add(card3);

        dealerHand.add(card2);

        String expected = "You Win";

        assertEquals(expected, table.checkWinner());
    }


    @Test
    public void checkWinnerTest3(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card1);
        dealerHand.add(card3);

        gamblerHand.add(card2);

        gamblerSplit.add(card4);

        String expected = "You lost both hands";

        assertEquals(expected, table.checkWinner());
    }


    @Test
    public void checkWinnerTest4(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card1);
        gamblerHand.add(card1);


        String expected = "You Push";

        assertEquals(expected, table.checkWinner());
    }

    @Test
    public void checkWinnerTest5(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card4);
        gamblerSplit.add(card3);

        gamblerHand.add(card2);

        String expected = "You won both hands";

        assertEquals(expected, table.checkWinner());
    }

    @Test
    public void checkWinnerTest6(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card3);
        gamblerHand.add(card4);
        gamblerSplit.add(card1);

        String expected = "You lost one hand and won the other";

        assertEquals(expected, table.checkWinner());

    }

    @Test
    public void checkWinnerTest6inverse(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card3);
        gamblerSplit.add(card4);
        gamblerHand.add(card1);

        String expected = "You lost one hand and won the other";

        assertEquals(expected, table.checkWinner());

    }



    @Test
    public void checkWinnerTest7(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();


        gamblerHand.add(card1);
        dealerHand.add(card1);
        gamblerSplit.add(card3);

        String expected = "You tied with one hand and lost the other.";

        assertEquals(expected, table.checkWinner());
    }

    @Test
    public void checkWinnerTest7Inverse(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();


        gamblerSplit.add(card1);
        dealerHand.add(card1);
        gamblerHand.add(card3);

        String expected = "You tied with one hand and lost the other.";

        assertEquals(expected, table.checkWinner());
    }




    @Test
    public void checkWinnerTest8(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card1);
        gamblerHand.add(card1);
        gamblerSplit.add(card5);

        String expected = "You tied with one hand and won the other.";

        assertEquals(expected, table.checkWinner());
    }

    @Test
    public void checkWinnerTest8inverse(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        dealerHand.add(card1);
        gamblerSplit.add(card1);
        gamblerHand.add(card5);

        String expected = "You tied with one hand and won the other.";

        assertEquals(expected, table.checkWinner());
    }



    @Test
    public void checkWinnerTest9(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        BlackjackPlayer dealer = table.getDealer();
        BlackjackPlayer gambler = table.getGambler();

        Hand gamblerHand = gambler.getHand();
        Hand gamblerSplit = gambler.getSplitHand();
        Hand dealerHand = dealer.getHand();

        gamblerHand.add(card1);
        dealerHand.add(card1);
        gamblerSplit.add(card1);
    }

}