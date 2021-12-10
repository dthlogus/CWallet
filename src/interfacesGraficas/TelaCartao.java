/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;
import javax.swing.JOptionPane;
import modelos.entidades.Cartoes;
import controle.CartaoControle;
import controle.ContaControle;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.entidades.Conta;

/**
 *
 * @author luisg
 */
public class TelaCartao extends javax.swing.JFrame {
    CartaoControle objCartaoControle = new CartaoControle();
    ContaControle contaControle = new ContaControle();

    
    
    public TelaCartao() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void montarComboBoxConta(){
        try {
            ArrayList<Conta> contas = contaControle.listagem();
            String[] contasArray = new String[contas.size()];
            for (int index = 0; index < contas.size(); index++) {
                contasArray[index] = String.valueOf(contas.get(index).getConta());
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(contasArray);
           // jComboBoxConta.setModel(model);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    
    public void limparTela(){
        jTextFieldId.setText("");
        jTextFieldBandeira.setText("");
        jTextFieldNumeroDoCartao.setText("");
        jTextFieldNomeDoTuitular.setText("");
        jTextFieldCCV.setText("");
        jTextFieldLimite.setText("");
        jFormattedTextFieldDataDeVencimento.setText(" / ");
        jFormattedTextFieldDataDeFechamento.setText(" /");
        jFormattedTextFieldPagamento.setText(" / ");
    }
    private void mostrarListagem() throws Exception {
        try {
            ArrayList<Cartoes> arrayDosCartoes = objCartaoControle.listagem();
            DefaultTableModel model = (DefaultTableModel) jTableTabelaCartao.getModel();
            model.setNumRows(0);
            
            for(int pos = 0; pos < arrayDosCartoes.size(); pos++){
                String[] saida = new String[9];
                Cartoes aux = arrayDosCartoes.get(pos);
                saida[0] = aux.getId() + "";
                saida[1] = aux.getBandeiraDoCartao();
                saida[2] = aux.getNumeroDoCartao();
                saida[3] = aux.getNomeDoTitular();
                saida[4] = aux.getCCV();
                saida[5] = aux.getLimiteDoCartao() + "";
                saida[6] = aux.getDataDeVencimento() + "";
                saida[7] = aux.getDataDeFechamento() + "";
                saida[8] = aux.getDataDePagamento() + "";
                model.addRow(saida);
            }
            
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

        jPanelMenuLateral = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        Listar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanelTelaPrincipal = new javax.swing.JPanel();
        bandeiraDoCartaojLabel = new javax.swing.JLabel();
        NumeroDoCartaojLabel = new javax.swing.JLabel();
        NomeDoTitularjLabel = new javax.swing.JLabel();
        cCVjLabel = new javax.swing.JLabel();
        jTextFieldBandeira = new javax.swing.JTextField();
        jTextFieldNumeroDoCartao = new javax.swing.JTextField();
        jTextFieldNomeDoTuitular = new javax.swing.JTextField();
        jTextFieldLimite = new javax.swing.JTextField();
        jTextFieldCCV = new javax.swing.JTextField();
        limiteDoCartaojLabel = new javax.swing.JLabel();
        IdjLabel = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabelaCartao = new javax.swing.JTable();
        dataDeVencimentojLabel = new javax.swing.JLabel();
        dataDeFechamentojLabel = new javax.swing.JLabel();
        dataDePagamentojLabel = new javax.swing.JLabel();
        jFormattedTextFieldDataDeVencimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataDeFechamento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPagamento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C'Wallet - Cartões");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenuLateral.setBackground(new java.awt.Color(102, 102, 255));
        jPanelMenuLateral.setPreferredSize(new java.awt.Dimension(200, 900));

        jButtonIncluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonIncluir.setText("Confirmar");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("C'Wallet");

        jButtonEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        Listar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Listar.setText("Listar");
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLateralLayout = new javax.swing.GroupLayout(jPanelMenuLateral);
        jPanelMenuLateral.setLayout(jPanelMenuLateralLayout);
        jPanelMenuLateralLayout.setHorizontalGroup(
            jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                .addGroup(jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1))
                    .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Listar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(40, 40, 40))
        );
        jPanelMenuLateralLayout.setVerticalGroup(
            jPanelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLateralLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addComponent(jButtonIncluir)
                .addGap(50, 50, 50)
                .addComponent(jButtonEditar)
                .addGap(50, 50, 50)
                .addComponent(Listar)
                .addGap(50, 50, 50)
                .addComponent(jButtonExcluir)
                .addGap(50, 50, 50)
                .addComponent(jButtonVoltar)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMenuLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 900));

        jPanelTelaPrincipal.setBackground(new java.awt.Color(51, 153, 0));

        bandeiraDoCartaojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bandeiraDoCartaojLabel.setText("Bandeira do cartão :");

        NumeroDoCartaojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NumeroDoCartaojLabel.setText("Número do cartão :");

        NomeDoTitularjLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        NomeDoTitularjLabel.setText("Nome do TItular :");

        cCVjLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cCVjLabel.setText("CCV :");

        jTextFieldBandeira.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTextFieldNumeroDoCartao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTextFieldNomeDoTuitular.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTextFieldLimite.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTextFieldCCV.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        limiteDoCartaojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        limiteDoCartaojLabel.setText("Limite do cartão :");

        IdjLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IdjLabel.setText("ID :");

        jTextFieldId.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jTableTabelaCartao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableTabelaCartao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Bandeira do cartão", "Número do cartão", "Nome do titular", "CCV", "LImite do cartão", "Data de vencimento", "Data de fechamento", "Data de pagamento"
            }
        ));
        jScrollPane1.setViewportView(jTableTabelaCartao);

        dataDeVencimentojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dataDeVencimentojLabel.setText("Data de vencimento :");

        dataDeFechamentojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dataDeFechamentojLabel.setText("Data de fechamento :");

        dataDePagamentojLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        dataDePagamentojLabel.setText("Data de pagamento :");

        jFormattedTextFieldDataDeVencimento.setText(" /");
        jFormattedTextFieldDataDeVencimento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jFormattedTextFieldDataDeFechamento.setText(" /");
        jFormattedTextFieldDataDeFechamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jFormattedTextFieldPagamento.setText(" /");
        jFormattedTextFieldPagamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanelTelaPrincipalLayout = new javax.swing.GroupLayout(jPanelTelaPrincipal);
        jPanelTelaPrincipal.setLayout(jPanelTelaPrincipalLayout);
        jPanelTelaPrincipalLayout.setHorizontalGroup(
            jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(limiteDoCartaojLabel)
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(cCVjLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCCV, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(IdjLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(bandeiraDoCartaojLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(NumeroDoCartaojLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldNumeroDoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(NomeDoTitularjLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldNomeDoTuitular, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(210, 210, 210)
                                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(dataDeFechamentojLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldDataDeFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(dataDePagamentojLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldPagamento))
                                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                                        .addComponent(dataDeVencimentojLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldDataDeVencimento)))))
                        .addGap(0, 269, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelTelaPrincipalLayout.setVerticalGroup(
            jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdjLabel)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDeVencimentojLabel)
                    .addComponent(jFormattedTextFieldDataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bandeiraDoCartaojLabel)
                    .addComponent(jTextFieldBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDeFechamentojLabel)
                    .addComponent(jFormattedTextFieldDataDeFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroDoCartaojLabel)
                    .addComponent(jTextFieldNumeroDoCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDePagamentojLabel)
                    .addComponent(jFormattedTextFieldPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeDoTitularjLabel)
                    .addComponent(jTextFieldNomeDoTuitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cCVjLabel)
                            .addComponent(jTextFieldCCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(limiteDoCartaojLabel))
                    .addGroup(jPanelTelaPrincipalLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getContentPane().add(jPanelTelaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1300, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        // TODO add your handling code here:
        
        try {
            
            int id = Integer.parseInt(jTextFieldId.getText());
            String bandeiraDoCartao = jTextFieldBandeira.getText();
            String numeroDoCartao = jTextFieldNumeroDoCartao.getText();
            String nomeDoTitular = jTextFieldNomeDoTuitular.getText();
            String ccv = jTextFieldCCV.getText();
            double limite = Double.parseDouble(jTextFieldLimite.getText());
            String dataDeVencimento = jFormattedTextFieldDataDeVencimento.getText();
            String dataDeFechamento = jFormattedTextFieldDataDeFechamento.getText();
            String dataDePagamento = jFormattedTextFieldPagamento.getText();
           
            
            Cartoes objCartao = new Cartoes(id, bandeiraDoCartao, numeroDoCartao, nomeDoTitular, ccv, limite, dataDeVencimento, dataDeFechamento, dataDePagamento);
            objCartaoControle.incluir(objCartao);
            limparTela();
            mostrarListagem();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
        
  
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        try {
            String str  = jTextFieldId.getText();
            int id = Integer.parseInt(str);
            if(str.length() == 0) {
                throw new Exception("O Identificador esta VAZIO!");
            }
            Cartoes objCartoes = objCartaoControle.consultarPorId(id);
            if (objCartoes == null) {
                throw new Exception("Cartão não existe no sistema");
            }
            
            String bandeiraDoCartao = jTextFieldBandeira.getText();
            String numeroDoCartao = jTextFieldNumeroDoCartao.getText();
            String nomeDoTitular = jTextFieldNomeDoTuitular.getText();
            String ccv = jTextFieldCCV.getText();
            double limite = Double.parseDouble(jTextFieldLimite.getText());
            String dataDeVencimento = jFormattedTextFieldDataDeVencimento.getText();
            String dataDeFechamento = jFormattedTextFieldDataDeFechamento.getText();
            String dataDePagamento = jFormattedTextFieldPagamento.getText();
            
            Cartoes objCartoes1 = new Cartoes(id, bandeiraDoCartao, numeroDoCartao, nomeDoTitular, ccv, limite, dataDeVencimento, dataDeFechamento, dataDePagamento);
            
            objCartaoControle.alterar(objCartoes1);
            limparTela();
            mostrarListagem();
           
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
     
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        try {
            String str = jTextFieldId.getText();
            int id  = Integer.parseInt(str);
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse cartão ?") == 0){
            objCartaoControle.apagarPorId(id);
            limparTela();
            mostrarListagem(); 
            } 
            
                
            
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
        // TODO add your handling code here:
        try {
            String str = jTextFieldId.getText();
            int id = Integer.parseInt(str);
            if (str.length() == 0){
                throw new Exception("O Identifcador está vazio!");
            }
            Cartoes objCartao = objCartaoControle.consultarPorId(id);
            if (objCartao == null){
                throw new Exception ("Cartão não existe no sistema ");
                
            }
            jTextFieldId.setText(objCartao.getId() + "" );
            jTextFieldBandeira.setText(objCartao.getBandeiraDoCartao()+ "");
            jTextFieldNumeroDoCartao.setText(objCartao.getNumeroDoCartao() + "");
            jTextFieldNomeDoTuitular.setText(objCartao.getNomeDoTitular() + "");
            jTextFieldCCV.setText(objCartao.getCCV()+ "");
            jTextFieldLimite.setText(objCartao.getLimiteDoCartao()+"");
            jFormattedTextFieldDataDeVencimento.setText(objCartao.getDataDeVencimento()+ "");
            jFormattedTextFieldDataDeFechamento.setText(objCartao.getDataDeFechamento()+ "");
            jFormattedTextFieldPagamento.setText(objCartao.getDataDePagamento()+ "");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_ListarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCartao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdjLabel;
    private javax.swing.JButton Listar;
    private javax.swing.JLabel NomeDoTitularjLabel;
    private javax.swing.JLabel NumeroDoCartaojLabel;
    private javax.swing.JLabel bandeiraDoCartaojLabel;
    private javax.swing.JLabel cCVjLabel;
    private javax.swing.JLabel dataDeFechamentojLabel;
    private javax.swing.JLabel dataDePagamentojLabel;
    private javax.swing.JLabel dataDeVencimentojLabel;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeFechamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeVencimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelMenuLateral;
    private javax.swing.JPanel jPanelTelaPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaCartao;
    private javax.swing.JTextField jTextFieldBandeira;
    private javax.swing.JTextField jTextFieldCCV;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldLimite;
    private javax.swing.JTextField jTextFieldNomeDoTuitular;
    private javax.swing.JTextField jTextFieldNumeroDoCartao;
    private javax.swing.JLabel limiteDoCartaojLabel;
    // End of variables declaration//GEN-END:variables
}
