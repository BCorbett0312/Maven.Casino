package io.zipcoder.casino.blackJack;

import io.zipcoder.casino.*;




public class Blackjack extends CardGame implements Gamble {
    private BlackjackPlayer gambler;
    private BlackjackPlayer dealer;
    private BlackjackMediator mediator;
    private Deck deck;


    private Integer endGameState;
    private Integer initialBet;
    private Integer totalBet;

    private Boolean stay;
    private Boolean playerSplit;
    private Boolean bust;
    private Boolean staySplit;
    private Boolean bustSplit;
    private Boolean desireToPlay;
    private Boolean dealerBust;


    public Blackjack(Player player) {
        dealer = new BlackjackPlayer();
        gambler = new BlackjackPlayer(player);
        deck = new DeckBuilder().addSet().build();
        initialBet = 0;
        totalBet = 0;
    }

    public void startBlackjack() {
        mediator.welcomeToBJ();
        desireToPlay = true;
        while (desireToPlay) {
            initializeGame();
            desireToPlay = keepPlaying();
        }
    }

    protected BlackjackPlayer getDealer() {
        return dealer;
    }

    protected BlackjackPlayer getGambler() {
        return gambler;
    }


    public Boolean checkBlackJack(BlackjackPlayer playerToCheck) {
        Boolean result = false;

        if (playerToCheck.getHandValue(playerToCheck.getHand()) == 21) {
            result = true;

        }
        return result;
    }

    public Boolean checkBlackJackOnSplit(){
        Boolean result = false;
        if(gambler.getHandValue(gambler.getSplitHand()) == 21){
            result = true;
        }
        return result;
    }

    public void initializeGame() {
        getNewDeck();
        gambler.discardHand();
        dealer.discardHand();
        gambler.bet();
        dealInitialHands();
        showInitialDeal();
        determineIfWinnerAfterDeal();


    }

    public void playRound() {
        playerTurn();
        if(!bust || !bustSplit){
            dealerTurn();
        }
        checkWinner();
        payOut();

    }

    public void getNewDeck() {
        this.deck = new DeckBuilder().addSet().build();

    }

    public Boolean keepPlaying() {

        return mediator.keepPlaying();
    }


    protected void dealerTurn() {
        Boolean dealerPlay = true;
        while (dealerPlay) {

            if (dealerActionSelection(dealer.getHand()) == 1) {
                dealer.hitForPlayer(deck.draw());
            } else if (dealerActionSelection(dealer.getHand()) == 2) {
                dealerPlay = false;
            }
            else{dealerPlay = false;}

        }

    }

    protected void playerTurn() {
        stay = false;
        playerSplit = false;
        staySplit = false;
        bust = false;
        bustSplit = false;

        if (playerCanSplit()) {
            playerCanSplitPlay();
            checkBust(gambler);
        }

        while (!stay && !bust ) {
            if (playerCanSplit()) {
                playerCanSplitPlay();
            } else if (playerCanDouble()) {
                playerCanDoublePlay();
            } else {
                hitOrStay();
            }
            checkBust(gambler);
        }
        if (playerSplit){
            while(!staySplit && !bustSplit){
                if(playerCanDoubleSplit()){
                    playerCanDoublePlay();
                    checkBustSplit(gambler);
                }
                else{hitOrStay();}
                checkBustSplit(gambler);
            }

        }


    }


    protected void checkBust(BlackjackPlayer playerToCheck){
        bust = false;
        if (playerToCheck.getHandValue(playerToCheck.getHand()) > 21){
            bust = true;
        }

    }

    protected void checkBustSplit(BlackjackPlayer playerToCheck){
        bustSplit = false;
        if (playerToCheck.getHandValue(playerToCheck.getSplitHand()) > 21){
            bustSplit = true;
        }

    }



    protected void hitOrStay(){
        switch(mediator.nextGameAction()){
            case 1:
                gambler.hitForPlayer(deck.draw());
                break;
            case 2:
                stay = true;
                break;
        }
    }


    protected void playerCanDoublePlay(){
        switch(mediator.firstGameActionNoSplit()){
            case 1:
                gambler.hitForPlayer(deck.draw());
                break;
            case 2:
                stay = true;
                break;
            case 3:
                totalBet = totalBet + initialBet;
                gambler.hitForPlayer(deck.draw());
                stay = true;
                break;
        }
    }

    protected String displayTable(){
        StringBuilder tableState = new StringBuilder();
        tableState.append("Your hand is as follows "+ gambler.getHand().toString() + " and the current count is " +
                gambler.getHandValue(gambler.getHand()));

        if(gambler.getSplitHand()!= null){
            tableState.append("\n Your split hand is as follows " + gambler.getSplitHand().toString() + " and the current count is " +
                    gambler.getHandValue(gambler.getSplitHand()));
        }



        return tableState.toString();
    }


    protected void playerCanSplitPlay(){
        switch (mediator.firstGameActionWithSplit()) {
            case 1:
                gambler.hitForPlayer(deck.draw());
                break;
            case 2:
                stay = true;
                break;
            case 3:
                totalBet = totalBet + initialBet;
                gambler.hitForPlayer(deck.draw());
                stay = true;
                break;
            case 4:
                totalBet = totalBet + initialBet;
                gambler.newSplitHand();
                gambler.hitForPlayer(deck.draw());
                gambler.hitForSplitHand(deck.draw());
                checkBlackJack(gambler);
                checkBlackJackOnSplit();
                playerSplit = true;
                break;
        }
    }


    protected Boolean playerCanDouble(){
        Boolean result = false;
        if(initialBet < gambler.getWalletBalance() && gambler.getHand().size() == 2) {
            result = true;
            }
        return result;
    }

    protected Boolean playerCanDoubleSplit(){
        Boolean result = false;
        if(initialBet < gambler.getWalletBalance() && gambler.getSplitHand().size() == 2) {
            result = true;
            }
        return result;
    }



    protected Boolean playerCanSplit(){
        Boolean result = false;
        if(initialBet < gambler.getWalletBalance()&& gambler.getSplitHand().size() == 0) {
            if (gambler.getHand().getValueAtIndex(0) == gambler.getHand().getValueAtIndex(1)) {
                result = true;

            }
        }
        return result;
    }



    protected void determineIfWinnerAfterDeal(){
        if(checkBlackJack(dealer) == checkBlackJack(gambler)){
            System.out.println("You both have Blackjack.  You push.");
            endGameState = initialBet;
        }

        else if(checkBlackJack(dealer) && !checkBlackJack(gambler)){
            System.out.println("The dealer has Blackjack, you lose");
            endGameState = 0;
        }
        else if(!checkBlackJack(dealer) && checkBlackJack(gambler)){
            System.out.println("You have Blackjack, the dealer loses");
            endGameState = initialBet * 2;
        }
        else {
            playRound();
        }
    }


    protected Integer dealerActionSelection(Hand hand){
        if(dealer.getHandValue(hand) > 21){
            dealerBust = true;
            return 3;
        }
        else if(dealer.getHandValue(hand) > 17 && dealer.getHandValue(hand)<= 21){
            return 2;
        }
        else {return 1;}

    }

    protected void dealInitialHands(){
        deck.shuffleDeck();

        gambler.hitForPlayer(deck.draw());

        dealer.hitForPlayer(deck.draw());

        gambler.hitForPlayer(deck.draw());

        dealer.hitForPlayer(deck.draw());
    }

    protected String showInitialDeal(){
        String initialHands = "";

        initialHands += "The dealer is showing "+ dealer.getHand().getCardAtIndex(0).getValue()+
                "\nYou have " + gambler.getHand().getCardAtIndex(0).getValue()+ " "+
                gambler.getHand().getCardAtIndex(1).getValue();


        return initialHands;
    }

    protected String checkWinner(){
        Integer dealerHandValue = dealer.getHandValue(dealer.getHand());
        Integer gamblerHandValue = gambler.getHandValue(gambler.getHand());
        Integer gamblerSplitHandValue = gambler.getHandValue(gambler.getSplitHand());

        String winner = "";

        if(!dealerBust && !bust && !bustSplit) {

            if (gambler.getSplitHand().size() != 0) {
                if ((dealerHandValue > gamblerHandValue && (dealerHandValue < gamblerSplitHandValue))) {
                    winner = "You lost one hand and won the other";
                    endGameState = initialBet;
                } else if ((dealerHandValue < gamblerHandValue && (dealerHandValue > gamblerSplitHandValue))) {
                    winner = "You lost one hand and won the other";
                    endGameState = initialBet;
                } else if (dealerHandValue < gamblerSplitHandValue
                        && dealerHandValue < gamblerHandValue) {
                    winner = "You won both hands";
                    endGameState = totalBet*2;
                } else if (dealerHandValue > gamblerSplitHandValue
                        && dealerHandValue > gamblerHandValue) {
                    winner = "You lost both hands";
                    endGameState = 0;
                } else if (dealerHandValue == gamblerHandValue
                        && dealerHandValue == gamblerSplitHandValue) {
                    winner = "You pushed with both hands";
                    endGameState = totalBet;

                } else if ((dealerHandValue == gamblerHandValue) &&
                        dealerHandValue > gamblerSplitHandValue) {
                    winner = "You tied with one hand and lost the other.";
                    endGameState = initialBet;
                } else if ((dealerHandValue == gamblerSplitHandValue
                        && dealerHandValue > gamblerHandValue)) {
                    winner = "You tied with one hand and lost the other.";
                    endGameState = initialBet;
                } else if ((dealerHandValue == gamblerHandValue &&
                        dealerHandValue < gamblerSplitHandValue)) {
                    winner = "You tied with one hand and won the other.";
                    endGameState = initialBet*3;
                } else if ((dealerHandValue == gamblerSplitHandValue
                        && dealerHandValue < gamblerHandValue)) {
                    winner = "You tied with one hand and won the other.";
                    endGameState = initialBet*3;
                }

            } else if (dealerHandValue > gamblerHandValue) {
                winner = "The Dealer Wins";
                endGameState = 0;
            } else if (gamblerHandValue > dealerHandValue) {
                winner = "You Win";
                endGameState = initialBet * 2;
            } else if (dealerHandValue == gamblerHandValue) {
                winner = "You Push";
                endGameState = initialBet;
            }
        }
        else if(dealerBust && !bustSplit && !bust){
            winner = "You won both hands and the dealer busted";
            endGameState = totalBet * 2;
        }

        else if(!dealerBust && !bust && bustSplit){
            if(dealerHandValue < gamblerHandValue){
                winner = "You lost one hand and won the other";
                endGameState = totalBet;
            }
            else {winner = "You lost both hands";
            endGameState = 0;}
        }

        else if(!dealerBust&& bust && !bustSplit){
            if(dealerHandValue < gamblerSplitHandValue){
                winner = "You lost one hand and won the other";
                endGameState = totalBet;
            }
            else {winner = "You lost both hands";
            endGameState = 0;}
        }


        return winner;
    }

    protected Integer getEndGameState(){
        return endGameState;
    }

    protected void setEndGameState(Integer amount){
        endGameState = amount;
    }




    public Integer payOut() {
        return gambler.addToWallet(endGameState);
    }

    @Override
    public Integer payOut(Integer amount) {
        return null;
    }
}
