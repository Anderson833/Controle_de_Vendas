/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ander
 */
public class Login  {
    
    public boolean logar(String login,String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt =null;
        ResultSet rs =null;
        
        boolean exato =false;
        
        try {
            stmt=con.prepareStatement("select * from usuario where login=? and senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs =stmt.executeQuery();
            
            
            if(rs.next()){
                exato=true;
            }
            
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch (Exception e) {
        }
        
        return false;
    }  
}
