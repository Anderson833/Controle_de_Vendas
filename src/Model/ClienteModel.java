/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ander
 */
public class ClienteModel {
    
    
    //Atributos
    private String codCli;
    private String nome;
    private String endereco;
    private String telefone;
    private String Idsu;

    //Os Métodos gettres e settres  
    public String getCodCli() {
        return codCli;
    }

  
    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

  
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

  
    public String getIdsu() {
        return Idsu;
    }

   
    public void setIdsu(String Idsu) {
        this.Idsu = Idsu;
    }

    @Override
    public String toString() {
        return getCodCli();
    }
    
    
}
