/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Conexao.Conexao_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */

  // HERDANDO DA CLASS Conexao_BD; 
public class Daologin  extends Conexao_BD {
    
     //MÉTODO PARA REALIZAR LOGIN DO USUÁRIO;
    public boolean logar(String usuario,String senha) throws SQLException{
        
        //Intânciando conexão com classe Conexso_BD;
        Connection conn=Conexao_BD.getConnection();
    
        
        try {
          
           
             String sql="select * from usuario where login=? and senha=? ";
             
             PreparedStatement Patm = conn.prepareStatement(sql);
             Patm.setString(1, usuario);
             Patm.setString(2, senha);
             
   
             
             //Fechando as Conexões com  Método da Classe Conexao_BD ;
              fecharConexoes();
 
          
        } catch (Exception ex) {
            //Caso ocorrer aldo errado mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Error ao Logar");
        }

    
            return true;
    }
    
    
}
