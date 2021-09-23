
  // VIEW DE PRODUTO
package View;

import Dao.ProdutoDao;
import Model.ProdutoModel;



import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class Produto extends javax.swing.JFrame {

    public Produto() {
        initComponents();
        
        //Centralizando a view ao centro da monitor;
        setLocationRelativeTo(null);
    }

     
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValorUnt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        EXIBIR = new javax.swing.JButton();
        salvarProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBProduto = new javax.swing.JTable();
        limp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Código Produto:");

        jLabel2.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Descrição:");

        jLabel4.setText("Valor  Unitário:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        jButton1.setText("Excluir");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        Atualizar.setText("Atualizar");
        Atualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        EXIBIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        EXIBIR.setText("Visualizar Dados");
        EXIBIR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        EXIBIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXIBIRActionPerformed(evt);
            }
        });

        salvarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        salvarProd.setText("Adicionar");
        salvarProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        salvarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarProdActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/produtos.png"))); // NOI18N
        jLabel6.setText("        PRODUTOS");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Qtd em  Estoque: ");

        txtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstoqueActionPerformed(evt);
            }
        });

        TBProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodProd", "Nome", "Descrição", "ValorUnit", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBProduto);

        limp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limp.setText("Limpar");
        limp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        limp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNome)
                                .addGap(314, 314, 314))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorUnt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 142, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(limp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EXIBIR, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEstoque)
                        .addComponent(txtValorUnt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXIBIR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        //Método que deletar Produto no banco de dados;
           deletarProduto();
    }//GEN-LAST:event_jButton1ActionPerformed
   
     //Metodo para deletar produtos;
    public void deletarProduto(){
        
              //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
              
              //seta valor
             prod.setCodProd(txtCodProd.getText());
             //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
             dao.deletaProduto(prod);
        
    }
    
    
    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
            
        //Método para atualizar produtos;
           atualizarProdutos();
    }//GEN-LAST:event_AtualizarActionPerformed

     //Método para atualizar os produtos
    public void atualizarProdutos(){
        
          if (TBProduto.getSelectedRow() != -1) {
        
                //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
              prod.setCodProd(txtCodProd.getText());
              prod.setNome(txtNome.getText());
              prod.setDescricao(txtDescricao.getText());
              prod.setValorUnit(Double.parseDouble(txtValorUnt.getText()));
              prod.setEstoque(Integer.parseInt(txtEstoque.getText()));
             //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
              dao.atualizarProdtuo(prod);
              
              
        }
    }
    
    private void salvarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarProdActionPerformed
        // Adicionando os Produtos no Banco de Dados;
        adicionarProdutos();
    }//GEN-LAST:event_salvarProdActionPerformed
       
    //Método para adicionar os produtos no bancode dados;
    public void adicionarProdutos(){
          //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
              prod.setCodProd(txtCodProd.getText());
              prod.setNome(txtNome.getText());
              prod.setDescricao(txtDescricao.getText());
              prod.setValorUnit(Double.parseDouble(txtValorUnt.getText()));
              prod.setEstoque(Integer.parseInt(txtEstoque.getText()));
                 //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
              dao.adicionarProduto(prod);
              
        
    }
    
    
    private void EXIBIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXIBIRActionPerformed
   
         // Exibindo os Dados dos Produtos No Banco de Dados;
         visualizarProdutos();
    
    }//GEN-LAST:event_EXIBIRActionPerformed

    private void TBProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBProdutoMouseClicked
      
        // Setando todos os dados da Tabela nas jTextField;
        
         if (TBProduto.getSelectedRow() != -1) {
            //Seta os dados de cada linha a ser clicadar da tabela;
         txtCodProd.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),0).toString());
             txtNome.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),1).toString());
         txtDescricao.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),2).toString());
          txtValorUnt.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),3).toString());
           txtEstoque.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),4).toString());
           
         
       
           
        }
        
        
    }//GEN-LAST:event_TBProdutoMouseClicked

    private void txtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstoqueActionPerformed
       
    }//GEN-LAST:event_txtEstoqueActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
       
    }//GEN-LAST:event_txtNomeActionPerformed

    private void limpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpActionPerformed
      
        //Método para limpar os campos de textos;
        limpar();
        //Método para limpar as linhas da tabela;
        limpalinha();
        
    }//GEN-LAST:event_limpActionPerformed

     //Método para visualizar toda tabela Produto;
     public void visualizarProdutos(){
              //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
         
           DefaultTableModel modelo = (DefaultTableModel) TBProduto.getModel();
           modelo.setNumRows(0);
           //Laço de repetição percorrendo a lista de produtos;
           for (ProdutoModel prod : dao.visualizarClientes()) {
               modelo.addRow(new Object[]{
               prod.getCodProd(),
               prod.getNome(),
               prod.getDescricao(),
               prod.getValorUnit(),
               prod.getEstoque()
               
               
               
               });
         }
         
     }
     
     //Método para limpar os campos de textos;
     public void limpar(){
          txtCodProd.setText("");
         txtNome.setText("");
         txtDescricao.setText("");
         txtValorUnt.setText("");
          txtEstoque.setText("");
         
         
    }
    
     // Método para limpar as linhas ;
     public void limpalinha(){
        DefaultTableModel dm = (DefaultTableModel) TBProduto.getModel();
while(dm.getRowCount() > 0)
{
    dm.removeRow(0);
}
    }
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton EXIBIR;
    private javax.swing.JTable TBProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limp;
    private javax.swing.JButton salvarProd;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorUnt;
    // End of variables declaration//GEN-END:variables

  
  
}
