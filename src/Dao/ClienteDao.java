
//Pacote Dao;
package Dao;

import Conexao.Conexao_BD;
import Model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDERSON 
 */
public class ClienteDao {
    
    //Método para adicionar cliente ao banco de dados;
    public void adicionaCliente(ClienteModel cliente){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados do cliente no banco de dados;
            String sql="insert into cliente(codCli,nome,endereco,telefone,IdUsu)values(?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do cliente da classe clienteModel;
            patm.setString(1, cliente.getCodCli());
            patm.setString(2, cliente.getNome());
            patm.setString(3, cliente.getEndereco());
            patm.setString(4, cliente.getTelefone());
            patm.setString(5, cliente.getIdsu());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Cliente Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Cliente Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar Cliente  !");
        }
        
    }
    
     //Método para visualizar todos clientes;
     public List<ClienteModel> visualizarClientes(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de cliente;
         ArrayList<ClienteModel> listCliente = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela cliente;
             String sql="SELECT * FROM cliente";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe ClienteModel;
                 ClienteModel cli = new ClienteModel();
                 //Setando os Valores;
                 cli.setCodCli(rst.getString("codCli"));
                 cli.setNome(rst.getString("nome"));
                 cli.setEndereco(rst.getString("endereco"));
                 cli.setTelefone(rst.getString("telefone"));
                 cli.setIdsu(rst.getString("IdUsu"));
                 
                 //Adicionado na Lista;
                 listCliente.add(cli);
          
             }
             
             //Fechando conexão ResultSet;
             rst.close();
             
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
             
         } catch (Exception e) {
             //Algo de error mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Visualizar Todos  Clientes!");
         }
         //Retornando uma Lista de Clientec;
        return listCliente;
         
     }
    
      //Método para deletar cliente no banco de dados pelo código do cliente;
      public void deletaCliente(ClienteModel model){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar cliente pelo código;
            String sql = "DELETE FROM cliente WHERE codCli=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do cliente;
            patm.setString(1, model.getCodCli());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Cliente Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Cliente não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Cliente  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
      //Método para fazer atualização dos dados dos clientes;
       public void atualizarCliente(ClienteModel cliente){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para  realizar atualização no banco de dados;
            String sql="UPDATE cliente SET nome=?,endereco=?, telefone=? WHERE codCli=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandos valores nos paramentros;
            patm.setString(1,cliente.getNome());
            patm.setString(2,cliente.getEndereco());
            patm.setString(3,cliente.getTelefone());
            patm.setString(4,cliente.getCodCli());
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Cliente Atualizador com Sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Cliente não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao Atualizar Cliente !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
}
