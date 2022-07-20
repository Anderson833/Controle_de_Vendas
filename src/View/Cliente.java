/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Conexao.Conexao_BD;
import Dao.ClienteDao;
import Model.ApenasNumeros;
import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public Cliente() {
       
        initComponents();
        setLocationRelativeTo(null);
        //Método para proíbir letras
        ApenasNumeros();
       
    }
     int c=0;
     String codCliente="";
     String IdUsuario="";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CodCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        AddCliente = new javax.swing.JButton();
        exibirDados = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCli = new javax.swing.JTable();
        btlimp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Código :");

        CodCli.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel4.setText("Endereço:");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        delete.setText("Excluir");
        delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        AddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        AddCliente.setText("Adicionar ");
        AddCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClienteActionPerformed(evt);
            }
        });

        exibirDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        exibirDados.setText("Ver Dados");
        exibirDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        exibirDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirDadosActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/comentarios.png"))); // NOI18N
        jLabel6.setText("Cadastrar Clientes");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCli);

        btlimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        btlimp.setText("Limpar");
        btlimp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btlimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlimpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome)
                            .addComponent(txtEndereco))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(AddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btlimp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(exibirDados, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jScrollPane1)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exibirDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlimp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void AddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClienteActionPerformed
     
       addCliente();
       visualizarClientes();
    }//GEN-LAST:event_AddClienteActionPerformed
  
    //Método para adicionar cliente;
    public void addCliente() {

        //Instânciando classe ClienteDao;
        ClienteDao dao = new ClienteDao();

        //Instânciando  classe ClienteModel;
        ClienteModel cli = new ClienteModel();

        //Pegando objeto da classe ClienteModel;
        //Setando os atributos  da Classe ClienteModel;
        cli.setNome(txtNome.getText());
        cli.setEndereco(txtEndereco.getText());
        cli.setTelefone(txtTelefone.getText());
      

        //Colocando os objetos da Classe ClienteModel no objeto da classe ClienteDAO;
        dao.adicionaCliente(cli);
    }


    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        //Método Para Deletar Cliente no Banco de Dados;
        deletarCliente();
        
        visualizarClientes();
    }//GEN-LAST:event_deleteActionPerformed

    //Método Para Deletar Cliente no Banco de Dados;
    public void deletarCliente() {
        //Instânciando classe ClienteDao;
        ClienteDao dao = new ClienteDao();

        //Instânciando  classe ClienteModel;
        ClienteModel cli = new ClienteModel();
        //Pegando código do cliente na JtextField;
        cli.setCodCli(Integer.parseInt(CodCli.getText()));
        //Colocando no objeto da classe ClienteDao;
        dao.deletaCliente(cli);
    }


    private void exibirDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirDadosActionPerformed

        //Método para visualizar dados dos Clientes;
        visualizarClientes();

    }//GEN-LAST:event_exibirDadosActionPerformed

    //Método para visualizar toda tabela cliente;
    public void visualizarClientes() {
        DefaultTableModel md = (DefaultTableModel) tabelaCli.getModel();
        //Método para não repetir os dados ao visualizar;
        md.setNumRows(0);

        //Instânciando a classe ClienteDao;
        ClienteDao dao = new ClienteDao();

        //laço de repetição para lista todos clientes no banco de dados;
        for (ClienteModel cliente : dao.visualizarClientes()) {
            md.addRow(new Object[]{
                //Percorrendo a lista de clientes;
                cliente.getCodCli(),
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getTelefone(),
             

            });

        }

    }
  
    
    //metodo para digita só números
    public void ApenasNumeros() {
        txtTelefone.setDocument(new ApenasNumeros());
        
          }

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        //Método que atualizar os dados dos clientes; 
        atualizarCliente();
      visualizarClientes();
    }//GEN-LAST:event_btAtualizarActionPerformed

    //Método para atualizar cliente;
    public void atualizarCliente() {

        if (tabelaCli.getSelectedRow() != -1) {
            //Instânciando classe ClienteDao;
            ClienteDao dao = new ClienteDao();

            //Instânciando  classe ClienteModel;
            ClienteModel cli = new ClienteModel();
            //Setandos os dados;
            cli.setNome(txtNome.getText());
            cli.setEndereco(txtEndereco.getText());
            cli.setTelefone(txtTelefone.getText());
            cli.setCodCli(Integer.parseInt(CodCli.getText()));
            //Passando objeto da classe clienteModel para o objeto da classe ClienteDao;
            dao.atualizarCliente(cli);

        }
    }


    private void tabelaCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCliMouseClicked

        //Seta os dados nos campos de textos ao clicar na linha da tabela;
        if (tabelaCli.getSelectedRow() != -1) {

            CodCli.setText(tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 0).toString());
            txtNome.setText(tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 1).toString());
            txtEndereco.setText(tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 2).toString());
            txtTelefone.setText(tabelaCli.getValueAt(tabelaCli.getSelectedRow(), 3).toString());

        }
    }//GEN-LAST:event_tabelaCliMouseClicked

    private void btlimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlimpActionPerformed

        //Método para limpar os campos;
        limpar();
        
        //Método para limpar as linhas da tabelas
        limpalinha();
    }//GEN-LAST:event_btlimpActionPerformed

    //Método para limpar os campos de textos;
    public void limpar() {
        CodCli.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");

    }

      //Método para limpar as linhas da tabelas
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tabelaCli.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

      // método para  ver se tem código ja  salvo ao adicionar um cliente novo;
    public boolean buscandoCodigoDosClientes() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar o código que já tem no banco de dados;
            String sql = "SELECT codCli FROM cliente";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo 
                codCliente = Rst.getString("codCli");
                
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, " código não encontrado ! ");
        }
        return true;

    }
     // método para  ver se tem usuário com o código salvo 
    public boolean buscandoCodigoDosUsuarios() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar o código de usuário;
            String sql = "SELECT IdUsu  FROM usuario";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo 
                IdUsuario = Rst.getString("IdUsu");
                
            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, " código não encontrado ! ");
        }
        return true;

    }
    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCliente;
    private javax.swing.JTextField CodCli;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btlimp;
    private javax.swing.JButton delete;
    private javax.swing.JButton exibirDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCli;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
