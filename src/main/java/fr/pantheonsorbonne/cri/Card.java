package fr.pantheonsorbonne.cri;

public class Card {
    public static final String[] SYMBOL = {"COEUR","TREFLE","PIQUE","CARREAU"};
    public static final String[] VALUE = {"AS","ROI","DAME","VALET","10","9","8","7","6","5","4","3","2"};
    private String[] card;
    private String symbol;
    private String value;
    public Card(String symbol, String value){
        this.symbol = symbol;
        this.value = value;
    }

    public String getValue(){ return symbol;}
    public String getSymbol(){ return value;}

    
    public boolean Equals(String symbol, String value){
        return (this.symbol.equals(symbol) && this.value.equals(value));
    }
}
