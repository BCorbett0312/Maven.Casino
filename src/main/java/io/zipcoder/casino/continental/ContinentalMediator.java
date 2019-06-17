package io.zipcoder.casino.continental;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.utilities.Console;

public class ContinentalMediator {

    private Console console;

    public ContinentalMediator(Console console) {
        this.console = console;
    }

    public static Boolean deckOrPileDraw(Console console) {
        Boolean valid = false;
        String input = "";
        while (valid) {

            input = console.getStringInput("Draw from the Deck of Pile?");
            input = input.toLowerCase();

            switch(input) {
                case "deck":
                    return true;

                case "pile":
                    return false;

                default:
                    console.println("Invalid input");
                    break;
            }
        }




        return null;
    }

    public static Card selectCard(Hand hand, Console console) {
        Boolean valid = false;

        while(valid) {
            Integer input = console.getIntegerInput("Select index of a Card to Discard");

            if((input >= 0) && (input < hand.size())) {
                return hand.removeByIndex(input);
            }
            else {
                console.println("Invalid input");
            }
        }


        return null;
    }

    public static void println(String string, Console console) {
        console.println(string);
    }
}
