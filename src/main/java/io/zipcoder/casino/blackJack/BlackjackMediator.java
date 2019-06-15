package io.zipcoder.casino.blackJack;



import java.io.Console;
import java.util.Scanner;

public class BlackjackMediator {
    Scanner blackJScanner;
    String response;
    Boolean playerWants;
    Integer gameAction;


    public BlackjackMediator(){

    }




    public void welcomeToBJ(){
        System.out.println("Welcome to BlackJack");
    }



//    public Boolean buyInsurance(){
//        System.out.println("Would you like to buy insurance");
//        response = blackJScanner.nextLine().toLowerCase();
//        if(response.equals("yes")|| response.equals("y")) {
//            playerWants = true;
//        }
//        else if(response.equals("no")||response.equals("n")){
//            playerWants = false;
//        }
//        else{
//            System.out.println("Please enter Yes or No");
//            buyInsurance();}
//        return playerWants;
//
//    }

    public Integer firstGameActionWithSplit(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double"+ "\n 4) Split");
        gameAction = blackJScanner.nextInt();

        if(gameAction == 1 || gameAction ==2 || gameAction ==3 || gameAction ==4){
            return gameAction;
        }
        else{
            System.out.println("Please enter a valid number");
            firstGameActionWithSplit();
        }

        return gameAction;
    }

    public Integer firstGameActionNoSplit(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double");
        gameAction = blackJScanner.nextInt();

        if(gameAction == 1 || gameAction ==2 || gameAction ==3){
            return gameAction;
        }
        else{
            System.out.println("Please enter a valid number");
            firstGameActionNoSplit();
        }

        return gameAction;
    }

    public Integer nextGameAction(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay");
        gameAction = blackJScanner.nextInt();

        if(gameAction == 1 || gameAction ==2){
            return gameAction;
        }
        else{
            System.out.println("Please enter a valid number");
            nextGameAction();
        }

        return gameAction;
    }

    public Boolean keepPlaying(){
        System.out.println("Would you like to keep playing?");
        response = blackJScanner.next();

        if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")){
            return true;
        }
        else{return false;}
    }





}
