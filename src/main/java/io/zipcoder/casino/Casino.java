package io.zipcoder.casino;


import io.zipcoder.casino.GoFish.GoFish;
import io.zipcoder.casino.GoFish.GoFishPlayer;
import io.zipcoder.casino.blackJack.Blackjack;
import io.zipcoder.casino.continental.Continental;
import io.zipcoder.casino.craps.CrapsGame;
import io.zipcoder.casino.roulette.Roulette;
import io.zipcoder.casino.utilities.Console;

public class Casino {

    public Player player;

    Console console = new Console(System.in, System.out);
    Boolean playAgain;

    public Casino(){

    }


    public void start(){
        welcomeToTheCasino();
        getPlayerInfo();

        playAgain = true;
        while(playAgain) {
            Integer userChoice = getGameChoice();
            gameSelector(userChoice);

        }

    }




    public void getPlayerInfo(){
        String name = console.getStringInput("What is your name?");
        Integer wallet = console.getIntegerInput("How much money would you like to start with?");
        this.player = new Player(wallet, name);
    }


    public void welcomeToTheCasino(){
        String welcome = "Welcome to our casino";
        console.println(welcome);
    }

    public Integer getGameChoice(){
        String gameChoice = "Welcome to the lobby" + "\nWhat game would you like to play?" +
                "\n1) Blackjack" + "\n2) Continental" + "\n3) Craps"+ "\n4) GoFish" + "\n5) Roulette" + "\n6) Slots";
        return console.getIntegerInput(gameChoice);


    }

    public void gameSelector(Integer userChoice){

        switch (userChoice){
            case 1:
                Blackjack bj = new Blackjack(player);
                bj.startBlackjack();
                break;
            case 2:
                Continental continental = new Continental(player, console);
                continental.startGame();
                break;
            case 3:
                //CrapsGame craps = new CrapsGame(player);
                break;
            case 4:
                GoFishPlayer bob = new GoFishPlayer(player);
                GoFish goFish = new GoFish(bob);
                goFish.startGame();
                break;
            case 5:
                Roulette roulette = new Roulette(player);
                break;
            case 6:
                //Slots slots
        }

    }
    public void keepPlaying(){
        String wantToPlay = "Do you want to play again?" +"\n1) Yes" + "\n2) No";
        Integer play = console.getIntegerInput(wantToPlay);
        switch (play){
            case 1:
                playAgain = true;
                break;
            case 2:
                playAgain = false;
                break;
        }
    }


}
