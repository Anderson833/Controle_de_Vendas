// view Usuário;
package View;

import Conexao.Conexao_BD;
import Dao.UsuarioDao;
import Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario extends javax.swing.JFrame {

    public Usuario() {
        initComponents();
        //Abrir no centro da tela;
        setLocationRelativeTo(this);
        // Método para buscar o login e ID do usuário
              buscandoCodigoDosUsuarios();
    }
          //Variável para armazenar o login e o IDusu
    String login="", IDusu="",senha="";
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDusu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefone = new javax.swing.JTextField();
        adicionarCli = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbusu = new javax.swing.JTable();
        visualizar = new javax.swing.JButton();
        limpaa = new javax.swing.JButton();
        execluir = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuário");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setText("ID Usuário:");

        txtIDusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDusuActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        txtendereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenderecoActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefone:");

        adicionarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/salve-.png"))); // NOI18N
        adicionarCli.setText("Adicionar");
        adicionarCli.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        adicionarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCliActionPerformed(evt);
            }
        });

        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/atualizar.png"))); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/usuario-masculino.png"))); // NOI18N
        jLabel5.setText("  Cadastrar Usuários");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Usuário:");

        jLabel7.setText("Senha:");

        tbusu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idUsu", "nome", "endereco", "telefone", "login", "senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbusu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbusuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbusu);

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/visualizador.png"))); // NOI18N
        visualizar.setText("Exibir Dados");
        visualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        limpaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/limpando-produtos.png"))); // NOI18N
        limpaa.setText("Limpar");
        limpaa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        limpaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpaaActionPerformed(evt);
            }
        });

        execluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/claro.png"))); // NOI18N
        execluir.setText("Excluir");
        execluir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        execluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jScrollPane2)
                .addGap(223, 223, 223))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefone)
                    .addComponent(txtIDusu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(adicionarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limpaa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(execluir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDusu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpaa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(execluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtenderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenderecoActionPerformed

    }//GEN-LAST:event_txtenderecoActionPerformed

    private void adicionarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarCliActionPerformed
          
       if(txtIDusu.getText().equalsIgnoreCase(IDusu)){
           JOptionPane.showMessageDialog(null, "Já tem usuário com esse ID "+txtIDusu.getText());
           visualizarUsuario();
       }else{
           //MÉTODO PARA ADICIONA USUARIO NO BANCO DE DADOS;
        addUsuario();
        //Limpar os campos depois que adicionar usuário;
          limpar();
          visualizarUsuario();
       }
       
    }//GEN-LAST:event_adicionarCliActionPerformed

    //Método para adicionar usuario;
    public void addUsuario() {

        //Instânciando UsuarioDao;
        UsuarioDao dao = new UsuarioDao();

        //Instânciando UsuarioModdel;
        UsuarioModel usu = new UsuarioModel();
        //Setando os atributos do UsuarioModel;
        usu.setIdUsu(txtIDusu.getText());
        usu.setNome(txtnome.getText());
        usu.setEndereco(txtendereco.getText());
        usu.setTelefone(txttelefone.getText());
        usu.setLogin(txtUsuario.getText());
        usu.setSenha(txtSenha.getText());
        //Passando os objetos do UsuarioModel para objeto UsuarioDao;
        dao.adicionaUsuario(usu);

    }


    private void txtIDusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDusuActionPerformed

    }//GEN-LAST:event_txtIDusuActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     
         //Método para fazer atualização do usuário;
          atualizarUsuario();
         //Limpar os campos depois que atualizar usuário;
          limpar();
    }//GEN-LAST:event_atualizarActionPerformed

    //Método para atualizar os dados do usuario; 
    public void atualizarUsuario() {

        if (tbusu.getSelectedRow() != -1) {

            //Instânciando UsuarioDao;
            UsuarioDao dao = new UsuarioDao();

            //Instânciando UsuarioModdel;
            UsuarioModel usu = new UsuarioModel();
            //Setando os atributos do UsuarioModel;
            usu.setIdUsu(txtIDusu.getText());
            usu.setNome(txtnome.getText());
            usu.setEndereco(txtendereco.getText());
            usu.setTelefone(txttelefone.getText());
            usu.setLogin(txtUsuario.getText());
            usu.setSenha(txtSenha.getText());
            //Passando os objetos do UsuarioModel para objeto UsuarioDao;
            dao.atualizarUsuario(usu);

        }

    }
    // método para  ver se tem usuário com meus código é id;
    public boolean buscandoCodigoDosUsuarios() {

        try {
            Connection Conn = Conexao_BD.getConnection();

            //Comando para selecionar o código de usuário;
            String sql = "SELECT IdUsu,login,senha FROM usuario";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando codigo 
                login = Rst.getString("login");
                IDusu = Rst.getString("IdUsu");
                senha = Rst.getString("senha");
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
    

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed

       //Método para visualizar todos os usuário no banco de dados; 
        visualizarUsuario();
    }//GEN-LAST:event_visualizarActionPerformed
    
     //Método para visualizar os dados do usuário;
      public void visualizarUsuario(){
          
           
          DefaultTableModel modelo = (DefaultTableModel) tbusu.getModel();
          //Para não repetir os dados novamente ao clicar no botão;
          modelo.setNumRows(0);
            //Instânciando UsuarioDao;
            UsuarioDao dao = new UsuarioDao();
           //Laço de repetição para percorrer a lista de usuário ; 
            for (UsuarioModel usuario:dao.visualizarUsuario()) {
               modelo.addRow(new Object[]{
               usuario.getIdUsu(),
               usuario.getNome(),
               usuario.getEndereco(),
               usuario.getTelefone(),
               usuario.getLogin(),
               usuario.getSenha()
               
               });
                
                
          }
          
      }
     
    private void tbusuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbusuMouseClicked
               
        // Ao clicar seta os valores nos campos de textos;
        if (tbusu.getSelectedRow() != -1) {

            txtIDusu.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 0).toString());
            txtnome.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 1).toString());
            txtendereco.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 2).toString());
            txttelefone.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 3).toString());
            txtUsuario.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 4).toString());
            txtSenha.setText(tbusu.getValueAt(tbusu.getSelectedRow(), 5).toString());

        }

    }//GEN-LAST:event_tbusuMouseClicked

    private void limpaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpaaActionPerformed

        //Método para limpar os campos de textos;
        limpar();
        
        //Método para limpar as linhas da tabela usuário;
        limpalinha();
    }//GEN-LAST:event_limpaaActionPerformed

    private void execluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execluirActionPerformed
      
        //Deletar Usuário;
        deletarUsuario();
        
         //Limpar os campos depois que excluir usuário;
          limpar();
    }//GEN-LAST:event_execluirActionPerformed
     //Método para deletar Usuário
      public void deletarUsuario(){
      
          
         //Instânciando UsuarioDao;
            UsuarioDao dao = new UsuarioDao();

            //Instânciando UsuarioModdel;
            UsuarioModel usu = new UsuarioModel();
            
            usu.setIdUsu(txtIDusu.getText());
            
            dao.deletaUsuario(usu);
        
    }
    
    //Método para limpar todos campos de textos;
    public void limpar() {
        txtIDusu.setText("");
        txtnome.setText("");
        txtendereco.setText("");
        txttelefone.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");

    }
     //Limpar linha da tabela usuário;
    public void limpalinha() {
        DefaultTableModel dm = (DefaultTableModel) tbusu.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarCli;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton execluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limpaa;
    private javax.swing.JTable tbusu;
    private javax.swing.JTextField txtIDusu;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txttelefone;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
