/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Conexao.Conexao_BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */

  // HERDANDO DA CLASS Conexao_BD; 
public class Daologin  extends Conexao_BD {
    
     //MÉTODO PARA REALIZAR LOGIN DO USUÁRIO;
    public boolean logar(String usuario,String senha){
        
        //Instânciando conexão com classe Conexso_BD;
        Connection conn=Conexao_BD.getConnection();
    
         boolean clicar=false;
       
          try{
             //Comando para selecionar usuário e senha no banco de dados;
             String sql="select * from usuario where login=? and senha=? ";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             patm.setString(1,usuario);
             patm.setString(2,senha);
             
             ResultSet rst =patm.executeQuery();
             
             if(rst.next()){
                 clicar=true;
             } else {
            }
   
           //Fechando conexão PreparedStatement;
           patm.close();
          
           //Fechando conexão Connection;
           conn.close();
          
        } catch (Exception ex) {
            //Caso ocorrer aldo errado mostrar essa mensagem;
            JOptionPane.showMessageDialog(null, "Error ao Logar");
        }

    
            return clicar;
    }
    
    
}
