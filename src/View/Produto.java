
  // VIEW DE PRODUTO
package View;

import Conexao.Conexao_BD;
import Dao.FornecedorDao;
import Dao.ProdutoDao;
import Model.FornecedorModel;
import Model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class Produto extends javax.swing.JFrame {

    public Produto() {
        initComponents();
        //método para seta os códigos dos fornecedores
        setaDadosJcomboxDeFornecedor();
        //Centralizando a view ao centro da monitor;
        setLocationRelativeTo(null);
    }

     
    String codProd="";

   
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
        jLabel5 = new javax.swing.JLabel();
        valorDcompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtCodInvestimento = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Código:");

        txtCodProd.setEditable(false);

        jLabel2.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel3.setText("Descrição:");

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });

        jLabel4.setText("Valor De  Revendar:");

        txtValorUnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorUntKeyReleased(evt);
            }
        });

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
        EXIBIR.setText("Listar Tudo");
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
        jLabel6.setText("    Cadastrar    Produtos");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Qtd em  Estoque: ");

        txtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstoqueActionPerformed(evt);
            }
        });
        txtEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEstoqueKeyReleased(evt);
            }
        });

        TBProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodProd", "Nome", "Descrição", "ValorUnit", "ValorDeComprar", "Estoque", "CodFornec"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        jLabel5.setText("Código do Fornecedor:");

        valorDcompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorDcompraKeyReleased(evt);
            }
        });

        jLabel7.setText("Valor De Comprar:");

        jComboBoxFornecedor.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jComboBoxFornecedor.setForeground(new java.awt.Color(102, 102, 255));
        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha Código do Fornecedor" }));

        jLabel9.setText("Código Investimento:");

        jButton2.setText("Pesquisa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(limp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(salvarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(EXIBIR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jScrollPane1)))
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorUnt, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorDcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodInvestimento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescricao)
                    .addComponent(valorDcompra)
                    .addComponent(txtValorUnt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXIBIR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpActionPerformed

        //Método para limpar os campos de textos;
        limpar();
        //Método para limpar as linhas da tabela;
        limpalinha();

    }//GEN-LAST:event_limpActionPerformed

    private void TBProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBProdutoMouseClicked

        // Setando todos os dados da Tabela nas jTextField;

        if (TBProduto.getSelectedRow() != -1) {
            //Seta os dados de cada linha a ser clicadar da tabela;
            txtCodProd.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),0).toString());
            txtNome.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),1).toString());
            txtDescricao.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),2).toString());
            txtValorUnt.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),3).toString());
            valorDcompra.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),4).toString());
            txtEstoque.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),5).toString());
          //  txtcodfornec.setText(TBProduto.getValueAt(TBProduto.getSelectedRow(),6).toString());
           

        }

    }//GEN-LAST:event_TBProdutoMouseClicked

     //Método para adiciona o codigo do fornecedor;
    public void setaDadosJcomboxDeFornecedor() {

        //Instanciando a classe FornecedorDao para criar o objeto;  
        FornecedorDao dao = new FornecedorDao();

        // laço de repetição para visualizar o código do fornecedor;
        for (FornecedorModel  fornec : dao.visualizarFornecedor()) {
            //Adicionando os itens na caixa de combinação;
            jComboBoxFornecedor.addItem(fornec.toString());

        }

    }
    
    private void txtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstoqueActionPerformed
       // setaDadosInvestimento();
    }//GEN-LAST:event_txtEstoqueActionPerformed
         //Método para seta os códigos dos produtos;
    public void setaCodigoDoProduto() {
        
        

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar  os dados da tabela vendas
            String sql = "SELECT max(codProd) FROM produto";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando os dados
                codProd=Rst.getString("max(codProd)");
                
            } 

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "dados não encontrado ! ");
        }
        
       
    }
  
    
    private void salvarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarProdActionPerformed
      
          
          //Condição para saber se tem capo vazio
        if(preencherCampos()){
        }else{
            
             if(jComboBoxFornecedor.getSelectedIndex()==0){
          JOptionPane.showMessageDialog(null," Escolha  o código do Fornecedor! "," Por Favor",JOptionPane.INFORMATION_MESSAGE);
           jComboBoxFornecedor.requestFocus();
               }
            setaCodigoDoProduto();
         // Adicionando os Produtos no Banco de Dados;
        adicionarProdutos();
        // Exibindo os Dados dos Produtos No Banco de Dados;
        visualizarProdutos();
        }
    }//GEN-LAST:event_salvarProdActionPerformed

    private void EXIBIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXIBIRActionPerformed

        // Exibindo os Dados dos Produtos No Banco de Dados;
        visualizarProdutos();

    }//GEN-LAST:event_EXIBIRActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
             //Método para saber se campo do código está vázio
     
        if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarProdutos();
        }else{
               if(jComboBoxFornecedor.getSelectedIndex()==0){
          JOptionPane.showMessageDialog(null," Escolha  o código do Fornecedor! "," Por Favor",JOptionPane.INFORMATION_MESSAGE);
           jComboBoxFornecedor.requestFocus();
               }else{
              //Método para atualizar produtos;
        atualizarProdutos();
        // Exibindo os Dados dos Produtos No Banco de Dados;
        visualizarProdutos();       
          }
            
        }
      
    }//GEN-LAST:event_AtualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          //Condição para saber se o código está setado no campo de código  
         if(avisoParaCampoDoCodigoVazio()){
        JOptionPane.showMessageDialog(null, "Clique na linha que deseja excluir!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
         //Método para visualizar os investimentos 
        visualizarProdutos();
        }else{
             //Método que deletar Produto no banco de dados;
        deletarProduto();
        // Exibindo os Dados dos Produtos No Banco de Dados;
        visualizarProdutos();
        }
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
 
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        //condição para impedir números
        if(checkLetters(txtDescricao.getText())){
          
        }else{
            if(txtDescricao.getText().isEmpty()){
                
            }else{
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         txtDescricao.setText("");
           txtDescricao.requestFocus();
            }
        }
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void txtValorUntKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUntKeyReleased
         //condição para permitir apenas números
        if(sonumeros(txtValorUnt.getText())){
           
        }else{
            
             if(txtValorUnt.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtValorUnt.setText("");
           txtValorUnt.requestFocus();
         }
    }//GEN-LAST:event_txtValorUntKeyReleased

    private void valorDcompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorDcompraKeyReleased
      
          //condição para permitir apenas números
        if(sonumeros(valorDcompra.getText())){
           
        }else{
            
             if(valorDcompra.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           valorDcompra.setText("");
           valorDcompra.requestFocus();
         }
    }//GEN-LAST:event_valorDcompraKeyReleased

    private void txtEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstoqueKeyReleased
          //condição para permitir apenas números
        if(sonumeros(txtEstoque.getText())){
           
        }else{
            
             if(txtEstoque.getText().isEmpty()){
                
            }else{
              JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar números! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
            }
           
           txtEstoque.setText("");
           txtEstoque.requestFocus();
         }
    }//GEN-LAST:event_txtEstoqueKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        //condição para impedir números
        if(checkLetters(txtNome.getText())){
            
        }else{
            if(txtNome.getText().isEmpty()&&txtNome.getText().length()==0 ){
                
            }else{
      JOptionPane.showMessageDialog(null, "Nesse campo você só poder colocar Letras! ","Por favor: ",JOptionPane.ERROR_MESSAGE);
         txtNome.setText("");
           txtNome.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
         if(txtCodInvestimento.getText().isEmpty()){
     JOptionPane.showMessageDialog(null, "Informe  o código do investimento!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
           txtCodInvestimento.requestFocus();
         }else{ 
        //método para seta os dados do investimento
          setaDadosInvestimento(); 
         }
       
    }//GEN-LAST:event_jButton2ActionPerformed
      //Método para mandar preenche os campos
    public boolean preencherCampos(){
        boolean vrg=false;
        if(txtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtNome.requestFocus();
            vrg=true;
        }else
        if(txtDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtDescricao.requestFocus();
             vrg=true;
        }else
        if(txtEstoque.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtEstoque.requestFocus();
             vrg=true;
        }else
          if(txtValorUnt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            txtValorUnt.requestFocus();
             vrg=true;
        }else
          if(valorDcompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!","Por favor:",JOptionPane.INFORMATION_MESSAGE);
            valorDcompra.requestFocus();
             vrg=true;
        }
       
        return vrg;
    }
    
     //Método para permitir apenas números
     public boolean sonumeros(String str){
        
         return str.matches("^[0.-9 ]+");
    }
    
      //metodo para digita só nomes
    public boolean checkLetters(String str) {

        return str.matches("[a-zA-Z é ê õ á ú íô ç â~,.ã^~,.]+");
    }
    

//Método para avisa se o campo de código está vázio
      public boolean avisoParaCampoDoCodigoVazio(){
          
          boolean aviso=false;
          
          if(txtCodProd.getText().isEmpty()){
             aviso=true;
          }
        return aviso;
          
      }

     //Método para seta dados dos fornecedores;  
      public void setaDadosInvestimento(){
          
           try {
            Connection Conn = Conexao_BD.getConnection();
            
        //    int v=Integer.parseInt(txtcodfornec.getText());
            
            String sql = "SELECT nomeProd,ValorDeRevenda,valorDeComprar,QtdProd FROM investimento where codInvestir='"+txtCodInvestimento.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);
            
            ResultSet Rst = Patm.executeQuery();
            
             
        

            
            while (Rst.next()) {
                 //seta valor de venda do produto que vem da tabela fornecedor
                 String valorDeRevendar= Rst.getString("ValorDeRevenda");
                txtValorUnt.setText(valorDeRevendar+"");
                 String valorDcomprar= Rst.getString("valorDeComprar");
                valorDcompra.setText(valorDcomprar);
               
                 //seta nome do produto que vem da tabela fornecedor
                String nome= Rst.getString("nomeProd");
                txtNome.setText(nome+"");
              //seta Qtd do produto que vem da tabela fornecedor
               String QtdProd= Rst.getString("QtdProd");
                txtEstoque.setText(QtdProd+"");
                
            }
            
                
             //Fechando conexão ResultSet;
             Rst.close();
             
             //Fechando conexão PreparedStatement;
            Patm.close();
            
            //Fechando conexão Connection;
            Conn.close();
           

        } catch (SQLException e) {
        
         
            //caso de algo errado mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Não tem esse produto no investimento !");
        }
        
      }
    
    
     //Metodo para deletar produtos;
    public void deletarProduto(){
        
              //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
              
              //seta valor
             prod.setCodProd(Integer.parseInt(txtCodProd.getText()));
             //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
             dao.deletaProduto(prod);
        
    }
    
    
     //Método para atualizar os produtos
    public void atualizarProdutos(){
        
          if (TBProduto.getSelectedRow() != -1) {
        
                //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
              prod.setCodProd(Integer.parseInt(txtCodProd.getText()));
              prod.setProduto(txtNome.getText());
              prod.setDescricao(txtDescricao.getText());
              prod.setValorDeRevenda(Double.parseDouble(txtValorUnt.getText()));
              prod.setValorDcomprar(Double.parseDouble(valorDcompra.getText()));
              prod.setQtd_estoquer(Integer.parseInt(txtEstoque.getText()));
              prod.setCodFornec(Integer.parseInt(jComboBoxFornecedor.getSelectedItem().toString()));
             //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
              dao.atualizarProdtuo(prod);
              
              
        }
    }
   
    //Método para adicionar os produtos no bancode dados;
    public void adicionarProdutos(){
        
              
          //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
              //Instânciando a classe ProdutoModel; 
              ProdutoModel prod = new ProdutoModel();
 
              prod.setProduto(txtNome.getText());
              prod.setCodigoNome(codProd+" "+txtNome.getText());
              prod.setDescricao(txtDescricao.getText());
              prod.setValorDeRevenda(Double.parseDouble(txtValorUnt.getText()));
              prod.setValorDcomprar(Double.parseDouble(valorDcompra.getText()));
              prod.setQtd_estoquer(Integer.parseInt(txtEstoque.getText()));
              prod.setCodFornec(Integer.parseInt(jComboBoxFornecedor.getSelectedItem().toString()));
                 //Passando objeto da classe ProdutoModel´para objeto da classe ProdutoDao;
              dao.adicionarProduto(prod);
              
        
    }
    
    
     //Método para visualizar toda tabela Produto;
     public void visualizarProdutos(){
              //Instânciando a classe ProdutoDao;
              ProdutoDao dao= new ProdutoDao();
         
           DefaultTableModel modelo = (DefaultTableModel) TBProduto.getModel();
           modelo.setNumRows(0);
           //Laço de repetição percorrendo a lista de produtos;
           for (ProdutoModel prod : dao.visualizarProduto()) {
               modelo.addRow(new Object[]{
               prod.getCodProd(),
               prod.getProduto(),
               prod.getDescricao(),
               prod.getValorDeRevenda(),
               prod.getValorDcomprar(),
               prod.getQtd_estoquer(),
               prod.getCodFornec()
               
               
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
         jComboBoxFornecedor.setSelectedIndex(0);
         valorDcompra.setText("");
         txtCodInvestimento.setText("");
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
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limp;
    private javax.swing.JButton salvarProd;
    private javax.swing.JTextField txtCodInvestimento;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorUnt;
    private javax.swing.JTextField valorDcompra;
    // End of variables declaration//GEN-END:variables

  
  
}
