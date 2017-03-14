/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import static magic.PhaseManager.*;

/**
 *
 * @author skari
 */
public class Magic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Stack phasesStack= new Stack();
      
      //create 2 players
      Player p1= new Player();
      Player p2= new Player();
      Player currentPlayer;
      Player enemy;
      int current=-1;
     
      //create the 2 decks
      p1.deckCreate();
      p2.deckCreate();
     
      p1.shuffleDeck();
      p2.shuffleDeck();
      
      //put 5 cards into the hand of the players
      p1.inizializeHand();
      p1.inizializeHand();
      
     // the 2 id of the players are 0 or 1
     
     p1.setId(0);
     p2.setId(1);
     
     // decidi chi inizia, in questo caso inizia il giocatore 1
     Scanner scanin = new Scanner(System.in);
     while(current != 0 && current!= 1){
         System.out.println("Quale giocatore deve iniziare? (0/1)");
     current = scanin.nextInt();
     }     
    
         if((current%2)==p1.getId()){
             currentPlayer=p1;
             enemy=p2;
         }
         else {
             currentPlayer=p2;
             enemy=p1;
         }
         
         stackInizialization(phasesStack);
         
        // Phase fase=(Phase)phasesStack.pop();
         //fase.execute(currentPlayer);           
         
  //corpo del gioco
  System.out.println("Tocca al giocatore "+current);
  System.out.println("Hai le seguenti carte "+currentPlayer.getHand().toString);
     
     
     /*
      
      System.out.println("the deck is" +p1.getDeck().toString());
      p1.shuffleDeck();
      System.out.println("the deck is" +p1.getDeck().toString());
      System.out.println("the hand is" +p1.getHand().toString());
      p1.inizializeHand();
      System.out.println("the deck is" +p1.getDeck().toString());
      System.out.println("the hand is" +p1.getHand().toString());
      System.out.println("the field is" +p1.getField().toString());
      
      System.out.println("the first card in my hand is" +p1.getHand().get(0).toString());
      System.out.println("is tapped? " +p1.getHand().get(0).istapped);
      p1.playCard(0);
      System.out.println("the field is" +p1.getField().toString());
      p1.tap(0);
      System.out.println("is tapped? " +p1.getField().get(0).istapped);
      p1.untap(0);
      System.out.println("is tapped? " +p1.getField().get(0).istapped);
         
         */
         
    }
 }
//ciao