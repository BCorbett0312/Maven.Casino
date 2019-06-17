package io.zipcoder.casino;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerOrder<T> {

    private Queue<T> order;

    public PlayerOrder() {
        order = new LinkedList<>();
    }

    public PlayerOrder(T player) {
        order = new LinkedList<>();
        order.add(player);
    }

    public PlayerOrder(T... players) {
        order = new LinkedList<>();
        for(T player : players) order.add(player);

    }

    /**
     * add player to the queue
     * @param player the player being added
     */
    public void addPlayer(T... player) {}

    /**
     * Goes to the next player in the order queue and sends the current player to the back
     */
    public void nextPlayer() {}

    public T getPlayer() {
        return null;
    }

    public T getPlayerAt(int position) {
        return null;
    }

    public Integer size() {
        return order.size();
    }

    public Boolean isEmpty() {
        return null;
    }
}
