// Para armazenar os dados do lucros
package Dao;

import Conexao.Conexao_BD;
import Model.LucroModel;
import Model.VendaModel;
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
public class LucroDao {
    
    String codProduto;
    int Quantidade=0;
    double total;
    
     public void set(){    
        try {
            Connection Conn = Conexao_BD.getConnection();

            String sql = "select codProd,sum(Qtd)as Quantidade,valorUnit,total from vendas where data ='2022-03-19' \n" +
"group by codProd;";

            PreparedStatement Patm = Conn.prepareStatement(sql);

            ResultSet Rst = Patm.executeQuery();

          

            while (Rst.next()) {

                String[] lista = new String[]{Rst.getString("codProd"), Rst.getString("Quantidade"),Rst.getString("valorUnit"),Rst.getString("total")};
                 
             codProduto=Rst.getString("codProd");
             Quantidade=Rst.getInt("Quantidade");
             total=  Rst.getDouble("total"); 
            }

            Rst.close();
            Patm.close();
            Conn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " ");
        }
     }  
     
     //Método para adicionar os dados do lucro no banco de dados;
     public void adicionarDadosLucros(LucroModel lucro){
          //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //Inserindo os dados das vendas no banco de dados;
            String sql="INSERT INTO lucro(codProd,Qtd,Vvend,total,Vlcompra,Ganhor,data) VALUES(?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
           
            patm.setString(1, lucro.getCodigoProduto());
            patm.setInt(2, lucro.getQuantidade());
            patm.setDouble(3, lucro.getValorUnitario());
            patm.setDouble(4, lucro.getValorTotal());
            patm.setDouble(5, lucro.getValorDcomprar());
            patm.setDouble(6, lucro.getValorGanhor());
            patm.setString(7, lucro.getData());
           
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Informações do Lucro Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Informações do Lucro Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar dados do lucro !");
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
            patm.setString(1, lucro.getCodigoLucro());
            patm.setString(2, lucro.getCodigoProduto());
            patm.setInt(3, lucro.getQuantidade());
            patm.setDouble(4, lucro.getValorUnitario());
            patm.setDouble(5, lucro.getValorTotal());
            patm.setDouble(6, lucro.getValorDcomprar());
            patm.setDouble(7, lucro.getValorGanhor());
            patm.setString(8, lucro.getData());
             
               listDados.add(lucro);
                 //Adicionado na Lista;
             
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar os dados do lucro!");
         }
         //Retornando uma Lista;
        return listDados;
         
     }
    
     
         
     }

