package Model;

import View.Home;
import java.awt.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class MalhaViaria extends Thread {

    ;
    private static Celula[][] matriz;
    private boolean inicio;
    private int speed;
    private JTextArea tamostrar;

    public MalhaViaria(Celula[][] matriz, JTextArea taMostrar) {
        this.matriz = matriz;
        this.inicio = false;
        this.speed = 100;
        this.tamostrar = taMostrar;
    }

    public void run() {
        while (true) {
            try {

                tamostrar.setText(null);
                tamostrar.append(lerMalha());
                Thread.sleep((long) (1000 / speed));
                if (temCarro() == false) {
                    tamostrar.setText(null);
                    tamostrar.append(lerMalha());
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MalhaViaria.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public String lerMalha() {
        setarTipos();
        String malha = "";
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                malha += " " + this.matriz[i][j].getTipoFormatado() + " ";
            }
            malha += "\n";
        }
        return malha;
    }

    public void setarTipos() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                if (!this.matriz[i][j].isOcupado()) {
                    switch (this.matriz[i][j].getTipo()) {
                        case "0":
                            this.matriz[i][j].setTipoFormatado("  ");
                            break;
                        case "1":
                            this.matriz[i][j].setTipoFormatado(" I ");
                            break;
                        case "2":
                            this.matriz[i][j].setTipoFormatado(">");
                            break;
                        case "3":
                            this.matriz[i][j].setTipoFormatado(" I ");
                            break;
                        case "4":
                            this.matriz[i][j].setTipoFormatado("<");
                            break;
                        case "5":
                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "6":
                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "7":

                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "8":

                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "9":
                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "10":
                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "11":

                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                        case "12":

                            this.matriz[i][j].setTipoFormatado("+");
                            break;
                    }
                } else {
                    this.matriz[i][j].setTipoFormatado("•");
                }
            }
        }
    }

    public int getSizeLinha() {
        return matriz[0].length;
    }

    public int getSizeColuna() {
        return matriz.length;
    }

    public Celula[][] getMatriz() {
        return matriz;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean temCarro() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                if (this.matriz[i][j].isOcupado()) {
                    return true;
                }
            }
        }
        return false;
    }
  
}
