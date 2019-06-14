package io.zipcoder.casino.blackJack;



import java.util.Scanner;

public class BlackjackMediator {
    Scanner blackJScanner;
    String response;
    Boolean playerWants;


    public BlackjackMediator(){
        blackJScanner = new Scanner(System.in);
    }


    public void welcomeToBJ(){
        System.out.println("Welcome to BlackJack");
    }



    public Boolean buyInsurance(){
        System.out.println("Would you like to buy insurance");
        response = blackJScanner.nextLine().toLowerCase();
        if(response.equals("yes")) {
            playerWants = true;
        }
        else if(response.equals("no")){
            playerWants = false;
        }
        return playerWants;

    }

    public Integer firstGameActionWithSplit(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double"+ "\n 4) Split");
        return blackJScanner.nextInt();
    }

    public Integer firstGameActionNoSplit(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay" +
                "\n 3) Double");
        return blackJScanner.nextInt();
    }

    public Integer nextGameAction(){
        System.out.println("What would you like to do?" + "\n 1) Hit" + "\n 2) Stay");
        return blackJScanner.nextInt();
    }





}
