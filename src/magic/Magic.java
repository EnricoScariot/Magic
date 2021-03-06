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
      p2.inizializeHand();
      
     // the 2 id of the players are 0 or 1
     
     p1.setId(0);
     p2.setId(1);
     stackInizialization(phasesStack);  
     // decidi chi inizia, in questo caso inizia il giocatore 1
     Scanner scanin = new Scanner(System.in);
     while(current != 0 && current!= 1){
     System.out.println("Which player have to begin? (0/1)");
     current = scanin.nextInt();
     }     
    while(p1.getLife()>0 && p2.getLife()>0){
         if((current%2)==p1.getId()){
             currentPlayer=p1;
             enemy=p2;
         }
         else {
             currentPlayer=p2;
             enemy=p1;
         }                        
//         System.out.println("Now is the turn of the player : "+current);
//         System.out.println("You have the following cards "+currentPlayer.getHand().toString());
//         //while che cicla finchè non viene inserita un numero di carta valida
//         System.out.println("which one do you want to play?");
         while(!phasesStack.empty()){
             Phase fase=(Phase)phasesStack.pop();
             fase.execute(currentPlayer);             
         }
         
         current++;  
         //inizializzo nuovamente lo stack
         stackInizialization(phasesStack);
         //aggiungo o tolgo fasi a seconda della carta che ho giocato
         resolveAddOrRemovePhases(addOrRemovePhases);
         //
         }
    }

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
