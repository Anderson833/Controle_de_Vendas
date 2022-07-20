
package View;

import Conexao.Conexao_BD;
import Dao.VendaDao;
import Model.VendaModel;
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
public class Comprovante extends javax.swing.JFrame {

    /**
     * Creates new form Comprovante
     */
    public Comprovante() {
        initComponents();
        
       visualizarVendas();
        
       setaValorTotalDosItens();
         setLocationRelativeTo(null);
    }
    
    
     //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalDosItens() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM item ";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(total),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
                 
           

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }
        
        
     }
    
    //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalDosItensPelaDataEspecifica() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM item where data='"+txtData.getText()+"'";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(total),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
                 
           

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }
        
        
     }
    
    //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalPelaDataDeInicio_Final() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "SELECT round(sum(total),2) FROM item data >'"+txtdataInicio+"' and data<'"+txtdataFinal+"'";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(total),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
                 
           

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVend = new javax.swing.JTable();
        Valortt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdataInicio = new javax.swing.JTextField();
        txtdataFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        visualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualização de todas vendas");
        setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(240, 176, 123));

        tabelaVend.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        tabelaVend.setForeground(new java.awt.Color(51, 51, 255));
        tabelaVend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdComprov", "CodVend", "CodCli", "CodProd", "Qtd_Prod", "ValorUnit", "ValorTotal", "data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVend.setAlignmentX(0.1F);
        tabelaVend.setRowHeight(25);
        tabelaVend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVend);

        Valortt.setEditable(false);
        Valortt.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Valortt.setForeground(new java.awt.Color(255, 0, 0));
        Valortt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorttActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Valor Total =");
        jLabel1.setAlignmentX(10.0F);

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel2.setText("Data:");

        txtdataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataFinalActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Inicio:");

        jLabel4.setText("Data Final:");

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtdataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendMouseClicked

     //Seta os valores nos campos de textos ao clicar na inha da tabela;
     /*   if (tabelaVend.getSelectedRow() != -1) {

            codVenda.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),0).toString());
            CodCli.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),1).toString());
            txtCodPro.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),2).toString());
            txtQtd.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),3).toString());
            ValorUnit.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),4).toString());
            Valortotal.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),5).toString());
        }*/
    }//GEN-LAST:event_tabelaVendMouseClicked

    private void ValorttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorttActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        
       visualizarPeladate();
       setaValorTotalDosItensPelaDataEspecifica();
      // setaValorTotalpelaData();
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtdataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataFinalActionPerformed
       
       
    }//GEN-LAST:event_txtdataFinalActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
    
        visualizarDataInicioDataFinal();
     setaValorTotalpelaDataComecoEfinal();
    }//GEN-LAST:event_visualizarActionPerformed
   
    
    //Método para  deletar vendas;
    public void deletarVendaPeloCodigo() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();
      
        
        //Instânciando a classe VendaModel;
        VendaModel cp = new VendaModel();
        cp.setCodVenda(Integer.parseInt(txtData.getText()));
        // colocando objeto cp no método deletar Itens da classe ComprovanteDao ;
        dao.deletaVendaPeloCodigo(cp);

    }
    
    
    
 
    // Visualizar os Detalhes da compra;
     public void visualizarVendas(){
          DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
            //Método para não repetir os dados na tabela de comprar;
            modelo.setNumRows(0);
            //Instânciando a classe ComprovanteDao;
            VendaDao dao = new VendaDao();
            //Um Laço de repetição para lista todas vendas que está  no banco de dados armazenadar; 
            for (VendaModel item : dao.visualizarVenda()) {
                modelo.addRow(new Object[]{
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData() 
               
               
                });
           }
            
            
         
     }
    
 // Visualizar os toda tabela  da compra pela data;
     public void visualizarPeladate(){
          DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
            //Método para não repetir os dados na tabela de comprar;
            modelo.setNumRows(0);
            //Instânciando a classe ComprovanteDao;
            VendaDao dao = new VendaDao();
            //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
            for (VendaModel item : dao.visualizarPelaData(txtData.getText())) {
                modelo.addRow(new Object[]{
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData() 
              
                
                });
           }
            
            
         
     }
     
     // Visualizar os toda tabela  da compra pela data;
     public void visualizarDataInicioDataFinal(){
          DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
            //Método para não repetir os dados na tabela de comprar;
            modelo.setNumRows(0);
            //Instânciando a classe ComprovanteDao;
            VendaDao dao = new VendaDao();
            //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
            for (VendaModel item : dao.visualizarDataComecoEfinal(txtdataInicio.getText(),txtdataFinal.getText())) {
                modelo.addRow(new Object[]{
               
                item.getIdDeleta(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getCodProd(),
                item.getQtdProd(),
                item.getValorUnit(),
                item.getValorTotal(),
                item.getData()
                
                
                });
           }
            
            
         
     }
     
     
     
     
     
         //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalpelaData() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from item where data='"+txtData.getText()+"'";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(total),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
            

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }
        
        
     }
    
     //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalEntreAsData() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select codItem,codVenda,codCli, codProd,Qtd,valorUnit,total,data from item where data >'"+txtdataInicio+"' and data<'"+txtdataFinal+"'";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(ValorTotal),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
            

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }
        
        
     }
     //Método para seta os valor total  dos itens no campo de texto e na label;
     public void setaValorTotalpelaDataComecoEfinal() {
         
         DecimalFormat formater = new DecimalFormat("#0.00");
        
         
        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from item where data>'"+txtdataInicio.getText()+"' and data <'"+txtdataFinal.getText()+"'";
   
            
            PreparedStatement Patm = Conn.prepareStatement(sql);
         
            ResultSet Rst = Patm.executeQuery();
            
           
         

            while (Rst.next()) {

                     //Pegando o valor da soma
               double total= Rst.getDouble("round(sum(total),2)");
                    //setando o valor no campo de texto e na label; 
                     Valortt.setText(formater.format(total));
            

            }
              //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
          

        } catch (SQLException e) {
             //caso de error mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Valor não setado! ");
        }
        
        
     }
    
     
   
    
    
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
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprovante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprovante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Valortt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtdataFinal;
    private javax.swing.JTextField txtdataInicio;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
