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
    public void addSetTest1() {

        //Given
        DeckBuilder builder = new DeckBuilder().addSet();
        Deck deck = builder.build();

        //When
        Card[] expected = arrayOfSetOfCards();
        Card[] actual = deck.toArray();

        //Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void addMutipleSetsTest1(){

        //Given
        DeckBuilder builder = new DeckBuilder().addSet(2);
        Deck deck = builder.build();
        Card[] singleSet = arrayOfSetOfCards();
        Card[] doubleSet = new Card[singleSet.length * 2];


        //When

    }

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

    public Card[] arrayOfSetOfCards() {

        Card[] cards = {
                new Card(CardSuit.HEART, CardValue.ACE),
                new Card(CardSuit.HEART, CardValue.TWO),
                new Card(CardSuit.HEART, CardValue.THREE),
                new Card(CardSuit.HEART, CardValue.FOUR),
                new Card(CardSuit.HEART, CardValue.FIVE),
                new Card(CardSuit.HEART, CardValue.SIX),
                new Card(CardSuit.HEART, CardValue.SEVEN),
                new Card(CardSuit.HEART, CardValue.EIGHT),
                new Card(CardSuit.HEART, CardValue.NINE),
                new Card(CardSuit.HEART, CardValue.TEN),
                new Card(CardSuit.HEART, CardValue.JACK),
                new Card(CardSuit.HEART, CardValue.QUEEN),
                new Card(CardSuit.HEART, CardValue.KING),

                new Card(CardSuit.DIAMOND, CardValue.ACE),
                new Card(CardSuit.DIAMOND, CardValue.TWO),
                new Card(CardSuit.DIAMOND, CardValue.THREE),
                new Card(CardSuit.DIAMOND, CardValue.FOUR),
                new Card(CardSuit.DIAMOND, CardValue.FIVE),
                new Card(CardSuit.DIAMOND, CardValue.SIX),
                new Card(CardSuit.DIAMOND, CardValue.SEVEN),
                new Card(CardSuit.DIAMOND, CardValue.EIGHT),
                new Card(CardSuit.DIAMOND, CardValue.NINE),
                new Card(CardSuit.DIAMOND, CardValue.TEN),
                new Card(CardSuit.DIAMOND, CardValue.JACK),
                new Card(CardSuit.DIAMOND, CardValue.QUEEN),
                new Card(CardSuit.DIAMOND, CardValue.KING),

                new Card(CardSuit.CLUB, CardValue.ACE),
                new Card(CardSuit.CLUB, CardValue.TWO),
                new Card(CardSuit.CLUB, CardValue.THREE),
                new Card(CardSuit.CLUB, CardValue.FOUR),
                new Card(CardSuit.CLUB, CardValue.FIVE),
                new Card(CardSuit.CLUB, CardValue.SIX),
                new Card(CardSuit.CLUB, CardValue.SEVEN),
                new Card(CardSuit.CLUB, CardValue.EIGHT),
                new Card(CardSuit.CLUB, CardValue.TEN),
                new Card(CardSuit.CLUB, CardValue.NINE),
                new Card(CardSuit.CLUB, CardValue.JACK),
                new Card(CardSuit.CLUB, CardValue.QUEEN),
                new Card(CardSuit.CLUB, CardValue.KING),

                new Card(CardSuit.SPADE, CardValue.ACE),
                new Card(CardSuit.SPADE, CardValue.TWO),
                new Card(CardSuit.SPADE, CardValue.THREE),
                new Card(CardSuit.SPADE, CardValue.FOUR),
                new Card(CardSuit.SPADE, CardValue.FIVE),
                new Card(CardSuit.SPADE, CardValue.SIX),
                new Card(CardSuit.SPADE, CardValue.SEVEN),
                new Card(CardSuit.SPADE, CardValue.EIGHT),
                new Card(CardSuit.SPADE, CardValue.NINE),
                new Card(CardSuit.SPADE, CardValue.TEN),
                new Card(CardSuit.SPADE, CardValue.JACK),
                new Card(CardSuit.SPADE, CardValue.QUEEN),
                new Card(CardSuit.SPADE, CardValue.KING)
        };

        return cards;

    }

}
