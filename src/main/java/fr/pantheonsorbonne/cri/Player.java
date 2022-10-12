package fr.pantheonsorbonne.cri;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Player {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private Card[] hand;
    public Player(String name){
        this.name=name;
    }
    public void setHand(Card[] hand){
        this.hand=hand;
    }
    public Card[] getCardsToDiscard(){
        List<Card> cardDiscard = new ArrayList<Card>();
        System.out.println("Voici vos cartes : \n"+getHandString());
        System.out.println("Combien de carte voulez vous retirer "+this.name+" ?");
        int numberCards = sc.nextInt();
        while(numberCards>0){
            System.out.println(" Saisi de la valeur : ");
            String valueCard = sc.next();
            System.out.println("Saisi du symbole : ");
            String symbolCard = sc.next();
            if(inHand(symbolCard, valueCard)){
                cardDiscard.add(hand[getIndex(symbolCard,valueCard)]);
                this.hand[getIndex(symbolCard,valueCard)]=null;
                System.out.println("Carte retirer ! ");
                numberCards--;
            }
        }
        System.out.println("Fin !");
        Card[] cardDiscardArray = new Card[cardDiscard.size()];
        return cardDiscard.toArray(cardDiscardArray);
    }
    public int getIndex(String symbol, String value){
        if(!hand[0].Equals(symbol,value)){
            for(int i=1;i<hand.length;i++){
                if(hand[i].Equals(symbol, value)){
                    return i;
                }
            }
        }
        return 0;
    }
    public boolean inHand(String symbol, String value){
        for(Card cardHand : hand){
            if(cardHand.Equals(symbol, value)){
                return true;
            }
        }
        return false;
    }
    public void addCard(Card[] newCards){
        int currentIndexCards = newCards.length-1;
        for(int i=0;i<hand.length;i++){
            if(hand[i]==null){
                hand[i]=newCards[currentIndexCards];
                currentIndexCards--;
            }
        }
    }
    public boolean beats(Player p){ // paire brolan carre
        if(getCombination(this.hand)>getCombination(p.hand)){
            return true;
        }else{
            if(getCombination(this.hand)<getCombination(p.hand)){
                return false;
            }
            else{
                if(getValueCombination(this.hand)>getValueCombination(p.hand)){
                    return true;
                }
                else{
                    if(getValueCombination(this.hand)<getValueCombination(p.hand)){
                        
                        return false;
                    }
                    else{
                        
                        return false;
                    }
                }
            }
        }
        
    }
    public int getCombination(Card[] hand){
        int countCard=1;
        int maxCountCard=1;
        for(int i=0;i<hand.length;i++){
            for(int y=i+1;y<hand.length;y++){
                if(hand[i].getValue().equals(hand[y].getValue())){
                        countCard++;
                }
            }
            if(countCard>maxCountCard){
                maxCountCard=countCard;
            }
            countCard=1;
        }
        return maxCountCard;
    }
    public int getValueCombination(Card[] hand){
        int countCard=1;
        int maxCountCard=1;
        String valueCard=Card.VALUE[Card.VALUE.length-1];
        int indexCard=Card.VALUE.length-1;
        for(int i=0;i<hand.length;i++){
            for(int y=1;y<=i;y++){
                if(hand[i].getValue().equals(hand[y].getValue())){
                        countCard++;
                }
            }
            if(countCard>=maxCountCard){
                if(countCard == maxCountCard && 
                Arrays.asList(Card.VALUE).indexOf(hand[i].getValue())>
                Arrays.asList(Card.VALUE).indexOf(valueCard)){
                    indexCard= Arrays.asList(Card.VALUE).indexOf(hand[i].getValue());
                    valueCard= hand[i].getValue();
                }
                else{
                    maxCountCard=countCard;
                    valueCard = hand[i].getValue();
                }
            }
            countCard=1;
        }
        return indexCard;
    }
    public String getHandString(){
        StringBuilder handString = new StringBuilder();
        for(int i=0;i<hand.length;i++){
            handString.append((i+1)+". "+hand[i].getValue()+" de "+hand[i].getSymbol()+"\n");
        }
        return handString.toString();
    }
}
