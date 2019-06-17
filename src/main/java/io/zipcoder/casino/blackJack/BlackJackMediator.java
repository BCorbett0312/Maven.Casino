package io.zipcoder.casino.blackJack;


import io.zipcoder.casino.utilities.Console;

public class BlackJackMediator {
    private Console console = new Console(System.in, System.out);

    public BlackJackMediator(){

    }


    public Integer firstGameActionNoSplit(){
        String toPrint = "What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double";
        return console.getIntegerInput(toPrint);
    }

    public Integer nextGameAction(){
        String toPrint = "What would you like to do?" + "\n 1) Hit" + "\n 2) Stay";
        return console.getIntegerInput(toPrint);
    }

    public Integer askKeepPlaying(BlackjackPlayer gambler) {
        String toPrint = "You have " + gambler.getWalletBalance() + "\nWould you like to keep playing?" + "\n1) Yes" + "\n2) No";
        return console.getIntegerInput(toPrint);
    }

    protected void printPush(){
        String push = "You and the dealer tied.  You get your bet back.";
        console.println(push);
    }

    protected void printGamblerWins(Integer amount){
        String gamblerWins = "You win " + amount;
        console.println(gamblerWins);
    }

    protected void printDealerWins(){
        String dealerWins = "The dealer wins.  Sorry.";
        console.println(dealerWins);
    }

    public void blackJackPush(){
        String toPrint = "You both have Blackjack.  You push.";
        console.println(toPrint);
    }

    public void blackJackDealerWin(){
        String toPrint = "The dealer has Blackjack, you lose";
        console.println(toPrint);
    }

    public void blackJackGamblerWin(){
        String toPrint = "You have Blackjack, the dealer loses";
        console.println(toPrint);
    }

    public void playerBust(){
        String busted = "You bust.  Too Bad.";
        console.println(busted);
    }

    public void welcomeToBlackJack(){
        String welcome = "Welcome to BlackJack";
        console.println(welcome);
    }

}

