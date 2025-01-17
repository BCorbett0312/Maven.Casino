package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import io.zipcoder.casino.utilities.Console;



public class GoFish extends CardGame {

    private GoFishMediator mediator;
    private Deck deck;
    private Hand handPlayerA;
    private GoFishPlayer playerA;
    private GoFishPlayer comp;
    private Hand compHand;
    GoFishPlayer asking;
    GoFishPlayer giving;
    Random random=new Random();

    Integer numBook;
    Integer playerBooks;
    Integer compBooks;
    Boolean gameOver;
    Boolean playing;


    String number = "";

    Console console = new Console(System.in, System.out);

    public GoFish() {}

    public GoFish (GoFishPlayer playerA){
        this.playerA = playerA;
        this.handPlayerA= new Hand ();
        deck = new DeckBuilder().addSet().shuffle().build();
        this.comp = new GoFishPlayer(new Player());

    }




    public void newGame(){
        playing = true;
        gameOver=false;
        deal();
        checkBooks(handPlayerA);
        checkBooks(comp.getHand());
    }

    public void switchPartner() {
        if (asking == playerA) {
            asking = comp;
            giving = playerA;
        } else {
            asking =playerA;
            giving = comp;
        }

    }


    public void startGame (){
        String input = console.getStringInput("Do you want to play Go Fish? Enter yes or no");
         switch(input){
             case "yes" :
                 rules();
                 break;
             case "no" :
                 playing=false;
                 break;
         }
        newGame();

         asking = playerA;
         giving=comp;

         while(playing){
            getGuess();
            askedCard(number, giving.getHand(),asking.getHand());
            checkBooks(asking.getHand());
             checkHand(asking);
             checkDeck();
             exit();
            switchPartner();

         }
    }



    public String getGuess(){
        if(asking == playerA){
         number = console.getStringInput("It's your turn. Here are your cards."+ showCards()+" What card do you want?" +
                "\n Enter the card number. ace,two,three,four,five,six,seven,eight,nine,ten,jack,queen,king");
        return number;}
       else {
             compGuess();

    }return null;}






    public String checkBooks(Hand hand){
        int count=0;

        List<Card> cards = new ArrayList<>(Arrays.asList(hand.getCards())) ;
        int value = -1;

        for(int x = 0; x< cards.size()-1;x++){
            if(cards.get(x).equals(cards.get(x+1))) {
                count++;
                if(count == 4)
                    numBook++;
            }
        }
        return "Your number of books is "+ numBook;
    }

    public void deal() {
        for (int x=0;x<7;x++){
            playerA.getHand().add(deck.draw());
            comp.getHand().add(deck.draw());
        }

    }

    public void checkHand(GoFishPlayer playerA){
        if(((playerA.getHand()).size() == 0 ) ){
            gameOver = true;
        } else playing = true;
    }

    public void checkDeck (){
        if(deck.isEmpty())
            gameOver= true;
    }

    public void rules () {
        console.println("You and your opponent will each receive 7 cards each." +
        "\nWhen it is your turn, you can choose a card and ask your opponent if they have a card of that value"+
        "\nIf they do, they'll give them to you. If not, you may take a card from the deck."+
                "\nThen it is your opponent's turn."+
        "\nA book is when you have four cards of the same value. The player with the most books wins."+
                "\nThe game ends when either your run out of cards in your hand or the deck runs out of cards."
                +"\nEnjoy the game and maybe you will even win!");

    }

    public void playerFromDeck(Hand askingHand){
        askingHand.add(deck.draw());
    }




    public String showCards(){
       return playerA.getHand().toString();

    }

    public void passCard(Hand giving,Hand asking,CardValue value) {
            Boolean hadCard = false;
            Card card1 = new Card(CardSuit.CLUB,value);
         Card card2= new Card(CardSuit.SPADE,value);
         Card card3=new Card(CardSuit.DIAMOND,value);
            Card card4 = new Card(CardSuit.HEART,value);
            if(giving.contains(card1)){
                giving.removeByCard(card1);
             asking.add(card1);
            hadCard=true;
            }
            if(giving.contains(card2)){
                giving.removeByCard(card2);
                asking.add(card2);
            hadCard=true;
            }
        if(giving.contains(card3)){
            giving.removeByCard(card3);
            asking.add(card3);
            hadCard=true;
        }
        if(giving.contains(card4)){
            giving.removeByCard(card4);
            asking.add(card4);
            hadCard=true;
        }
        if(hadCard == false){
            console.println("GO FISH!");
            playerFromDeck(asking);

        }
    }

    public void askedCard (String number, Hand givingHand, Hand askingHand) {
    switch(number){
        case "ace" :
            passCard(givingHand,askingHand,CardValue.ACE);
            break;
        case "two" :
            passCard(givingHand,askingHand, CardValue.TWO);
            break;
        case "three" :
            passCard(givingHand,askingHand,CardValue.THREE);
            break;
        case "four":
            passCard(givingHand,askingHand,CardValue.FOUR);
            break;
        case "five":
            passCard(givingHand,askingHand,CardValue.FIVE);
            break;
        case "six":
            passCard(givingHand,askingHand,CardValue.SIX);
            break;
        case "seven":
            passCard(givingHand,askingHand,CardValue.SEVEN);
            break;
        case "eight":
            passCard(givingHand,askingHand,CardValue.EIGHT);
            break;
        case "nine":
            passCard(givingHand,askingHand,CardValue.NINE);
            break;
        case "ten":
            passCard(givingHand,askingHand,CardValue.TEN);
            break;
        case "jack":
            passCard(givingHand,askingHand,CardValue.JACK);
            break;
        case "queen":
            passCard(givingHand,askingHand,CardValue.QUEEN);
            break;
        case "king":
            passCard(givingHand,askingHand,CardValue.KING);
            break;
    }}

    public void goFish (Hand giving,Hand asking,CardValue value){
        Card card1 = new Card(CardSuit.CLUB,value);
        Card card2= new Card(CardSuit.SPADE,value);
        Card card3=new Card(CardSuit.DIAMOND,value);
        Card card4 = new Card(CardSuit.HEART,value);
        if(!(giving.contains(card1))){
            console.println("GO FISH!");
            playerFromDeck(asking);
        }
        if(!(giving.contains(card2))){
            console.println("GO FISH!");
            playerFromDeck(asking);}
        if(!(giving.contains(card3))){
            console.println("GO FISH!");
            playerFromDeck(asking);}
        if(!(giving.contains(card4))){
            console.println("GO FISH!");
            playerFromDeck(asking);}
    }

    public CardValue compGuess (){

        number = Integer.valueOf((random.nextInt(10)+1)).toString();
        switch(number) {
            case "1":
                return CardValue.ACE;

            case "2":
                return CardValue.TWO;

            case "3":
                return CardValue.THREE;

            case "4":
                return CardValue.FOUR;

            case "5":
                return CardValue.FIVE;

            case "6":
                return CardValue.SIX;

            case "7":
                return CardValue.SEVEN;

            case "8":
                return CardValue.EIGHT;

            case "9":
                return CardValue.NINE;

            case "10":
                return CardValue.TEN;

        }
            return null;

        }

        public void exit () {
            String exit = console.getStringInput("Do you want to quit playing? yes or no");
            switch(exit){
                case "yes":
                    playing = false;
                    break;
                case "no" :
                    playing=true;
                    break;

        }

    }}








