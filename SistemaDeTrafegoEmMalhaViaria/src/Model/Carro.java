package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carro extends Thread {

    private Celula posicao;
    private float speed;
    private MalhaViaria malha;
    private int seletor;
    private ArrayList<Celula> cruzamentos;

    public Carro(Celula posicao, float speed, MalhaViaria malha, int seletor) {
        this.posicao = posicao;
        this.speed = speed;
        this.malha = malha;
        this.seletor = seletor;
        cruzamentos = new ArrayList<>();
    }

    public void run() {
        if (seletor == 0) {
            semaforo();
        } else {
            monitor();
        }
    }

    public int[] proximaPosicao(Celula celula) {
        int[] novaPos = new int[2];
        String tipoPosicaoAtual = celula.getTipo();
        Random random = new Random();
        switch (tipoPosicaoAtual) {
            case "1":
                if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                    if (random.nextInt(2) == 0) {
                        novaPos[0] = posicao.getLinha() - 1;
                        novaPos[1] = posicao.getColuna();
                        break;
                    }
                    //direita
                } else if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].isOcupado() && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].getTipo().equals("1") && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() - 1;
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                    //esquerda
                } else if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].isOcupado() && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].getTipo().equals("1") && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() - 1;
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                }

                break;
            case "2":
                if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                    novaPos[0] = posicao.getLinha();
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                    //cima
                } else if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].isOcupado() && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].getTipo().equals("2") && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() + 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() - 1;
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                    //baixo
                } else if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].isOcupado() && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].getTipo().equals("2") && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                }
                break;
            case "3":
                if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna();
                    break;
                    //Direita
                } else if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].isOcupado() && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].getTipo().equals("3") && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() + 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                    //Esquerda
                } else if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].isOcupado() && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].getTipo().equals("3") && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                }
                break;

            case "4":
                if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                    novaPos[0] = posicao.getLinha();
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                    //Cima
                } else if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].isOcupado() && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].getTipo().equals("4") && malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna() - 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() - 1;
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                    //baixo
                } else if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].isOcupado() && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].getTipo().equals("4") && malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna() - 1].isCruzamento() == false) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                }
                break;

            case "5":
                if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                    novaPos[0] = posicao.getLinha() - 1;
                    novaPos[1] = posicao.getColuna();
                    break;
                } else {
                    break;
                }

            case "6":
                if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                    novaPos[0] = posicao.getLinha();
                    novaPos[1] = posicao.getColuna() + 1;
                    break;
                } else {
                    break;
                }

            case "7":
                if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                    novaPos[0] = posicao.getLinha() + 1;
                    novaPos[1] = posicao.getColuna();
                    break;
                } else {
                    break;
                }
            case "8":
                if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                    novaPos[0] = posicao.getLinha();
                    novaPos[1] = posicao.getColuna() - 1;
                    break;
                } else {
                    break;
                }
            case "9":

                if (random.nextInt(2) == 0) {
                    if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() - 1;
                        novaPos[1] = posicao.getColuna();
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            break;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() + 1;
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() - 1;
                            novaPos[1] = posicao.getColuna();
                            break;
                        } else {
                            break;
                        }
                    }
                }

            case "10":
                if (random.nextInt(2) == 0) {
                    if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() - 1;
                        novaPos[1] = posicao.getColuna();
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() - 1;
                            break;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() - 1;
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() - 1;
                            novaPos[1] = posicao.getColuna();
                            break;
                        } else {
                            break;
                        }
                    }
                }
            case "11":
                if (random.nextInt(2) == 0) {
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() + 1;
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() + 1;
                            novaPos[1] = posicao.getColuna();
                            break;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() + 1;
                        novaPos[1] = posicao.getColuna();
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            case "12":
                if (random.nextInt(2) == 0) {
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() + 1;
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() + 1;
                            novaPos[1] = posicao.getColuna();
                            break;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() + 1;
                        novaPos[1] = posicao.getColuna();
                        break;
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            break;
                        } else {
                            break;
                        }
                    }
                }
        }
        return novaPos;
    }

    public Celula getPosicao() {
        return posicao;
    }

    public void setPosicao(Celula posicao) {
        this.posicao = posicao;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private boolean verificaSaida(Celula posicao) {
        if (posicao.isFim()) {
            return true;
        } else {
            return false;
        }
    }

    public void montaCruzamento(Celula posicao) {
        if (posicao.isCruzamento()) {
            String tipo = posicao.getTipo();
            int[] novaPos = new int[2];
            Random random = new Random();
            switch (tipo) {
                case "5":
                    if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() - 1;
                        novaPos[1] = posicao.getColuna();
                        cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                        montaCruzamento(posicao);
                        break;
                    }
                    break;
                case "6":
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() + 1;
                        cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                        montaCruzamento(posicao);
                        break;
                    }
                    break;
                case "7":
                    if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                        novaPos[0] = posicao.getLinha() + 1;
                        novaPos[1] = posicao.getColuna();
                        cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                        montaCruzamento(posicao);
                        break;
                    }
                    break;
                case "8":
                    if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                        novaPos[0] = posicao.getLinha();
                        novaPos[1] = posicao.getColuna() - 1;
                        cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                        montaCruzamento(posicao);
                        break;
                    }
                    break;
                case "9":
                    if (random.nextInt(2) == 0) {
                        if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() - 1;
                            novaPos[1] = posicao.getColuna();
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                                novaPos[0] = posicao.getLinha();
                                novaPos[1] = posicao.getColuna() + 1;
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                                novaPos[0] = posicao.getLinha() - 1;
                                novaPos[1] = posicao.getColuna();
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    }
                    break;
                case "10":
                    if (random.nextInt(2) == 0) {
                        if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() - 1;
                            novaPos[1] = posicao.getColuna();
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                                novaPos[0] = posicao.getLinha();
                                novaPos[1] = posicao.getColuna() - 1;
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() - 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() - 1;
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha() - 1][posicao.getColuna()].isOcupado()) {
                                novaPos[0] = posicao.getLinha() - 1;
                                novaPos[1] = posicao.getColuna();
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    }
                    break;
                case "11":
                    if (random.nextInt(2) == 0) {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                                novaPos[0] = posicao.getLinha() + 1;
                                novaPos[1] = posicao.getColuna();
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() + 1;
                            novaPos[1] = posicao.getColuna();
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                                novaPos[0] = posicao.getLinha();
                                novaPos[1] = posicao.getColuna() + 1;
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    }
                    break;
                case "12":
                    if (random.nextInt(2) == 0) {
                        if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                            novaPos[0] = posicao.getLinha();
                            novaPos[1] = posicao.getColuna() + 1;
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                                novaPos[0] = posicao.getLinha() + 1;
                                novaPos[1] = posicao.getColuna();
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    } else {
                        if (!malha.getMatriz()[posicao.getLinha() + 1][posicao.getColuna()].isOcupado()) {
                            novaPos[0] = posicao.getLinha() + 1;
                            novaPos[1] = posicao.getColuna();
                            cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                            montaCruzamento(posicao);
                            break;
                        } else {
                            if (!malha.getMatriz()[posicao.getLinha()][posicao.getColuna() + 1].isOcupado()) {
                                novaPos[0] = posicao.getLinha();
                                novaPos[1] = posicao.getColuna() + 1;
                                cruzamentos.add(malha.getMatriz()[novaPos[0]][novaPos[1]]);
                                montaCruzamento(posicao);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }

    public void semaforo() {
        while (true) {
            try {
                if (verificaSaida(posicao)) {
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setCarro(null);
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setOcupado(false);
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].release();
                    this.stop();
                } else {
                    int[] proxPos = proximaPosicao(posicao);
                    /*if (malha.getMatriz()[proxPos[0]][proxPos[1]].isCruzamento()) {
                        montaCruzamento(posicao);
                        for (int i = 0; i < cruzamentos.size(); i++) {
                            cruzamentos.get(i).setCarro(this);
                            cruzamentos.get(i).setOcupado(true);
                            this.posicao = cruzamentos.get(i);
                            cruzamentos.get(i).acquire();
                        }
                        for (int i = 0; i < cruzamentos.size(); i++) {
                            cruzamentos.get(i).setCarro(null);
                            cruzamentos.get(i).setOcupado(false);
                            cruzamentos.get(i).release();
                        }

                    }*/
                    if (proxPos[0] != 0 || proxPos[1] != 0) {
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setCarro(null);
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setOcupado(false);
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].release();

                        malha.getMatriz()[proxPos[0]][proxPos[1]].setCarro(this);
                        this.posicao = malha.getMatriz()[proxPos[0]][proxPos[1]];
                        malha.getMatriz()[proxPos[0]][proxPos[1]].setOcupado(true);
                        malha.getMatriz()[proxPos[0]][proxPos[1]].acquire();
                        Thread.sleep((long) (1000 / speed));
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public synchronized void monitor() {
        while (true) {
            try {
                if (verificaSaida(posicao)) {
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setCarro(null);
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setOcupado(false);
                    malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].release();
                    this.stop();
                } else {
                    int[] proxPos = proximaPosicao(posicao);
                    if (proxPos[0] != 0 || proxPos[1] != 0) {
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setCarro(null);
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].setOcupado(false);
                        malha.getMatriz()[posicao.getLinha()][posicao.getColuna()].release();

                        malha.getMatriz()[proxPos[0]][proxPos[1]].setCarro(this);
                        this.posicao = malha.getMatriz()[proxPos[0]][proxPos[1]];
                        malha.getMatriz()[proxPos[0]][proxPos[1]].setOcupado(true);
                        malha.getMatriz()[proxPos[0]][proxPos[1]].acquire();
                        Thread.sleep((long) (1000 / speed));
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    

}
