/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.MalhaViaria;
import View.Home;

/**
 *
 * @author ramom
 */
public class LeitorMalhaController {

    private Home telaInicial;
    private static MalhaViaria malha;
    public LeitorMalhaController(Home home,MalhaViaria malha) {
        this.telaInicial = home;
        this.malha = malha;
    }
    public void atualizar(){
            telaInicial.atualizarTela(malha.lerMalha());
    }
    
}
