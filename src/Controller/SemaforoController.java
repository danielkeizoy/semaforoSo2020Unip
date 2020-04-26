/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Processo;
import Model.Semaforo;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    public void start() throws InterruptedException {
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
            if(proc.status.equalsIgnoreCase("Finalizado")){
                int q = 0;
                while(p == q){
                    q = new Random().nextInt(5);
                    System.out.println(q);
                }
                proc = semaforo.processos.get(q);
            }
            else{
                down(semaforo, proc);
            }
        }
    }
  
    public void down(Semaforo aSemaforo, Processo aProcesso) throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        //Terceiro passo
        if(!(aProcesso.status.equalsIgnoreCase("Em execucao"))){
            impressao = "O processo - " + aProcesso.name + " esta solicitando um recurso." + System.lineSeparator() + impressao;
            System.out.println(impressao);                    
        }
        
        //Quarto passo
        quarto = aSemaforo.recursos;
        System.out.println(impressao);
        
        //Quinto passo
        if(quarto){
            if((aProcesso.status.equalsIgnoreCase("Livre")) || (aProcesso.status.equalsIgnoreCase("Dormindo"))){
                System.out.println("processo entrou em execucao"+ System.lineSeparator());
                aProcesso.setStatus("Em execucao");
            }            
            String inExec = "Nao ha processo em execucao." + System.lineSeparator();
            
            //oitavo passo
            for(Processo iterador: aSemaforo.processos){
                if((iterador.status.equalsIgnoreCase("Em execucao"))){
                    System.out.println("achei um processo em execucao"+ System.lineSeparator());
                    inExec = "Processo em execucao - " +iterador.name+ System.lineSeparator();
                }   
            }
            impressao = inExec + impressao;
        }        
        
        //Sexto passo
        aProcesso.tur--;
        if(aProcesso.tur == 0){
            System.out.println("processo finalizado"+ System.lineSeparator());
            up(aSemaforo, aProcesso);
        }
        
    }
    
    public void up(Semaforo theSemaforo, Processo theProcesso){
        //sexto passo
        System.out.println(impressao);
        
        //setimo passo
        theProcesso.setStatus("Finalizado");
        theSemaforo.recursos = true;
        
//        int p = 0;
//        Random rand = new Random();        
//        
//        p = rand.nextInt(5);
//        Processo proc = aSemaforo.processos.get(p);
//        down(aSemaforo,proc);
//        if(!(proc.String.equals(String.FINALIZADO))){
//            if(proc.tur == 0){
//            proc.setString(String.FINALIZADO);
//            aSemaforo.recursos = true;
//            }
//        }
    }
}
