package io.zipcoder.casino.craps;

public interface CrapsBet {

    Boolean hasLost();


    Boolean hasWon();

    Integer payout();

    void checkRoll(CrapsRoll roll);

    String printBet();

}
