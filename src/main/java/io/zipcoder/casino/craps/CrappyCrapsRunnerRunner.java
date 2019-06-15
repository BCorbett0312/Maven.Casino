package io.zipcoder.casino.craps;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class CrappyCrapsRunnerRunner {

    public static void main(String[] args) {
        Player gamblinJoe = new Player(100, "Gamblin' Joe");
        Console luciusCorneliusSullaFelix = new Console(System.in, System.out);
        CrapsMediator casinko = new CrapsMediator(gamblinJoe, luciusCorneliusSullaFelix);
        casinko.play();
        System.out.println(gamblinJoe.getName() + ", you now have $" + gamblinJoe.getMoney() + ".");
    }

}
