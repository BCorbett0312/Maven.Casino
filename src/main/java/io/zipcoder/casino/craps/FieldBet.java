package io.zipcoder.casino.craps;

public class FieldBet extends CrapsBet {

    private Integer payoutMultiplier;
    private Boolean won;
    private Boolean lost;
    private BetType type;

    public FieldBet(Integer value){
        super(value);
        this.payoutMultiplier = null;
        this.won = false;
        this.lost = false;
        this.type = BetType.FIELD;
    }

    public Integer payout() {
        if(won && !lost){
            return getValue() * payoutMultiplier;
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

    public String printBet() {
        StringBuilder sbuild = new StringBuilder("Field bet for $");
        sbuild.append(getValue());
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
}
