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
    Semaforo ls;
    public SemaforoController(int qtd) {
        this.qtd = qtd;
        this.ls = new Semaforo(qtd);
    }

    public void start() {
    
    }
    
}
