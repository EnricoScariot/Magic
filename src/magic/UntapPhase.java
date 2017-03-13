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
public class UntapPhase extends Phase {

    @Override
    public String getName() {
       return "UntapPhase";
    }

    @Override
    public void execute(Player p) {
       for(int i=0;i<p.getField().size();i++)
           p.untap(i);
    }
  
}
