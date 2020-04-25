/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Processo {
    String status;
    int tur;
    String name;
    Random rand = new Random();

    Processo(int i) {
        this.name = "P" + i;
        this.tur = rand.nextInt(16);
    }

    @Override
    public String toString(){
        String string = "";
        String newLine = System.lineSeparator();
        string = "Processo - " + this.name + newLine + "Tempo - "+ this.tur + newLine + "Status - " + this.status + newLine;
        return string;
    }

}
