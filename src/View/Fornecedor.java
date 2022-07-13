
//View Fornecedor;
package View;

import Dao.FornecedorDao;
import Model.FornecedorModel;
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
        
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codFornec = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        valorvenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        valorcompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        qtd = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Produto:");

        jLabel5.setText("Valor  De Revendar:");

        jLabel6.setText("ValorDeComprar:");

        jLabel7.setText("Quantidade:");

        jLabel8.setText("Endereço:");

        jLabel9.setText("Data:");

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
                "CodFornec", "Nome", "Telefone", "Produto", "ValordeRevenda", "ValordComprar", "Qtd_Prod", "Endereço", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        visualizarFornec.setText("Visualizar");
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
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(valorvenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codFornec, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valorcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visualizarFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codFornec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limpa))
                    .addComponent(deletar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addFornec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visualizarFornec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFornecActionPerformed
     
        //Método para adicionar fornecedores no banco de dados;
            addFornecedor();
    }//GEN-LAST:event_addFornecActionPerformed

    private void visualizarFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarFornecActionPerformed
     
        //Metodo para visualizar todos os fornecedores;
        visualizarFornecedores();
        
    }//GEN-LAST:event_visualizarFornecActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     
        //Método para atualizar os dados do fornecedores;
        atualizarFornecedor();
        
    }//GEN-LAST:event_atualizarActionPerformed

    private void tabelaFornecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornecMouseClicked
       //Ao clicar seta os valores nos campos de textos;
        if(tabelaFornec.getSelectedRow() !=-1){
            
            codFornec.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),0).toString());
            txtnome.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),1).toString());
            telefone.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),2).toString());
            prod.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),3).toString());
            valorvenda.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),4).toString());
            valorcompra.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),5).toString());
            qtd.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),6).toString());
              endereco.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),7).toString());
            data.setText(tabelaFornec.getValueAt(tabelaFornec.getSelectedRow(),8).toString());
            
        }
        
    }//GEN-LAST:event_tabelaFornecMouseClicked

    private void limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaActionPerformed
     
        //Método para limpar os campos de textos;
         limparCampos();
         
           //Método para limpar todas linhas da tabela;
           limpalinha();
    }//GEN-LAST:event_limpaActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed

        //Método para deletar fornecedor
        deletarFornecedor();
    }//GEN-LAST:event_deletarActionPerformed
      
    //Método para deletar fornecedores;
     public void deletarFornecedor(){
          //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();
         //Instânciando a classe FornecedorModel;
       FornecedorModel fornec = new FornecedorModel();
       //setando os valores;
       fornec.setCodFornec(codFornec.getText());
       dao.deletaFornecedor(fornec);
     }
    
    
    //Método para atualizar os dados do fornecedor;
     public void atualizarFornecedor(){
         
            //Instânciando a classe FornecedorDao;
         FornecedorDao dao =new FornecedorDao();
         
         
         //Instânciando a classe FornecedorModel;
       FornecedorModel fornec = new FornecedorModel();
       //setando os valores;
       fornec.setCodFornec(codFornec.getText());
       fornec.setNomeFornec(txtnome.getText());
       fornec.setEndereco(endereco.getText());
       fornec.setContato(telefone.getText());
       fornec.setNomeproduto(prod.getText());
       fornec.setValorDeRevenda(Double.parseDouble(valorvenda.getText()));
       fornec.setValorDcomprar(Double.parseDouble(valorcompra.getText()));
       fornec.setQtd_estoque(Integer.parseInt(qtd.getText()));
       fornec.setData(data.getText());
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
             fornec.getContato(),
             fornec.getNomeproduto(),
             fornec.getValorDeRevenda(),
             fornec.getValorDcomprar(),
             fornec.getQtd_estoque(),
             fornec.getEndereco(),
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
       fornec.setCodFornec(codFornec.getText());
       fornec.setNomeFornec(txtnome.getText());
       fornec.setEndereco(endereco.getText());
       fornec.setContato(telefone.getText());
       fornec.setNomeproduto(prod.getText());
       fornec.setValorDeRevenda(Double.parseDouble(valorvenda.getText()));
       fornec.setValorDcomprar(Double.parseDouble(valorcompra.getText()));
       fornec.setQtd_estoque(Integer.parseInt(qtd.getText()));
       fornec.setData(data.getText());
       // adicionando os valores no objeto dao;
       dao.adicionarFornecedor(fornec);
       
         
   }
     //Método para Limpar os campos de textos;
    public void limparCampos(){
        codFornec.setText("");
        endereco.setText("");
        valorcompra.setText("");
        txtnome.setText("");
        valorvenda.setText("");
        prod.setText("");
        qtd.setText("");
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
    private javax.swing.JTextField codFornec;
    private javax.swing.JTextField data;
    private javax.swing.JButton deletar;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpa;
    private javax.swing.JTextField prod;
    private javax.swing.JTextField qtd;
    private javax.swing.JTable tabelaFornec;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField valorcompra;
    private javax.swing.JTextField valorvenda;
    private javax.swing.JButton visualizarFornec;
    // End of variables declaration//GEN-END:variables
}
