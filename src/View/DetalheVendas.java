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
public class DetalheVendas extends javax.swing.JFrame {

    /**
     * Creates new form Comprovante
     */
    public DetalheVendas() {
        initComponents();

        visualizarVendas();

        setaValorTotalDosItens();
        verificaData();
        setLocationRelativeTo(null);
    }
  
     String data="";
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
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                Valortt.setText("R$ "+formater.format(total));
                     
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
            String sql = "SELECT round(sum(total),2) FROM item where data='" + txtcodvenda.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
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
            String sql = "SELECT round(sum(total),2) FROM item data >'" + txtcodcliente + "' and data<'" + txtdata + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
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
    
     
  // método para  ver se tem a data salvar;
    public boolean verificaData() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para seleciona a data salvar na tabela de vendas
            String sql = "SELECT data FROM item ";

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
        txtcodvenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcodcliente = new javax.swing.JTextField();
        txtdata = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LISTAESPECIFICAMENTE = new javax.swing.JButton();
        ListaTudo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        deletatd = new javax.swing.JButton();
        deletaITENS = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informações das vendas em detalhes");
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

        txtcodvenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodvendaActionPerformed(evt);
            }
        });
        txtcodvenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodvendaKeyReleased(evt);
            }
        });

        jLabel2.setText("Código Venda:");

        txtcodcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodclienteActionPerformed(evt);
            }
        });
        txtcodcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodclienteKeyReleased(evt);
            }
        });

        txtdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataActionPerformed(evt);
            }
        });
        txtdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdataKeyReleased(evt);
            }
        });

        jLabel3.setText("Código Cliente:");

        jLabel4.setText("Data:");

        LISTAESPECIFICAMENTE.setText("Listar itens especificos");
        LISTAESPECIFICAMENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTAESPECIFICAMENTEActionPerformed(evt);
            }
        });

        ListaTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/esta-bem.png"))); // NOI18N
        ListaTudo.setText("Listar Tudo");
        ListaTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaTudoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setText("Detalhe das vendas");

        deletatd.setText("Deletar Tudo");
        deletatd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletatdActionPerformed(evt);
            }
        });

        deletaITENS.setText("Deletar itens especificos");
        deletaITENS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaITENSActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LISTAESPECIFICAMENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deletatd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(ListaTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deletaITENS, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LISTAESPECIFICAMENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ListaTudo)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deletatd, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                    .addComponent(deletaITENS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void tabelaVendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendMouseClicked

        //Seta os valores nos campos de textos ao clicar na inha da tabela;
       

            txtcodvenda.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),1).toString());
            txtcodcliente.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),2).toString());
            txtdata.setText(tabelaVend.getValueAt(tabelaVend.getSelectedRow(),7).toString());
         
       
    }//GEN-LAST:event_tabelaVendMouseClicked

    private void ValorttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorttActionPerformed

    private void txtcodvendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodvendaActionPerformed

            if(txtcodvenda.getText().equals("")){
             
             JOptionPane.showMessageDialog(null, "Preencha o campo da data!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
              txtcodvenda.requestFocus();
            }else if(txtcodvenda.getText()!=data){
             JOptionPane.showMessageDialog(null, "Tente outra data diferente dessa  "+txtcodvenda.getText()+"","Data não encontrada:",JOptionPane.INFORMATION_MESSAGE);
              txtcodvenda.requestFocus();
         }else{
           visualizarPeladate();
             setaValorTotalDosItensPelaDataEspecifica();
  
         }
               // setaValorTotalpelaData();
    }//GEN-LAST:event_txtcodvendaActionPerformed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed

       listaPeloCodigoClienteData();
         setaValorTotalPeloCodigoClienteData();

    }//GEN-LAST:event_txtdataActionPerformed

    private void LISTAESPECIFICAMENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTAESPECIFICAMENTEActionPerformed
       //método paralista itens especificos 
        listaitensEspecificosDasVendas();
        //método para seta a soma pelo código da venda do cliente e da data
        setaValorTotalPeloCodigoClienteData();
    }//GEN-LAST:event_LISTAESPECIFICAMENTEActionPerformed

    private void ListaTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaTudoActionPerformed
        //métodos para lista e somar todas vendas
        visualizarVendas();
        setaValorTotalDosItens();
    }//GEN-LAST:event_ListaTudoActionPerformed

    private void txtcodvendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodvendaKeyReleased
        
            //condição para permitir apenas números
        if(sonumeros(txtcodvenda.getText())){
        }else{
             if(txtcodvenda.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtcodvenda.setText("");
           txtcodvenda.requestFocus();
         }
    }//GEN-LAST:event_txtcodvendaKeyReleased

    private void txtcodclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodclienteKeyReleased
      
           //condição para permitir apenas números
        if(sonumeros(txtcodcliente.getText())){
        }else{
             if(txtcodcliente.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtcodcliente.setText("");
           txtcodcliente.requestFocus();
         }

    }//GEN-LAST:event_txtcodclienteKeyReleased

    private void txtdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataKeyReleased
         //condição para permitir apenas números
        if(sonumeros(txtdata.getText())){
        }else{
             if(txtdata.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtdata.setText("");
           txtdata.requestFocus();
         }

    }//GEN-LAST:event_txtdataKeyReleased

    private void deletatdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletatdActionPerformed
       
           int op=JOptionPane.showConfirmDialog(null, "Tem certeza ?");
        if(op==JOptionPane.YES_OPTION){
              VendaDao vd = new VendaDao();
             vd.deletaTodaVenda();
               //Método para limpar as linhas da tabela;
               limpalinha();
        }else if(op==JOptionPane.NO_OPTION || op==JOptionPane.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "Dados não excluidos!");
        }
      
    }//GEN-LAST:event_deletatdActionPerformed

    private void txtcodclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodclienteActionPerformed

    private void deletaITENSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaITENSActionPerformed
       
        VendaDao vd = new VendaDao();
        //método para deleta os itens do cliente pelo código da venda e pela data
        vd.deletaItensPeloCodigoClienteData(txtcodvenda.getText(), txtcodcliente.getText(), txtdata.getText());
        visualizarVendas();
         setaValorTotalDosItens();
    }//GEN-LAST:event_deletaITENSActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        limparCampos();
        limpalinha();
       
        
    }//GEN-LAST:event_jButton1ActionPerformed
   //método para limpas os campos
    public void limparCampos(){
         txtcodcliente.setText("");
        txtcodvenda.setText("");
        txtdata.setText("");
    }
     //Método para limpar as linhas da tabela
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tabelaVend.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }
    public boolean sonumeros(String str){
        
         return str.matches("^[0./-9 ]+");
        
      // return s.matches("[^0-9]+");
    }
    //Método para  deletar vendas;
    public void deletarVendaPeloCodigo() {
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();

        //Instânciando a classe VendaModel;
        VendaModel cp = new VendaModel();
        cp.setCodVenda(Integer.parseInt(txtcodvenda.getText()));
        // colocando objeto cp no método deletar Itens da classe ComprovanteDao ;
        dao.deletaVendaPeloCodigo(cp);

    }
 // Visualizar os Detalhes da compra;
    public void visualizarVendas() {
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
    // metodo para lista pelo código do cliente e a dataa
    public void listaPeloCodigoClienteData() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas vendas que está  no banco de dados armazenadar; 
        for (VendaModel item : dao.listaPeloCodigoClienteEaData(txtcodcliente.getText(), txtdata.getText())) {
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
    // lista itens especificos  pelo códido da venda do cliente e da data;
    public void listaitensEspecificosDasVendas() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela item;
        modelo.setNumRows(0);
        //Instânciando a classe VendaDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas itens pelo código da venda do cliente e da data; 
        for (VendaModel item : dao.listaVendaPeloCodigoClienteData(txtcodvenda.getText(), txtcodcliente.getText(), txtdata.getText())) {
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

    // lista  toda tabela de item pela data;
    public void visualizarPeladate() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (VendaModel item : dao.visualizarPelaData(txtcodvenda.getText())) {
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
    public void visualizarEntreDataInicioDataFinal() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (VendaModel item : dao.visualizarDataComecoEfinal(txtdata.getText(), txtdata.getText())) {
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
            String sql = "select round(sum(total),2) from item where data='" + txtcodvenda.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                Valortt.setText("R$ "+formater.format(total));

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
    //Método para seta os valor total  dos itens pelo codigo cliente e data no campo de texto e na label;
    public void setaValorTotalpeloClienteData() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados;
            String sql = "select round(sum(total),2) from item where codCli='" + txtcodcliente.getText() + "'and data='"+txtdata.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                Valortt.setText("R$ "+formater.format(total));

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
      //método para seta a soma dos itens pelo código da venda do cliente e pela data
     public void setaValorTotalPeloCodigoClienteData() {

        DecimalFormat formater = new DecimalFormat("#0.00");

        try {
            Connection Conn = Conexao_BD.getConnection();
            //Comando para fazer a soma de toda coluna Valor Total no banco de dados da tabela item;
            String sql = "select round(sum(total),2) from item where codCli='" + txtcodcliente.getText() + "'and data='"+txtdata.getText()+"'"
                    + "and data='"+txtdata.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                Valortt.setText("R$ "+formater.format(total));

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
            String sql = "select codItem,codVenda,codCli, codProd,Qtd,valorUnit,total,data from item where data >'" + txtcodcliente + "' and data<'" + txtdata + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(ValorTotal),2)");
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
            String sql = "select round(sum(total),2) from item where data>'" + txtcodcliente.getText() + "' and data <'" + txtdata.getText() + "'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

            while (Rst.next()) {

                //Pegando o valor da soma
                double total = Rst.getDouble("round(sum(total),2)");
                //setando o valor no campo de texto e na label; 
                Valortt.setText("R$ "+formater.format(total));
               
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
            java.util.logging.Logger.getLogger(DetalheVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalheVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalheVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalheVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalheVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LISTAESPECIFICAMENTE;
    private javax.swing.JButton ListaTudo;
    private javax.swing.JTextField Valortt;
    private javax.swing.JButton deletaITENS;
    private javax.swing.JButton deletatd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtcodcliente;
    private javax.swing.JTextField txtcodvenda;
    private javax.swing.JTextField txtdata;
    // End of variables declaration//GEN-END:variables
}
