package io.zipcoder.casino.craps;


public class DontPassBet implements CrapsBet {

    private CrapsRoll point;
    private Integer value;
    private Integer payoutMultiplier;
    private Boolean won;
    private Boolean lost;

    public DontPassBet(Integer value){
        this.value = value;
        this.lost = false;
        this.won = false;
        this.point = null;
        this.payoutMultiplier = null;
    }


    public Integer payout() {
        if(won && !lost) {
            return value * payoutMultiplier;
        }
        else {
            return null;
        }
    }

    public void checkRoll(CrapsRoll roll) {
        if(point == null){
            if(roll.getValue() == 7 || roll.getValue() == 11){
                lost = true;
            }
            else if(roll.getValue() == 2 || roll.getValue() == 3){
                won = true;
                payoutMultiplier = 2;
            }
            else if(roll.getValue() == 12){
                won = true;
                payoutMultiplier = 1;
            }
            else{
                point = roll;
            }
        }
        else{
            if(roll.getValue() == 7 || roll.getValue() == 11){
                won = true;
                payoutMultiplier = 2;
            }
            else if(roll.getValue().equals(point.getValue())){
                lost = true;
            }
        }
    }

    public Boolean hasLost() {
        return lost;
    }

    public Boolean hasWon() {
        return won;
    }

    // Only needed for testing

    public CrapsRoll getPoint(){
        return point;
    }


}
