
package Dao;

import Conexao.Conexao_BD;
import Model.ClienteModel;
import Model.UsuarioModel;

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
public class UsuarioDao {
    
     //Método para adicionar usuario ao banco de dados;
    public void adicionaUsuario(UsuarioModel usuario){
        
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
        
       
        try {
            //Inserindo os dados do usuario no banco de dados;
            String sql="insert into usuario(idUsu,nome,endereco,telefone,login,senha) values(?,?,?,?,?,?)";
             
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passando como paramentros os atributos do USUARIO da classe UsuarioModel;
            patm.setString(1, usuario.getIdUsu());
            patm.setString(2, usuario.getNome());
            patm.setString(3, usuario.getEndereco());
            patm.setString(4, usuario.getTelefone());
            patm.setString(5, usuario.getLogin());
            patm.setString(6, usuario.getSenha());
            
            //Executar;
            int upd=patm.executeUpdate();
            
            if(upd>0){
                //Caso de tudo certo exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Usuário Adicionado Com Sucesso");
            }else{
                //Caso de error  exibir essa mensagem;
                JOptionPane.showMessageDialog(null, "Usuário Não Adicionado !","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
             //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (SQLException ex) {
            //Caso aconteça algum error mostrar essa mensagem;
           JOptionPane.showMessageDialog(null, "Error ao Adicionar Usuário !");
        }
        
    }
    
    
    
     //Método para visualizar todos usuario;
     public List<UsuarioModel> visualizarUsuario(){
        //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
     
        //ArrayList de Usuario;
         ArrayList<UsuarioModel> listUsuario = new ArrayList<>();
        
         try {
             
             //Selecionando toda tabela usuario;
             String sql="SELECT * FROM usuario";
             
             PreparedStatement patm = conn.prepareStatement(sql);
             
             ResultSet rst=patm.executeQuery();
             
             while (rst.next()) {
               
                 //Instânciando  classe UsuarioModel;
                 UsuarioModel usuario = new UsuarioModel();
                 //Setando os Valores;
                usuario.setIdUsu(rst.getString("idUsu"));
                usuario.setNome(rst.getString("nome"));
                usuario.setEndereco(rst.getString("endereco"));
                usuario.setTelefone(rst.getString("telefone"));
                usuario.setLogin(rst.getString("login"));
                usuario.setSenha(rst.getString("senha"));
                 
                 //Adicionado na Lista;
                 listUsuario.add(usuario);
          
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
         //Retornando uma Lista de Usuários;
        return listUsuario;
         
     }
    
      //Método para deletar usuario no banco de dados pelo código do Usuário;
      public void deletaUsuario(UsuarioModel model){
          
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
             
        try {

          // Comando que  Deletar usuario pelo código;
            String sql = "DELETE FROM usuario WHERE idUsu=?";

            PreparedStatement patm = conn.prepareStatement(sql);
             
            //Passando em paramentros código do usuario;
            patm.setString(1, model.getIdUsu());
            
            //Executar;
            int res = patm.executeUpdate();

            if (res > 0) {
                //Caso de tudo certo será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Usuário Deletado com Sucesso !", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 //Caso de errado será exibido essa mensagem para usuário;
                JOptionPane.showMessageDialog(null, "Usuário não Deletado !", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            

        } catch (Exception e) {
            //Caso de error ao deletar mostrar essa mensagem;
             JOptionPane.showMessageDialog(null, "Error ao Deletar Usuário  !", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
      }
      
       //Método para fazer atualização dos dados dos Usuário;
       public void atualizarUsuario(UsuarioModel usuario){  
           //Criando uma Connection com Classe Conexao_BD; 
        Connection conn=Conexao_BD.getConnection();
               try {
           
          //Comando para  realizar atualização dos dados do usuario no banco de dados;
            String sql="UPDATE usuario SET nome=?,endereco=?, telefone=?, login=?,senha=? WHERE idUsu=?";
            
            
            
            PreparedStatement patm = conn.prepareStatement(sql);
            //Passandos valores nos paramentros;
            patm.setString(1, usuario.getNome());
            patm.setString(2,usuario.getEndereco());
            patm.setString(3,usuario.getTelefone());
            patm.setString(4,usuario.getLogin());
            patm.setString(5,usuario.getSenha());
            patm.setString(6,usuario.getIdUsu());
            //Executar;
             int res= patm.executeUpdate();
            
            if(res>0){
                //Mensagem para mostrar para usuário caso esteja tudo correto!;
                JOptionPane.showMessageDialog(null,"Usuário Atualizador com Sucesso !","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            }else{
                //Mensagem oara exibir para usuário caso tenha informações incorretas;
                JOptionPane.showMessageDialog(null,"Usuário não Atualizador !","Error",JOptionPane.ERROR_MESSAGE);
            }
            
            //Fechando conexão PreparedStatement;
            patm.close();
            
            //Fechando conexão Connection;
            conn.close();
            
        } catch (Exception e) {
            //Mensagem caso de error;
              JOptionPane.showMessageDialog(null,"Error ao Atualizar Usuário !","Error",JOptionPane.ERROR_MESSAGE);
        }
     
       }
    
}
