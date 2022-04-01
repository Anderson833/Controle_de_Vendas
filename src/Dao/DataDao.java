
package Dao;

import Conexao.Conexao_BD;
import Model.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DataDao {
    
     //Variável para pegar a data do banco de dados
      String data ="";
    
     //Método para adicionar data ao banco de dados;
    public void adicionaData(Data dat){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo a data no banco de dados;
            String sql="INSERT INTO data(data) VALUES(?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe data;
            patm.setString(1, dat.getData());
          
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Data Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Data Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
         //  JOptionPane.showMessageDialog(null, "Error ao Adicionar data !");
        }
        
    }
    
      //Método para adicionar data ao banco de dados;
    public void deletaData(Data dat){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //para deletar a data no banco de dados;
            String sql="DELETE FROM data WHERE data=?";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe data;
            patm.setString(1, dat.getData());
          
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Data deletada Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Data Não deletada !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
         //  JOptionPane.showMessageDialog(null, "Error ao Adicionar data !");
        }
        
    }
    
    //MÉTODO PARA PEGAR A DATA NO BANCO DE DADOS;
    public void setaDATA(){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo a data no banco de dados;
            String sql="SELECT data from data";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe data;
           
            ResultSet rst=patm.executeQuery();
            
           
            
            while(rst.next()){
                //Caso de tudo certo exibir essa mensagem;
               // JOptionPane.showMessageDialog(null, "Data processada!");
               
               data= rst.getString("data");
            
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
         //  JOptionPane.showMessageDialog(null, "Error ao Adicionar data !");
        }
    }
        //Método para ver se tem a data cadrastrada no banco de dados
        public String setaDatasDoBncos(){
            
            Data dt = new Data();
            dt.setData(data);
            dt.getData();
          return dt.getData();
          
        }
    }
    

  
    
    
    

