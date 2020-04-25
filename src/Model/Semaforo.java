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
    public ArrayList<Processo> processos;
    public boolean recursos;

    public Semaforo(int qtd) {
        this.processos = new ArrayList();
        this.recursos = false;

        for(int i=0;i<qtd;i++){
            Processo process = new Processo(i+1);
            processos.add(process);
        }
        
    }
    @Override
    public String toString(){
        String string = "";
        for(Processo iterador: processos){
            string += iterador.toString();
        }
        return string;
    }
}
