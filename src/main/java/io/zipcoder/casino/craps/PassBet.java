package io.zipcoder.casino.craps;

public class PassBet extends CrapsBet {
    private CrapsRoll point;
    private Boolean won;
    private Boolean lost;
    private BetType type;

    public PassBet(Integer value){
        super(value);
        this.won = false;
        this.lost = false;
        this.point = null;
        this.type = BetType.PASS;
    }


    public Integer payout() {
        if(won && !lost) {
            return getValue() * 2;
        }
        else {
            return null;
        }
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

    public String printBet() {
        StringBuilder sbuild = new StringBuilder("Pass Line for $");
        sbuild.append(getValue());
        sbuild.append("\nPoint: ");
        if(point == null){
            sbuild.append("TBD");
        }
        else{
            sbuild.append(point.getValue());
        }
        return sbuild.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && getClass() == o.getClass()){
            CrapsBet bet = (CrapsBet)o;
            return (type.equals(bet.getType()) && getValue().equals(bet.getValue()));
        }
        return false;
    }

    public Boolean hasLost() {
        return lost;
    }

    public Boolean hasWon() {
        return won;
    }

    public BetType getType(){
        return type;
    }

    //// only needed for testing

    public CrapsRoll getPoint(){
        return point;
    }


}
