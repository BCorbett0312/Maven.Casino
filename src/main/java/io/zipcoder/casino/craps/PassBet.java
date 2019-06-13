package io.zipcoder.casino.craps;

public class PassBet implements CrapsBet {
    private CrapsRoll point;
    private Integer value;
    private Boolean won;
    private Boolean lost;

    public PassBet(Integer value){
        this.value = value;
        this.won = false;
        this.lost = false;
        this.point = null;
    }


    public Integer payout() {
        return value * 2;
    }

    public void checkRoll(CrapsRoll roll){
        if(won || lost){ return; }

        if(point == null){
            if(roll.getValue() == 2 || roll.getValue() == 3 || roll.getValue() == 12){
                lost = true;
            }
            else if(roll.getValue() == 7 || roll.getValue() ==11){
                won = true;
            }
            else{
                point = roll;
            }
        }
        else {
            if(roll.getValue() == 7 || roll.getValue() == 11){
                lost = true;
            }
            else if(roll.getValue().equals(point.getValue())){
                won = true;
            }
        }
    }

    public Boolean hasLost() {
        return lost;
    }

    public Boolean hasWon() {
        return won;
    }

    //// only needed for testing

    public CrapsRoll getPoint(){
        return point;
    }


}
