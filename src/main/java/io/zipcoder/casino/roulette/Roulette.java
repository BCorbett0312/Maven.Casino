package io.zipcoder.casino.roulette;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.SpinGame;

public class Roulette extends SpinGame {

    private Chips chips;
    private Player player;

    // constructor
    public Roulette (Chips chips) {
        this.chips = chips;
    }
    // constructor
    public Roulette (Player player) {

        this.player = player;
    }


    public Integer getPlayerBalance() {

        return null;
    }


    public Integer spin() {

        return null;
    }

    /**
     *
     * @return the bet the player has placed
     */
    public Integer playerBet () {

        return null;
    }


//     * @return the money that will be collected after the bet is placed
//     */
//    public Integer collectPlayerMoney() {
//
//        return null;
//    }

    /**
     *
     *
     * @return if they continue game or not
     */
    public boolean continueGame() {

        return false;
    }

    /**
     *
     *
     * @return if they clear chips or not
     */
    public boolean clearchips() {

        return false;
    }









}
