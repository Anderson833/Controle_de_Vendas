
// Pacote dao;
package Dao;

import Conexao.Conexao_BD;
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
public class VendaDao {
    
     //Método para visualizar todos os dados das vendas;
     public List<VendaModel> visualizarVenda(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de venda;
         ArrayList<VendaModel> listVenda = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela venda;
             String sql="SELECT * FROM venda";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
                venda.setCodVenda(rst.getString("codVend"));
                venda.setCodCli(rst.getString("codCli"));
                venda.setCodProd(rst.getString("codProd"));
               venda.setQtdProd(rst.getInt("Qtd_Prod"));
               venda.setValorUnit(rst.getDouble("valorUnit"));  
               venda.setValorTotal(rst.getDouble("ValorTotal"));
              
               listVenda.add(venda);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas vendas!");
         }
         //Retornando uma Lista;
        return listVenda;
         
     }
    
     
      //Método para adicionar venda ao banco de dados;
    public void adicionaVenda(VendaModel venda){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados das vendas no banco de dados;
            String sql="INSERT INTO venda(codVend,codCli,codProd,Qtd_Prod,valorUnit,ValorTotal) VALUES(?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
            patm.setString(1, venda.getCodVenda());
            patm.setString(2, venda.getCodCli());
            patm.setString(3, venda.getCodProd());
            patm.setInt(4, venda.getQtdProd());
            patm.setDouble(5, venda.getValorUnit());
            patm.setDouble(6, venda.getValorTotal());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Venda Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Venda Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar Venda !");
        }
        
    }
     
     //Método para deletar venda no banco de dados pelo código do Venda;
      public void deletaVendaPeloCodigo(VendaModel vd){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar a venda pelo código;
            String sql = "DELETE FROM venda WHERE codVend=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código da venda;
            patm.setString(1, vd.getCodVenda());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Venda Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Venda não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Venda  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
       //Método para deletar todas  vendas no banco  Venda;
      public void deletaTodaVenda(){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar toda venda ;
            String sql = "DELETE FROM venda";

            PreparedStatement patm = conn.prepareStatement(sql);
           
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Toda Venda Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Venda não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Venda  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
}
