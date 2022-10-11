package fr.pantheonsorbonne.cri;
import java.util.Scanner;
public class Player {
    private String name;
    private Card[] hand;
    public Player(String name){
        this.name=name;
    }
    public void setHand(Card[] hand){this.hand=hand;}
    public void getCardsToDiscard(){}
    public void addCard(){}
    public void beats(Player p){}
    public void getHandString(){}
}
