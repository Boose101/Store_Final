package AQ;
class Money{
    private double money;

    public Money(double money){
        this.money = money;
    }

    public Money(){
        money = 20;
    }

    public double getMoney(){
        return money;
    }

    public void addMoney(double amount){
        money += amount;
    }

    public boolean subtractMoney(double amount){
        if(money >= amount){
            return true;
        }else{
            return false;
        }
    }

}

public class Person{
    private String name;
    private Money cash;
    private int posInLine;

    public Person(){
        name = "Bob";
        cash = new Money();
        posInLine = -1;
    }

    public Person(int cash){
        name = "Bob";
        this.cash = new Money(cash);
        posInLine = -1;
    }

    public Person(String name, int cash){
        this.name = name;
        this.cash = new Money(cash);
        posInLine = -1;
    }

    public void setPosInLine(int pos){
        posInLine = pos;
    }
    public void modifyPosInLine(int mod){
        posInLine -= mod;
    }
    public Integer getPosInLine(){
        return posInLine;
    }
    public double getCash(){
        return cash.getMoney();
    }
    public String getName(){
        return name;
    }



}