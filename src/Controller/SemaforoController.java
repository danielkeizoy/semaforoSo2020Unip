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
    
    int quantidadeDeProcessos;
    int ultimoPedido;
    Semaforo semaforo;
    public boolean quarto;
    public String impressao;
    int numProcessoAleatorio;
    public Processo processo;
    
    public SemaforoController(int umaQuantidadeDeProcessos) {
        this.quantidadeDeProcessos = umaQuantidadeDeProcessos;
        this.semaforo = new Semaforo(umaQuantidadeDeProcessos);
        this.processo = new Processo(0);
    }
    
    public void delay()throws InterruptedException {
        TimeUnit.SECONDS.sleep(0);
    }
    public void start() throws InterruptedException {
        ultimoPedido = 0;
        int quatroPrintsSegundoPasso = 4;
        System.out.println(semaforo);
        
        Random randomizador = new Random();
        
        numProcessoAleatorio = 0;
        numProcessoAleatorio = randomizador.nextInt(quantidadeDeProcessos);
        Processo processo = semaforo.processos.get(numProcessoAleatorio);
        
        //Oitavo passo 
        int tempoTotal = 0;
        for(Processo iterador: semaforo.processos){
            tempoTotal += iterador.tur;
        }
        //Segundo passo
        impressao = semaforo.toString();
        for(int i = 0; i < quatroPrintsSegundoPasso; i++){
            System.out.println(semaforo.toString());
        }
        delay();
        
        for(Processo iterador: semaforo.processos){
            iterador.solicitandoRecurso = true;
            System.out.println("O processo - "+iterador.name+" esta solicitando recurso.");
            iterador.setStatus("Dormindo");
        }
        System.out.println(System.lineSeparator());
        delay();
        
        while(tempoTotal > 0){
            numProcessoAleatorio = 0;
            while(processo.status.equalsIgnoreCase("Finalizado")){                
                numProcessoAleatorio = new Random().nextInt(quantidadeDeProcessos);                
                processo = semaforo.processos.get(numProcessoAleatorio);
            }
            down(semaforo, processo);
            tempoTotal--;
        }
        down(semaforo, processo);
    }
  
    public void down(Semaforo aSemaforo, Processo aProcesso) throws InterruptedException{
        delay();
        //Terceiro passo
        if(!(aProcesso.status.equalsIgnoreCase("Em execucao"))){
            impressao = "O processo - " + aProcesso.name + " esta solicitando um recurso." + System.lineSeparator() + semaforo.toString();
            ultimoPedido = aSemaforo.processos.indexOf(aProcesso);
            System.out.println(impressao);                    
        }
        
        //Quarto passo
        quarto = aSemaforo.recursos;
//        System.out.println(impressao);
//        System.out.println("Quarto passo aqui" + System.lineSeparator());
        
        //Quinto passo
        String inExec = "Nao ha processo em execucao." + System.lineSeparator(); 
        if(quarto){
            if((aProcesso.status.equalsIgnoreCase("Livre")) || (aProcesso.status.equalsIgnoreCase("Dormindo"))){
//                System.out.println("processo entrou em execucao"+ System.lineSeparator());
                aProcesso.setStatus("Em execucao");               
                updateSemaforo(aSemaforo,aProcesso);
            }
                        
            
            //oitavo passo
            for(Processo iterador: aSemaforo.processos){
                if(iterador.status.equalsIgnoreCase("Em execucao")){
                inExec = "Processo em execucao - " + iterador.name + System.lineSeparator();
//                System.out.println("Achei um processo em execucao, o processo " + aProcesso.name + System.lineSeparator());
                }
            }
            impressao = inExec + aSemaforo.toString();
        }        
        
        //Sexto passo
        delay();
//        System.out.println("Espera 2 segundos." + System.lineSeparator());
        System.out.println(impressao);
        aProcesso.tur--;
        updateSemaforo(aSemaforo,aProcesso);
        numProcessoAleatorio = new Random().nextInt(quantidadeDeProcessos);        
        aProcesso = semaforo.processos.get(numProcessoAleatorio);
        processo = aProcesso; 
        System.out.println("O processo - "+processo.name+" esta solicitando recurso."+System.lineSeparator());        
        for(Processo iterador: aSemaforo.processos){
            if((iterador.tur == 0)&&(!(iterador.status.equalsIgnoreCase("Finalizado")))){
                up(aSemaforo, iterador);
            }
        }
        if((processo.status.equalsIgnoreCase("Em execucao")) || (processo.status.equalsIgnoreCase("Finalizado"))){
            System.out.println("O processo - " +processo.name+ " Esta em execucao ou finalizado");
            while(ultimoPedido == numProcessoAleatorio){
                numProcessoAleatorio = new Random().nextInt(quantidadeDeProcessos);        
                aProcesso = semaforo.processos.get(numProcessoAleatorio);
                processo = aProcesso;
            }
        }
    }
    
    public void up(Semaforo theSemaforo, Processo theProcesso){
        System.out.println("Realizando o UP no recurso!!!!"+ System.lineSeparator());
        //sexto passo
        System.out.println(impressao);
        
        //setimo passo
        theProcesso.setStatus("Finalizado");
        updateSemaforo(theSemaforo,theProcesso);
        theSemaforo.recursos = true;
    }

    private void updateSemaforo(Semaforo aSemaforo, Processo aProcesso) {
        for(Processo iterador: aSemaforo.processos){
            if(iterador.name.equalsIgnoreCase(aProcesso.name)){
                int i = aSemaforo.processos.indexOf(iterador);
                aSemaforo.processos.set(i, aProcesso);
            }
        }
    }
}
