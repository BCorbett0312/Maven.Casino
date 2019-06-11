package io.zipcoder.casino.craps;

public abstract class CrapsBet {
    private Integer value;
    private Boolean wonBet;
    private Boolean lostBet;;

    protected CrapsBet(Integer value){

    }

    public Boolean hasLost(){
        return null;
    }

    public Boolean hasWon(){
        return null;
    }

    protected void setWonBet(){

    }

    protected void setLostBet(){

    }

    abstract public Integer payOut();
    public abstract void checkRoll(CrapsRoll roll);

}
