
package Dao;

import Conexao.Conexao_BD;
import Model.EstoqueModel;
import Model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author anderson
 */
public class EstoqueDao {
    
      //Método para adicionar dados na tabela estoque no banco de dados;
    public void adicionarAoEstoque(EstoqueModel estoque){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Comando para inserir os dados na tabela estoque banco de dados;
            String sql="INSERT INTO estoque(codEstoq,codProd,entrada,saida,qtd_Estoque,data)values(?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos da tabela estoque da classe EstoqueModel;
            patm.setString(1, estoque.getCodEstoq());
            patm.setString(2, estoque.getCodProd());
            patm.setInt(3, estoque.getEntrada());
            patm.setInt(4,estoque.getSaida());
            patm.setInt(5, estoque.getQtdEstoq());
            patm.setString(6, estoque.getData());
            
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Estoque salvor Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Estoque não salvor !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Realizar Estoque  !");
        }
        
    }
    
    
     //Método para visualizar todos os dados do estoque;
     public List<EstoqueModel> visualizarEstoque(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de Estoque;
         ArrayList<EstoqueModel> listEstoque = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela Estoque;
             String sql="SELECT * FROM estoque";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe EstoqueModel;
                 EstoqueModel estoque = new EstoqueModel();
                 //Setando os Valores;
                 estoque.setCodEstoq(rst.getString("codEstoq"));
                 estoque.setCodProd(rst.getString("codProd"));
                 estoque.setEntrada(rst.getInt("entrada"));
                 estoque.setSaida(rst.getInt("saida"));
                 estoque.setQtdEstoq(rst.getInt("qtd_Estoque"));
                 estoque.setData(rst.getString("data"));
               
                 listEstoque.add(estoque);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todos  Usuários!");
         }
         //Retornando uma Lista;
        return listEstoque;
         
     }
     
     
     
        //Método para deletar estoque no banco de dados pelo código do estoque;
      public void deletatoque(EstoqueModel estoque){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar estoque pelo código;
            String sql = "DELETE FROM estoque WHERE codEstoq=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do estoque;
            patm.setString(1,estoque.getCodEstoq());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Estoque Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de error será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Estoque não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Estoque !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
    
      
       //Método para fazer atualização dos dados do estoque;
       public void atualizarEstoque(EstoqueModel estoque){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para que realizar atualização no banco de dados;
            String sql="UPDATE estoque SET codProd=?, entrada=?, saida=?, qtd_Estoque=? ,data=? WHERE codEstoq=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandoos valores nos paramentros;
          
            patm.setString(1,estoque.getCodProd());
            patm.setInt(2,estoque.getEntrada());
            patm.setInt(3,estoque.getSaida());
            patm.setInt(4,estoque.getQtdEstoq());
            patm.setString(5,estoque.getData());
            patm.setString(6,estoque.getCodEstoq());
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Estoque Atualizador com Sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Estoque não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao Atualizar Estoque !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
    
}
