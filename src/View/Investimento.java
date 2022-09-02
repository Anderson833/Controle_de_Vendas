/*
  Essa classe realizar os calculos de investimentos, lucros e do valor total de todos produtos vendidos
 */
package View;

import Conexao.Conexao_BD;
import Dao.InvestimentoDao;
import Model.ApenasNumeros;
import Model.Data;
import Model.InvestimentoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class Investimento extends javax.swing.JFrame {

    
    public Investimento() {
        initComponents();
        setLocationRelativeTo(this);
        //método que só poder digita números
        soApenasNumeros();
        //método para seta a data do dia no campo de texto
        DataDoDia();
    }
        //variaveis para armazenar os dados de investimentos, valor total de todos produtos e o valor de todo lucro
     double valorDeTodoInvestimento=0;
     double valorTotalDeTDProdutosVendido=0;
     double valorDeTodoLucro=0;
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodInvestimento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValorDeRevenda = new javax.swing.JTextField();
        txtValorDeComprar = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        LABELvalorDoLucro = new javax.swing.JLabel();
        LABELvalorDoInvestimento = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fazeCalculor = new javax.swing.JButton();
        labelValorDEtodosVendidos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInvestimento = new javax.swing.JTable();
        Alterar = new javax.swing.JButton();
        salvarInvestimentos = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        visualizar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 102));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        txtCodInvestimento.setEditable(false);
        txtCodInvestimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodInvestimentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código do Investimento:");

        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });
        txtNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeProdutoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Valor Total De Tds Produto Vendidos:");

        txtValorDeRevenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDeRevendaActionPerformed(evt);
            }
        });
        txtValorDeRevenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorDeRevendaKeyReleased(evt);
            }
        });

        txtValorDeComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDeComprarActionPerformed(evt);
            }
        });
        txtValorDeComprar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorDeComprarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorDeComprarKeyReleased(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataKeyReleased(evt);
            }
        });

        jLabel3.setText("Nome do Produto:");

        jLabel4.setText("Data:");

        jLabel5.setText("Valor De Comprar:");

        jLabel6.setText("Valor De Revendar:");

        jLabel7.setText("Quantidade:");

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        LABELvalorDoLucro.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        LABELvalorDoInvestimento.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Valor Do Lucro:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Valor Do Investimento:");

        fazeCalculor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/calculadora-de-impressao.png"))); // NOI18N
        fazeCalculor.setText("Calcular");
        fazeCalculor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazeCalculorActionPerformed(evt);
            }
        });

        labelValorDEtodosVendidos.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel8.setText("   Registrar Investimentos");

        tbInvestimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodInvestir", "NomeProduto", "Quantidade", "ValorDeComprar", "ValorDeRevendar", "ValorInvestidor", "ValorDeTdVendidos", "ValorDoLucro", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbInvestimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbInvestimentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbInvestimento);

        Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        salvarInvestimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/esta-bem.png"))); // NOI18N
        salvarInvestimentos.setText("Investir");
        salvarInvestimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarInvestimentosActionPerformed(evt);
            }
        });

        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Listar Tudo");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorDeComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorDeRevenda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LABELvalorDoInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(289, 289, 289))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(salvarInvestimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(fazeCalculor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelValorDEtodosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LABELvalorDoLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(735, 735, 735)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorDeRevenda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorDeComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelValorDEtodosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LABELvalorDoInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LABELvalorDoLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarInvestimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fazeCalculor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fazeCalculorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazeCalculorActionPerformed
      
        RealizarOsCalculosEsetaValores();
    
    }//GEN-LAST:event_fazeCalculorActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed

    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
         DataDoDia();   
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtValorDeComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDeComprarActionPerformed

    }//GEN-LAST:event_txtValorDeComprarActionPerformed

    private void txtValorDeRevendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDeRevendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDeRevendaActionPerformed

    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed

    private void txtCodInvestimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodInvestimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodInvestimentoActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
       
         //Método para saber se campo do código está vázio
      
        if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarOsInnvestimentos();
        }else{
           //método para fazer o calculor do investimento de um produto especifico
        calculorDoInvestimento();
        //Método para altera 
        alterarInvestimento();
         //Método para visualizar os investimentos 
        visualizarOsInnvestimentos();
        }
       
        
         //método para fazer o calculor de todos investimentos
        // RealizarOsCalculosEsetaValores();
    }//GEN-LAST:event_AlterarActionPerformed

    private void salvarInvestimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarInvestimentosActionPerformed
       
        
        
        if(preencherCampos()){
            
        }else{
         //método para fazer o calculor do investimento de um produto especifico
         calculorDoInvestimento();
         //Método para salvar os dados de investimetos
         addInvestimento();
          //Método para visualizar os investimentos 
       visualizarOsInnvestimentos(); 
        }
            
        
       
        
    }//GEN-LAST:event_salvarInvestimentosActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
      
        
        
         if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarOsInnvestimentos();
        }else{
            //Método para excluir
           deletaInvestimento();
           //Método para limpar os campos de textos e as label 
           limpaCampos();
           //método para limpar as linhas da tabela
           limpalinhas();
         //método para fazer o calculor de todos investimentos
         RealizarOsCalculosEsetaValores();
         //Método para visualizar os investimentos
        visualizarOsInnvestimentos();
        }
       
      
    }//GEN-LAST:event_ExcluirActionPerformed
    
     //Método para limpar as linhas da tabela
    public void limpalinhas() {
        DefaultTableModel dm = (DefaultTableModel) tbInvestimento.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }
    
    
    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        
        //Método para visualizar os investimentos 
        visualizarOsInnvestimentos();
    }//GEN-LAST:event_visualizarActionPerformed

    private void tbInvestimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbInvestimentoMouseClicked
      
      
            txtCodInvestimento.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),0).toString());
            txtNomeProduto.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),1).toString());
            txtQuantidade.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),2).toString());
            txtValorDeComprar.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),3).toString());
            txtValorDeRevenda.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),4).toString());
            LABELvalorDoInvestimento.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),5).toString()); 
            labelValorDEtodosVendidos.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),6).toString());
            LABELvalorDoLucro.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),7).toString()); 
            txtData.setText(tbInvestimento.getValueAt(tbInvestimento.getSelectedRow(),8).toString());
      
        
    }//GEN-LAST:event_tbInvestimentoMouseClicked

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
       limpaCampos();
        //método para limpar as linhas da tabela
        limpalinhas();
    }//GEN-LAST:event_limparActionPerformed

    private void txtValorDeComprarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDeComprarKeyPressed
      
     
    }//GEN-LAST:event_txtValorDeComprarKeyPressed

    private void txtValorDeComprarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDeComprarKeyReleased
      //condição para permitir apenas números
        if(sonumeros(txtValorDeComprar.getText())){
           
        }else{
            
             if(txtValorDeComprar.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtValorDeComprar.setText("");
           txtValorDeComprar.requestFocus();
         }
    }//GEN-LAST:event_txtValorDeComprarKeyReleased

    private void txtValorDeRevendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDeRevendaKeyReleased
         //condição para permitir apenas números
        if(sonumeros(txtValorDeRevenda.getText())){
        }else{
            if(txtValorDeRevenda.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
            txtValorDeRevenda.setText("");
           
           txtValorDeRevenda.requestFocus();
         }
    }//GEN-LAST:event_txtValorDeRevendaKeyReleased

    private void txtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyReleased
      
        //condição para permitir apenas números
        if(sonumeros(txtData.getText())){
        }else{
             if(txtData.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtData.setText("");
           txtData.requestFocus();
         }
    }//GEN-LAST:event_txtDataKeyReleased

    private void txtNomeProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeProdutoKeyReleased
         //condição para impedir números
        if(checkLetters(txtNomeProduto.getText())){
          
        }else{
             if(txtNomeProduto.getText().isEmpty()){
                
            }else{
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         txtNomeProduto.setText("");
           txtNomeProduto.requestFocus();
             }
        }
    }//GEN-LAST:event_txtNomeProdutoKeyReleased
   //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtCodInvestimento.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }
      
      //Método para mandar preenche os campos
    public boolean preencherCampos(){
        boolean vrg=false;
        if(txtNomeProduto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtNomeProduto.requestFocus();
            vrg=true;
        }else
        if(txtValorDeComprar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtValorDeComprar.requestFocus();
             vrg=true;
        }else
        if(txtValorDeRevenda.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtValorDeRevenda.requestFocus();
             vrg=true;
        }else
          if(txtData.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtData.requestFocus();
             vrg=true;
        }
        else
          if(txtQuantidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtQuantidade.requestFocus();
             vrg=true;
        }
        return vrg;
    }
    //método para a limpar os campos 
   public void limpaCampos(){
       txtCodInvestimento.setText(" ");
       txtData.setText("");
       txtNomeProduto.setText("");
       txtQuantidade.setText("");
       txtValorDeComprar.setText("");
       txtValorDeRevenda.setText("");
       labelValorDEtodosVendidos.setText("");
       LABELvalorDoLucro.setText("");
       LABELvalorDoInvestimento.setText("");
               
   }
    
     // class para formatar os números com casas decimais
  DecimalFormat def = new DecimalFormat("#,##0.00");
    //Método para fazer o calculor do investimento e do lucro
    public void calculorDoInvestimento(){
        //Passando valor de comprar de String para double
        double valorDeCompra=Double.parseDouble(txtValorDeComprar.getText());
        
          //Passando valor de revendar de String para double
        double valorDeRevendar=Double.parseDouble(txtValorDeRevenda.getText());
        
          //Passando valor de quantidade de String para double
        int Quantidade=Integer.parseInt(txtQuantidade.getText());
        
        // multiplicação do produto pelo preço de comprar vezes a quantidade
        double investir=valorDeCompra*Quantidade;
        
        //multiplicação de todos produtos pelo preço de revendar vezez a quantidade;
        double total=valorDeRevendar*Quantidade;
        
        //subtração para saber do lucro conseguidor pela venda de todos os produtos
        double lucro=total-investir;
        
       //  String s=def.format(lucro);
        //double a=Double.parseDouble(s);
        
        // Exibir o valor do investimento
        LABELvalorDoInvestimento.setText(" "+investir);
        // Exibir o valor do lucro
        LABELvalorDoLucro.setText(" "+lucro);
        // exibir o valor total de todos produtos vendidos
        labelValorDEtodosVendidos.setText(" "+total);
        
    }
    
    
    //Método para adicionar os dados do investimentos;
     public void addInvestimento(){
         try {
              //instanciando a classe InvestimetoDao para criar um objeto 
         InvestimentoDao dao =new InvestimentoDao();
         // Instanciando a classe InvestimetoModel para criar um objeto 
         InvestimentoModel invest = new InvestimentoModel();
         invest.setNomeProduto(txtNomeProduto.getText());
         invest.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
         invest.setValorDeComprar(Double.parseDouble(txtValorDeComprar.getText()));
         invest.setValorDeRevenda(Double.parseDouble(txtValorDeRevenda.getText()));
         invest.setValorDoInvestimento(Double.parseDouble(LABELvalorDoInvestimento.getText()));
         invest.setValorTotalDeTodasVendas(Double.parseDouble(labelValorDEtodosVendidos.getText()));
         invest.setValorDoLucro(Double.parseDouble(LABELvalorDoLucro.getText()));
         invest.setData(txtData.getText());
         // Passando o objeto invest no método  
         dao.adicionaInvestimento(invest);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " error"+e);
         }
         
     }
    
     
     //Método para visualizar os dados de investimentos;
    public void visualizarOsInnvestimentos(){
        
         //Instanciando a classe InvestimentoDao;
         InvestimentoDao dao =new InvestimentoDao();

          DefaultTableModel modelo = (DefaultTableModel) tbInvestimento.getModel();
          //método para não repetir os dados
          modelo.setNumRows(0);
        
          //Laço de repetição para buscar os dados ;
          for (InvestimentoModel invest :dao.visualizarInvestimento() ) {
             modelo.addRow(new Object[] {
             invest.getCodInvestimento(),
             invest.getNomeProduto(),
             invest.getQuantidadeProduto(),
             invest.getValorDeComprar(),
             invest.getValorDeRevenda(),
             invest.getValorDoInvestimento(),
             invest.getValorTotalDeTodasVendas(),
             invest.getValorDoLucro(),
             invest.getData()
             
             
             });
              
              
        }
        
    }
    //Método para alterar algum investimento
    public void alterarInvestimento(){
        
        InvestimentoDao daoalt = new InvestimentoDao();
        
        InvestimentoModel in =new InvestimentoModel();
        in.setNomeProduto(txtNomeProduto.getText());
        in.setQuantidadeProduto(Integer.parseInt(txtQuantidade.getText()));
        in.setValorDeComprar(Double.parseDouble(txtValorDeComprar.getText()));
        in.setValorDeRevenda(Double.parseDouble(txtValorDeRevenda.getText()));
        in.setValorDoInvestimento(Double.parseDouble(LABELvalorDoInvestimento.getText()));
        in.setValorTotalDeTodasVendas(Double.parseDouble(labelValorDEtodosVendidos.getText()));
        in.setValorDoLucro(Double.parseDouble(LABELvalorDoLucro.getText()));
        in.setData(txtData.getText());
        in.setCodInvestimento(Integer.parseInt(txtCodInvestimento.getText()));
        
        daoalt.atualizarDadosDoInvestimentos(in);
    }
     //Método para deleta um investimento
     public void deletaInvestimento(){
         InvestimentoDao excluir = new InvestimentoDao();
        
        InvestimentoModel deleta =new InvestimentoModel();
        deleta.setCodInvestimento(Integer.parseInt(txtCodInvestimento.getText()));
        excluir.deletaInvestimento(deleta);
     }
     
     
        //Método para realizar as somas do investimentos, lucro e de todos produtos vendidos  
       public  void RealizarOsCalculosEsetaValores(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            //comando para realizar a soma
            String sql = "SELECT (round(sum(ValorDoInvestimento))),(round(sum(ValorTotalDeTodosVendidos))),(round(sum(Lucro))) FROM investimento;";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
        
            while (Rst.next()) {
                                
                 valorDeTodoInvestimento=Rst.getDouble("(round(sum(ValorDoInvestimento)))");
                
                  valorTotalDeTDProdutosVendido= Rst.getDouble("(round(sum(ValorTotalDeTodosVendidos)))");
                  valorDeTodoLucro= Rst.getDouble("(round(sum(Lucro)))");
             
              // Passando os valores para 2 casas  decimais
              String valorInvestir=def.format(valorDeTodoInvestimento);
              String valorTotal=def.format(valorTotalDeTDProdutosVendido);
              String valorLucro=def.format(valorDeTodoLucro);
                  
                  LABELvalorDoInvestimento.setText(""+valorInvestir);
                  labelValorDEtodosVendidos.setText(""+valorTotal);
                   LABELvalorDoLucro.setText(""+valorLucro);
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Soma não realizadar !");
        }
        
     }
       
     
       //metodo para digita apenas números
    public void soApenasNumeros() {

       // txtData.setDocument(new ApenasNumeros());
        txtQuantidade.setDocument(new ApenasNumeros());
       // txtValorDeRevenda.setDocument(new ApenasNumeros());
       // txtValorDeComprar.setDocument(new ApenasNumeros());
        

          }
    
     //Método para mostrar a data ao abrir essa jFRAME investimento;
    public void DataDoDia() {
        Data dt = new Data();
        txtData.setText(dt.setaData());
      

    }
     public boolean sonumeros(String str){
        
         return str.matches("^[0./-9 ]+");
        
      // return s.matches("[^0-9]+");
    }
    
    //metodo para digita só nomes
    public boolean checkLetters(String str) {

        return str.matches("[a-zA-Z Á É ÃÀ à í é ê ô ó á!úûí õ ç â~,.ã^~,.]+");
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Investimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Excluir;
    private javax.swing.JLabel LABELvalorDoInvestimento;
    private javax.swing.JLabel LABELvalorDoLucro;
    private javax.swing.JButton fazeCalculor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelValorDEtodosVendidos;
    private javax.swing.JButton limpar;
    private javax.swing.JButton salvarInvestimentos;
    private javax.swing.JTable tbInvestimento;
    private javax.swing.JTextField txtCodInvestimento;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorDeComprar;
    private javax.swing.JTextField txtValorDeRevenda;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}



