/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

/**
 *
 * @author skari
 */
public class DrawPhase extends Phase {

    @Override
   public String getName() {
       return "DrawPhase";
    }

    @Override
    
    public void execute(Player p) {
        System.out.println("Now is player "+p.getId() +" draw phase......");
        p.draw();        
    }
    
  
}
