/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Daniel
 */
public class Semaforo{
    
    
    public Semaforo(int qtd) {
        ArrayList <LightStage> semaforo = new ArrayList();
        for(int i=1;i<qtd;i++){
            LightStage stage = new LightStage(i);
            stage.name = "Processo "+ i;
            stage.state = "Sleeping";
            semaforo.add(stage);
        }
        
    }
    @Override
    public toString(){
        String string = "";
        for(semaforo:processos)
        return string;
    }
    
    
}
