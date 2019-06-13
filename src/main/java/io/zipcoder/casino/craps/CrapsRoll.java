package io.zipcoder.casino.craps;

public class CrapsRoll {
    private Integer die1;
    private Integer die2;

    public CrapsRoll(Integer die1, Integer die2){
        this.die1 = die1;
        this.die2 = die2;
    }

    @Override
    public String toString(){
        return die1.toString() + ", " + die2.toString();
    }

    public Integer getValue(){
        return die1 + die2;
    }



}
