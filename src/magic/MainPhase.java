/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;
import java.util.Scanner;
/**
 *
 * @author skari
 */
public class MainPhase extends Phase {

    @Override
   public String getName() {
       return "MainPhase";
    }

    @Override
    public void execute(Player p) {
       // the player select the card that he want to play
       System.out.println("Which card do you want to play?");
       Scanner sc = new Scanner(System.in);
       int i = sc.nextInt();
       p.playCard(i);
    }
}
    
  

