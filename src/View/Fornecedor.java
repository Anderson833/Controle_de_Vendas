
//View Fornecedor;
package View;

import Dao.FornecedorDao;
import Model.Data;
import Model.FornecedorModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class Fornecedor extends javax.swing.JFrame {

    /**
     * Jframe Fornecedor
     */
    public Fornecedor() {
        initComponents();
        //Método para seta data do dia
        DataDoDia();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFornec = new javax.swing.JTable();
        visualizarFornec = new javax.swing.JButton();
        addFornec = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        limpa = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setText("Nome:");

        txtnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Telefone:");

        telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telefoneKeyReleased(evt);
            }
        });

        jLabel8.setText("Endereço:");

        endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enderecoKeyReleased(evt);
            }
        });

        jLabel9.setText("Data:");

        data.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });
        data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setText("Cadastrar Fornecedores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelaFornec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodFornec", "Nome", "Endereço", "Telefone", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFornec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFornec);

        visualizarFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizarFornec.setText("Listar Tudo");
        visualizarFornec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        visualizarFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarFornecActionPerformed(evt);
            }
        });

        addFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        addFornec.setText("Adicionar");
        addFornec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFornecActionPerformed(evt);
            }
        });

        deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        deletar.setText("Deletar");
        deletar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limpa.setText("Limpar");
        limpa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaActionPerformed(evt);
            }
        });

        txtcodigo.setEditable(false);

        jLabel1.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jScrollPane1)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endereco))
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(telefone))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visualizarFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(addFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(limpa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpa))
                    .addComponent(deletar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(visualizarFornec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addFornec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFornecActionPerformed
     
          //Condição para saber se tem capo vazio
        if(preencherCampos()){
            
        }else{
         //Método para adicionar fornecedores no banco de dados;
            addFornecedor();
        //Metodo para visualizar todos os fornecedores;
        visualizarFornecedores();
        }
     
    }//GEN-LAST:event_addFornecActionPerformed

    private void visualizarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarFornecActionPerformed
     
        //Metodo para visualizar todos os fornecedores;
        visualizarFornecedores();
        
    }//GEN-LAST:event_visualizarFornecActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     
          //Método para saber se campo do código está vázio
      
        if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarFornecedores();
        }else{
           //Método para atualizar os dados do fornecedores;
        atualizarFornecedor();
        //Metodo para visualizar todos os fornecedores;
        visualizarFornecedores(); 
            
        }
        
        
    }//GEN-LAST:event_atualizarActionPerformed

     //Método para mandar preenche os campos
    public boolean preencherCampos(){
        boolean vrg=false;
        if(txtnome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtnome.requestFocus();
            vrg=true;
        }else
        if(endereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            endereco.requestFocus();
             vrg=true;
        }else
        if(data.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            data.requestFocus();
             vrg=true;
        }else
          if(telefone.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            telefone.requestFocus();
             vrg=true;
        }
       
        return vrg;
    }
    
    //Método para mostrar a data ao abrir essa jFRAME venda;
    public void DataDoDia() {
        Data dt = new Data();
        data.setText(dt.setaData());
        
    }
    //Método para permitir apenas números
     public boolean sonumeros(String str){
        
         return str.matches("^[0.-9 ]+");
    }
    
      //metodo para digita só nomes
    public boolean checkLetters(String str) {

        return str.matches("[a-zA-Z é ê ú í ôá õ ç â~,.ã^~,.]+");
    }
    
    private void tabelaFornecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecMouseClicked
       //Ao clicar seta os valores nos campos de textos;
        if(tabelaFornec.getSelectedRow() !=-1){
            
          
            txtcodigo.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),0).toString());
            txtnome.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),1).toString());
             endereco.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),2).toString());
              telefone.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),3).toString());
            data.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),4).toString());
            
        }
        
    }//GEN-LAST:event_tabelaFornecMouseClicked

    private void limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaActionPerformed
     
        //Método para limpar os campos de textos;
         limparCampos();
         
           //Método para limpar todas linhas da tabela;
           limpalinha();
    }//GEN-LAST:event_limpaActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed

         //Condição para saber se o código está setado no campo de código  
         if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarFornecedores();
        }else{
            //Método para deletar fornecedor
        deletarFornecedor();
          //Metodo para visualizar todos os fornecedores;
        visualizarFornecedores();
        }
       
        
       
    }//GEN-LAST:event_deletarActionPerformed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        DataDoDia();
    }//GEN-LAST:event_dataActionPerformed

    private void dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataKeyReleased
        
         //condição para permitir apenas números
        if(sonumeros(data.getText())){
           
        }else{
            
             if(data.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           data.setText("");
           data.requestFocus();
         }
    }//GEN-LAST:event_dataKeyReleased

    private void txtnomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeKeyReleased
        //condição para impedir números
        if(checkLetters(txtnome.getText())){
          
        }else{
               if(txtnome.getText().equals("")){
                
            }else{
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         txtnome.setText("");
           txtnome.requestFocus();
               }
        }
    }//GEN-LAST:event_txtnomeKeyReleased

    private void enderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enderecoKeyReleased
         //condição para impedir números
        if(checkLetters(endereco.getText())){
          
        }else{
              if(endereco.getText().isEmpty()){
                
            }else{
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         endereco.setText("");
           endereco.requestFocus();
              }
        }
    }//GEN-LAST:event_enderecoKeyReleased

    private void telefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyReleased
          //condição para permitir apenas números
        if(sonumeros(telefone.getText())){
           
        }else{
            
             if(telefone.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           telefone.setText("");
           telefone.requestFocus();
         }
    }//GEN-LAST:event_telefoneKeyReleased
      
     //Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtcodigo.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }
    //Método para deletar fornecedores;
     public void deletarFornecedor(){
          //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();
         //Instânciando a classe FornecedorModel;
       FornecedorModel fornec = new FornecedorModel();
       //setando os valores;
       fornec.setCodFornec(Integer.parseInt(txtcodigo.getText()));
       dao.deletaFornecedor(fornec);
     }
    
    
    //Método para atualizar os dados do fornecedor;
     public void atualizarFornecedor(){
         
            //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();
         
         
         //Instânciando a classe FornecedorModel;
       FornecedorModel fornec = new FornecedorModel();
       //setando os valores;
      
       fornec.setNomeFornec(txtnome.getText());
       fornec.setEndereco(endereco.getText());
       fornec.setContato(telefone.getText());
       fornec.setData(data.getText());
       fornec.setCodFornec(Integer.parseInt(txtcodigo.getText()));
       // atualizar os dados do fornecedor no objeto dao;
       dao.atualizarFornecedor(fornec);
       
     }
    
    
     //Método para visualizar;
    public void visualizarFornecedores(){
        
         //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();

          DefaultTableModel modelo = (DefaultTableModel) tabelaFornec.getModel();
          modelo.setNumRows(0);
        
          //Laço de repetição para visualizar os dados dos fornecedores;
          for (FornecedorModel fornec :dao.visualizarFornecedor() ) {
             modelo.addRow(new Object[] {
             fornec.getCodFornec(),
             fornec.getNomeFornec(),
             fornec.getEndereco(),
             fornec.getContato(),
             fornec.getData()
             
             
             
             });
              
              
        }
        
    }
    
    
    //Método para adicionar fornecedor;
     public void addFornecedor(){
        //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();
         
         
         //Instânciando a classe FornecedorModel;
       FornecedorModel fornec = new FornecedorModel();
       //setando os valores;
     //  fornec.setCodFornec(codFornec.getText());
       fornec.setNomeFornec(txtnome.getText());
       fornec.setEndereco(endereco.getText());
       fornec.setContato(telefone.getText());
       
       fornec.setData(data.getText());
       // adicionando os valores no objeto dao;
       dao.adicionarFornecedor(fornec);
       
         
   }
     //Método para Limpar os campos de textos;
    public void limparCampos(){
       
        endereco.setText("");
        txtnome.setText("");
        data.setText("");
        telefone.setText("");
    }
     
    //Método para limpar todas linhas da tabela;
       public void limpalinha(){
        DefaultTableModel dm = (DefaultTableModel) tabelaFornec.getModel();
   while(dm.getRowCount() > 0)
   {
    dm.removeRow(0);
    }
    }
     
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFornec;
    private javax.swing.JButton atualizar;
    private javax.swing.JTextField data;
    private javax.swing.JButton deletar;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpa;
    private javax.swing.JTable tabelaFornec;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnome;
    private javax.swing.JButton visualizarFornec;
    // End of variables declaration//GEN-END:variables
}
