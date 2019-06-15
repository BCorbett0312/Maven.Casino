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

        BlackjackPlayer dealer = new BlackjackPlayer();
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

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




//    @Test
//    public void checkBlackJackOnSplit1(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card1);
//        gambler.hitForSplitHand(card5);
//
//        assertTrue(table.checkBlackJackOnSplit());
//
//    }


//    @Test
//    public void checkBlackJackOnSplit2(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card5);
//
//        assertFalse(table.checkBlackJackOnSplit());
//
//    }


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

        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);

        BlackjackPlayer gambler = table.getGambler();

        gambler.hitForPlayer(card2);
        gambler.hitForPlayer(card4);

        assertTrue(table.playerCanDouble());
    }


//    @Test
//    public void playerCanDoubleSplitTest1(){
//        Player player = new Player(0, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card2);
//
//        assertTrue(table.playerCanDoubleSplit());
//    }

//    @Test
//    public void playerCanDoubleSplitTest2(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card3);
//
//        assertTrue(table.playerCanDoubleSplit());
//    }


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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
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


//    @Test
//    public void checkSplitBustTest1(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card1);
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card1);
//
//        assertTrue(table.checkBustSplit(gambler));
//    }

//    @Test
//    public void checkSplitBustTest2(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//
//        BlackjackPlayer gambler = table.getGambler();
//
//
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card2);
//        gambler.hitForSplitHand(card2);
//
//        assertFalse(table.checkBustSplit(gambler));
//    }



    @Test
    public void determineWinnerAfterDealTest1(){
        Player player = new Player(500, "Testy McTesterFace");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

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
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        table.setInitialBet(500);

        BlackjackPlayer gambler = table.getGambler();

        Integer expected= 1000;


        gambler.hitForPlayer(card1);
        gambler.hitForPlayer(card5);

        table.determineIfWinnerAfterDeal();

        assertEquals(expected, table.getEndGameState());

    }




//    @Test
//    public void determineIfPlayerCanSplitTest1(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        gambler.hitForPlayer(card1);
//        gambler.hitForPlayer(card1);
//
//        assertTrue(table.playerCanSplit());
//
//    }

//    @Test
//    public void determineIfPlayerCanSplitTest2(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        gambler.hitForPlayer(card1);
//        gambler.hitForPlayer(card2);
//
//        assertFalse(table.playerCanSplit());
//
//    }

//    @Test
//    public void determineIfPlayerCanSplitTest3(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        gambler.hitForPlayer(card5);
//        gambler.hitForPlayer(card5);
//
//        assertTrue(table.playerCanSplit());
//
//    }
//
//    @Test
//    public void determineIfPlayerCanSplitTest4(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        gambler.hitForPlayer(card4);
//        gambler.hitForPlayer(card3);
//
//        assertFalse(table.playerCanSplit());
//
//    }

//    @Test
//    public void determineIfPlayerCanSplitTest5(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        gambler.hitForPlayer(card3);
//        gambler.hitForPlayer(card3);
//
//        assertTrue(table.playerCanSplit());
//
//    }




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

//    @Test
//    public void checkWinnerTest1(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card1);
//        dealerHand.add(card3);
//
//        gamblerHand.add(card2);
//
//        String expected = "The Dealer Wins";
//
//        assertEquals(expected, table.checkWinner());
//
//    }

//    @Test
//    public void checkWinnerTest2(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//
//        Hand gamblerHand = gambler.getHand();
//
//        Hand dealerHand = dealer.getHand();
//
//        gamblerHand.add(card1);
//        gamblerHand.add(card3);
//
//        dealerHand.add(card2);
//
//        String expected = "You Win";
//
//        assertEquals(expected, table.checkWinner());
//    }


//    @Test
//    public void checkWinnerTest3(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card1);
//        dealerHand.add(card3);
//
//        gamblerHand.add(card2);
//
//        gamblerSplit.add(card4);
//
//        String expected = "You lost both hands";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//
//    @Test
//    public void checkWinnerTest4(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        table.setBust(false);
//        table.setDealerBust(false);
////        table.setBustSplit(false);
//
//
//        Hand gamblerHand = gambler.getHand();
//
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card1);
//        gamblerHand.add(card1);
//
//
//        String expected = "You Push";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//    @Test
//    public void checkWinnerTest5(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//
//        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card4);
//        gamblerSplit.add(card3);
//
//        gamblerHand.add(card2);
//
//        String expected = "You won both hands";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//    @Test
//    public void checkWinnerTest6(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card3);
//        gamblerHand.add(card4);
//        gamblerSplit.add(card1);
//
//        String expected = "You lost one hand and won the other";
//
//        assertEquals(expected, table.checkWinner());
//
//    }
//
//    @Test
//    public void checkWinnerTest6inverse(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
//
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card3);
//        gamblerSplit.add(card4);
//        gamblerHand.add(card1);
//
//        String expected = "You lost one hand and won the other";
//
//        assertEquals(expected, table.checkWinner());
//
//    }
//
//
//
//    @Test
//    public void checkWinnerTest7(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//
//        gamblerHand.add(card1);
//        dealerHand.add(card1);
//        gamblerSplit.add(card3);
//
//        String expected = "You tied with one hand and lost the other.";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//    @Test
//    public void checkWinnerTest7Inverse(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//
//        gamblerSplit.add(card1);
//        dealerHand.add(card1);
//        gamblerHand.add(card3);
//
//        String expected = "You tied with one hand and lost the other.";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//
//
//
//    @Test
//    public void checkWinnerTest8(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//        table.setBust(false);
//        table.setDealerBust(false);
//        table.setBustSplit(false);
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card1);
//        gamblerHand.add(card1);
//        gamblerSplit.add(card5);
//
//        String expected = "You tied with one hand and won the other.";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//    @Test
//    public void checkWinnerTest8inverse(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        dealerHand.add(card1);
//        gamblerSplit.add(card1);
//        gamblerHand.add(card5);
//
//        String expected = "You tied with one hand and won the other.";
//
//        assertEquals(expected, table.checkWinner());
//    }
//
//
//
//    @Test
//    public void checkWinnerTest9(){
//        Player player = new Player(500, "Testy McTesterFace");
//        Blackjack table = new Blackjack(player);
//        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
//
//        BlackjackPlayer dealer = table.getDealer();
//        BlackjackPlayer gambler = table.getGambler();
//
//        Hand gamblerHand = gambler.getHand();
//        Hand gamblerSplit = gambler.getSplitHand();
//        Hand dealerHand = dealer.getHand();
//
//        gamblerHand.add(card1);
//        dealerHand.add(card1);
//        gamblerSplit.add(card1);
//    }

    @Test
    public void displayTableTest(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

        BlackjackPlayer gambler = table.getGambler();

        gambler.hitForPlayer(card1);

        String expected = "Your hand is as follows KING OF SPADES\n" +
                " and the current count is 10";


        assertEquals(expected, table.displayTable());



    }

    @Test
    public void displayTableTest2(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);

        BlackjackPlayer gambler = table.getGambler();

        gambler.hitForPlayer(card1);
        gambler.hitForSplitHand(card1);

        String expected = "Your hand is as follows KING OF SPADES\n" +
                " and the current count is 10\n" +
                " Your split hand is as follows KING OF SPADES\n" +
                " and the current count is 10";


        assertEquals(expected, table.displayTable());
    }

//    @Test
//    public void payOut(){
//        Player player = new Player (400, "testy");
//        Blackjack table = new Blackjack(player);
//        table.setEndGameState(0);
//        Integer expected = 400;
//
//        assertEquals(expected, table.payOut());
//    }

    @Test
    public void payOutNull(){
        Player player = new Player (400, "testy");
        Blackjack table = new Blackjack(player);
        table.setEndGameState(0);
        Integer expected = 400;

        assertNull(table.payOut(400));

    }

}