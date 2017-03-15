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
public class CombatPhase implements Phase {

    @Override
   public String getName() {
        return "CombatPhase";
    }

    @Override
    public void execute(Player p) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Combat phase........");
    }
    
    
 
}
