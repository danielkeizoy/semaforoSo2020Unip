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
        
        //Oitavo passo 
        int tempoTotal = 0;
        for(Processo iterador: semaforo.processos){
            tempoTotal += iterador.tur;
        }
        //Segundo passo
        impressao = semaforo.toString();
        for(int i = 0; i < n; i++){
            System.out.println(impressao);
        }
        while(tempoTotal > 0){
            if(proc.status.equals(Status.FINALIZADO)){              
                p = new Random().nextInt(5);
                proc = semaforo.processos.get(p);
            }
            down(semaforo, proc);
            
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
            if((aProcesso.status.equals(Status.LIVRE)) || (aProcesso.status.equals(Status.DORMINDO))){
                aProcesso.status.setStatus(Status.EXECUCAO);
            }            
            String inExec = "Nao ha processo em execucao.";
            
            //oitavo passo
            for(Processo iterador: aSemaforo.processos){
                if((iterador.status.equals(Status.EXECUCAO))){
                    inExec = "Processo em execucao - " +iterador.name+ System.lineSeparator();
                }   
            }
            impressao = inExec + impressao;
        }        
        
        //Sexto passo
        aProcesso.tur--;
        if(aProcesso.tur == 0){
            up(aSemaforo, aProcesso);
        }
        
    }
    
    public void up(Semaforo theSemaforo, Processo theProcesso){
        //sexto passo
        System.out.println(impressao);
        
        //setimo passo
        theProcesso.status.setStatus(Status.FINALIZADO);
        theSemaforo.recursos = true;
        
//        int p = 0;
//        Random rand = new Random();        
//        
//        p = rand.nextInt(5);
//        Processo proc = aSemaforo.processos.get(p);
//        down(aSemaforo,proc);
//        if(!(proc.status.equals(Status.FINALIZADO))){
//            if(proc.tur == 0){
//            proc.status.setStatus(Status.FINALIZADO);
//            aSemaforo.recursos = true;
//            }
//        }
    }
}
