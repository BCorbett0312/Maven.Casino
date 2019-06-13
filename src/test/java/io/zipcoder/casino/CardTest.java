package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

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
}
