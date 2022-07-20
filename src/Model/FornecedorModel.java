
package Model;

/**
 *
 * @author Anderson
 */
public class FornecedorModel {
    
  // Os Atributos que contem para fornecedor;
    private int codFornec;
    private String nomeFornec;
    private String endereco;
    private String contato;
    private String data;
   
    public int getCodFornec() {
        return codFornec;
    }

   
    public void setCodFornec(int codFornec) {
        this.codFornec = codFornec;
    }

  
    public String getNomeFornec() {
        return nomeFornec;
    }

    public void setNomeFornec(String nomeFornec) {
        this.nomeFornec = nomeFornec;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   
    public String getContato() {
        return contato;
    }

   
    public void setContato(String contato) {
        this.contato = contato;
    }

    
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getCodFornec());
    }
    
    
}
