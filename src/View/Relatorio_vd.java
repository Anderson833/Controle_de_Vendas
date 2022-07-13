/*
  Essa Jframe tem objetivo de realizar os calculor dos valores e armazenar os dados  
 */
package View;

import Conexao.Conexao_BD;
import Dao.ClienteDao;
import Dao.RelatorioDao;
import Model.ClienteModel;
import Model.RelatorioModel;
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
public class Relatorio_vd extends javax.swing.JFrame {

   
    public Relatorio_vd() {
        initComponents();
        setLocationRelativeTo(null);
        //Método que vai seta o total de todas despesas assim que a jframe abrir 
       RealizarSomaDasDespesas();
       
       //Método para realizar as soma de investimento, lucro, e valor todal de todos produtos na tabela de investimento;
       RealizarOsCalculosEsetaValores();
    }
       //variável para receber o total da soma de todas as despesas
      double ValorTotalDespesas=0; 
  
        //As Variaveis para receber os valores da jframe Investimento são else:
        //investimento,lucro, todo valor dos produtos vendidos;
       double valorDeTodoInvestimento=0;
       double valorTotalDeTDProdutosVendido=0;
       double valorDeTodoLucro=0;
       DecimalFormat def = new DecimalFormat("#,##0.00");
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodRe = new javax.swing.JTextField();
        txtDespesas = new javax.swing.JTextField();
        bTapagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        visualizar = new javax.swing.JButton();
        BTSALVAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelatorio = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        limpar = new javax.swing.JButton();
        Labeltotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        labelCapital = new javax.swing.JLabel();
        labelInvestimento1 = new javax.swing.JLabel();
        labelLucro = new javax.swing.JLabel();
        fazerCalculor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Alterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");

        jPanel1.setBackground(new java.awt.Color(162, 230, 229));

        jLabel2.setText(" Valor Das Despesas:");

        bTapagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        bTapagar.setText("Excluir");
        bTapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTapagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código Relatório:");

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Exibir");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        BTSALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        BTSALVAR.setText("Salvar");
        BTSALVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSALVARActionPerformed(evt);
            }
        });

        tbRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodRelatorio", "ValorDeDespesas", "ValorDoLucro", "ValorInvestidor", "ValorDeTdProdutosVendidos", "ValorDoCapital", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRelatorio);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Relatório Das Vendas");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        Labeltotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Valor Total De Todos Produtos Vendidos:");

        jLabel8.setText(" Valor Investidor:");

        jLabel10.setText("Valor Do lucro:");

        jLabel11.setText("Valor Do Capital:");

        jLabel12.setText("       Data:");

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        labelCapital.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelInvestimento1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelLucro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        fazerCalculor.setText("Calcular");
        fazerCalculor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazerCalculorActionPerformed(evt);
            }
        });

        jLabel3.setText("Realizar o calculor:");

        Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(340, 340, 340)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(453, 453, 453)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(labelInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(fazerCalculor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodRe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(BTSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(bTapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(65, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodRe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(Labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fazerCalculor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BTSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bTapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTapagarActionPerformed
          
        RelatorioDao daoRel = new RelatorioDao();
        
        RelatorioModel relModel = new RelatorioModel();
        relModel.setCodRelatorio(txtCodRe.getText());
        
        daoRel.deletaRelatorio(relModel);

    }//GEN-LAST:event_bTapagarActionPerformed
     
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
              //String valorTotal=def.format(valorTotalDeTDProdutosVendido);
              String valorLucro=def.format(valorDeTodoLucro);
                  
                  labelInvestimento1.setText(""+valorDeTodoInvestimento);
                  Labeltotal.setText(""+valorTotalDeTDProdutosVendido);
                   labelLucro.setText(""+valorDeTodoLucro);
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Soma não realizada !");
        }
        
     }
       //método para saber do valor total do capital
     public void rendimento(){
        
         double capital=valorTotalDeTDProdutosVendido-ValorTotalDespesas;
         
         labelCapital.setText(""+capital);
        
     }
    
    
    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        
      //Método para visualizar relatorio;
      visualizaRelatorio();
        //evitarDuplicacao();
    }//GEN-LAST:event_visualizarActionPerformed
             //Método para visualizar todo Relatório;
    public void visualizaRelatorio(){
        
        DefaultTableModel modelo = (DefaultTableModel) tbRelatorio.getModel();
        modelo.setNumRows(0);
        //Instânciando objeto RelatorioDao;
        RelatorioDao dao = new RelatorioDao();
        
        for (RelatorioModel relat : dao.visualizarRelatorio()) {
            modelo.addRow(new Object []{
            
            relat.getCodRelatorio(),
            relat.getValorDespesa(),
            relat.getValorLucro(),
            relat.getValorInvestido(),
            relat.getValorDeTodosProdutosVendidos(),
            relat.getCapital(),
            relat.getData()
   
            });
            
            
        }
        
    }
    
      //Método para atualizar dados do relatório;
    public void atualizarRelatorio() {

        if (tbRelatorio.getSelectedRow() != -1) {
            //Instanciando classe RelatorioDao;
            RelatorioDao dao = new RelatorioDao();

            //Instanciando  classe RelatorioModel;
            RelatorioModel rel = new RelatorioModel();
            //Setandos os dados;
           
            rel.setValorDespesa(Double.parseDouble(txtDespesas.getText()));
            rel.setValorLucro(Double.parseDouble(labelLucro.getText()));
            rel.setValorInvestido(Double.parseDouble(labelInvestimento1.getText()));
            rel.setValorDeTodosProdutosVendidos(Double.parseDouble(Labeltotal.getText()));
            rel.setCapital(Double.parseDouble(labelCapital.getText()));
            rel.setData(txtData.getText());
            rel.setCodRelatorio(txtCodRe.getText());
           
            //Passando objeto da classe RelatorioModel para o objeto da classe RelatorioDao;
            dao.alterarRelatorio(rel);

        }
    }
    
    
    private void BTSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSALVARActionPerformed
         
        if(txtCodRe.getText().isEmpty()){
           JOptionPane.showMessageDialog(null," Preencha o campo de código!");
           txtCodRe.requestFocus();
        }else{
           //Método para salvar relatório;
           salvarRelatorio(); 
        }
        
    }//GEN-LAST:event_BTSALVARActionPerformed
       
    //Método para salvar relatorio;
      public void salvarRelatorio(){
        
           //Instanciando a classe de RelatorioDao;
        RelatorioDao dao = new RelatorioDao();
          
         //Instânciando a classe RelatorioModel;
        RelatorioModel relat = new RelatorioModel();
        //setando os valores nos paramentros
        relat.setCodRelatorio(txtCodRe.getText());
        relat.setValorDespesa(Double.parseDouble(txtDespesas.getText()));
        relat.setValorLucro(Double.parseDouble(labelLucro.getText()));
        relat.setValorInvestido(Double.parseDouble(labelInvestimento1.getText()));
        relat.setValorDeTodosProdutosVendidos(Double.parseDouble(Labeltotal.getText()));
        relat.setCapital(Double.parseDouble(labelCapital.getText()));
        relat.setData(txtData.getText());
        //Passando o objeto de Relatório
        dao.adicionarRelatorio(relat);
        
      }
    
      //Método para realizar a soma das despesas
        public  void RealizarSomaDasDespesas(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            
            String sql = "SELECT (round(sum(valorTotal))) FROM despesas;";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
          
            while (Rst.next()) {
                                
                 ValorTotalDespesas=Rst.getDouble("(round(sum(valorTotal)))");
            
              // Passando os valores para 2 casas  decimais
              String valorDespesas=def.format(ValorTotalDespesas);
             
                  txtDespesas.setText(""+ValorTotalDespesas);
              
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Valor não Encontrado !");
        }
        
     }
    
    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
      limpalinha();
        limpar();
    }//GEN-LAST:event_limparActionPerformed
      
      //Método para seta os valores do estoque;
      public void setaDadosEstoque(){
          
          //Instânciando umaconnection com a classe Conexao_BD;
          Connection conn=Conexao_BD.getConnection();
          
          try {
              
              String sql="SELECT codProd,entrada,saida,qtd_Estoque,data FROM estoque WHERE codEstoq=?";
              
              PreparedStatement patm = conn.prepareStatement(sql);
              patm.setString(1,txtData.getText());
              
              ResultSet rst =patm.executeQuery();
              
              while(rst.next()){
                  
                  String codprod=rst.getString("codProd");
                  int entrada=rst.getInt("entrada");
                  int saida=rst.getInt("saida");
                  int Estoque=rst.getInt("qtd_Estoque");
                  String date=rst.getString("data");
                  
                 /* txtValorInvestidor.setText(codprod+"");
                  txtEntrada.setText(entrada+"");
                  txtSaida.setText(saida+"");
                  qtdEstoque.setText(Estoque+"");
                  txtData.setText(date+"");
                  */
              }
          } catch (Exception e) {
              
              JOptionPane.showMessageDialog(null, "Error ao seta dados do Estoque !","Opa Error", JOptionPane.ERROR_MESSAGE );
              
          }
          
      }
    
    
    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
       
    }//GEN-LAST:event_txtDataActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        
        //Método para realizar alterações de dados no relatório
        atualizarRelatorio();
    }//GEN-LAST:event_AlterarActionPerformed

    private void fazerCalculorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazerCalculorActionPerformed
      
        rendimento();
    }//GEN-LAST:event_fazerCalculorActionPerformed

    private void tbRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelatorioMouseClicked
       
        if(tbRelatorio.getSelectedRow()!=-1){
            txtCodRe.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),0).toString());
            txtDespesas.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),1).toString());
            labelLucro.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),2).toString());
            labelInvestimento1.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),3).toString());
            Labeltotal.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),4).toString());
            Labeltotal.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),5).toString());
            txtData.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),6).toString());
        }
        
    }//GEN-LAST:event_tbRelatorioMouseClicked
      
    public void exibirDados(){
          try {
            Connection Conn = Conexao_BD.getConnection();

            String sql = "SELECT * FROM relatorio";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            DefaultTableModel md = (DefaultTableModel) tbRelatorio.getModel();

            while (Rst.next()) {

                String[] lista = new String[]{Rst.getString("codRel"), Rst.getString("codVend"), Rst.getString("data"),
                     Rst.getString("valorTtvd"), Rst.getString("qtdPdisp")};

                md.addRow(lista);

            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " ");
        }
    }
     
    
    public void limpar(){
        txtCodRe.setText("");
        txtDespesas.setText("");
        txtData.setText("");
       // qtdEstoque.setText("");
        //TOTALvendas.setText("");
        Labeltotal.setText("");
    }
   
    
    public void apagar(){
          Connection conn=Conexao_BD.getConnection();
         
        int codVd=Integer.parseInt(txtCodRe.getText());
         
        try {

          
            String sql = "delete from relatorio where codRel=?";

            PreparedStatement patm = conn.prepareStatement(sql);

            patm.setInt(1, Integer.parseInt(txtCodRe.getText()));

            int res = patm.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Relatório Execluido com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Relatório não Excluido !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            patm.close();
            conn.close();

        } catch (Exception e) {
        }
    }
     
    
     public  void setaDados(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
            
       
            
            String sql = "SELECT round(sum(ValorTotal),2) FROM vendar where dhata='"+txtData.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
            
             
        

            
            while (Rst.next()) {
                 String valorTotal= Rst.getString("round(sum(ValorTotal),2)");
               // TOTALvendas.setText(""+Double.parseDouble(valorTotal)); 
                
               
            
             
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Valor não Encontrado !");
        }
        
     }
    
     
       public  void setaValores(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            
            String sql = "SELECT round(sum(valorTtvd),2) FROM relatorio";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
            
             
       

            
            while (Rst.next()) {
                 double TOTAL= Rst.getDouble("round(sum(valorTtvd),2)");
           
               
            
             
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Valor não Encontrado !");
        }
        
     }
       
        public  void contaProduto(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            
            String sql = "SELECT count(codProd)FROM produto";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
            
             
       

            
            while (Rst.next()) {
                 int TOTAL= Rst.getInt("count(codProd)");
            // qtdEstoque.setText(""
                  //   +TOTAL); 
               
            
             
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Produto não Contado !");
        }
        
     }
        
        public void evitarDuplicacao(){
          try {
            Connection Conn = Conexao_BD.getConnection();

            String sql = "SELECT DISTINCT codRel,codVend,data,valorTtvd,qtdPdisp FROM relatorio";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            DefaultTableModel md = (DefaultTableModel) tbRelatorio.getModel();

            while (Rst.next()) {

                String[] lista = new String[]{Rst.getString("codRel"), Rst.getString("codVend"), Rst.getString("data"),
                     Rst.getString("valorTtvd"), Rst.getString("qtdPdisp")};

                md.addRow(lista);

            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " ");
        }
    }
     
         public void limpalinha(){
        DefaultTableModel dm = (DefaultTableModel) tbRelatorio.getModel();
while(dm.getRowCount() > 0)
{
    dm.removeRow(0);
}
    }
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio_vd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton BTSALVAR;
    private javax.swing.JLabel Labeltotal;
    private javax.swing.JButton bTapagar;
    private javax.swing.JButton fazerCalculor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCapital;
    private javax.swing.JLabel labelInvestimento1;
    private javax.swing.JLabel labelLucro;
    private javax.swing.JButton limpar;
    private javax.swing.JTable tbRelatorio;
    private javax.swing.JTextField txtCodRe;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDespesas;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
