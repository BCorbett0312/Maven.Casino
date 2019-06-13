package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void drawTest1() {

        //Given
        Card card = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Deck deck = new Deck(card);

        //When
        Card expected = card;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawTest2() {

        //Given
        Card card = new Card(CardSuit.HEART, CardValue.QUEEN);
        Deck deck = new Deck(card);

        //When
        Card expected = card;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawTest3() {

        //Given
        Card card = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Deck deck = new Deck(card);

        //When
        Card expected = card;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawTest4() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Card card2 = new Card(CardSuit.HEART, CardValue.QUEEN);
        Card card3 = new Card(CardSuit.SPADE, CardValue.EIGHT);

        Deck deck = new Deck();
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);


        //When
        Card expected = card3;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawTest5() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Card card2 = new Card(CardSuit.HEART, CardValue.QUEEN);
        Card card3 = new Card(CardSuit.SPADE, CardValue.EIGHT);

        Deck deck = new Deck();
        deck.add(card3);
        deck.add(card2);
        deck.add(card3);
        deck.add(card1);


        //When
        Card expected = card1;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addTest1() {

        //Given
        Card card = new Card(CardSuit.DIAMOND, CardValue.FIVE);
        Deck deck = new Deck();
        deck.add(card);

        //When
        Card expected = card;
        Card actual = deck.draw();

        //Then
        Assert.assertEquals(expected, actual);



    }

    @Test
    public void addMultipleTest1() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.KING);
        Card card3 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card card4 = new Card(CardSuit.DIAMOND, CardValue.NINE);
        Card[] cards = {card1, card2, card3, card4};

        Deck deck = new Deck();
        deck.add(cards);

        //When
        Card[] expected = cards;
        Card[] actual = deck.toArray();

        Assert.assertArrayEquals(expected, actual);


    }

    @Test
    public void addMultipleTest2() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.KING);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.DIAMOND, CardValue.ACE);
        Card card4 = new Card(CardSuit.DIAMOND, CardValue.QUEEN);
        Card[] cards = {card1, card2, card3, card4};

        Deck deck = new Deck();
        deck.add(cards);

        //When
        Card[] expected = cards;
        Card[] actual = deck.toArray();

        Assert.assertArrayEquals(expected, actual);


    }

    @Test
    public void addMultipleTest3() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.FIVE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card4 = new Card(CardSuit.CLUB, CardValue.THREE);
        Card card5 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);

        //When
        Card[] expected = cards;
        Card[] actual = deck.toArray();

        //Then
        Assert.assertArrayEquals(expected, actual);


    }

    @Test
    public void shuffleTest1() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.FIVE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card4 = new Card(CardSuit.CLUB, CardValue.THREE);
        Card card5 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);
        deck.shuffleDeck();

        //When
        Card[] original = cards;
        Card[] actual = deck.toArray();

        //Then
        Assert.assertFalse(assertArraysDoNotEqual(original, actual));


    }

    @Test
    public void shuffleTest2() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.FIVE);
        Card card2 = new Card(CardSuit.HEART, CardValue.EIGHT);
        Card card3 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card4 = new Card(CardSuit.CLUB, CardValue.JACK);
        Card card5 = new Card(CardSuit.DIAMOND, CardValue.KING);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);
        deck.shuffleDeck();

        //When
        Card[] original = cards;
        Card[] actual = deck.toArray();

        //Then
        Assert.assertFalse(assertArraysDoNotEqual(original, actual));


    }

    @Test
    public void shuffleTest3() {

        //Given
        Card card1 = new Card(CardSuit.CLUB, CardValue.SIX);
        Card card2 = new Card(CardSuit.SPADE, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.SPADE, CardValue.TWO);
        Card card4 = new Card(CardSuit.CLUB, CardValue.KING);
        Card card5 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);
        deck.shuffleDeck();

        //When
        Card[] original = cards;
        Card[] actual = deck.toArray();

        //Then
        Assert.assertFalse(assertArraysDoNotEqual(original, actual));


    }

    @Test
    public void clearTest1() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.FIVE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card4 = new Card(CardSuit.CLUB, CardValue.THREE);
        Card card5 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);
        deck.clear();

        //When
        Card[] expected = {};
        Card[] actual = deck.toArray();

        //Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void clearTest2() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.FIVE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card4 = new Card(CardSuit.CLUB, CardValue.THREE);
        Card card5 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card[] cards = {card1, card2, card3, card4, card5};

        Deck deck = new Deck();
        deck.add(cards);
        deck.clear();

        //When
        Card[] expected = {};
        Card[] actual = deck.toArray();

        //Then
        Assert.assertArrayEquals(expected, actual);
    }

    public Boolean assertArraysDoNotEqual(Card[] cards1, Card[] cards2) {

        if(cards1.length == cards2.length) {
            for(int i = 0; i < cards1.length; i ++) {
                if(!cards1[i].equals(cards2[i])) return false;
            }
        }
        else {
            return false;
        }

        return true;
    }
}
