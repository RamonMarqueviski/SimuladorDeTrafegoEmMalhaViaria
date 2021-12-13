package Controllers;

import Model.MalhaViaria;
import View.Home;

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
