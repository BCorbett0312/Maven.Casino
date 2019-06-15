package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;




public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer gambler;
    private BlackjackPlayer dealer;
    private BlackjackMediator mediator;
    private Deck deck;


    private Integer playerHand;
    private Integer playerSplitHand;
    private Integer dealerHand;
    private Integer theBet;
    private DeckBuilder builder;
    Boolean stay;



    public Blackjack(Player player){
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
        deck = new DeckBuilder().addSet().build();
    }

    public void startBlackjack(){
        mediator.welcomeToBJ();
        Boolean desireToPlay = true;
        while (desireToPlay){
            playRound();
            desireToPlay = keepPlaying();
        }
    }

    protected BlackjackPlayer getDealer(){
        return dealer;
    }

    protected BlackjackPlayer getGambler(){
        return gambler;
    }




    public Boolean checkBlackJack(BlackjackPlayer playerToCheck){
        Boolean result = false;

        if (playerToCheck.getHandValue(playerToCheck.getHand()) == 21) {
            result = true;

        }
        return result;


    }

    public void playRound(){


        getNewDeck();
        gambler.discardHand();
        dealer.discardHand();
        gambler.bet();
        dealInitialHands();
        showInitialDeal();
        //checkBlackJack();

        playerTurn();
        dealerTurn();
        checkWinner();
        //settleBets();
    }



    public void getNewDeck(){
        this.deck = new DeckBuilder().addSet().build();

    }

    public Boolean keepPlaying(){
        return null;
    }


    public void dealerTurn(){
        Boolean dealerPlay = true;
        while(dealerPlay) {

            if (dealerActionSelection(dealer.getHand()) == 1) {
                dealer.hitForPlayer(deck.draw());
            }
            else if(dealerActionSelection(dealer.getHand())== 2){
                dealerPlay = false;
            }

        }

    }

    public void playerTurn(){


    }

    public Integer dealerActionSelection(Hand hand){
        if(dealer.getHandValue(hand) > 21){
            return 3;
        }
        else if(dealer.getHandValue(hand) > 17 && dealer.getHandValue(hand)<= 21){
            return 2;
        }
        else {return 1;}

    }

    public void dealInitialHands(){
        deck.shuffleDeck();

        gambler.hitForPlayer(deck.draw());

        dealer.hitForPlayer(deck.draw());

        gambler.hitForPlayer(deck.draw());

        dealer.hitForPlayer(deck.draw());
    }

    public String showInitialDeal(){
        String initialHands = "";

        initialHands += "The dealer is showing "+ dealer.getHand().getCardAtIndex(0).getValue()+
                "\nYou have " + gambler.getHand().getCardAtIndex(0).getValue()+ " "+
                gambler.getHand().getCardAtIndex(1).getValue();


        return initialHands;
    }

    public String checkWinner(){
        Integer dealerHandValue = dealer.getHandValue(dealer.getHand());
        Integer gamblerHandValue = gambler.getHandValue(gambler.getHand());
        Integer gamblerSplitHandValue = gambler.getHandValue(gambler.getSplitHand());

        String winner = "";


        if(gambler.getSplitHand().size() != 0) {
            if ((dealerHandValue > gamblerHandValue && (dealerHandValue < gamblerSplitHandValue))){
                winner = "You lost one hand and won the other";
            }
            else if ((dealerHandValue < gamblerHandValue && (dealerHandValue > gamblerSplitHandValue))){
                winner = "You lost one hand and won the other";
            }

            else if (dealerHandValue < gamblerSplitHandValue
                    && dealerHandValue < gamblerHandValue) {
                winner = "You won both hands";
            }
            else if (dealerHandValue > gamblerSplitHandValue
                    && dealerHandValue > gamblerHandValue){
                winner = "You lost both hands";
            }
            else if (dealerHandValue == gamblerHandValue
                    && dealerHandValue == gamblerSplitHandValue){
                winner = "You pushed with both hands";

            }
            else if ((dealerHandValue == gamblerHandValue) &&
                    dealerHandValue > gamblerSplitHandValue){
                winner = "You tied with one hand and lost the other.";
            }
            else if ((dealerHandValue == gamblerSplitHandValue
                    && dealerHandValue > gamblerHandValue)){
                winner = "You tied with one hand and lost the other.";
            }
            else if ((dealerHandValue == gamblerHandValue &&
                    dealerHandValue < gamblerSplitHandValue)){
                winner = "You tied with one hand and won the other.";
            }
            else if ((dealerHandValue == gamblerSplitHandValue
                    && dealerHandValue < gamblerHandValue)){
                winner = "You tied with one hand and won the other.";
            }

        }

        else if (dealerHandValue > gamblerHandValue){
            winner = "The Dealer Wins";
        }

        else if(gamblerHandValue > dealerHandValue){
            winner = "You Win";
        }

        else if (dealerHandValue == gamblerHandValue){
            winner = "You Push";
        }

        return winner;
    }


    public Integer payOut(Integer amount) {
        return null;
    }
}
