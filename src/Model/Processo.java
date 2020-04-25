/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.entities.Status;

import java.util.Random;

public class Processo {
    public Status status;
    public int tur;
    public String name;
    Random rand = new Random();

    Processo(int i) {
        this.name = "P" + i;
        this.tur = rand.nextInt(16) + 1;
        this.status = Status.LIVRE;
    }

    @Override
    public String toString(){
        String string = "";
        String newLine = System.lineSeparator();
        string = "Processo - " + this.name + newLine + "Tempo - "+ this.tur + newLine + "Status - " + this.status + newLine;
        return string;
    }

}
