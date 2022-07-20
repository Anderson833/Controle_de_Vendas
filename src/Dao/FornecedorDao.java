
package Dao;

import Conexao.Conexao_BD;
import Model.FornecedorModel;
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
public class FornecedorDao {
    
    
     //Método para adicionar fornecedor ao banco de dados;
    public void adicionarFornecedor(FornecedorModel fornec){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Comando para inserir os dados do fornecedor no banco de dados;
            String sql="INSERT INTO fornecedor(nome,endereco,contato,data)VALUES(?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do fornecedor da classe FornecedorModel;
            patm.setString(1, fornec.getNomeFornec());
            patm.setString(2, fornec.getEndereco());
            patm.setString(3, fornec.getContato());
            patm.setString(4, fornec.getData());
           
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Fornecedor Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Fornecedor Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar Fornecedor  !");
        }
        
    }
    
    
    
          //Método para visualizar todos os dados do Fornecedor;
        public List<FornecedorModel> visualizarFornecedor(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de Fornecedor;
         ArrayList<FornecedorModel> listFornec = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela Fornecedor;
             String sql="SELECT * FROM fornecedor";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe FornecedorModel;
                 FornecedorModel fornec = new FornecedorModel();
                 //Setando os Valores;
                 fornec.setCodFornec(rst.getInt("codFornec"));
                 fornec.setNomeFornec(rst.getString("nome"));
                 fornec.setEndereco(rst.getString("endereco"));
                 fornec.setContato(rst.getString("contato"));
                 fornec.setData(rst.getString("data"));
              
               
                 listFornec.add(fornec);
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
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todos  Fornecedores!");
         }
         //Retornando uma Lista;
        return listFornec;
        
    }

        
          //Método para fazer atualização dos dados do fornecedor;
       public void atualizarFornecedor(FornecedorModel fornec){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para que realizar atualização no banco de dados;
            String sql="UPDATE fornecedor SET nome=?,endereco=?,contato=?,data=? WHERE codFornec=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandoos valores nos paramentros;
          
            patm.setString(1,fornec.getNomeFornec());
            patm.setString(2, fornec.getEndereco());
            patm.setString(3,fornec.getContato());
            patm.setString(4, fornec.getData());
            patm.setInt(5, fornec.getCodFornec());
           
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Fornecedor Atualizador com Sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Fornecedor não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao Atualizar Fornecedor !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
    
        
        //Método para deletar fornecedor no banco de dados pelo código do fornecedor;
      public void deletaFornecedor(FornecedorModel fornec){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar fornecedor pelo código;
            String sql = "DELETE FROM fornecedor WHERE codFornec=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do fornecedor;
            patm.setInt(1,fornec.getCodFornec());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Fornecedor Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de error será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Fornecedor não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Fornecedor !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
    
      
        
}
