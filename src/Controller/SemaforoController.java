/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Processo;
import Model.Semaforo;

/**
 *
 * @author Daniel
 */
public class SemaforoController {
    int qtd;
    Semaforo semaforo;
    public SemaforoController(int qtd) {
        this.qtd = qtd;
        this.semaforo = new Semaforo(qtd);
    }

    public void start() {
        int n = 4;
        System.out.println(semaforo);
        //TODO imprime uma vez os dados de cada processo

        for(int i = 0; i < n; i++){
            System.out.println(semaforo);
        }
    }

    public void down(Semaforo aSemaforo, Processo aProcesso){
        if(!(aSemaforo.recursos)){



        }
    }

}
