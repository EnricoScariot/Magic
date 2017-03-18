/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

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
    //if in the hand of the player tjere are more than 7 cards the player have to choose which cards to discard
    public void tooManyCards(Player p){
        while(p.getHand().size()>7){
            System.out.println("Now you have more than 7 cards, choose which one you want to discard (0/"+(p.getHand().size()-1)+")");
            System.out.println(p.getHand().toString());            
            Scanner sc = new Scanner(System.in);
            int cs = sc.nextInt();
            p.getHand().remove(cs);
        }
    }
   
    // draw 5 card from the top of the deck and put them into the hand
    public void inizializeHand(){
        if(deck.size()>=5){
            for(int i=0;i<7;i++)
                draw();
        }
    }
    
    // draw a card from the hand of the player and put in into the battlefield
    public void playCard(int index){
        //controlla se posso giocare le carte
        if(!hand.isEmpty()){
            //se la carta è un incantesimo o una creatura allora mettila in campo e esegui l'incantesimo o effetto della creatura altrimenti esegui l'effetto della stregoneria o istantaneo
            //if(hand.get(index).type=="Enchantment"||hand.get(index).type=="Creature" ){
                //hand.get(index).effect.execute();
                field.add(hand.remove(index));
                hand.remove(index);
            //}
            //else
                 //hand.remove(index).effect.execute();
        }
        
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
    
     // remove the target card from the battlefield
     public void removeCard(int index){
         field.remove(index);
     }
}
