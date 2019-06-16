package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.zipcoder.casino.utilities.Console;



public class GoFish extends CardGame {

    private GoFishMediator mediator;
    private Deck deck;
    private Hand handPlayerA;
    private GoFishPlayer playerA;
    private GoFishPlayer comp;
    private Hand compHand;
    Integer numBook;
    Boolean gameOver;
    Boolean playing;
    Boolean switchTurns;

    Console console = new Console(System.in, System.out);

    public GoFish() {}

    public GoFish (GoFishPlayer playerA){
        this.playerA = playerA;
        this.handPlayerA= new Hand ();
        deck = new DeckBuilder().addSet().shuffle().build();

    }


    public void newGame(){
        playing = true;
        gameOver=false;
        deal();
        checkBooks(handPlayerA);
        checkBooks(compHand);
    }

    public void startGame (){
        newGame();
        while(playing){
            console.getStringInput("Do you want to play Go Fish?");

        }
    }







    public String checkBooks(Hand hand){
        int count=0;

        List<Card> cards = Arrays.asList(hand.getCards());
        int value = -1;

        for(int x = 0; x< cards.size();x++){
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
        console.println("You and your opponent will each receive 7 cards each. When it is your turn, you can choose a card and ask your opponent if they have a card of that value");
        console.println("If they do, they'll give them to you. If not, you may take a card from the deck. Then it is your opponent's turn.");
        console.println("A book is when you have four cards of the same value. The player with the most books wins. The game ends when either your run out of cards in your hand ");
        console.println("or the deck runs out of cards. Enjoy the game and maybe you will even win!");

    }

    public void playerFromDeck(){
        playerA.getHand().add(deck.draw());
    }

    public void compFromDeck(){
        comp.getHand().add(deck.draw());
    }

    public void showCards(){
        handPlayerA.toString();
    }






}
