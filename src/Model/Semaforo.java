/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Semaforo{
    ArrayList<Processo> semaforo;
    public boolean recursos;

    public Semaforo(int qtd) {
        this.semaforo = new ArrayList();
        this.recursos = false;

        for(int i=0;i<qtd;i++){
            Processo process = new Processo(i+1);
            semaforo.add(process);
        }
        
    }
    @Override
    public String toString(){
        String string = "";
        for(Processo iterador: semaforo){
            string += iterador.toString();
        }
        return string;
    }
}
