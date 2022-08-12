/*
  Essa Jframe tem objetivo de realizar os calculor dos valores e armazenar os dados  
 */
package View;

import Conexao.Conexao_BD;
import Dao.RelatorioDao;
import Model.Data;
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
        //SETA A DATA DO DIA
        DataDoDia();
        //Método que vai seta o total de todas despesas assim que a jframe abrir 
       RealizarSomaDasDespesas();
       
       //Método para realizar as soma de investimento, lucro, e valor todal de todos produtos na tabela de investimento;
       RealizarOsCalculosEsetaValores();
       
       rendimentoDoCapital();
       
       oLucroDepoisDasdespesas();
       
       
       
    }
       //variável para receber o total da soma de todas as despesas
      double ValorTotalDespesas=0; 
     //variavél para receber o valor do capital
      double capital  =0;
        //As Variaveis para receber os valores da jframe Investimento são else:
        //investimento,lucro, todo valor dos produtos vendidos;
       double valorDeTodoInvestimento=0;
       double valorTotalDeTDProdutosVendido=0;
       double valorDeTodoGanhoInvestido=0;
       double valorDeTodoLucro=0;
       
       
       //ESSAS VARIAVEIS ESTÃO ALTERADAS PARA REALIZAR AS OPERAÇÕES DO DIA ATUAL
       
       
       
         //variável para receber o total da soma de todas as despesas do dia
      double ValorTotalDespesasDiaAtual=0; 
     //variavél para receber o valor do capital do dia presente
      double capitalDiaAtual  =0;
        //As Variaveis para receber os valores da jframe Investimento são else:
        //investimento,lucro, todo valor dos produtos vendidos;
       double valorDeTodoInvestimentoDiaAtual=0;
       double valorTotalDeTDProdutosVendidoDiaAtual=0;
       double valorDeTodoGanhoInvestidoDiaAtual=0;
       double valorDeTodoLucroDiaAtual=0;
       
       //método para colocar os números com casas decimais
       DecimalFormat def = new DecimalFormat("#,##0.00");
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodRe = new javax.swing.JTextField();
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
        labelganho = new javax.swing.JLabel();
        Alterar = new javax.swing.JButton();
        labelDespesa = new javax.swing.JLabel();
        labelLucro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");

        jPanel1.setBackground(new java.awt.Color(162, 230, 229));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText(" Valor Das Despesas:");

        txtCodRe.setEditable(false);

        bTapagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        bTapagar.setText("Excluir");
        bTapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTapagarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Código:");

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Listar Tudo");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText(" Valor Investidor:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setText("Valor Do lucro:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setText("Valor Do Capital:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setText("       Data:");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jLabel12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel12KeyPressed(evt);
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

        labelCapital.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelInvestimento1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelganho.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        labelDespesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        labelLucro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ganhor de todo investimento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(BTSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(bTapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodRe, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelganho, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(478, 478, 478)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(318, 318, 318)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(137, 137, 137)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jScrollPane1)
                .addGap(101, 101, 101))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(974, Short.MAX_VALUE)
                    .addComponent(labelLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(95, 95, 95)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelInvestimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodRe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(labelDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelganho, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bTapagar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(190, 190, 190)
                    .addComponent(labelLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(449, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTapagarActionPerformed
      
            // condição para saber se o campo dd código está vazio 
        if(avisoParaCampoDoCodigoVazio()){
             JOptionPane.showMessageDialog(null, "Clique na linha que deseja deletar!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             //Método para visualizar relatorio;
        visualizaRelatorio();
        }else{
            //Método para deleta
            deletaRelatorio();
         //Método para fazer o calculor dos valores de investimento,lucro e de toda mercadoria vendida
         RealizarOsCalculosEsetaValores();
          //Método para sabe do rendimento que o vendedo vai ficar
         rendimentoDoCapital();
         
         oLucroDepoisDasdespesas();
          //Método para visualizar relatorio;
       visualizaRelatorio();
      
        }
    
    }//GEN-LAST:event_bTapagarActionPerformed
     //Método para deleta relatório
    public void deletaRelatorio(){
         RelatorioDao daoRel = new RelatorioDao();
        
        RelatorioModel relModel = new RelatorioModel();
        relModel.setCodRelatorio(Integer.parseInt(txtCodRe.getText()));
        
        daoRel.deletaRelatorio(relModel);
       
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
                  valorDeTodoGanhoInvestido= Rst.getDouble("(round(sum(Lucro)))");
             
                   labelInvestimento1.setText(""+valorDeTodoInvestimento);
                   Labeltotal.setText(""+valorTotalDeTDProdutosVendido);
                   labelganho.setText(""+valorDeTodoGanhoInvestido);
                  
                  
              // Passando os valores para 2 casas  decimais
              String valorInvestir=def.format(valorDeTodoInvestimento);
              //String valorTotal=def.format(valorTotalDeTDProdutosVendido);
              String valorTOTAL=def.format(valorTotalDeTDProdutosVendido);
              String valorDeTodoGanhoInvestidor=def.format(valorDeTodoGanhoInvestido);
                  
                  labelInvestimento1.setText(""+valorInvestir);
                   Labeltotal.setText(""+valorTOTAL);
                   labelganho.setText(""+valorDeTodoGanhoInvestidor);
                  
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Soma não realizada !");
        }
        
     }
       //método para saber do valor total do capital
     public void rendimentoDoCapital(){
        
          capital=valorTotalDeTDProdutosVendido-ValorTotalDespesas;
         
         labelCapital.setText(""+capital);
         
         String cptl=def.format(capital);
         
         labelCapital.setText(cptl);
        
     }
     
     //método para saber do valor tota do lucro depois das despesas
     public void oLucroDepoisDasdespesas(){
        
          valorDeTodoLucro=capital-valorDeTodoInvestimento;
         
         labelLucro.setText(""+valorDeTodoLucro);
         
         String lucrototal=def.format(valorDeTodoLucro);
         
         labelLucro.setText(lucrototal);
        
     }
     
    
    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
     //Método para visualizar relatorio;
      visualizaRelatorio();
    }//GEN-LAST:event_visualizarActionPerformed
      //Método para visualizar todo Relatório;
    public void visualizaRelatorio(){
        
        DefaultTableModel modelo = (DefaultTableModel) tbRelatorio.getModel();
        modelo.setNumRows(0);
        //Instanciando objeto RelatorioDao;
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
        rel.setValorDespesa(ValorTotalDespesas);
        rel.setValorLucro(valorDeTodoLucro);
        rel.setValorInvestido(valorDeTodoInvestimento);
        rel.setValorDeTodosProdutosVendidos(valorTotalDeTDProdutosVendido);
        rel.setCapital(capital);
        rel.setData(txtData.getText());
        rel.setCodRelatorio(Integer.parseInt(txtCodRe.getText()));
           
            //Passando objeto da classe RelatorioModel para o objeto da classe RelatorioDao;
            dao.alterarRelatorio(rel);

        }
    }
    
    
    private void BTSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSALVARActionPerformed

          //condição para saber se o campo da data está vázio
          if(camposVazio()){
            JOptionPane.showMessageDialog(null, "Preencha o campo data!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
          }else{
              
            rendimentoDoCapital();
            
            oLucroDepoisDasdespesas();
               //Método para salvar relatório;
           salvarRelatorio(); 
             //Método para visualizar relatorio;
          visualizaRelatorio();
          }
        
          
      
    }//GEN-LAST:event_BTSALVARActionPerformed
        //Método para mostrar a data ao abrir essa jFRAME venda;
    public void DataDoDia() {
        Data dt = new Data();
        txtData.setText(dt.setaData());
        
    }
    //Método para salvar relatorio;
      public void salvarRelatorio(){
        
           //Instanciando a classe de RelatorioDao;
        RelatorioDao dao = new RelatorioDao();
          
         //Instânciando a classe RelatorioModel;
        RelatorioModel relat = new RelatorioModel();
        //setando os valores nos paramentros
        relat.setValorDespesa(ValorTotalDespesas);
        relat.setValorLucro(valorDeTodoLucro);
        relat.setValorInvestido(valorDeTodoInvestimento);
        relat.setValorDeTodosProdutosVendidos(valorTotalDeTDProdutosVendido);
        relat.setCapital(capital);
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
            
                  labelDespesa.setText(""+ValorTotalDespesas);
              // Passando os valores para 2 casas  decimais
              String valorDespesas=def.format(ValorTotalDespesas);
             
                  labelDespesa.setText(valorDespesas);
              
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
      
    
    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
         DataDoDia();
    }//GEN-LAST:event_txtDataActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
         // condição para saber se o campo dd código está vazio 
        if(avisoParaCampoDoCodigoVazio()){
             JOptionPane.showMessageDialog(null, "Clique na linha que deseja altera!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             //Método para visualizar relatorio;
        visualizaRelatorio();
        }else{
          //Método para realizar alterações de dados no relatório
        atualizarRelatorio();
         //Método para fazer o calculor dos valores de investimento,lucro e de toda mercadoria vendida
         RealizarOsCalculosEsetaValores();
          //Método para sabe do rendimento que o vendedo vai ficar
         rendimentoDoCapital();
          //Método para visualizar relatorio;
       visualizaRelatorio();
      
        }
      
    }//GEN-LAST:event_AlterarActionPerformed
     
     //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtCodRe.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }
    
     //Método para verificar se tem campos vazios
    public boolean camposVazio(){
        boolean preencha=false;
       
          
            if(txtData.getText().isEmpty()){
                 txtData.requestFocus();
                  preencha=true;
            }
        
         return preencha;
      }
    
    
    private void tbRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelatorioMouseClicked
       
           String despesas=def.format(ValorTotalDespesas);
           String lucro=def.format(valorDeTodoLucro);
           String investimento=def.format(valorDeTodoInvestimento);
           String valorTotal=def.format(valorTotalDeTDProdutosVendido);
           String capital=def.format(this.capital);
           
           txtCodRe.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),0).toString());
            labelDespesa.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),1).toString()); labelDespesa.setText(despesas); //labelganho.setText(""); 
            labelganho.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),2).toString());  labelganho.setText(lucro);      // labelganho.setText(""); 
            labelInvestimento1.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),3).toString()); labelInvestimento1.setText(investimento); //labelganho.setText(""); 
            Labeltotal.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),4).toString());    Labeltotal.setText(valorTotal);//labelganho.setText(""); 
            labelCapital.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),5).toString());  labelCapital.setText(capital);//labelganho.setText(""); 
            txtData.setText(tbRelatorio.getValueAt(tbRelatorio.getSelectedRow(),6).toString());
            
        
    }//GEN-LAST:event_tbRelatorioMouseClicked

    private void txtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyReleased
       
        //condição para permitir apenas números
        if(soNumeros(txtData.getText())){
           
        }else{
            
             if(txtData.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtData.setText("");
           txtData.requestFocus();
         }
    }//GEN-LAST:event_txtDataKeyReleased

    private void jLabel12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel12KeyPressed
       
    }//GEN-LAST:event_jLabel12KeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         operacoesParaDiaAtual();
    }//GEN-LAST:event_jLabel12MouseClicked
      
    
    //Método para permitir só números
      public boolean soNumeros(String str){
        
         return str.matches("^[0/.-9]+");
        
      // return s.matches("[^0-9]+");
    }
   /* public void exibirDados(){
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
     
    */
    public void limpar(){
        txtCodRe.setText("");
        labelDespesa.setText("");
        txtData.setText("");
       // qtdEstoque.setText("");
        //TOTALvendas.setText("");
        Labeltotal.setText("");
        labelInvestimento1.setText("");
        labelganho.setText("");
        labelCapital.setText("");
    }
   
    //ESSAS AÇÕES DAQUI PARA BAIXO E PARA REALIZAR AS OPRERAÇÕES DO DIA PRESENTE
     
       //Método para realizar as somas do investimentos, lucro e de todos produtos vendidos  
       public  void RealizarOsCalculosEsetaValoresDiaAtual(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            //comando para realizar a soma
            String sql = "SELECT (round(sum(valorinvest))),(round(sum(total))),(round(sum(Ganhor))) FROM lucro;";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
        
            while (Rst.next()) {
                                
                 valorDeTodoInvestimentoDiaAtual=Rst.getDouble("(round(sum(valorinvest)))");
                
                  valorTotalDeTDProdutosVendidoDiaAtual= Rst.getDouble("(round(sum(total)))");
                  valorDeTodoGanhoInvestidoDiaAtual= Rst.getDouble("(round(sum(Ganhor)))");
             
                   labelInvestimento1.setText(""+valorDeTodoInvestimentoDiaAtual);
                   Labeltotal.setText(""+valorTotalDeTDProdutosVendidoDiaAtual);
                   labelganho.setText(""+valorDeTodoGanhoInvestidoDiaAtual);
                  
                  
              // Passando os valores para 2 casas  decimais
              String valorInvestir=def.format(valorDeTodoInvestimentoDiaAtual);
              //String valorTotal=def.format(valorTotalDeTDProdutosVendido);
              String valorTOTAL=def.format(valorTotalDeTDProdutosVendidoDiaAtual);
              String valorDeTodoGanhoInvestidor=def.format(valorDeTodoGanhoInvestidoDiaAtual);
                  
                  labelInvestimento1.setText(""+valorInvestir);
                   Labeltotal.setText(""+valorTOTAL);
                   labelganho.setText(""+valorDeTodoGanhoInvestidor);
                  
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Soma do dia de hoje não realizada !");
        }
        
     }
        //método para saber do valor total do capital do dia atual
     public void rendimentoDoCapitalDiaAtual(){
        
          capitalDiaAtual=valorTotalDeTDProdutosVendidoDiaAtual-ValorTotalDespesasDiaAtual;
         
         labelCapital.setText(""+capitalDiaAtual);
         
         String cptl=def.format(capitalDiaAtual);
         
         labelCapital.setText(cptl);
        
     }
      //método para saber do valor tota do lucro depois das despesas do dia atual
     public void oLucroDepoisDasdespesasDiaAtual(){
        
          valorDeTodoLucroDiaAtual=capitalDiaAtual-valorDeTodoInvestimentoDiaAtual;
         
         labelLucro.setText(""+valorDeTodoLucroDiaAtual);
         
         String lucrototal=def.format(valorDeTodoLucroDiaAtual);
         
         labelLucro.setText(lucrototal);
        
     }
      //Método para realizar a soma das despesas
        public  void RealizarSomaDasDespesasDiaAtual(){
         
           try {
            Connection Conn = Conexao_BD.getConnection();
        
            
            String sql = "SELECT (round(sum(valorTotal))) FROM despesas where data='"+txtData.getText()+"';";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
          
            while (Rst.next()) {
                                
                 ValorTotalDespesasDiaAtual=Rst.getDouble("(round(sum(valorTotal)))");
            
                  labelDespesa.setText(""+ValorTotalDespesasDiaAtual);
              // Passando os valores para 2 casas  decimais
              String valorDespesas=def.format(ValorTotalDespesasDiaAtual);
             
                  labelDespesa.setText(valorDespesas);
              
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Valor não Encontrado !");
        }
        
     }
        //método para realizar as operações para dia atual
        public void operacoesParaDiaAtual(){
              DataDoDia();
         RealizarSomaDasDespesasDiaAtual();
        RealizarOsCalculosEsetaValoresDiaAtual();
         rendimentoDoCapitalDiaAtual();
        oLucroDepoisDasdespesasDiaAtual();
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
    private javax.swing.JLabel labelDespesa;
    private javax.swing.JLabel labelInvestimento1;
    private javax.swing.JLabel labelLucro;
    private javax.swing.JLabel labelganho;
    private javax.swing.JButton limpar;
    private javax.swing.JTable tbRelatorio;
    private javax.swing.JTextField txtCodRe;
    private javax.swing.JTextField txtData;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
