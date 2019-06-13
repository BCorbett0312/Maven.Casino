package io.zipcoder.casino.roulette;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.SpinGame;

public class Roulette extends SpinGame {


    private Chips chips;
    private Player player;

    /**
     *
     * @param player - player to check balance
     * @return - balance
     */
    public Integer checkBalance(Player player) {
        return null;
    }


    public Integer spin() { return null; }

    /**
     *
     * @return the bet the player has placed
     */
    public Integer bet (Player player) {
        return null;
    }

    /**
     *
     * @return the money that will be collected after the bet is placed
     */
    public Integer collectMoney(Player player) {
        return null;
    }

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
