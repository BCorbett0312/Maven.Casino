package io.zipcoder.casino.craps;

public class FieldBet implements CrapsBet {

    private Integer value;
    private Integer payoutMultiplier;
    private Boolean won;
    private Boolean lost;

    public FieldBet(Integer value){
        this.value = value;
        this.payoutMultiplier = null;
        this.won = false;
        this.lost = false;
    }

    public Integer payout() {
        if(won && !lost){
            return value * payoutMultiplier;
        }
        else {
            return null;
        }
    }

    public void checkRoll(CrapsRoll roll) {
        if(roll.getValue() == 2 || roll.getValue() == 12){
            won = true;
            payoutMultiplier = 3;
        }
        else if(roll.getValue() >= 5 && roll.getValue() <= 8){
            lost = true;
        }
        else{
            won = true;
            payoutMultiplier = 2;
        }

    }

    public Boolean hasLost() {
        return lost;
    }

    public Boolean hasWon() {
        return won;
    }
}
