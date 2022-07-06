
package Model;

/**
 *
 * @author anderson
 */
public class UsuarioModel {
    
    //Atributos do usuário;
    
    private String idUsu;
    private String nome;
    private String endereco;
    private String telefone;
    private String login;
    private String senha;

     //Métodos get e set
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getEndereco() {
        return endereco;
    }

    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    public String getTelefone() {
        return telefone;
    }

   
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    public String getIdUsu() {
        return idUsu;
    }
    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }
   
    public String getLogin() {
        return login;
    }

   
    public void setLogin(String login) {
        this.login = login;
    }

   
    public String getSenha() {
        return senha;
    }

   
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getIdUsu();
    }
     
}
