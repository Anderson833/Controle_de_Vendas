/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Conexao.Conexao_BD;
import Dao.Daologin;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        
        //CENTRALIZANDO VIEW AO CENTRO;
        setLocationRelativeTo(this);
        
      //  logarSemPressionarBota();
     
    }
    
       //Variavel para pegar usuario do banco de dados
        String usuario="";
        
        //variavel para pegar a senha do usuario no banco
        String senha="";
        
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUSUARIO = new javax.swing.JTextField();
        BTLOGIN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        mostra = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acessar Sistema");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("  Senha:");

        txtUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUSUARIOActionPerformed(evt);
            }
        });
        txtUSUARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUSUARIOKeyPressed(evt);
            }
        });

        BTLOGIN.setBackground(new java.awt.Color(255, 255, 255));
        BTLOGIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTLOGIN.setText("Logar");
        BTLOGIN.setBorder(null);
        BTLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTLOGINActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("    Controle De Vendas");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsenhaActionPerformed(evt);
            }
        });
        txtsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsenhaKeyReleased(evt);
            }
        });

        mostra.setText("Mostrar");
        mostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraActionPerformed(evt);
            }
        });

        jButton1.setText("cadastrar-se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mostra)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(BTLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtUSUARIO, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(txtsenha))
                .addGap(180, 180, 180))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(BTLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostra)
                    .addComponent(jButton1))
                .addContainerGap(97, Short.MAX_VALUE))
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
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTLOGINActionPerformed
      
        //depois termino
         boolean onclik;
        boolean clik;
        
        boolean cor;
         onclik=(txtUSUARIO.getText().isEmpty());
         
         clik=(txtsenha.getText().isEmpty());
         
         cor=(onclik && clik);
          Daologin lg = new Daologin();
          
              if(cor){
                  txtUSUARIO.setBackground(Color.GREEN);
                   txtsenha.setBackground(Color.GREEN);
                   JOptionPane.showMessageDialog(null, "Preenchar os campos!");
             }
          
            else  if(onclik){
                  JOptionPane.showMessageDialog(null, "Preenchar campo de login!","Por favor:",JOptionPane.WARNING_MESSAGE);
                  txtUSUARIO.setBackground(Color.red);
                    txtUSUARIO.requestFocus();
                  
             }else if(clik){
                 JOptionPane.showMessageDialog(null, "Preenchar campo de senha!","Por favor:",JOptionPane.WARNING_MESSAGE);
                  txtsenha.setBackground(Color.red);
                    txtsenha.requestFocus();
             }
             
             else if(lg.logar(txtUSUARIO.getText(), txtsenha.getText())){
                
                  //Instânciando view  TelaPrincipal;
            TelaPrincipal tp = new TelaPrincipal();
            //Passando objeto para abrir TelaPrincipal ao Logar;
            tp.setVisible(true);
            //Fechando a  TelaLgin;
            this.dispose();
            }else{
                 JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorreta!");
            }
            
    
    }//GEN-LAST:event_BTLOGINActionPerformed

    private void txtUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUSUARIOActionPerformed

  
    }//GEN-LAST:event_txtUSUARIOActionPerformed

    
    private void txtsenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsenhaKeyReleased


    }//GEN-LAST:event_txtsenhaKeyReleased

  
    
    private void txtsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsenhaActionPerformed

    }//GEN-LAST:event_txtsenhaActionPerformed

    private void mostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraActionPerformed
     
        
        
        // condição para mostrar a senha do usuário digitada
       
         if(mostra.isSelected()){
            
             if(txtsenha.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null,"Tenter Novamente: ", "Senha não Digitada: ",JOptionPane.ERROR_MESSAGE);
                  txtsenha.requestFocus();
             }else{
             String senha="USUARIO "+this.txtsenha.getPassword();
             senha=txtsenha.getText();
             JOptionPane.showMessageDialog(null, "Senha Digitada:  "+senha);
              txtsenha.requestFocus();
            }
     
         }
    }//GEN-LAST:event_mostraActionPerformed

    private void txtUSUARIOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUSUARIOKeyPressed
       
                txtUSUARIO.setBackground(Color.WHITE);
                      txtUSUARIO.requestFocus();
    }//GEN-LAST:event_txtUSUARIOKeyPressed

    private void txtsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsenhaKeyPressed
        
        
          txtsenha.setBackground(Color.WHITE);
                      txtsenha.requestFocus();
        
        
    }//GEN-LAST:event_txtsenhaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario l = new Usuario();
        l.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
      //Método para seta usuário e senha  dos usuários para logar;
    public boolean logarSemPressionarBota() {

         try {
            Connection Conn = Conexao_BD.getConnection();

            
            String sql = "SELECT login,senha FROM usuario where login like '"+txtUSUARIO.getText()+"'";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            //Executar
            ResultSet Rst = Patm.executeQuery();

            if (Rst.next()) {
                //setando nome
               // txtNcli.setText(Rst.getString("codVenda"));
               usuario=  Rst.getString("login");
               senha=  Rst.getString("senha");
              
            } else {
                //SETA CAMPO VAZIO
              //  txtNcli.setText("");

            }

            //Fechando conexão ResultSet;
            Rst.close();

            //Fechando conexão PreparedStatement;
            Patm.close();

            //Fechando conexão Connection;
            Conn.close();

        } catch (SQLException e) {
            //caso de algo errado exiber essa mensagem;
            JOptionPane.showMessageDialog(null, "login não encontrado ! ");
        }
        return true;

 
      
         
    }
  
  
    
  
   
        
    
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTLOGIN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox mostra;
    private javax.swing.JTextField txtUSUARIO;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
