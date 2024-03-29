package View;

import Controllers.AdicionarCarro;
import Controllers.LeitorMalhaController;
import Model.Carro;
import Model.Celula;
import Model.MalhaViaria;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    private LeitorMalhaController leitor;
    private int quantidadeCarros;
    private float ms;
    private ArrayList<int[]> listaInicio = new ArrayList<int[]>();
    private boolean exec = true;
    private MalhaViaria malhaViaria;
    private AdicionarCarro adicionaCarro;

    public void atualizarTela(String malha) {
        taMostrar.append(malha);
    }

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        rbMonitor.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMostrar = new javax.swing.JTextArea();
        rbSemafaro = new javax.swing.JRadioButton();
        rbMonitor = new javax.swing.JRadioButton();
        btIniciar = new javax.swing.JToggleButton();
        btEncerrar = new javax.swing.JToggleButton();
        btSelecionaMalha = new javax.swing.JToggleButton();
        tfMilli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCarros = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nomes: Ramon Vinicius Marqueviski e João Pedro Solagna");

        taMostrar.setColumns(20);
        taMostrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        taMostrar.setRows(5);
        jScrollPane1.setViewportView(taMostrar);

        buttonGroup1.add(rbSemafaro);
        rbSemafaro.setText("Semáfaro");
        rbSemafaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSemafaroActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMonitor);
        rbMonitor.setText("Monitor");

        btIniciar.setText("Iniciar");
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        btEncerrar.setText("Encerrar");
        btEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEncerrarActionPerformed(evt);
            }
        });

        btSelecionaMalha.setText("Selecionar malha");
        btSelecionaMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaMalhaActionPerformed(evt);
            }
        });

        tfMilli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMilliActionPerformed(evt);
            }
        });

        jLabel2.setText("Intervalo em millisegundos entre surgimento carros");

        jLabel3.setText("Quantidade de carros na malha");

        tfCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCarrosActionPerformed(evt);
            }
        });

        jButton1.setText("Encerrar Apenas Carros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSelecionaMalha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEncerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCarros)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 186, Short.MAX_VALUE)
                                .addComponent(rbSemafaro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfMilli, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(9, 9, 9))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSelecionaMalha)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMilli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCarros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSemafaro)
                    .addComponent(rbMonitor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEncerrar)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbSemafaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSemafaroActionPerformed

    }//GEN-LAST:event_rbSemafaroActionPerformed

    private void btEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEncerrarActionPerformed
        malhaViaria.stop();
           
    }//GEN-LAST:event_btEncerrarActionPerformed

    private void tfCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCarrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCarrosActionPerformed

    private void btSelecionaMalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaMalhaActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChoser = new JFileChooser();
        fileChoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChoser.showSaveDialog(null);
        File arquivo = fileChoser.getSelectedFile();

        try {
            if (arquivo != null) {
                
                FileReader lerCaminhoDoTexto = new FileReader(arquivo);
                BufferedReader lerArquivo = new BufferedReader(lerCaminhoDoTexto);

                ArrayList<String> lista = new ArrayList<>();
                while (lerArquivo.ready()) {
                    String texto = lerArquivo.readLine();
                    String textoSplit[] = texto.split("\t");
                    for (int i = 0; i < textoSplit.length; i++) {
                        lista.add(textoSplit[i]);
                        //   taMostrar.append(textoSplit[i] + ' ');
                    }
                    //taMostrar.append("\n");
                }
                lerArquivo.close();

                //Coloca numa matriz normal
                String[][] matriz = new String[Integer.parseInt(lista.get(0))][Integer.parseInt(lista.get(1))];
                int cont = 2;
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[0].length; j++) {
                        matriz[i][j] = lista.get(cont);
                        cont++;
                    }
                }
                //Coloca na celula
                Celula[][] matrizCelula = new Celula[Integer.parseInt(lista.get(0))][Integer.parseInt(lista.get(1))];

                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[0].length; j++) {
                        String tipo = matriz[i][j];
                        String tipoFormatado = "";
                        boolean cruzamento = false;
                        int linha = i;
                        int coluna = j;
                        boolean inicio = false;
                        boolean fim = false;

                        switch (tipo) {
                            case "0":
                                tipoFormatado = " ";
                                break;
                            case "1":
                                tipoFormatado = "↑";
                                break;
                            case "2":
                                tipoFormatado = ">";
                                break;
                            case "3":
                                tipoFormatado = "↓";
                                break;
                            case "4":
                                tipoFormatado = "<";
                                break;
                            case "5":
                                tipoFormatado = " ";
                                break;
                            case "6":
                                tipoFormatado = " ";
                                cruzamento = true;
                                break;
                            case "7":
                                tipoFormatado = " ";
                                cruzamento = true;
                                break;
                            case "8":
                                tipoFormatado = " ";
                                cruzamento = true;
                                break;
                            case "9":
                                tipoFormatado = "9";
                                cruzamento = true;
                                break;
                            case "10":
                                tipoFormatado = "10";
                                cruzamento = true;
                                break;
                            case "11":
                                tipoFormatado = "11";
                                cruzamento = true;
                                break;
                            case "12":
                                tipoFormatado = "12";
                                cruzamento = true;
                                break;
                        }
                        int[] posicao = new int[2];
                        if (tipo.equals("1") && i == matriz.length - 1) {
                            inicio = true;
                            posicao[0] = i;
                            posicao[1] = j;
                            listaInicio.add(posicao);
                        } else if (tipo.equals("3") && i == 0) {
                            inicio = true;
                            posicao[0] = i;
                            posicao[1] = j;
                            listaInicio.add(posicao);
                        } else if (tipo.equals("2") && j == 0) {
                            inicio = true;
                            posicao[0] = i;
                            posicao[1] = j;
                            listaInicio.add(posicao);
                        } else if (tipo.equals("4") && j == matriz[0].length - 1) {
                            inicio = true;
                            posicao[0] = i;
                            posicao[1] = j;
                            listaInicio.add(posicao);
                        }

                        if (tipo.equals("1") && i == 0) {
                            fim = true;
                        } else if (tipo.equals("3") && i == matriz.length - 1) {
                            fim = true;
                        } else if (tipo.equals("2") && j == matriz[0].length - 1) {
                            fim = true;
                        } else if (tipo.equals("4") && j == 0) {
                            fim = true;
                        }
                        Celula celula = new Celula(tipo, tipoFormatado, cruzamento, linha, coluna, inicio, fim);
                        matrizCelula[i][j] = celula;
                    }
                }

                malhaViaria = new MalhaViaria(matrizCelula, taMostrar);
                taMostrar.append(malhaViaria.lerMalha());
                leitor = new LeitorMalhaController(this, malhaViaria);
            } else {
                JOptionPane.showMessageDialog(null, "É preciso selecionar um arquivo!");
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }


    }//GEN-LAST:event_btSelecionaMalhaActionPerformed

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        if (verificarCampos()) {
            iniciar();
        }
    }//GEN-LAST:event_btIniciarActionPerformed

    private void tfMilliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMilliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMilliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btEncerrar;
    private javax.swing.JToggleButton btIniciar;
    private javax.swing.JToggleButton btSelecionaMalha;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbMonitor;
    private javax.swing.JRadioButton rbSemafaro;
    private javax.swing.JTextArea taMostrar;
    private javax.swing.JTextField tfCarros;
    private javax.swing.JTextField tfMilli;
    // End of variables declaration//GEN-END:variables
public void iniciar() {
        if (rbSemafaro.isSelected()) {
            int quantidadeCarros = Integer.parseInt(tfCarros.getText());
            float ms = Float.parseFloat(tfMilli.getText());
            malhaViaria.start();
            adicionaCarro = new AdicionarCarro(listaInicio, ms, malhaViaria, quantidadeCarros, 0);
            adicionaCarro.start();
        } else {
            int quantidadeCarros = Integer.parseInt(tfCarros.getText());
            float ms = Float.parseFloat(tfMilli.getText());
            malhaViaria.start();
            adicionaCarro = new AdicionarCarro(listaInicio, ms, malhaViaria, quantidadeCarros, 1);
            adicionaCarro.start();
        }
    }

    public boolean verificarCampos() {
        if (tfCarros.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de quantidade de carros inválido!");
            return false;
        } else if (tfMilli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de ms inválido!");
            return false;
        }
        if (Integer.parseInt(tfCarros.getText()) < 2) {
            JOptionPane.showMessageDialog(null, "Carros precisam ser maior que 1");
            return false;
        }
        return true;
    }

}
