
package View;

import Conexao.Conexao_BD;
import Dao.ComprovanteDao;
import Dao.LucroDao;
import Dao.VendaDao;
import Model.ComprovanteModel;
import Model.Data;
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
     String codigoOpcao="";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabdetalhevd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        botdelete = new javax.swing.JButton();
        txtOpcoes = new javax.swing.JTextField();
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
        botdeleteTUDO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações das vendas realizadas");
        setBackground(new java.awt.Color(255, 255, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        tabdetalhevd.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
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
        tabdetalhevd.setAlignmentX(0.1F);
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

        txtOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpcoesActionPerformed(evt);
            }
        });
        txtOpcoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOpcoesKeyReleased(evt);
            }
        });

        jLabel2.setText("Informe o código:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Listar Todas Vendas");

        LABELtOTAL.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Total De Todas Vendas:");

        txtDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioActionPerformed(evt);
            }
        });
        txtDataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataInicioKeyReleased(evt);
            }
        });

        jLabel4.setText("Data de Inicio:");

        txtDataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFinalActionPerformed(evt);
            }
        });
        txtDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataFinalKeyReleased(evt);
            }
        });

        jLabel5.setText("Data Final:");

        listaentreasdatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
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

        botdeleteTUDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        botdeleteTUDO.setText("Deletar Tudo");
        botdeleteTUDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botdeleteTUDOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                                            .addComponent(txtOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(71, 71, 71))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(listaentreasdatas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton1)
                                        .addGap(50, 50, 50)
                                        .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botdeleteTUDO, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)))
                                .addComponent(jButton2)))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LABELtOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(txtOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaentreasdatas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botdeleteTUDO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
        txtOpcoes.setText("");
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
        cm.setCodDetalhe(Integer.parseInt(txtOpcoes.getText()));
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
    //MÉTODO PARA DELETA TODAS VENDAS, TODOS ITENS, TODOS DOS CÓDIGOS DA TABELA VENDAS, TODOS DADOS DA TABELA DDE LUCROS
    public void detelaEmGeral(){
            VendaDao vd = new VendaDao();
         //MÉTODO PARA DELETAR TODOS CÓDIGOS DA TABELA VENDAS
             vd.deletaTodosCodigoDaTabelaVenda();
         //instânciando comprovante dão; 
          ComprovanteDao dao = new ComprovanteDao();
          //MÉTODO PARA DELETAR TODAS VENDAS
          dao.ExcluirTodaTabelaDoDetalhe();
          
           //MÉTODO PARA DELETAR TODOS ITENS
             vd.deletaTodaVenda();
            
            
             LucroDao LC = new LucroDao();
             //MÉTODO PARA DELETAR TODOS DADOS DA TABELA LUCROS
             LC.deletaTODOSLucros();
             
             
    }
    
    private void tabdetalhevdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdetalhevdMouseClicked
        
        txtOpcoes.setText(tabdetalhevd.getValueAt(tabdetalhevd.getSelectedRow(),2).toString());
        txtdataespecifica.setText(tabdetalhevd.getValueAt(tabdetalhevd.getSelectedRow(),4).toString());
    }//GEN-LAST:event_tabdetalhevdMouseClicked

    private void txtOpcoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOpcoesKeyReleased
          //condição para permitir apenas números
        if(sonumeros(txtOpcoes.getText())){
           
        }else{
            
             if(txtOpcoes.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtOpcoes.setText("");
           txtOpcoes.requestFocus();
         }
    }//GEN-LAST:event_txtOpcoesKeyReleased

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
      
          buscarData();
        
        if(txtdataespecifica.getText().equals(data)){
             //método para lista por uma data especifica
        listaPorDataEspecificar();
        //método para seta o valor total por uma unica data
        setaValorTotalPelaDataEspecifica();
        }else{
            JOptionPane.showMessageDialog(null, "Essa data  "+txtdataespecifica.getText()+"  não se encontrar ! ");
        }

     
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

    private void txtOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpcoesActionPerformed
                  
         //método para seta os códigos dos clientes cadastrados
          setacodigoDoCliente();
              buscarData();
        if(txtdataespecifica.getText().equals("")){
                   
            if(txtOpcoes.getText().equals(codigoOpcao)){
                 //método para lista pelo código do cliente
               listaPeloCodCliente();
              //método para soma a venda pelo código do cliente
               somaVendaValorTotalPeloCodCliente();
            }else{
               JOptionPane.showMessageDialog(null, "Não se encontra cliente com esse código "+txtOpcoes.getText()+"","Tente outro código:",JOptionPane.INFORMATION_MESSAGE);
            txtOpcoes.requestFocus();
            }  
       }else{   
            if(txtOpcoes.getText().equals(codigoOpcao)){
              
            }else if(txtOpcoes.getText()!=codigoOpcao){
               JOptionPane.showMessageDialog(null, "Não se encontra cliente com esse código "+txtOpcoes.getText()+"","Tente outro código:",JOptionPane.INFORMATION_MESSAGE);
            txtOpcoes.requestFocus();
            }   
          else  if(txtdataespecifica.getText().equals(data)){
            
        }else if(txtdataespecifica.getText()!=data){
            JOptionPane.showMessageDialog(null, "Essa data  "+txtdataespecifica.getText()+"  não se encontrar ! ");
        }else{
                 //método para lista pela data, código do cliente
                 listaPelaDataCodCliente();
                //método para soma as vendas pela data, código do cliente
                 somaVendaValorTotalPelaDataCodCliente();
                }
           
         }
        
    }//GEN-LAST:event_txtOpcoesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         //método para lista tudo
           visualizarVenda();
           //método para soma todas vendas salvas
          setaValorTotalDeTodasVendas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
          Data dt = new Data();
        txtDataInicio.setText(dt.setaData());
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void txtDataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFinalActionPerformed
         Data dt = new Data();
        txtDataFinal.setText(dt.setaData());
    }//GEN-LAST:event_txtDataFinalActionPerformed

    private void botdeleteTUDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botdeleteTUDOActionPerformed
     detelaEmGeral();
    }//GEN-LAST:event_botdeleteTUDOActionPerformed
     //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtOpcoes.getText().isEmpty()){
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

    //Método para seta os valor total por uma data especifica na labeltotal;
    public void somaVendaValorTotalPeloCodCliente() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from detalhe WHERE codCli='"+txtOpcoes.getText()+"'";

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
   
      //Método para seta os valor total por uma data especifica e pelo código do cliente na labeltotal;
    public void somaVendaValorTotalPelaDataCodCliente() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from detalhe WHERE data='"+txtdataespecifica.getText()+"' and codCli='"+txtOpcoes.getText()+"'";

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
     //Método para lista as vendas pelo código do cliente;
    public void listaPeloCodCliente() {
        DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (ComprovanteModel item : dao.listaItensCliente(txtOpcoes.getText())) {
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
     //Método para lista as vendas pelo código do cliente;
    public void listaPelaDataCodCliente() {
        DefaultTableModel modelo = (DefaultTableModel) tabdetalhevd.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        ComprovanteDao dao = new ComprovanteDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (ComprovanteModel item : dao.listapelaDataCodCliente(txtdataespecifica.getText(),txtOpcoes.getText())) {
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
    
      //Método para buscar o código do cliente;
    public void setacodigoDoCliente() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //comando para seta o código do cliente
            String sql = "SELECT codCli from detalhe";
            PreparedStatement Patm = Conn.prepareStatement(sql);
            //executar
            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {
            //Setando o código
               codigoOpcao=Rst.getString("codCli");
                
           //   JOptionPane.showMessageDialog(null," Código do detalhe "+codigoOpcao);

            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de error exiber essa mensagem
            JOptionPane.showMessageDialog(null, "codigo do cliente não Encontrado !");
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
    private javax.swing.JButton botdeleteTUDO;
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
    private javax.swing.JTextField txtOpcoes;
    private javax.swing.JTextField txtdataespecifica;
    // End of variables declaration//GEN-END:variables
}
