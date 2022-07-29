
package View;

import Conexao.Conexao_BD;
import Dao.ComprovanteDao;
import Model.ComprovanteModel;
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

  
    public Comprovante() {
        initComponents();
        visualizarVenda();
        setaValorTotalDeTodasVendas();
        setLocationRelativeTo(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabdetalhevd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        botdelete = new javax.swing.JButton();
        deletar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LABELtOTAL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações das vendas realizadas");
        setBackground(new java.awt.Color(255, 255, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        tabdetalhevd.setBackground(new java.awt.Color(0, 204, 204));
        tabdetalhevd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codDetalhe", "CodVenda", "CodCliente", "Total", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabdetalhevd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdetalhevdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabdetalhevd);

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botdelete.setText("Deletar");
        botdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botdeleteActionPerformed(evt);
            }
        });

        deletar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deletarKeyReleased(evt);
            }
        });

        jLabel2.setText("Informe o código:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Listar Todas Vendas");

        LABELtOTAL.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        jLabel3.setText("Total De Todas Vendas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jScrollPane1)))
                .addGap(173, 173, 173))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     //método para limpa os campos 
        limpaCampos();
        //método para limpar as linhas da tabela
        limpalinha();
    }//GEN-LAST:event_jButton1ActionPerformed
   //método para limpa os campos
    public void limpaCampos(){
        deletar.setText("");
        LABELtOTAL.setText("");
    }
    
    private void botdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botdeleteActionPerformed
    
        
           
         if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
       
        }else{
                //criando um objeto comprovante;
        ComprovanteModel cm = new ComprovanteModel();
        //passando os dados para deleta;
        cm.setCodDetalhe(Integer.parseInt(deletar.getText()));
        //recebendo os dados de deleta
      
        
        //instânciando comprovante dão; 
          ComprovanteDao dao = new ComprovanteDao();
          dao.ExcluirUmaVendaDoDetalhe(cm);
          limpaCampos();
          limpalinha();
         visualizarVenda();
         setaValorTotalDeTodasVendas();
        }
        
    
       
    }//GEN-LAST:event_botdeleteActionPerformed
    
    
    private void tabdetalhevdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdetalhevdMouseClicked
        
        deletar.setText(tabdetalhevd.getValueAt(tabdetalhevd.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tabdetalhevdMouseClicked

    private void deletarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deletarKeyReleased
          //condição para permitir apenas números
        if(sonumeros(deletar.getText())){
           
        }else{
            
             if(deletar.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           deletar.setText("");
           deletar.requestFocus();
         }
    }//GEN-LAST:event_deletarKeyReleased
     //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(deletar.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }
    public boolean sonumeros(String str){
        
         return str.matches("^[0./-9 ]+");
        
      // return s.matches("[^0-9]+");
    }
      //Método para limpar as linhas da tabela
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tabdetalhevd.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }
    //Método para seta os valor total  de todas vendas na labeltotal;
    public void setaValorTotalDeTodasVendas() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from detalhe";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                LABELtOTAL.setText("R$ "+formater.format(total));

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

    /*
    public void tab(){
           try {

           

            Connection Conn = Conexao_BD.getConnection();

         String sql="select * from vendas";

            PreparedStatement Patm = Conn.prepareStatement(sql);

           ResultSet Rst = Patm.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
             modelo.setNumRows(0);
            while(Rst.next()){

                String [] lista = new String[]{Rst.getString("codVendar"),Rst.getString("codCli"),Rst.getString("codProd")
                    ,Rst.getString("Qtd"),Rst.getString("login") ,Rst.getString("senha")};
               
                modelo.addRow(lista);
            
               
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (Exception e) {
        }
    
    }
   */
    //Método para visualizar todas Vendas;
    public void visualizarVenda() {
        DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (ComprovanteModel item : dao.visualizarComprovante()) {
            modelo.addRow(new Object[]{
                //Passando os objetos 
                item.getCodDetalhe(),
                item.getCodVenda(),
                item.getCodCli(),
                item.getValorTotal(),
                item.getData()

            });
        }

    }
  
    
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprovante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABELtOTAL;
    private javax.swing.JButton botdelete;
    private javax.swing.JTextField deletar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabdetalhevd;
    // End of variables declaration//GEN-END:variables
}
