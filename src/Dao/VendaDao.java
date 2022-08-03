
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
             String sql="SELECT * FROM item";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
             
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
    
      //Método para lista todos os dados das vendas pelo código da venda do cliente e da data;
     public List<VendaModel> listaVendaPeloCodigoClienteData3(String cod,String cli,String data){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de venda;
         ArrayList<VendaModel> listVenda = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela de item;
             String sql="SELECT * FROM item WHERE codVenda='"+cod+"' and codCli='"+cli+"'and data='"+data+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
             
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todos Itens!");
         }
         //Retornando uma Lista;
        return listVenda;
         
     }
    
      //Método para lista todos os dados das vendas pelo codigo do cliente e da data;
     public List<VendaModel> listaClienteData2(String cli,String data){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de venda;
         ArrayList<VendaModel> listVenda = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela de item;
             String sql="SELECT * FROM item WHERE codCli='"+cli+"'and data='"+data+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
             
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
             JOptionPane.showMessageDialog(null, "Error ao lista itens vendas!");
         }
         //Retornando uma Lista;
        return listVenda;
         
     }
       
   //Método para adicionar itens na tabela vendas no banco de dados;
    public void adicionaItens(VendaModel venda){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //Inserindo os dados das vendas no banco de dados;
            String sql="INSERT INTO item(codVenda,codCli,codProd,Qtd,valorUnit,total,data) VALUES(?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
          
            patm.setInt(1, venda.getCodVenda());
            patm.setInt(2, venda.getCodCli());
            patm.setInt(3, venda.getCodProd());
            patm.setDouble(4, venda.getQtdProd());
            patm.setDouble(5, venda.getValorUnit());
            patm.setDouble(6, venda.getValorTotal());
            patm.setString(7, venda.getData());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Item Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Item Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar itens !");
        }
        
    }
     
     //Método para deletar item no banco de dados pelo código do Venda;
      public boolean deletaVendaPeloCodigo(VendaModel vd){
          
          boolean deletar=false;
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar a venda pelo código;
            String sql = "DELETE FROM item WHERE codItem=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código da venda;
            patm.setInt(1, vd.getCodVenda());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                
                deletar=true;
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Item Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Item não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
               deletar=false;
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
            // JOptionPane.showMessageDialog(null, "Error ao Deletar Item,  !", "Error", JOptionPane.ERROR_MESSAGE);
             JOptionPane.showMessageDialog(null,"Esse item só poder se deletado quando a venda que está com esse item salvo for deletada  "
                     + " ","Aviso:",JOptionPane.ERROR_MESSAGE);
        }
         return deletar;
        
      }
      
       //Método para deletar todas  vendas no banco  Venda;
      public void deletaTodaVenda(){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar toda venda ;
            String sql = "DELETE FROM item";

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
      
       //Método para deletar o codigo da venda na tabela vendas;
      public void deletaTodosCodigoDaTabelaVenda(){
           //
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar o codigo pelo código;
            String sql = "DELETE FROM vendas ";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código da venda;
          //  patm.setInt(1, vd.getCodVenda());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Todos Código venda Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "todos Código venda não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar codigo venda,  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
       //Método para deletar  os itens pelo código da venda do cliente e pela data;
      public void deletaItensPeloCodigoClienteData(String codvenda,String codcli,String data){
           //
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar ;
            String sql = "DELETE FROM item WHERE codVenda='"+codvenda+"'and codCli='"+codcli+"'and data='"+data+"' ";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código da venda;
           // patm.setInt(1, vd.getIdDeleta());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "itens Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "itens não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar codigo venda,  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
        //Método para visualizar todos os dados da vendas pela data;
     public ArrayList<VendaModel> visualizarPelaData(String dat){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pela data;
             String sql="SELECT * FROM item WHERE data='"+dat+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
              listComprov.add(venda);
             
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas compras pela data!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
     
     //Método para visualizar todos os dados da vendas pelo código do cliente e a data;
     public ArrayList<VendaModel> listaPeloCodigoClienteEaData(String CodCli,String data){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela item pela codigo do cliente e a data;
             String sql="SELECT * FROM item WHERE codCli='"+CodCli+"' and data='"+data+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
              listComprov.add(venda);
             
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "error ao lista os itens pelo código do cliente e a data!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
     
     
     
       //Método para visualizar todos os dados da vendas pela data;
     public List<VendaModel> visualizarDataComecoEfinal(String dataInicio,String dataFinal){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas;
             String sql="select * from item where data>'"+dataInicio+"' and data<'"+dataFinal+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                  //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codItem"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
              listComprov.add(venda);
             
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas compras entre as datas desejadas!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
     
       //Método para adicionar venda ao banco de dados;
    public void adicionaCodVENDA(){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados das vendas no banco de dados;
            String sql="INSERT INTO vendas() VALUES()";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
           // patm.setString(1, venda.getIdVendar());
          
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
               // JOptionPane.showMessageDialog(null, "Codigo da venda Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
              //  JOptionPane.showMessageDialog(null, "codigo da venda não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
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
    
    
      //Método para adicionar o lucro ao banco de dados;
    public void adicionaValoresDoLucro(VendaModel venda){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
           
       
        try {
            //Inserindo os dados na tabela lucro no banco de dados;
            String sql="INSERT INTO lucro(codLuc,codProd,Qtd,Vvend,total,VLcompra,Ganhor,data) VALUES(?,?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe VendaModel;
           
            patm.setInt(1, venda.getCodProd());
            patm.setInt(2, venda.getCodProd());
            patm.setInt(3, venda.getQtdProd());
            patm.setDouble(4, venda.getValorUnit());
            patm.setDouble(5, venda.getValorTotal());
            patm.setDouble(6, venda.getPrecoDeComprar());
            patm.setDouble(7, venda.getValorGanhor());
            patm.setString(8, venda.getData());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "lucro Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "lucro Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
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
}
