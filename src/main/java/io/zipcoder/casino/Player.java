package io.zipcoder.casino;

public class Player {

    private Integer money;
    private String name;




    public Player(Integer money, String name) {
        this.money = money;
        this.name = name;
    }

    public Player (){
        this.name = "Dealer";
        this.money = 0;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

