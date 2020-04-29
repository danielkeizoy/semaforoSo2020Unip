/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

public class Processo {
    public String status;
    public int tur;
    public String name;
    Random rand = new Random();
    public boolean solicitandoRecurso;

    public Processo(int i) {
        this.name = "P" + i;
        this.tur = rand.nextInt(16) + 1;
        this.status = "Livre";
        this.solicitandoRecurso = false;
    }
    
    public void setStatus(String aString){
        this.status = aString;
    }
    
    public String getStatus(){
        return this.status;
    }
    @Override
    public String toString(){
        String newLine = System.lineSeparator();
        String stringa = "Processo - " + this.name + newLine + "Tempo - "+ this.tur + newLine + "Status - " + getStatus() + newLine + newLine;
        return stringa;
    }

}
