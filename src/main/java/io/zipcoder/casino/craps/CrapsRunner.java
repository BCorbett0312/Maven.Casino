package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import org.javatuples.Pair;

public class CrapsRunner {
    private CrapsGame game;
    private Console consul;

    public CrapsRunner(CrapsGame game, Console consul){
        this.game = game;
        this.consul = consul;
    }


    public void runGame(){

        while(!game.getExit()){
            consul.print(game.nextPhase());

            Boolean moveOn = false;
            while(!moveOn){
                String input = consul.getStringInput("");
                Pair<String,Boolean> inputResult = game.processInput(input);
                consul.print(inputResult.getValue0());
                moveOn = inputResult.getValue1();
            }
        }
    }
}
