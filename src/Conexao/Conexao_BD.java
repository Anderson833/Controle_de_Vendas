/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
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

   
 
  
   
}

 
  
