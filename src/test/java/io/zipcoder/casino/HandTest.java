package io.zipcoder.casino;

import org.junit.Test;



import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void getCards() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        Card[] expected = new Card[3];
        expected[0] = card1;
        expected[1] = card2;
        expected[2] = card3;

        assertArrayEquals(expected, testHand.getCards());




    }

    @Test
    public void indexOf() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);


        Integer expected = 2;

        assertEquals(expected, testHand.indexOf(card3));

    }

    @Test
    public void removeByCard() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        assertEquals(3, testHand.size());

        testHand.removeByCard(card2);

        assertEquals(2, testHand.size());
        assertFalse(testHand.contains(card2));



    }

    @Test
    public void removeByIndex() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);


        assertEquals(3, testHand.size());

        testHand.removeByIndex(1);

        assertEquals(2, testHand.size());
        assertFalse(testHand.contains(card2));
    }

    @Test
    public void getCardAtIndex() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        assertEquals(3, testHand.size());


        assertSame(card2, testHand.getCardAtIndex(1));
        assertSame(card1, testHand.getCardAtIndex(0));
        assertSame(card3, testHand.getCardAtIndex(2));

    }

    @Test
    public void getValueAtIndex() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);


        assertEquals(CardValue.KING, testHand.getValueAtIndex(0));
        assertEquals(CardValue.FOUR, testHand.getValueAtIndex(1));
        assertEquals(CardValue.EIGHT, testHand.getValueAtIndex(2));

    }

    @Test
    public void getSuitAtIndex() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        assertEquals(CardSuit.SPADE, testHand.getSuitAtIndex(0));
        assertEquals(CardSuit.DIAMOND, testHand.getSuitAtIndex(1));
        assertEquals(CardSuit.CLUB, testHand.getSuitAtIndex(2));
    }

    @Test
    public void contains() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Hand testHand = new Hand(card1, card2, card3);

        assertTrue(testHand.contains(card1));
        assertTrue(testHand.contains(card2));
        assertTrue(testHand.contains(card3));
        assertFalse(testHand.contains(card4));
    }

    @Test
    public void add() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Card card4 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card5 = new Card(CardSuit.HEART, CardValue.ACE);
        Hand testHand = new Hand(card1, card2, card3);

        assertEquals(3, testHand.size());

        testHand.add(card4);

        assertEquals(4, testHand.size());

        testHand.add(card5);

        assertEquals(5, testHand.size());


    }

    @Test
    public void add2(){
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);

        Hand testHand = new Hand();

        assertEquals(0, testHand.size());

        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);

        assertEquals(3, testHand.size());

    }

    @Test
    public void isEmpty() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        assertFalse(testHand.isEmpty());

    }

    @Test
    public void isEmpty2(){
        Hand testHand = new Hand();

        assertTrue(testHand.isEmpty());
    }

    @Test
    public void clear() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);

        assertFalse(testHand.isEmpty());


        testHand.clear();

        assertTrue(testHand.isEmpty());

    }

    @Test
    public void size() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);


        assertEquals(3, testHand.size());



    }

    @Test
    public void toString1() {
        Card card1 = new Card (CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card( CardSuit.DIAMOND, CardValue.FOUR);
        Card card3 = new Card(CardSuit.CLUB, CardValue.EIGHT);
        Hand testHand = new Hand(card1, card2, card3);
    }
}