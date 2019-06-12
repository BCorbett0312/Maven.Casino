package io.zipcoder.casino.craps;


public class DontPassBet extends CrapsBet {


    public DontPassBet(Integer value){
        super(value);
    }

    public Integer payOut() {
        return null;
    }

    public void checkRoll(CrapsRoll roll) {

    }


}
