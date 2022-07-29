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
            String sql = "SELECT round(sum(total),2) FROM item where data='" + txtData.getText() + "'";

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
            String sql = "SELECT round(sum(total),2) FROM item data >'" + txtdataInicio + "' and data<'" + txtdataFinal + "'";

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
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdataInicio = new javax.swing.JTextField();
        txtdataFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        visualizar = new javax.swing.JButton();
        ListaTudo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        deletatd = new javax.swing.JButton();

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

        jLabel2.setText("Data Especifica:");

        txtdataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdataInicioKeyReleased(evt);
            }
        });

        txtdataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataFinalActionPerformed(evt);
            }
        });
        txtdataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdataFinalKeyReleased(evt);
            }
        });

        jLabel3.setText("Data de Inicio:");

        jLabel4.setText("Data Final:");

        visualizar.setText("Listar Entrer as Datas");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtdataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(txtdataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(ListaTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                                .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(deletatd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1)))
                .addGap(37, 37, 37))
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ListaTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(deletatd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Valortt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
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

            if(txtData.getText().equals("")){
             
             JOptionPane.showMessageDialog(null, "Preencha o campo da data!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
              txtData.requestFocus();
            }else if(txtData.getText()!=data){
             JOptionPane.showMessageDialog(null, "Tente outra data diferente dessa  "+txtData.getText()+"","Data não encontrada:",JOptionPane.INFORMATION_MESSAGE);
              txtData.requestFocus();
         }else{
           visualizarPeladate();
             setaValorTotalDosItensPelaDataEspecifica();
  
         }
               // setaValorTotalpelaData();
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtdataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataFinalActionPerformed


    }//GEN-LAST:event_txtdataFinalActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
     if(txtdataInicio.getText().equals("")&&txtdataFinal.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Preencha os campos das datas de inicio e final!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
       
     }else  if(txtdataInicio.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo da data de inicio!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             txtdataInicio.requestFocus();
         }
           
      else   if(txtdataFinal.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Preencha o campo da data final!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
             txtdataFinal.requestFocus();
             
         } else if(txtdataFinal.getText().equals(data)&&txtdataInicio.getText()!=data){
                JOptionPane.showMessageDialog(null, "Data de inicio não se encontra!","Opa...:",JOptionPane.ERROR_MESSAGE); 
                 txtdataInicio.requestFocus();
         } else 
            if(txtdataInicio.getText().equals(data)&&txtdataFinal.getText()!=data){
                JOptionPane.showMessageDialog(null, "Data final não se encontra!","Opa...:",JOptionPane.ERROR_MESSAGE);
                 txtdataFinal.requestFocus();
                 
             }else if(txtdataInicio.getText()!=data&&txtdataFinal.getText()!=data){
             JOptionPane.showMessageDialog(null, "Tente outras datas diferentes dessas  "+txtdataInicio.getText()+" e "+txtdataFinal.getText()+" ","Datas não encontradas:",JOptionPane.INFORMATION_MESSAGE);
              
          } else{
                 visualizarDataInicioDataFinal();
               setaValorTotalpelaDataComecoEfinal();
                   
          }
    }//GEN-LAST:event_visualizarActionPerformed

    private void ListaTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaTudoActionPerformed
        //métodos para lista e somar todas vendas
        visualizarVendas();
        setaValorTotalDosItens();
    }//GEN-LAST:event_ListaTudoActionPerformed

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

    private void txtdataInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataInicioKeyReleased
      
           //condição para permitir apenas números
        if(sonumeros(txtdataInicio.getText())){
        }else{
             if(txtdataInicio.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtdataInicio.setText("");
           txtdataInicio.requestFocus();
         }

    }//GEN-LAST:event_txtdataInicioKeyReleased

    private void txtdataFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdataFinalKeyReleased
         //condição para permitir apenas números
        if(sonumeros(txtdataFinal.getText())){
        }else{
             if(txtdataFinal.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           txtdataFinal.setText("");
           txtdataFinal.requestFocus();
         }

    }//GEN-LAST:event_txtdataFinalKeyReleased

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
        cp.setCodVenda(Integer.parseInt(txtData.getText()));
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

    // lista  toda tabela de item pela data;
    public void visualizarPeladate() {
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
    public void visualizarDataInicioDataFinal() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVend.getModel();
        //Método para não repetir os dados na tabela de comprar;
        modelo.setNumRows(0);
        //Instânciando a classe ComprovanteDao;
        VendaDao dao = new VendaDao();
        //Um Laço de repetição para lista todas compras na tabela comprar no banco de dados; 
        for (VendaModel item : dao.visualizarDataComecoEfinal(txtdataInicio.getText(), txtdataFinal.getText())) {
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
            String sql = "select round(sum(total),2) from item where data='" + txtData.getText() + "'";

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
            String sql = "select codItem,codVenda,codCli, codProd,Qtd,valorUnit,total,data from item where data >'" + txtdataInicio + "' and data<'" + txtdataFinal + "'";

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
            String sql = "select round(sum(total),2) from item where data>'" + txtdataInicio.getText() + "' and data <'" + txtdataFinal.getText() + "'";

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
    private javax.swing.JButton ListaTudo;
    private javax.swing.JTextField Valortt;
    private javax.swing.JButton deletatd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVend;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtdataFinal;
    private javax.swing.JTextField txtdataInicio;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
