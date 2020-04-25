/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Processo;
import Model.Semaforo;
import Model.entities.Status;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class SemaforoController {
    int qtd;
    Semaforo semaforo;
    public boolean quarto;
    public String impressao;
    public SemaforoController(int qtd) {
        this.qtd = qtd;
        this.semaforo = new Semaforo(qtd);
    }

    public void start() {
        int n = 4;
        System.out.println(semaforo);
        Random rand = new Random();
        int p = 0;
        p = rand.nextInt(5);
        Processo proc = semaforo.processos.get(p);
        if(proc.tur == 0){
            proc.status.setStatus(Status.FINALIZADO);
            up(semaforo);
        }
        //Segundo passo
        impressao = semaforo.toString();
        for(int i = 0; i < n; i++){
            System.out.println(impressao);
        }
    }
  
    public void down(Semaforo aSemaforo, Processo aProcesso){
        //Terceiro passo
        if(!(aProcesso.status.equals(Status.EXECUCAO))){
            impressao = "O processo - " + aProcesso.name + "esta solicitando um recurso." + System.lineSeparator() + impressao;
            System.out.println(impressao);                    
        }
        //Quarto passo
        quarto = aSemaforo.recursos;
        System.out.println(impressao);
        
        //Quinto passo
        if(quarto){
            if(!(aProcesso.status.equals(Status.LIVRE))){
                aProcesso.status.setStatus(Status.EXECUCAO);
            }
            String exec = aProcesso.name;
            impressao ="Processo em execucao - "+exec + System.lineSeparator()+ impressao;
            
        }
        
    }
    
    public void up(Semaforo aSemaforo){
        
        int p = 0;
        Random rand = new Random();        
        
        p = rand.nextInt(5);
        Processo proc = aSemaforo.processos.get(p);
        down(aSemaforo,proc);
        if(!(proc.status.equals(Status.FINALIZADO))){
            if(proc.tur == 0){
            proc.status.setStatus(Status.FINALIZADO);
            aSemaforo.recursos = true;
            }
        }
    }
}
