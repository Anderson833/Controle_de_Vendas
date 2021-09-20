/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexãoBd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class login  {
    
     
    public boolean logar(String usuario,String senha) throws SQLException{
        
        
        boolean exato=false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque_venda","root","");  
             String sql="select * from usuario where login=? and senha=? ";
             
             PreparedStatement Patm = Conn.prepareStatement(sql);
             Patm.setString(1, usuario);
             Patm.setString(2, senha);
            ResultSet Rst = Patm.executeQuery();

    

            while(Rst.next()){

             exato=true;
               
            }

            Rst.close();
            Patm.close();
            Conn.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

            return exato; 
    }
    
    
}
