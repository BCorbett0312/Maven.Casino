package io.zipcoder.casino.craps;

public interface CrapsBet {

    public Boolean hasLost();


    public Boolean hasWon();

    abstract public Integer payout();

    abstract public void checkRoll(CrapsRoll roll);

}
