
package Dao;

import Conexao.Conexao_BD;
import Model.ClienteModel;
import Model.RelatorioModel;
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
public class RelatorioDao {
    
     //Método para visualizar todo Relatório;
     public List<RelatorioModel> visualizarRelatorio(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de Relatorio;
         ArrayList<RelatorioModel> listRelatorio = new ArrayList<>();
        
         try {
             
             //Comando para selecionar toda tabela Relatório;
             String sql="SELECT * FROM relatorio";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             //Executar;
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe RelatorioModel;
                 RelatorioModel relat = new RelatorioModel();
                 //Setando os Valores;
                relat.setCodRelatorio(rst.getString("codRela"));
                relat.setValorDespesa(rst.getDouble("Despesa"));
                relat.setValorLucro(rst.getDouble("Lucro"));
                relat.setValorInvestido(rst.getDouble("Investimento"));
                relat.setValorDeTodosProdutosVendidos(rst.getDouble("ValorDeTodoProdutoVendido"));
                relat.setCapital(rst.getDouble("capital"));
                relat.setData(rst.getString("data"));
            
                
                 //Adicionando na Lista;
               listRelatorio.add(relat);
          
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Relatório!");
         }
         //Retornando uma Lista de Relatório;
        return listRelatorio;
         
     }
    
     
      //Método para adicionar relatorio ao banco de dados;
    public void adicionarRelatorio(RelatorioModel relat){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Comando para inserir os dados do relatório no banco de dados;/,
            String sql="INSERT INTO relatorio(codRela,Despesa,Lucro,Investimento,ValorDeTodoProdutoVendido,capital,data) VALUES(?,?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do relatório da classe RelatorioModel;
            patm.setString(1, relat.getCodRelatorio());
            patm.setDouble(2, relat.getValorDespesa());
            patm.setDouble(3, relat.getValorLucro());
            patm.setDouble(4, relat.getValorInvestido());
            patm.setDouble(5, relat.getValorDeTodosProdutosVendidos());
            patm.setDouble(6, relat.getCapital());
            patm.setString(7, relat.getData());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Relatório adicionado com sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Relatório não salvo !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao salvar Relatório  !");
        }
        
    }
    
     //Método para fazer alterar dados no relatório;
       public void alterarRelatorio(RelatorioModel relatorio){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para  alterar os dados do relatório
            String sql="UPDATE relatorio SET Despesa=?,Lucro=?,Investimento=?,ValorDeTodoProdutoVendido=?,capital=?,data=? WHERE codRela=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandos valores nos paramentros;
            patm.setDouble(1,relatorio.getValorDespesa());
            patm.setDouble(2,relatorio.getValorLucro());
            patm.setDouble(3,relatorio.getValorInvestido());
            patm.setDouble(4,relatorio.getValorDeTodosProdutosVendidos());
            patm.setDouble(5,relatorio.getCapital());
            patm.setString(6,relatorio.getData());
            patm.setString(7,relatorio.getCodRelatorio());
        
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Dados do relatório alterado comsucesso!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Dados não alterado !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao alterar relatório!","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
     
        //Método para deletar relatório pelo código do relatório;
      public void deletaRelatorio(RelatorioModel relatorio){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando para  Deletar relatório pelo código;
            String sql = "DELETE FROM relatorio WHERE codRela=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código de relatorio;
            patm.setString(1, relatorio.getCodRelatorio());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Relatório deletado com sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Relatório não deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Relatório  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
}
