package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Deck;
import io.zipcoder.casino.Hand;
import io.zipcoder.casino.Mediator;
import io.zipcoder.casino.Player;

public class GoFish {

    private GoFishMediator mediator;
    private Deck deck;
    private Hand hand;
    private GoFishPlayer player;

    public GoFish (){}

    /**
     * asks another player for the card you want but you have to have one of the numbers first
     */
    public void askCard (){}

    /**
     * if another player asks you for a card and you have it ... give it to them.
     */
    public void giveCard() {}

    /**
     * get the card from another player
     */

    public void receiveCard (){}

    /**
     * take card off hand
     */

    public void removeCard (){}

    /**
     * take card from card when the other player doesn't have the card you want
     * if the card from the deck matches the number you asked for ....another turn
     */

    public void takeFromDeck (){}

    /**
     * if you have 4 cards of the same number put them down...they called it a book on wiki
     */

    public void putCardsDown (){}

    /**
     * player with the most number of books after the deck runs out wins!
     */

    public void win (){}

    /**
     * if you didn't win you probably lost
     */
    public void lose () {}

    /**
     * if the player doesn't have the card println GO FISH
     */
    public void goFish (){}
    




}
