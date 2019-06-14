package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import static org.junit.Assert.*;

public class CardTest {



    @Test
    public void toStringTest1() {

        //Given
        Card card = new Card(CardSuit.DIAMOND, CardValue.JACK);

        //When
        String expected = "JACK OF DIAMONDS";
        String actual = card.toString();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void toStringTest2() {

        //Given
        Card card = new Card(CardSuit.CLUB, CardValue.EIGHT);

        //When
        String expected = "EIGHT OF CLUBS";
        String actual = card.toString();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void toStringTest3() {

        //Given
        Card card = new Card(CardSuit.HEART, CardValue.TWO);

        //When
        String expected = "TWO OF HEARTS";
        String actual = card.toString();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void toStringTest4() {

        //Given
        Card card = new Card(CardSuit.NONE, CardValue.JOKER);

        //When
        String expected = "JOKER";
        String actual = card.toString();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void toStringTest5() {

        //Given
        Card card = new Card(CardSuit.SPADE, CardValue.QUEEN);

        //When
        String expected = "QUEEN OF SPADES";
        String actual = card.toString();

        //Then
        Assert.assertEquals(expected, actual);
        
    }

    @Test
    public void compareValueTest1() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 0;
        Integer actual = card1.compareValueTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareValueTest2() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.TWO);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = -1;
        Integer actual = card1.compareValueTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareValueTest3() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.ACE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.FOUR);

        //When
        Integer expected = -3;
        Integer actual = card1.compareValueTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareValueTest4() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.FIVE);
        Card card2 = new Card(CardSuit.HEART, CardValue.FOUR);

        //When
        Integer expected = 1;
        Integer actual = card1.compareValueTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareValueTest5() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.TEN);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 7;
        Integer actual = card1.compareValueTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareSuitTest1() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 0;
        Integer actual = card1.compareSuitTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareSuitTest2() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card2 = new Card(CardSuit.HEART, CardValue.THREE);

        //When
        Integer expected = 0;
        Integer actual = card1.compareSuitTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareSuitTest3() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = -1;
        Integer actual = card1.compareSuitTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareSuitTest4() {

        //Given
        Card card1 = new Card(CardSuit.CLUB, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 1;
        Integer actual = card1.compareSuitTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareSuitTest5() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.THREE);

        //When
        Integer expected = 2;
        Integer actual = card1.compareSuitTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest1() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 0;
        Integer actual = card1.compareTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest2() {

        //Given
        Card card1 = new Card(CardSuit.DIAMOND, CardValue.NINE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = 6;
        Integer actual = card1.compareTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest3() {

        //Given
        Card card1 = new Card(CardSuit.HEART, CardValue.THREE);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = -13;
        Integer actual = card1.compareTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest4() {

        //Given
        Card card1 = new Card(CardSuit.SPADE, CardValue.TWO);
        Card card2 = new Card(CardSuit.DIAMOND, CardValue.THREE);

        //When
        Integer expected = -25;
        Integer actual = card1.compareTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void compareToTest5() {

        //Given
        Card card1 = new Card(CardSuit.CLUB, CardValue.TWO);
        Card card2 = new Card(CardSuit.HEART, CardValue.THREE);

        //When
        Integer expected = 27;
        Integer actual = card1.compareTo(card2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getBlackJackValueTest(){
        Card card1 = new Card (CardSuit.CLUB, CardValue.JACK);

        Card card2 = new Card (CardSuit.DIAMOND, CardValue.ACE);

        Card card3 = new Card (null, CardValue.JOKER);


        Integer expected1 = 11;
        Integer expected2 = 1;
        Integer expected3 = 0;

        assertEquals(expected1, card1.getBlackJackValue(card1));
        assertEquals(expected2, card2.getBlackJackValue(card2));
        assertEquals(expected3, card3.getBlackJackValue(card3));

    }
}
