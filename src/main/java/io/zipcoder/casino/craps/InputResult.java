package io.zipcoder.casino.craps;

public class InputResult {
    private final String printOut;
    private final Boolean moveOn;

    public InputResult(String printOut, Boolean moveOn){
        this.printOut = printOut;
        this.moveOn = moveOn;
    }

    public String getPrintOut(){
        return printOut;
    }

    public Boolean moveOn(){
        return moveOn;
    }
}
