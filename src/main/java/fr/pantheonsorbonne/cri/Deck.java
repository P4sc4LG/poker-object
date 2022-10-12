package fr.pantheonsorbonne.cri;
import java.util.Random;
public class Deck {
    static Random random = new Random();
    public static Card[] newRandomHand(){
        Card[] hand = new Card[5];
        for(int i=0; i<hand.length; i++){ //sans remise
            int randomSymbol = random.nextInt(Card.SYMBOL.length);
            int randomValue = random.nextInt(Card.VALUE.length);
            hand[i]= new Card(Card.SYMBOL[randomSymbol],Card.VALUE[randomValue]);
        }
        return hand;
    }
    public static Card[] getRandomCards(int numberCards){
        StringBuilder printCardAdd = new StringBuilder("");
        Card[] newCards = new Card[numberCards];
        for(int i=0; i<numberCards; i++){
            int randomSymbol = random.nextInt(Card.SYMBOL.length);
            int randomValue = random.nextInt(Card.VALUE.length);
            newCards[i]= new Card(Card.SYMBOL[randomSymbol],Card.VALUE[randomValue]);
            printCardAdd.append(i+". "+Card.VALUE[randomValue]+" de "+Card.SYMBOL[randomSymbol]+" ajouté!\n");
        }
        System.out.println(printCardAdd.toString());
        return newCards;
    }
}
