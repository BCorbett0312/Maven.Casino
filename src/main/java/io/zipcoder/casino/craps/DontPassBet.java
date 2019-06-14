package io.zipcoder.casino.craps;


public class DontPassBet extends CrapsBet {

    private CrapsRoll point;
    private Integer payoutMultiplier;
    private Boolean won;
    private Boolean lost;
    private BetType type;

    public DontPassBet(Integer value){
        super(value);
        this.lost = false;
        this.won = false;
        this.point = null;
        this.payoutMultiplier = null;
        this.type = BetType.DONTPASS;
    }


    public Integer payout() {
        if(won && !lost) {
            return getValue() * payoutMultiplier;
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

    public String printBet() {
            StringBuilder sbuild = new StringBuilder("Don't Pass for $");
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
    public BetType getType() {
        return type;
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

    // Only needed for testing

    public CrapsRoll getPoint(){
        return point;
    }


}
