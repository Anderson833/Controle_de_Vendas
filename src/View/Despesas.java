/*

 Esse view realizar a soma das despesas e armazenar os dados;
 */
package View;

import Conexao.Conexao_BD;
import Dao.DespesaDao;
import Model.ApenasNumeros;
import Model.Data;
import Model.DespesaModel;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
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
public class Despesas extends javax.swing.JFrame {

    /**
     * Creates new form Despesas
     */
    public Despesas() {
        initComponents();
        //MÉTODO PARA EXIBIR A DATA DO DIA PRESENTE
         DataDoDia();
        //Método para impedir letras nos campos de data, valor total
        
        setLocationRelativeTo(this);
    }
     // variável para armazenar o valor total das despesas
       double ValorTotalDespesas=0;                     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDespesas = new javax.swing.JTable();
        addDespesas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodDespesa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelTotalDeTodasDespesas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        visualizar = new javax.swing.JButton();
        Deleta = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        alterar2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));

        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
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

        jLabel2.setText("Valor Total:");

        jLabel3.setText("Data:");

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });

        tbDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodDespesa", "Descrição:", "ValorTotal", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDespesasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbDespesas);

        addDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        addDespesas.setText("Adicionar");
        addDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDespesasActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição:");

        txtCodDespesa.setEditable(false);

        jLabel4.setText("Código:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setText(" Despesas");

        LabelTotalDeTodasDespesas.setBackground(new java.awt.Color(0, 0, 0));
        LabelTotalDeTodasDespesas.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jLabel6.setText("Valor Total De Todas Despesas:");

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        Deleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        Deleta.setText("Deletar");
        Deleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletaActionPerformed(evt);
            }
        });

        limparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limparCampos.setText("Limpar");
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposActionPerformed(evt);
            }
        });

        alterar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        alterar2.setText("Alterar");
        alterar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jScrollPane4)
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTotalDeTodasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(alterar2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(Deleta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(limparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtCodDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelTotalDeTodasDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alterar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limparCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
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
       DecimalFormat def = new DecimalFormat("#,##0.00");
       
    private void addDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDespesasActionPerformed
         
        camposVazio();
        
          if(camposVazio()){
           JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);    
          }else{
           
            //Método para salvar os dados das despesas
            salvarDespesas();
        //Método para visualizar as despesas
        visualizarDespesas();
        //Método para realizar a soma das despesas
        RealizarSomaDasDespesas();
          }
         
    }//GEN-LAST:event_addDespesasActionPerformed
  
    public void salvarDespesas(){
        // Instanciando a classe DespesaModel para criar  o objeto despesa
        DespesaModel d = new DespesaModel();
        //setando os valores 
        d.setDescricao(txtDescricao.getText());
        d.setTotal(Double.parseDouble(txtTotal.getText()));
        d.setData(txtData.getText());
        //Instanciando a classe DespesaDao para criar um objeto 
        DespesaDao dp = new DespesaDao();
        //Passando para o método de adicionarDespesa o objeto da classe DespesaModel
        dp.adicionaDespesa(d);
    }
    
    
    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
     //Método para exibir todas as despesas armazenadar
     visualizarDespesas();
     //Método para realizar a soma das despesas
       RealizarSomaDasDespesas();
    }//GEN-LAST:event_visualizarActionPerformed

    private void alterar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar2ActionPerformed
        
        if(avisoParaCampoDoCodigoVazio()){
             JOptionPane.showMessageDialog(null, "Clique na linha que deseja altera!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
       //Método para exibir todas as despesas armazenadar
        visualizarDespesas();
        }else{
         
        //Método para alterar os dados de despesa
        alterarDespesa(); 
         //Método para realizar a soma das despesas
        RealizarSomaDasDespesas();  
        //Método para exibir todas as despesas armazenadar
        visualizarDespesas();
      
        }
        
       
    }//GEN-LAST:event_alterar2ActionPerformed
    //Método para permitir só números
      public boolean soNumeros(String str){
        
         return str.matches("^[0.-9]+");
        
      // return s.matches("[^0-9]+");
    }
    
    private void tbDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDespesasMouseClicked
        
        if(tbDespesas.getSelectedRow()!=-1){
            txtCodDespesa.setText(tbDespesas.getValueAt(tbDespesas.getSelectedRow(),0).toString());
            txtDescricao.setText(tbDespesas.getValueAt(tbDespesas.getSelectedRow(),1).toString());
            txtTotal.setText(tbDespesas.getValueAt(tbDespesas.getSelectedRow(),2).toString());
            txtData.setText(tbDespesas.getValueAt(tbDespesas.getSelectedRow(),3).toString());
        }
        
    }//GEN-LAST:event_tbDespesasMouseClicked

    private void DeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletaActionPerformed
       //Método para saber se campo do código está vázio
        avisoParaCampoDoCodigoVazio();  
        if(avisoParaCampoDoCodigoVazio()){
             JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
        }else{
            //Método para deleta despesa
        ApagarDespesa();
         //Método para exibir todas as despesas armazenadar
        visualizarDespesas();
          //Método para realizar a soma das despesas
        RealizarSomaDasDespesas(); 
        }
        
       
    }//GEN-LAST:event_DeletaActionPerformed
  
      
     //metodo para digita só letras
    public boolean checkLetters(String str) {
        
              return str.matches("[a-zA-Z]+"); 
         
    }
     //Método para mostrar a data ao abrir essa jFRAME venda;
    public void DataDoDia() {
        Data dt = new Data();
        txtData.setText(dt.setaData());
        
    }
    //Método para verificar se tem campos varios
    public boolean camposVazio(){
        boolean preencha=false;
        if(txtDescricao.getText().isEmpty() && txtData.getText().isEmpty()&& txtTotal.getText().isEmpty()
                || txtDescricao.getText().isEmpty() || txtData.getText().isEmpty()|| txtTotal.getText().isEmpty()){
          
            if(txtDescricao.getText().isEmpty()){
                 txtDescricao.requestFocus();
            }else if(txtTotal.getText().isEmpty()){
                txtTotal.requestFocus();
            }else if(txtData.getText().isEmpty()){
                txtData.requestFocus();
        }
         preencha=true;
        }
         return preencha;
      }
    
    private void limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposActionPerformed
       //limpar tudo
        limparGeral();
    }//GEN-LAST:event_limparCamposActionPerformed

     public void limparGeral(){
           //setando os campos vázio
        txtCodDespesa.setText("");
        txtData.setText("");
        txtDescricao.setText("");
        txtTotal.setText("");
        LabelTotalDeTodasDespesas.setText("");
        //Método para limpa as linhas da tabela
        limpalinhas();
     }
     
    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
          //condição para impedir números
        if(soNumeros(txtDescricao.getText())){
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         txtDescricao.setText("");
           txtDescricao.requestFocus();
            
        }
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void txtDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyPressed
       
    }//GEN-LAST:event_txtDescricaoKeyPressed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
       
         //condição para permitir apenas números
        if(soNumeros(txtTotal.getText())){
        }else{
            if(txtTotal.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
            txtTotal.setText("");
           
           txtTotal.requestFocus();
         }
    }//GEN-LAST:event_txtTotalKeyReleased

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

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
      DataDoDia();
    }//GEN-LAST:event_txtDataActionPerformed
    
    //Método para limpar as linhas da tabela
    public void limpalinhas() {
        DefaultTableModel dm = (DefaultTableModel) tbDespesas.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }
    
//Método sem retorno para visualizar as despesas 
     public void visualizarDespesas(){
            //Instanciando a classe DespesaDao;
         DespesaDao despesas =new DespesaDao();

          DefaultTableModel modeloDespesa = (DefaultTableModel) tbDespesas.getModel();
          //método para não repetir os dados 
          modeloDespesa.setNumRows(0);
        
          //Laço de repetição para buscar os dados das despesas;
          for (DespesaModel desp :despesas.visualizarAsDespesas() ) {
             modeloDespesa.addRow(new Object[] {
             desp.getCodDespesa(),
             desp.getDescricao(),
             desp.getTotal(),
             desp.getData(), 
             });
              
              
        }
     }
     //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtCodDespesa.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }
     
     
    //Método para alterar os dados da despesa
    public void alterarDespesa(){
        //Instanciando a  classe de DespesaDao para construir um objeto 
        DespesaDao alt = new DespesaDao();
        //Instanciando a  classe de DespesaModel para criar um objeto do tipo despesa
        DespesaModel dps =new DespesaModel();
        //setando os dados
        dps.setDescricao(txtDescricao.getText());
        dps.setTotal(Double.parseDouble(txtTotal.getText()));
        dps.setData(txtData.getText());
        dps.setCodDespesa(Integer.parseInt(txtCodDespesa.getText()));
      
        //Uma objeto com seu método de atualizarDespesa receber um objeto de despesa 
        alt.atualizarDespesa(dps);
    }
    
    //Deletar despesas pelo código da despesa
     public void ApagarDespesa(){
          //Instanciando a  classe de DespesaDao para construir um objeto 
        DespesaDao deleta = new DespesaDao();
        //Instanciando a  classe de DespesaModel para criar um objeto do tipo despesa
        DespesaModel dps =new DespesaModel();
        dps.setCodDespesa(Integer.parseInt(txtCodDespesa.getText()));
        deleta.excluirDespesa(dps);
     }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        this.setExtendedState(MAXIMIZED_BOTH);

        
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
             
                  LabelTotalDeTodasDespesas.setText(""+valorDespesas);
              
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {
        
         
            
            JOptionPane.showMessageDialog(null, "Valor não Encontrado !");
        }
        
     }
       
        
    public static void main(String args[]) {
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Despesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deleta;
    private javax.swing.JLabel LabelTotalDeTodasDespesas;
    private javax.swing.JButton addDespesas;
    private javax.swing.JButton alterar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton limparCampos;
    private javax.swing.JTable tbDespesas;
    private javax.swing.JTextField txtCodDespesa;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
