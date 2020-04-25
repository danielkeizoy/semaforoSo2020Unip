/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SemaforoController;

/**
 *
 * @author Daniel
 */
public class SemaforoSo2020Unip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SemaforoController semaforo = new SemaforoController(5);
        semaforo.start();
    }
    
}
