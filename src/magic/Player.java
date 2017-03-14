/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author skari
 */
public class Player {
   
    private int id;
    private String Name;
    private int life=21;
    private ArrayList<Card> hand=new ArrayList<>();
    private ArrayList<Card> field=new ArrayList<>();
    private ArrayList<Card> deck=new ArrayList<>();
    final private Random rnd=new Random();
  
    //Getter
    public int getId() {
        return id;
    }
    
    public String getName() {
        return Name;
    }

    public int getLife() {
        return life;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getField() {
        return field;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    
    
    //Other Functions
    
    //create my Deck
     public void deckCreate(){
        Card mycard;
        for(int i=0;i<=10;i++){
            mycard=new Instant();
            deck.add(mycard);
        }
  
    }
     
    // Shuffle my Deck
    public void shuffleDeck(){
       final int end=deck.size();
    for (int i=0; i!=end-1; ++i) {
        int idx = i+ rnd.nextInt(end-i);
        Card tmp = deck.get(idx);
        deck.set(idx,deck.get(i));
        deck.set(i, tmp);
        }
    }
    
    
    // draw a card from the top of the deck and put it in my hand
    public void draw(){
        hand.add(deck.remove(deck.size()-1));
    }
        
    
    // discard a card from the top of the deck or discard the card with index "i" from the hand of the target player
    public void discard(int index, String deckOrHand){
        //discard from hand
        if(deckOrHand=="hand"){
            hand.remove(index);
        }
        //discard from the top of the deck
        else{
            deck.remove(deck.size()-1);
            
        }
    }
    
   
    // draw 5 card from the top of the deck and put them into the hand
    public void inizializeHand(){
        if(deck.size()>=5){
            for(int i=0;i<5;i++)
                hand.add(deck.remove(deck.size()-1));
        }
    }
    
    // draw a card from the hand of the player and put in into the battlefield
    public void playCard(int index){
        if(!hand.isEmpty())
            field.add(hand.remove(index));
        
    }
    
    //untap the target card
    public void untap (int index){
        if(field.get(index).istapped)
            field.get(index).istapped=false;
    }

    //tap the target card
    
     public void tap (int index){
        if(!field.get(index).istapped)
            field.get(index).istapped=true;
    }
    
}
