/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Carro;
import Model.Celula;
import Model.MalhaViaria;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramom
 */
public class AdicionarCarro extends Thread {

    private float ms;
    private MalhaViaria malha;
    private int qtdCarros;
    private ArrayList<int[]> listaInicio;
    private int seletor;

    public AdicionarCarro(ArrayList listaInicio, float ms, MalhaViaria malha, int qtdCarros,int seletor) {
        this.ms = ms;
        this.qtdCarros = qtdCarros;
        this.malha = malha;
        this.listaInicio = listaInicio;
        this.seletor = seletor;
    }

    public void run() {
        while (true) {
            try {
                if (contadorDeCarros() < qtdCarros) {
                    Random random = new Random();
                    int vel = random.nextInt(10);
                    if(vel == 0){
                        vel = 1;
                    }
                    int[] posicaoSaida = listaInicio.get(random.nextInt(listaInicio.size()));
                    new Carro(malha.getMatriz()[posicaoSaida[0]][posicaoSaida[1]],vel , malha,seletor).start();
                }
                Thread.sleep((long) (1000/ms));

            } catch (InterruptedException ex) {
                Logger.getLogger(AdicionarCarro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int contadorDeCarros() {
        int cont = 0;
        for (int i = 0; i < malha.getMatriz().length; i++) {
            for (int j = 0; j < malha.getMatriz()[0].length; j++) {
                if (malha.getMatriz()[i][j].isOcupado()) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
