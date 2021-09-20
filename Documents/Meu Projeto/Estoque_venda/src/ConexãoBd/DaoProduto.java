/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexãoBd;

import Model.Prod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author ander
 */
public class DaoProduto {

   
    
    public  List<Prod> unit(){
        
      
        PreparedStatement smt=null;
         ResultSet rst = null;
         try {
             
                List <Prod> produtos = new ArrayList<>();
            Connection Conn = Conexao_BD.getConnection();

           smt=Conn.prepareStatement("SELECT * FROM produto");
            rst=smt.executeQuery();
           
           
            
            
            
           

          

            while (rst.next()) {
          
              Prod p = new Prod();
              p.setId(rst.getString("codProd"));
              p.setNome(rst.getString("nome"));
              p.setDescricao(rst.getString("descricao"));
              p.setValorUnit(rst.getString("valorUnit"));
              p.setEstoque(rst.getString("estoque"));
              produtos.add(p);
            }

            rst.close();
            smt.close();
            Conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " ");
        }
        return null;
       
       
      
      
        

        
        
    }

    public Iterable<Prod> unitario(double unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterable<Prod> unitario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
  

