/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        System.out.println(semaforo);
        //TODO imprime uma vez os dados de cada processo
    }
    
}
