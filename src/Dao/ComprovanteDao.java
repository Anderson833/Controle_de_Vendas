
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
             
             //Selecionando toda tabela detalhe;
             String sql="SELECT * FROM detalhe";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
                 //Setando os Valores;
                 comp.setCodDetalhe(rst.getInt("codDetalh"));
                 comp.setCodVenda(rst.getInt("codVenda"));
                comp.setCodCli(rst.getInt("codCli"));
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
    
       //Método para visualizar todos os dados da venda pelo código;
     public List<VendaModel> visualizarComprovantePeloIDCOMPRAR(VendaModel num){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<VendaModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pelo código da venda;
             String sql="SELECT * FROM item WHERE codVenda="+num.getCodVenda()+"";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
               //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setCodVenda(rst.getInt("codDetalh"));
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
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
    
      //Método para visualizar todos os dados das vendas entre as datas;
     public ArrayList<ComprovanteModel> listaEntreAsDatas(String dataInicio,String datafinal){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas entre as datas data;
             String sql="SELECT * FROM detalhe  WHERE data>'"+dataInicio+"' and data<'"+datafinal+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
                 //Setando os Valores;
                 comp.setCodDetalhe(rst.getInt("codDetalh"));
                 comp.setCodVenda(rst.getInt("codVenda"));
                comp.setCodCli(rst.getInt("codCli"));
                comp.setValorTotal(rst.getDouble("total"));
               comp.setData(rst.getString("data"));
                listComprov.add(comp);
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao listar entre as datas!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
     
       //Método para lista todos os dados das vendas pela data;
     public ArrayList<ComprovanteModel> ListarPelaDataEspecifica(String dat){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pela data;
             String sql="SELECT * FROM detalhe WHERE data='"+dat+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
                   //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
               comp.setCodDetalhe(rst.getInt("codDetalh"));
                 comp.setCodVenda(rst.getInt("codVenda"));
                comp.setCodCli(rst.getInt("codCli"));
                comp.setValorTotal(rst.getDouble("total"));
               comp.setData(rst.getString("data"));
              listComprov.add(comp);
             
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error, mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todas vendas pela data!");
         }
         //Retornando uma Lista;
        return listComprov;
         
     }
      //Método para visualizar todos os dados da venda pela data;
     public List<ComprovanteModel> listapelaDataCodCliente(String dat,String cli){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pela data;
             String sql="SELECT * FROM detalhe WHERE data='"+dat+"'and codCli='"+cli+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
              
               //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
               comp.setCodDetalhe(rst.getInt("codDetalh"));
                 comp.setCodVenda(rst.getInt("codVenda"));
                comp.setCodCli(rst.getInt("codCli"));
                comp.setValorTotal(rst.getDouble("total"));
               comp.setData(rst.getString("data"));
              listComprov.add(comp);
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
     
      //Método para adicionar a venda na tabel detalhe no banco de dados;
    public void adicionarVendaNoDetalhe(ComprovanteModel comprov){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados  na tabela detalhe no banco de dados;
            String sql="INSERT INTO detalhe(codDetalh,codVenda,codCli,total,data) VALUES(?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe ComprovanteModel;
          
            patm.setInt(1, comprov.getCodDetalhe());
            patm.setInt(2, comprov.getCodVenda());
            patm.setInt(3, comprov.getCodCli());
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
      public void ExcluirUmaVendaDoDetalhe(ComprovanteModel comp){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar uma venda;
            String sql = "DELETE FROM detalhe WHERE codDetalh= ?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código de excluir;
            patm.setInt(1, comp.getCodDetalhe());
            
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
         //Método para deletar uma venda na tabela detalhe;
      public void ExcluirTodaTabelaDoDetalhe(){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar uma venda;
            String sql = "DELETE FROM detalhe";

            PreparedStatement patm = conn.prepareStatement(sql);
        
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Todas vendas deletadas com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Todas vendas não deletadas !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
          //   JOptionPane.showMessageDialog(null, "Error ao Deletar venda !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
     //Método para visualizar todos os dados da venda pela data;
     public List<ComprovanteModel> visualizarPelaDataEspecifica(String dat){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela vendas pela data;
             String sql="SELECT * FROM detalhe WHERE data='"+dat+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
                 //Instânciando  classe VendaModel;
                 VendaModel venda = new VendaModel();
                 //Setando os Valores;
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodItens(rst.getInt("codItens"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
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
               venda.setCodVenda(rst.getInt("codVenda"));
               venda.setCodItens(rst.getInt("codItens"));
               venda.setCodCli(rst.getInt("codCli")); 
               venda.setCodProd(rst.getInt("codProd"));
               venda.setQtdProd(rst.getInt("Qtd"));
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
     
        //Método para lista todas venda pelo codigo do cliente e da data;
     public List<ComprovanteModel> listaItensCliente(String cli){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de venda;
         ArrayList<ComprovanteModel> listVenda = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela de item;
             String sql="SELECT * FROM detalhe WHERE codCli='"+cli+"'";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
               comp.setCodDetalhe(rst.getInt("codDetalh"));
                 comp.setCodVenda(rst.getInt("codVenda"));
                comp.setCodCli(rst.getInt("codCli"));
                comp.setValorTotal(rst.getDouble("total"));
               comp.setData(rst.getString("data"));
              listVenda.add(comp);
             
               listVenda.add(comp);
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
    
    
     //Método para adicionar o tipo de pagemento na tabela detalhe no banco de dados;
    public void adicionaTipoPagamento(ComprovanteModel comprov){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo o idComprar na tabela idVenda no bd
            String sql="INSERT INTO TiposDePagamentos(tiposPg) VALUES(?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classe ComprovanteModel;
             patm.setString(1,comprov.getPagamento());
           
            //Executar;
            int upd=patm.executeUpdate();
            
         if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
             JOptionPane.showMessageDialog(null, "Tipo de pagamento Adicionado Com Sucesso");
        
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Tipo de pagamentos Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
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
    
      //Método para visualizar todos os dados da comprar;
     public List<ComprovanteModel> visualizarTiposPagamentos(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de comprovante;
         ArrayList<ComprovanteModel> listComprov = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela comprar;
             String sql="SELECT * FROM TiposDePagamentos";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe ComprovateModel;
                 ComprovanteModel comp = new ComprovanteModel();
                 //Setando os Valores;
                 comp.setPagamento(rst.getString("tiposPg"));
                 
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
    
  
}
