/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfacesGraficas;

import controle.ContaControle;
import controle.BancoControle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.entidades.Banco;
import modelos.entidades.Conta;


/**
 *
 * @author João
 */
public class TelaDeContas extends javax.swing.JFrame {

    ContaControle objContaControle = new ContaControle();
    BancoControle bancoControler = new BancoControle();

    /**
     * Creates new form TelaConta
     */
    public TelaDeContas() throws Exception {
        this.setLocationRelativeTo(null);
        initComponents();
        mostrarListagem();
    }

    private void mostrarListagem() throws Exception {
        try {
            ArrayList<Conta> arrayDasContas = objContaControle.listagem();
            DefaultTableModel model = (DefaultTableModel) jTableResumoDeContas.getModel();
            model.setNumRows(0);

            for (int pos = 0; pos < arrayDasContas.size(); pos++) {
                String[] saida = new String[6];
                Conta aux = arrayDasContas.get(pos);
                saida[0] = aux.getDescricao();
                saida[1] = aux.getConta() + "";
                saida[2] = aux.getAgencia() + "";
                saida[3] = aux.getTitular() + "";
                saida[4] = "R$ " + aux.getLimite() + "";
                saida[5] = "R$ " + aux.getSaldo() + "";
                model.addRow(saida);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    //Limpar tela
    public void limparTela() {
        jComboBoxBanco.addItem("");
        jTextFieldLimiteDaConta.setText("");
        jTextFieldNomeTitular.setText("");
        jTextFieldNumeroAgencia.setText("");
        jTextFieldNumeroContaCorrente.setText("");
        jTextFieldSaldo.setText("");

    }
    
    //ComboBox
    public void montarComboBanco(){
        try {
            ArrayList<Banco> banco = bancoControler.listagem();
            String[] bancoArray = new String[banco.size()];
            for(int index = 0; index < banco.size(); index++){
                bancoArray[index] = banco.get(index).getDescricao();
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(bancoArray);
            jComboBoxBanco.setModel(model);
                    
                    
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumeroContaCorrente = new javax.swing.JTextField();
        jTextFieldNumeroAgencia = new javax.swing.JTextField();
        jTextFieldNomeTitular = new javax.swing.JTextField();
        jTextFieldLimiteDaConta = new javax.swing.JTextField();
        jTextFieldSaldo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResumoDeContas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxBanco = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU DE CONTAS");

        jPanel3.setBackground(new java.awt.Color(101, 111, 255));

        jButtonCadastrar.setFont(new java.awt.Font("Iosevka Fixed", 1, 15)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Iosevka Fixed", 1, 15)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Iosevka Fixed", 1, 15)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Iosevka Fixed", 1, 15)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Iosevka Fixed", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("C'Wallet");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel8)
                .addGap(123, 123, 123)
                .addComponent(jButtonCadastrar)
                .addGap(34, 34, 34)
                .addComponent(jButtonExcluir)
                .addGap(41, 41, 41)
                .addComponent(jButtonAlterar)
                .addGap(44, 44, 44)
                .addComponent(jButtonVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Iosevka Fixed", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Banco");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Iosevka Fixed", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero da Conta Corrente");

        jLabel3.setFont(new java.awt.Font("Iosevka Fixed", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero da Agência");

        jLabel4.setFont(new java.awt.Font("Iosevka Fixed", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome do Títular");

        jLabel5.setFont(new java.awt.Font("Iosevka Fixed", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Limite da Conta Corrente");

        jLabel6.setFont(new java.awt.Font("Iosevka Fixed", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Saldo");

        jTableResumoDeContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Banco", "Conta Corrente", "Agencia", "Titular", "Limite de CC", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(jTableResumoDeContas);

        jLabel7.setFont(new java.awt.Font("Iosevka Fixed", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lista de Contas Cadastradas");

        jComboBoxBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caixa Economica", "Santander", "Itau", "Bradesco", "Safra", "Sicoob", "C6", "NUBank", "Inter", "Next", "PicPay" }));
        jComboBoxBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNumeroContaCorrente, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jTextFieldNumeroAgencia)
                    .addComponent(jTextFieldNomeTitular)
                    .addComponent(jTextFieldLimiteDaConta)
                    .addComponent(jTextFieldSaldo)
                    .addComponent(jComboBoxBanco, 0, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumeroContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumeroAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLimiteDaConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        try {
            
            if(jTextFieldNumeroContaCorrente.getText().isEmpty() || jTextFieldNumeroAgencia.getText().isEmpty() || jTextFieldNomeTitular.getText().isEmpty() || jTextFieldLimiteDaConta.getText().isEmpty() || jTextFieldSaldo.getText().isEmpty()){
                throw new Exception("Por favor preencher todos os campos");
            }
            
            Conta cc = new Conta();
            
            cc.setDescricao(jComboBoxBanco.getSelectedItem().toString());
            cc.setConta(Integer.parseInt(jTextFieldNumeroContaCorrente.getText()));
            cc.setAgencia(Integer.parseInt(jTextFieldNumeroAgencia.getText()));
            cc.setTitular(jTextFieldNomeTitular.getText());
            cc.setLimite(Double.parseDouble(jTextFieldLimiteDaConta.getText()));
            cc.setSaldo(Double.parseDouble(jTextFieldSaldo.getText()));
            
            
            
            objContaControle.incluir(cc);
            limparTela();
            mostrarListagem();

            

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jComboBoxBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBancoActionPerformed
      
    }//GEN-LAST:event_jComboBoxBancoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        
        try {
            
            String str = jTextFieldNumeroContaCorrente.getText();
            int conta = Integer.parseInt(str);
            if(str.length() == 0){
                throw new Exception("Preencha o campo de CONTA para que a operação possa ser realizada");
            }
           
            
            Conta objConta = objContaControle.consultarPorConta(conta);
            if(objConta == null){
                throw new Exception("Conta não existe no sistema");
            }
            
            
            objContaControle.apagarPorConta(conta);
            limparTela();
            mostrarListagem();
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        try {
            String str = jTextFieldNumeroContaCorrente.getText();
            
            int cc = Integer.parseInt(str);
            
            if(str.length() == 0){
                throw new Exception("Por favor preencha o campo de conta corrente");
            }
            
            Conta contaModificada = new Conta();
            
            contaModificada.setDescricao(jComboBoxBanco.getSelectedItem().toString());
            contaModificada.setConta(Integer.parseInt(jTextFieldNumeroContaCorrente.getText()));
            contaModificada.setAgencia(Integer.parseInt(jTextFieldNumeroAgencia.getText()));
            contaModificada.setTitular(jTextFieldNomeTitular.getText());
            contaModificada.setLimite(Double.parseDouble(jTextFieldLimiteDaConta.getText()));
            contaModificada.setSaldo(Double.parseDouble(jTextFieldSaldo.getText()));
            
            
            objContaControle.alterar(contaModificada);
            limparTela();
            mostrarListagem();
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        Inicial inicial = new Inicial();
        inicial.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaDeContas().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaDeContas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResumoDeContas;
    private javax.swing.JTextField jTextFieldLimiteDaConta;
    private javax.swing.JTextField jTextFieldNomeTitular;
    private javax.swing.JTextField jTextFieldNumeroAgencia;
    private javax.swing.JTextField jTextFieldNumeroContaCorrente;
    private javax.swing.JTextField jTextFieldSaldo;
    // End of variables declaration//GEN-END:variables
}