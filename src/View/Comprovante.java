
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
   //variavel para armazenar as datas salvas no banco de dados
     String data="";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
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
        txtDataInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        listaentreasdatas = new javax.swing.JButton();
        txtdataespecifica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        botdelete.setText("Deletar");
        botdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botdeleteActionPerformed(evt);
            }
        });

        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Total De Todas Vendas:");

        txtDataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataInicioKeyReleased(evt);
            }
        });

        jLabel4.setText("Data de Inicio:");

        txtDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataFinalKeyReleased(evt);
            }
        });

        jLabel5.setText("Data Final:");

        listaentreasdatas.setText("Listar entre as datas");
        listaentreasdatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaentreasdatasActionPerformed(evt);
            }
        });

        txtdataespecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataespecificaActionPerformed(evt);
            }
        });
        txtdataespecifica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdataespecificaKeyReleased(evt);
            }
        });

        jLabel6.setText("Data Espeficica:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        jButton2.setText("Listar Tudo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdataespecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(listaentreasdatas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jScrollPane1)
                        .addGap(90, 90, 90)))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(110, 110, 110)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(txtdataespecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaentreasdatas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        txtDataFinal.setText("");
        txtDataInicio.setText("");
        txtdataespecifica.setText("");
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

    private void listaentreasdatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaentreasdatasActionPerformed
      
        
          if(txtDataInicio.getText().equals("")&&txtDataFinal.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Preencha os campos das datas de inicio e final!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
       
     }else  if(txtDataInicio.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo da data de inicio!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             txtDataInicio.requestFocus();
         }
           
      else   if(txtDataFinal.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Preencha o campo da data final!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             txtDataFinal.requestFocus();
             
         } else if(txtDataFinal.getText().equals(data)&&txtDataInicio.getText()!=data){
                JOptionPane.showMessageDialog(null, "Data de inicio não se encontra!","Opa...:",JOptionPane.ERROR_MESSAGE); 
                 txtDataInicio.requestFocus();
         } else 
            if(txtDataInicio.getText().equals(data)&&txtDataFinal.getText()!=data){
                JOptionPane.showMessageDialog(null, "Data final não se encontra!","Opa...:",JOptionPane.ERROR_MESSAGE);
                 txtDataFinal.requestFocus();
                 
             }else if(txtDataInicio.getText()!=data&&txtDataFinal.getText()!=data){
             JOptionPane.showMessageDialog(null, "Tente outras datas diferentes dessas  "+txtDataInicio.getText()+" e "+txtDataFinal.getText()+" ","Datas não encontradas:",JOptionPane.INFORMATION_MESSAGE);
              
          } else{
                
                  //metodo para listar entre as datas
        listaEntreASdatas();
        //método para seta os valores entre as datas
        setaValorTotalEntreAsData();   
          }
        
        
      
    }//GEN-LAST:event_listaentreasdatasActionPerformed
   
     // método para  busca a data no banco de dados;
    public boolean buscarData() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para seleciona a data salvar na tabela de vendas
            String sql = "SELECT data FROM detalhe ";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando a data

                data = Rst.getString("data");
            } 
            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "data não encontrada ! ");
        }
        return true;

    }
    private void txtdataespecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataespecificaActionPerformed
       //método para lista por uma data especifica
        listaPorDataEspecificar();
        //método para seta o valor total por uma unica data
        setaValorTotalPelaDataEspecifica();
    }//GEN-LAST:event_txtdataespecificaActionPerformed

    private void txtDataInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicioKeyReleased
          //condição para permitir apenas números
        if(sonumeros(txtDataInicio.getText())){
        }else{
             if(txtDataInicio.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtDataInicio.setText("");
           txtDataInicio.requestFocus();
         }
    }//GEN-LAST:event_txtDataInicioKeyReleased

    private void txtDataFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFinalKeyReleased
        
          //condição para permitir apenas números
        if(sonumeros(txtDataFinal.getText())){
        }else{
             if(txtDataFinal.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtDataFinal.setText("");
           txtDataFinal.requestFocus();
         }
    }//GEN-LAST:event_txtDataFinalKeyReleased

    private void txtdataespecificaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataespecificaKeyReleased
          //condição para permitir apenas números
        if(sonumeros(txtdataespecifica.getText())){
        }else{
             if(txtdataespecifica.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtdataespecifica.setText("");
           txtdataespecifica.requestFocus();
         }
    }//GEN-LAST:event_txtdataespecificaKeyReleased

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         //método para lista tudo
           visualizarVenda();
    }//GEN-LAST:event_jButton2ActionPerformed
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
  //Método para seta os valor total entre as datas das vendas na labeltotal;
    public void setaValorTotalEntreAsData() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from detalhe WHERE data>'"+txtDataInicio.getText()+"' and data<'"+txtDataFinal.getText()+"'";

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
     
    //Método para seta os valor total por uma data especifica na labeltotal;
    public void setaValorTotalPelaDataEspecifica() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from detalhe WHERE data='"+txtdataespecifica.getText()+"'";

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
  
      //Método para visualizar todas Vendas;
    public void listaEntreASdatas() {
        DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
        //Método para não repetir os dados na tabela detalhe;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas vendas entrer as datas 
        for (ComprovanteModel item : dao.listaEntreAsDatas(txtDataInicio.getText(),txtDataFinal.getText())) {
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
      //Método para lista todas vendas por uma data especifica;
    public void listaPorDataEspecificar() {
        DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
        //Método para não repetir os dados na tabela detalhe
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas vendas pela data especifica 
        for (ComprovanteModel item : dao.ListarPelaDataEspecifica(txtdataespecifica.getText())) {
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listaentreasdatas;
    private javax.swing.JTable tabdetalhevd;
    private javax.swing.JTextField txtDataFinal;
    private javax.swing.JTextField txtDataInicio;
    private javax.swing.JTextField txtdataespecifica;
    // End of variables declaration//GEN-END:variables
}
