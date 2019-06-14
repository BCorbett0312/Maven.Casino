package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckBuilderTest {

    @Test
    public void isEmptyTest1() {

        //Given
        DeckBuilder builder = new DeckBuilder();

        //Then
        Assert.assertTrue(builder.isEmpty());

    }

    @Test
    public void isEmptyTest2() {

        //Given
        Deck deck = new Deck();
        deck.add(new Card(CardSuit.DIAMOND, CardValue.FIVE));

        DeckBuilder builder = new DeckBuilder(deck);

        //Then
        Assert.assertFalse(builder.isEmpty());

    }

    @Test
    public void clearTest1(){

        //Given
        Deck deck = new Deck();
        deck.add(new Card(CardSuit.DIAMOND, CardValue.FIVE));

        DeckBuilder builder = new DeckBuilder(deck);

        //When
        builder.clear();

        //Then
        Assert.assertTrue(builder.isEmpty());

    }

    @Test
    public void clearTest2(){

        //Given
        Deck deck = new Deck();
        deck.add(new Card(CardSuit.DIAMOND, CardValue.FIVE));
        deck.add(new Card(CardSuit.SPADE, CardValue.THREE));

        DeckBuilder builder = new DeckBuilder(deck);

        //When
        builder.clear();

        //Then
        Assert.assertTrue(builder.isEmpty());

    }

    @Test
    public void addSetTest1() {}

    @Test
    public void addMutipleSetsTest1(){}

    @Test
    public void addSetWithJokersTest1(){}

    @Test
    public void addMultipleSetsWithJokersTest1() {}

    @Test
    public void addJokerTest(){}

    @Test
    public void addHeartsTest(){}

    @Test
    public void addDiamondsTest() {}

    @Test
    public void addClubsTest() {}

    @Test
    public void addSpadesTest() {}


}
