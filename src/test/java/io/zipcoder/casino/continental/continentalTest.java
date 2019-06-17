package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSuit;
import io.zipcoder.casino.CardValue;
import io.zipcoder.casino.Hand;
import org.junit.Assert;
import org.junit.Test;

public class continentalTest {

    @Test
    public void dealTest1() {

        //Given
        Continental continental = new Continental();
        continental.deal();
        ContinentalPlayer player = continental.getPlayer();
        Hand playerHand = player.getHand();
        Hand computerHand = continental.getComputer();

        //When
        Integer expected = 6;
        Integer playerSize = playerHand.size();
        Integer computerSize = computerHand.size();

        //Then
        Assert.assertEquals(expected, playerSize);
        Assert.assertEquals(expected, computerSize);

    }

    @Test
    public void dealTest2() {

        //Given
        Continental continental = new Continental();
        continental.deal();
        ContinentalPlayer player = continental.getPlayer();
        Hand playerHand = player.getHand();
        Hand computerHand = continental.getComputer();

        //When
        Integer expected = 6;
        Integer playerSize = playerHand.size();
        Integer computerSize = computerHand.size();

        //Then
        Assert.assertEquals(expected, playerSize);
        Assert.assertEquals(expected, computerSize);

    }

    @Test
    public void dealTest3() {

        //Given
        Continental continental = new Continental();
        continental.deal();
        ContinentalPlayer player = continental.getPlayer();
        Hand playerHand = player.getHand();
        Hand computerHand = continental.getComputer();

        //When
        Integer expected = 6;
        Integer playerSize = playerHand.size();
        Integer computerSize = computerHand.size();

        //Then
        Assert.assertEquals(expected, playerSize);
        Assert.assertEquals(expected, computerSize);

    }

    @Test
    public void drawFromDeckTest1() {

        //Given
        Continental continental = new Continental();
        ContinentalPlayer player = continental.getPlayer();
        Hand playerHand = player.getHand();
        playerHand.add(continental.drawFromDeck());


        //When
        Integer expected = 1;
        Integer playerSize = playerHand.size();


        //Then
        Assert.assertEquals(expected, playerSize);


    }

    @Test
    public void drawFromDeckTest2() {

        //Given
        Continental continental = new Continental();
        ContinentalPlayer player = continental.getPlayer();
        Hand playerHand = player.getHand();
        playerHand.add(continental.drawFromDeck());
        playerHand.add(continental.drawFromDeck());
        playerHand.add(continental.drawFromDeck());
        playerHand.add(continental.drawFromDeck());
        playerHand.add(continental.drawFromDeck());


        //When
        Integer expected = 5;
        Integer playerSize = playerHand.size();


        //Then
        Assert.assertEquals(expected, playerSize);

    }

    @Test
    public void pileTest1() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.SPADE, CardValue.THREE);
        continental.discard(card);


        //When
        Card expected = card;
        Card actual = continental.drawFromPile();


        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void pileTest2() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.NONE, CardValue.JOKER);
        continental.discard(card);


        //When
        Card expected = card;
        Card actual = continental.drawFromPile();


        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void pileTest3() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.HEART, CardValue.KING);
        continental.discard(card);


        //When
        Card expected = card;
        Card actual = continental.drawFromPile();


        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void displayPileTest1() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.HEART, CardValue.KING);
        continental.discard(card);


        //When
        String expected = card.toString();
        String actual = continental.showTopCardOnPile();


        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void displayPileTest2() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.SPADE, CardValue.KING);
        continental.discard(card);


        //When
        String expected = card.toString();
        String actual = continental.showTopCardOnPile();


        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void displayPileTest3() {

        //Given
        Continental continental = new Continental();
        Card card = new Card(CardSuit.DIAMOND, CardValue.FIVE);
        continental.discard(card);


        //When
        String expected = card.toString();
        String actual = continental.showTopCardOnPile();


        //Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void isThreeOfAKindTest1() {

        //Given
        Continental continental = new Continental();
        Card card1 = new Card(CardSuit.HEART, CardValue.EIGHT);
        Card card2 = new Card(CardSuit.SPADE, CardValue.EIGHT);
        Card card3 = new Card(CardSuit.DIAMOND, CardValue.EIGHT);

        //Then
        Assert.assertTrue(continental.isThreeOfAKind(card1, card2, card3));

    }

    @Test
    public void isThreeOFAKindTest2() {

        //Given
        Continental continental = new Continental();
        Card card1 = new Card(CardSuit.HEART, CardValue.EIGHT);
        Card card2 = new Card(CardSuit.SPADE, CardValue.TEN);
        Card card3 = new Card(CardSuit.DIAMOND, CardValue.ACE);

        //Then
        Assert.assertFalse(continental.isThreeOfAKind(card1, card2, card3));

    }

    @Test
    public void isThreeOfAKindTest3() {

        //Given
        Continental continental = new Continental();
        Card card1 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card2 = new Card(CardSuit.SPADE, CardValue.ACE);
        Card card3 = new Card(CardSuit.DIAMOND, CardValue.ACE);

        //Then
        Assert.assertTrue(continental.isThreeOfAKind(card1, card2, card3));

    }

    @Test
    public void isThreeOfAKindTest4() {

        //Given
        Continental continental = new Continental();
        Card card1 = new Card(CardSuit.HEART, CardValue.ACE);
        Card card2 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card card3 = new Card(CardSuit.DIAMOND, CardValue.ACE);

        //Then
        Assert.assertTrue(continental.isThreeOfAKind(card1, card2, card3));

    }

    @Test
    public void isThreeOfAKindTest5() {

        //Given
        Continental continental = new Continental();
        Card card1 = new Card(CardSuit.NONE, CardValue.JOKER);
        Card card2 = new Card(CardSuit.SPADE, CardValue.JACK);
        Card card3 = new Card(CardSuit.SPADE, CardValue.TWO);

        //Then
        Assert.assertFalse(continental.isThreeOfAKind(card1, card2, card3));

    }

    @Test
    public void isStraightTest3() {

    }

    @Test
    public void displaySetTest1() {

    }

    @Test
    public void displaySetTest2() {

    }

    @Test
    public void displaySetTest3() {

    }

}
