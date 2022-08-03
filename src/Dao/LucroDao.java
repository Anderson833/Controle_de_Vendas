// Para armazenar os dados do lucros
package Dao;

import Conexao.Conexao_BD;
import Model.LucroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class LucroDao {
    
 
    
   
     //Método para adicionar os dados do lucro no banco de dados;
     public void adicionarDadosLucros(LucroModel lucro){
          //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //Inserindo os dados das vendas no banco de dados;
            String sql="INSERT INTO lucro(codLuc,codProd,Qtd,Vvend,total,Vlcompra,valorinvest,Ganhor,data) VALUES(?,?,?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
           
         
            patm.setString(1, lucro.getCodigoLucro());
            patm.setString(2, lucro.getCodigoProduto());
            patm.setDouble(3, lucro.getQuantidade());
            patm.setDouble(4, lucro.getValorUnitario());
            patm.setDouble(5, lucro.getValorTotal());
            patm.setDouble(6, lucro.getValorDcomprar());
            patm.setDouble(7, lucro.getValorInvestir());
            patm.setDouble(8, lucro.getValorGanhor());
            patm.setString(9, lucro.getData());
           
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
              //  JOptionPane.showMessageDialog(null, "Informações do Lucro Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
              //  JOptionPane.showMessageDialog(null, "Informações do Lucro Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
          // JOptionPane.showMessageDialog(null, "Error ao Adicionar dados do lucro !");
        }
        
    }
     
      //Método para deleta os dados do lucro no banco de dados;
     public void deletaLucros(String cod){
          //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //deleta os dados lucro no banco de dados;
            String sql="delete from lucro where codLuc=?";
             
            PreparedStatement pam=conn.prepareStatement(sql);
            pam.setString(1, cod);
            
            int dtl=pam.executeUpdate();
            
            if(dtl>0){
                JOptionPane.showMessageDialog(null, "deletado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Não deletado !");
            }
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao deleta  dados do lucro !");
        }
        
    }
     
      
      //Método para deleta os dados do lucro no banco de dados;
     public void deletaTODOSLucros(){
          //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //deleta os dados lucro no banco de dados;
            String sql="delete from lucro";
             
            PreparedStatement pam=conn.prepareStatement(sql);
           // pam.setString(1, cod);
            
            int dtl=pam.executeUpdate();
            
            if(dtl>0){
         //       JOptionPane.showMessageDialog(null, "Todo lucro deletado com sucesso");
            }else{
           //     JOptionPane.showMessageDialog(null, "Não deletou o lucro  !");
            }
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
         ///  JOptionPane.showMessageDialog(null, "Error ao deleta  dados do lucro !");
        }
        
    }
     
     
         //Método para visualizar todos os dados do lucro;
     public ArrayList<LucroModel> visualizarLucro(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de dados;
         ArrayList<LucroModel> listDados = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela lucro;
             String sql="SELECT * FROM lucro";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 LucroModel lucro = new LucroModel();
                 //Setando os Valores;
            lucro.setCodigoLucro(rst.getString("codLuc"));
            lucro.setCodigoProduto(rst.getString("codProd"));
            lucro.setQuantidade(rst.getDouble("Qtd"));
            lucro.setValorUnitario(rst.getDouble("Vvend"));
            lucro.setValorTotal(rst.getDouble("total"));
            lucro.setValorDcomprar(rst.getDouble("Vlcompra"));
            lucro.setValorInvestir(rst.getDouble("valorinvest"));
            lucro.setValorGanhor(rst.getDouble("ganhor"));
            lucro.setData(rst.getString("data"));
             
               listDados.add(lucro);
                 //Adicionado na Lista;
             
             }
         
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (SQLException e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar os dados do lucro!");
         }
         //Retornando uma Lista;
        return listDados;
         
     }
     //Método para visualizar todos os dados do lucro;
     public ArrayList<LucroModel> visualizarLucroPeloCodigo(String cod){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de dados;
         ArrayList<LucroModel> listDados = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela lucro;
             String sql="SELECT * FROM lucro  where codLuc='"+cod+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 LucroModel lucro = new LucroModel();
                 //Setando os Valores;
            lucro.setCodigoLucro(rst.getString("codLuc"));
            lucro.setCodigoProduto(rst.getString("codProd"));
            lucro.setQuantidade(rst.getDouble("Qtd"));
            lucro.setValorUnitario(rst.getDouble("Vvend"));
            lucro.setValorTotal(rst.getDouble("total"));
            lucro.setValorDcomprar(rst.getDouble("Vlcompra"));
            lucro.setValorGanhor(rst.getDouble("ganhor"));
            lucro.setData(rst.getString("data"));
             
               listDados.add(lucro);
                 //Adicionado na Lista;
             
             }
         
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (SQLException e) {
             //Algo de error, mostrar essa mensagem;
         //    JOptionPane.showMessageDialog(null, "Error ao Visualizar os dados do lucro!");
         }
         //Retornando uma Lista;
        return listDados;
         
     }
    
     //Método para fazer atualização dos dados dos lucros;
       public void atualizarLucro(LucroModel lucro){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para que realizar atualização no banco de dados;
            String sql="UPDATE lucro SET Qtd=?,Vvend=?,total=?,Vlcompra=?, valorinvest=?,Ganhor=?, data=? WHERE codProd=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandoos valores nos paramentros;
           
            patm.setDouble(1, lucro.getQuantidade());
            patm.setDouble(2, lucro.getValorUnitario());
            patm.setDouble(3, lucro.getValorTotal());
            patm.setDouble(4, lucro.getValorDcomprar());
            patm.setDouble(5, lucro.getValorInvestir());
            patm.setDouble(6, lucro.getValorGanhor());
            patm.setString(7, lucro.getData());
            patm.setString(8, lucro.getCodigoProduto());
          
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
              //  JOptionPane.showMessageDialog(null,"Lucro Atualizador com Sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
              //  JOptionPane.showMessageDialog(null,"Lucro não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
            //  JOptionPane.showMessageDialog(null,"Error ao Atualizar Lucro !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
    
       
         
     }

