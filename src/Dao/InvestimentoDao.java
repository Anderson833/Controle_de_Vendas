/*
   Esse classe vai realizar a manipulação dos dados com banco de dados
 */
package Dao;

import Conexao.Conexao_BD;
import Model.InvestimentoModel;
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
public class InvestimentoDao {
    
    //Método para salvar os dados do investimento no banco de dados, da tabela investimento;
    public void adicionaInvestimento(InvestimentoModel investir){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //comando para inserir os dados do investimento;
            String sql="insert into investimento(nomeProd,QtdProd,ValorDeComprar,ValorDeRevenda,ValorDoInvestimento,ValorTotalDeTodosVendidos,Lucro,data)values(?,?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do investimento da classe InvestimentoModel;
           
            patm.setString(1, investir.getNomeProduto());
            patm.setInt(2, investir.getQuantidadeProduto());
            patm.setDouble(3, investir.getValorDeComprar());
            patm.setDouble(4, investir.getValorDeRevenda());
            patm.setDouble(5, investir.getValorDoInvestimento());
            patm.setDouble(6, investir.getValorTotalDeTodasVendas());
            patm.setDouble(7, investir.getValorDoLucro());
            patm.setString(8, investir.getData());
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Investimento adicionado com sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Investimento não foi adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar o investimento  !");
        }
        
    }
    
    //Método para visualizar os valores de investimentos;
     public List<InvestimentoModel> visualizarInvestimento(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList para lista os investimentos;
         ArrayList<InvestimentoModel> listaInvestir = new ArrayList<>();
        
         try {
             
             //Selecionando todos dados da tabela investimento;
             String sql="SELECT * FROM investimento";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instanciando  classe InvestimentoModel;
                 InvestimentoModel invest = new InvestimentoModel();
                 //setando os Valores ;
                invest.setCodInvestimento(rst.getInt("codInvestir"));
                invest.setNomeProduto(rst.getString("nomeProd"));
                invest.setQuantidadeProduto(rst.getInt("QtdProd"));
                invest.setValorDeComprar(rst.getDouble("ValorDeComprar"));
                invest.setValorDeRevenda(rst.getDouble("ValorDeRevenda"));
                invest.setValorDoInvestimento(rst.getDouble("ValorDoInvestimento"));
                invest.setValorTotalDeTodasVendas(rst.getDouble("ValorTotalDeTodosVendidos"));
                invest.setValorDoLucro(rst.getDouble("lucro"));
                invest.setData(rst.getString("data"));
                 //Adicionado na Lista;
                 listaInvestir.add(invest);
          
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar todos investimentos!");
         }
         //Retornando uma Lista de Clientec;
        return listaInvestir;
         
     }
     
       //Método para fazer atualização dos dados de investimentos;
       public void atualizarDadosDoInvestimentos(InvestimentoModel invest){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para que realizar a alteração dos dados;
            String sql="UPDATE investimento SET nomeProd=?,QtdProd=?, valorDeComprar=?,ValorDeRevenda=?, ValorDoInvestimento=?,ValorTotalDeTodosVendidos=?,lucro=?,data=? WHERE codInvestir=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandoos valores nos paramentros;
            patm.setString(1,invest.getNomeProduto());
            patm.setInt(2,invest.getQuantidadeProduto());
            patm.setDouble(3, invest.getValorDeComprar());
            patm.setDouble(4, invest.getValorDeRevenda());
            patm.setDouble(5, invest.getValorDoInvestimento());
            patm.setDouble(6, invest.getValorTotalDeTodasVendas());
            patm.setDouble(7, invest.getValorDoLucro());
            patm.setString(8, invest.getData());
            patm.setInt(9, invest.getCodInvestimento());
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Dados do investimento atualizador com sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Dados não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao Atualizar so dados de investimento !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }         
        //Método para deletar investimento no banco de dados pelo código de investimento;
      public void deletaInvestimento(InvestimentoModel invest){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando para deleta um investimento;
            String sql = "DELETE FROM investimento WHERE codInvestir=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do investimento;
            patm.setInt(1,invest.getCodInvestimento());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Investimento Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de error será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Investimento não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar um investimento !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
    
       }

