package io.zipcoder.casino;

import java.util.Comparator;

public class Card implements Comparable<Card> {

    private final CardSuit suit;
    private final CardValue value;
    private Integer numValue;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }


    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    public Integer aceValue(Integer num) { return null; }

    public Integer getBlackJackValue(Card cardToEvaluate) {
        switch (cardToEvaluate.value){
            case JOKER:
                numValue = 0;
                break;
            case ACE:
                numValue = 1;
                break;
            case TWO:
                numValue = 2;
                break;
            case THREE:
                numValue = 3;
                break;
            case FOUR:
                numValue = 4;
                break;
            case FIVE:
                numValue = 5;
                break;
            case SIX:
                numValue = 6;
                break;
            case SEVEN:
                numValue = 7;
                break;
            case EIGHT:
                numValue = 8;
                break;
            case NINE:
                numValue = 9;
                break;
            case TEN:
                numValue = 10;
                break;
            case JACK:
                numValue = 11;
                break;
            case QUEEN:
                numValue = 12;
                break;
            case KING:
                numValue = 13;
                break;

        }
        return numValue;
    }


    public int compareTo(Card card) {
        return 0;
    }

    public int compareValueTo(Card card) { return 0; }

    public int compareSuitTo(Card card) { return 0; }

    @Override
    public String toString() {
        return valueToString() + suitToString(); }

    /**
     * Gets the string interpretation of the CardSuit
     * @return the string interpretation of the CardSuit
     */
    private String suitToString() {

        switch (suit) {
            case DIAMOND:
                return "DIAMONDS";

            case HEART:
                return "HEARTS";

            case CLUB:
                return "CLUBS";

            case SPADE:
                return "SPADES";

            default:
                return "";

        }

    }

    /**
     * Gets the string interpretation of the CardValue
     * @return the string interpretation of the CardValue
     */
    private String valueToString() {

        switch(value) {
            case ACE:
                return "ACE OF ";

            case TWO:
                return "TWO OF ";

            case THREE:
                return "THREE OF ";

            case FOUR:
                return "FOUR OF ";

            case FIVE:
                return "FIVE OF ";

            case SIX:
                return "SIX OF ";

            case SEVEN:
                return "SEVEN OF ";

            case EIGHT:
                return "EIGHT OF ";

            case NINE:
                return "NINE OF ";

            case TEN:
                return "TEN OF ";

            case JACK:
                return "JACK OF ";

            case QUEEN:
                return "QUEEN OF ";

            case KING:
                return "KING OF ";

            case JOKER:
                return "JOKER";

            default:
                return "";
        }
    }

}
