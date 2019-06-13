package io.zipcoder.casino.craps;

public abstract class CrapsBet {

    private Integer value;

    public CrapsBet(Integer value){
        this.value = value;
    }

    abstract public Boolean hasLost();

    abstract public Boolean hasWon();

    abstract public Integer payout();

    abstract public void checkRoll(CrapsRoll roll);

    abstract public String printBet();

    abstract public BetType getType();

    public Integer getValue(){
        return value;
    }

    @Override
    public abstract boolean equals(Object o);

}


enum BetType{
    PASS, DONTPASS, FIELD;
}