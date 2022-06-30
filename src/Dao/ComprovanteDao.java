
package Dao;

import Conexao.Conexao_BD;
import Model.ComprovanteModel;
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
public class ComprovanteDao {
    
      //Método para visualizar todos os dados da comprar;
     public List<ComprovanteModel> visualizarComprovante(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela comprar;
             String sql="SELECT * FROM detalhe";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
                 //Setando os Valores;
                 comp.setCodDetalhe(rst.getString("codDetalh"));
                 comp.setIdVenda(rst.getString("codVendar"));
                comp.setCodCli(rst.getString("codCli"));
                comp.setValorTotal(rst.getDouble("total"));
               comp.setData(rst.getString("data"));
               listComprov.add(comp);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas compras!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
    
       //Método para visualizar todos os dados da comprar pelo código;
     public List<VendaModel> visualizarComprovantePeloIDCOMPRAR(VendaModel num){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pelo código da venda;
             String sql="SELECT * FROM vendas WHERE codVendar="+num.getCodVenda()+"";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
               //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codExcluir"));
               venda.setCodVenda(rst.getString("codVendar"));
               venda.setCodCli(rst.getString("codCli")); 
               venda.setCodProd(rst.getString("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setCompleto(rst.getInt("Completo"));
               venda.setVz(rst.getInt("Vz"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
               listComprov.add(venda);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas venda pelo código");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
    
     
     
      //Método para adicionar a venda na tabel detalhe no banco de dados;
    public void adicionarVendaNoDetalhe(ComprovanteModel comprov){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados  na tabela detalhe no banco de dados;
            String sql="INSERT INTO detalhe(codDetalh,codVendar,codCli,total,data) VALUES(?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe ComprovanteModel;
            patm.setString(1, comprov.getCodDetalhe());
            patm.setString(2, comprov.getIdVenda());
            patm.setString(3, comprov.getCodCli());
            patm.setDouble(4, comprov.getValorTotal());
            patm.setString(5, comprov.getData());
            //Executar;
            int upd=patm.executeUpdate();
            
         if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
             JOptionPane.showMessageDialog(null, "venda Adicionado Com Sucesso");
        
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "venda Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
         
            
       
            
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar venda !");
        }
        
    }
     
     //Método para deletar uma venda na tabela detalhe;
      public void ExcluirUmaVenda(ComprovanteModel comp){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar uma venda;
            String sql = "DELETE FROM detalhe WHERE codDetalh= ?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código de excluir;
            patm.setInt(1, comp.getIdExcluir());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Venda Deletada com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Venda não Deletada !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar venda !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
     //Método para visualizar todos os dados da venda pela data;
     public List<ComprovanteModel> visualizarPelaData(String dat){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pela data;
             String sql="SELECT * FROM vendas WHERE data='"+dat+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codExcluir"));
               venda.setCodVenda(rst.getString("codVenda"));
               venda.setCodCli(rst.getString("codCli")); 
               venda.setCodProd(rst.getString("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setCompleto(rst.getInt("Completo"));
               venda.setVz(rst.getInt("Vz"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
             
             
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
    
      //Método para visualizar todos os dados da comprar pela data;
     public List<VendaModel> visualizarDataComecoFim(String dataInicio,String dataFinal){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela comprar;
             String sql="select * from vendas where data >'"+dataInicio+"' and data<'"+dataFinal+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                  //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setIdDeleta(rst.getInt("codExcluir"));
               venda.setCodVenda(rst.getString("codVendar"));
               venda.setCodCli(rst.getString("codCli")); 
               venda.setCodProd(rst.getString("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
               venda.setCompleto(rst.getInt("Completo"));
               venda.setVz(rst.getInt("Vz"));
               venda.setValorUnit(rst.getDouble("valorUnit"));
               venda.setValorTotal(rst.getDouble("total"));
               venda.setData(rst.getString("data"));
               listComprov.add(venda);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas vendas entre as datas desejadas!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
     
     
       //Método para adicionar código da venda na tabela detalhe no banco de dados;
    public void adicionaIdVenda(VendaModel comprov){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo o idComprar na tabela idVenda no bd
            String sql="INSERT INTO idvenda(idComprar) VALUES(?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe ComprovanteModel;
         
           
            //Executar;
            int upd=patm.executeUpdate();
            
         if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
          //   JOptionPane.showMessageDialog(null, "Item Adicionado Com Sucesso");
        
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "IdVenda Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
         
            
       
            
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar Item !");
        }
     
        
        
    }
     //Método para deletar Item na tabela idvenda no banco de dados pelo código do idCompar;
      public void deletaIdComprar(ComprovanteModel md){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar a Item pelo código do IdComprar;
            String sql = "DELETE FROM idvenda WHERE idComprar=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do comprovante pelo idCompar da tabela comprar;
            patm.setString(1, md.getIdVenda());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "IdVenda Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "IdVenda  não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Id Venda  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
}
