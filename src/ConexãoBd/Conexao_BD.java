/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexãoBd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ander
 */
public class Conexao_BD {
    
    //Instânciando conexão com Classe Conexao_BD;
    public static Connection getConnection(){
       
        
        Connection conexao =null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque_venda","root","");
            
            
            
            
        } catch (Exception e) {
            
        }
       
        
        return conexao;
        
        
        
    }
    
    
}
