package io.zipcoder.casino.craps;

public class PassBet extends CrapsBet {
    private CrapsRoll point;

    public PassBet(Integer value){
        super(value);
    }

    public Integer payOut() {
        return null;
    }

    public void checkRoll(CrapsRoll roll){

    }


}
