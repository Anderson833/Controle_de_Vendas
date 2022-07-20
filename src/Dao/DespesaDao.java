/*
ESSA CLASSE VAI FAZER A MANIPULAÇÃO DOS DADOS DAS DESPESAS
 */
package Dao;

import Conexao.Conexao_BD;
import Model.DespesaModel;
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
public class DespesaDao {
    
     //MÉTODO PARA ADICIONAR OS DADOS DAS DESPESAS NO BANCO DE DADOS NA TABELA DESPESAS;
    public void adicionaDespesa(DespesaModel despesa){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados da despesa no banco de dados ;
            String sql="insert into despesas(descricao,valorTotal,data)values(?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da classse DespesaModel;
            patm.setString(1, despesa.getDescricao());
            patm.setDouble(2, despesa.getTotal());
            patm.setString(3, despesa.getData());
          
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Dados da despesa adicionado com sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Dados da despesa não adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao adicionar os dados das despesas !");
        }
        
    }
    
     //Método para visualizar os dados das despesas;
        public List<DespesaModel> visualizarAsDespesas(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de despesa;
         ArrayList<DespesaModel> listaDespesas = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela de despesas;
             String sql="SELECT * FROM despesas";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instanciando a classe DespesaModel;
                 DespesaModel desp = new DespesaModel();
                 //Setando os dados da despesa;
                 desp.setCodDespesa(rst.getInt("codDespesa"));
                 desp.setDescricao(rst.getString("descricao"));
                 desp.setTotal(rst.getDouble("valorTotal"));
                 desp.setData(rst.getString("data"));
               
                 listaDespesas.add(desp);
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
             JOptionPane.showMessageDialog(null, "Error ao visualizar todas despesas!");
         }
         //Retornando uma Lista de despesas;
        return listaDespesas;
        
    }
        
        
         //Método para realizar alteração da despesa;
       public void atualizarDespesa(DespesaModel despesa){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para alterar os dados da despesa
            String sql="UPDATE despesas SET descricao=?,valorTotal=?, data=? WHERE codDespesa=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandos valores nos paramentros;
            patm.setString(1,despesa.getDescricao());
            patm.setDouble(2,despesa.getTotal());
            patm.setString(3,despesa.getData());
            patm.setInt(4,despesa.getCodDespesa());
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Dados da despesa alterado com  sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Dados da despesa não alterado !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao alterar os dados das despesas !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
       
        //Método para excluir uma despesa pelo código da despesa;
      public void excluirDespesa(DespesaModel despesas){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          //  Comando para excluir a despesa;
            String sql = "DELETE FROM despesas WHERE codDespesa=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do cliente;
            patm.setInt(1, despesas.getCodDespesa());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "A despesa foi excluida com sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Despesa não excluida !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao tentar excluir a despesa  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
}


