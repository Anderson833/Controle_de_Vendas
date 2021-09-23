/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class Conexao_BD {

    //Método de Conexão com Banco De Dados ;
    public static Connection getConnection() {

        //Criando uma Connection;
        Connection conexao = null;

        try {

            //Carregando os Driver ;
            Class.forName("com.mysql.jdbc.Driver");

            //Criando uma Conexão com Banco De Dados;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque_venda", "root", "");

        } catch (Exception e) {
            // Caso ocorrer algum error exibir essa mensagem;
            JOptionPane.showMessageDialog(null, "Error ao Conectar Com Banco  De Dados !");
        }

        //Retornando a Conexão com Banco de Dados;
        return conexao;

    }

     //Método para Fechar as Conexões;
    public void fecharConexoes(){

        
        try {
            
            //Abrindo uma Connection;
            Connection conn = null;

             //Abrindo um PreparedStatement;
            PreparedStatement patm = null;

            //Abrindo um ResultSet;
            ResultSet rst = null;
        
            //Fechando ResultSet;
              rst.close();
    
            //Fechando PreparedStatement;
             patm.close();
            
             //Fechando Connection;
             conn.close();
            
            
        } catch (Exception e) {
        }
       
      
    }

}
