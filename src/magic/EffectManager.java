/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import java.util.Stack;

/**
 *
 * @author skari
 */
public class EffectManager {
    // svuota lo stack degli effetti e lo risolve
    
    public void resolveEffect(Stack s){
        while(!s.empty()){
            CardEffect e=(CardEffect) s.pop();
            e.execute();
        }
    }
    
}
