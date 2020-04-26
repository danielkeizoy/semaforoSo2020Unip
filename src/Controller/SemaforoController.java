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
            System.out.println(semaforo.toString());
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
            impressao = "O processo - " + aProcesso.name + " esta solicitando um recurso." + System.lineSeparator() + semaforo.toString();
            System.out.println(impressao);                    
        }
        
        //Quarto passo
        quarto = aSemaforo.recursos;
        System.out.println(impressao);
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
        TimeUnit.SECONDS.sleep(1); // sleep 1 sec
//        System.out.println("Espera 2 segundos." + System.lineSeparator());
        System.out.println(impressao);
        aProcesso.tur--;
        updateSemaforo(aSemaforo,aProcesso);
        if(aProcesso.tur == 0){
            System.out.println("processo finalizado"+ System.lineSeparator());
            up(aSemaforo, aProcesso);
        }
        
    }
    
    public void up(Semaforo theSemaforo, Processo theProcesso){
        //sexto passo
        System.out.println(impressao);
//        System.out.println("DEU UP" + System.lineSeparator());
        
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
