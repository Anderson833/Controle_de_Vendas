
package Dao;

import Conexao.Conexao_BD;
import Model.EstoqueModel;
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
    
      //Método para adicionar dados na tabela estoque ao banco de dados;
    public void adicionarProdAoEstoque(EstoqueModel estoque){
        
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
                JOptionPane.showMessageDialog(null, "Estoque Realizado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Estoque Não Realizado !","Error ",JOptionPane.ERROR_MESSAGE);
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
    
}
