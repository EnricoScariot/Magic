/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;
import java.util.Stack;
import magic.Phase;
/**
 *
 * @author skari
 */
public class PhaseManager {
    
    
    static Stack support= new Stack();
   
    //add the phase "el" after the Phase specified into "where"
    static void addPhase(Stack s, String where, Phase el){
        if(where=="top")
            s.push(el);
        else{
            
            //cerco il posto giusto in cui mettere la fase
            Phase p=(Phase)s.peek();
            while(p.getName()!=where){
                Phase fase=(Phase)s.pop();
                support.push(fase);
                p=(Phase)s.peek();
           }
            //faccio la push nel posto giusto
            s.push(el);
            //rimetto nel mio stck le altre fasi in ordine
            while(!support.empty()){
              Phase fase=(Phase)support.pop();  
              s.push(fase);
            }
        }
    }  
    
    // delete from the stack the phase specified into "where"
    static void deletePhase(Stack s, String where){
        if(where=="top")
            s.pop();
        else{
             //cerco il posto giusto in cui mettere la fase
            Phase p=(Phase)s.peek();
            while(p.getName()!=where){
                Phase fase=(Phase)s.pop();
                support.push(fase);
                p=(Phase)s.peek();
           }
            //elimino la fase
            s.pop();
            //rimetto nel mio stck le altre fasi in ordine
            while(!support.empty()){
              Phase fase=(Phase)support.pop();  
              s.push(fase);
            }
        }
    }
    
     static void stackTest(Stack s){
       DrawPhase d=new DrawPhase();
       
      
       addPhase(s,"CombatPhase",d);
       System.out.println("now the stack is: " + s);
            
    }
    
     static void stackInizialization(Stack s){
        EndPhase e=new EndPhase();
        s.push(e);
        MainPhase m=new MainPhase();
        s.push(m);
        CombatPhase c=new CombatPhase();
        s.push(c);
        UntapPhase u=new UntapPhase();
        s.push(u);
        DrawPhase d=new DrawPhase();
        s.push(d);
        System.out.println("now the stack is: " + s);
     }
    
}
