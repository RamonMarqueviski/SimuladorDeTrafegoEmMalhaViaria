/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ramom
 */
public class Celula {

    private boolean ocupado;
    private String tipo;
    private String tipoFormatado;
    private boolean cruzamento;
    private Celula[] posicoesAoRedor;
    private int linha;
    private int coluna;
    private boolean inicio;
    private boolean fim;
    private Carro carro;
    public Semaphore semaforo;

    public Celula(String tipo, String tipoFormatado, boolean cruzamento, int linha, int coluna, boolean inicio,boolean fim) {
        this.ocupado = false;
        this.tipo = tipo;
        this.tipoFormatado = tipoFormatado;
        this.cruzamento = cruzamento;
        this.linha = linha;
        this.coluna = coluna;
        this.inicio = inicio;
        this.fim = fim;
        this.carro = null;
        semaforo = new Semaphore(1);
    }

    @Override
    public String toString() {
        return "Celula{" + "ocupado=" + ocupado + ", tipo=" + tipo + ", tipoFormatado=" + tipoFormatado + ", cruzamento=" + cruzamento + ", posicoesAoRedor=" + posicoesAoRedor + ", linha=" + linha + ", coluna=" + coluna + ", inicio=" + inicio + '}';
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoFormatado() {
        return tipoFormatado;
    }

    public void setTipoFormatado(String tipoFormatado) {
        this.tipoFormatado = tipoFormatado;
    }

    public boolean isCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(boolean cruzamento) {
        this.cruzamento = cruzamento;
    }

    public Celula[] getPosicoesAoRedor() {
        return posicoesAoRedor;
    }

    public void setPosicoesAoRedor(Celula[] posicoesAoRedor) {
        this.posicoesAoRedor = posicoesAoRedor;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void acquire() throws InterruptedException {
        semaforo.acquire();
    }

    public void release() {
        semaforo.release();
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }
    
}
