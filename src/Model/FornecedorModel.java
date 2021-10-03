
package Model;

/**
 *
 * @author Anderson
 */
public class FornecedorModel {
    
  // Os Atributos que contem para fornecedor;
    private String codFornec;
    private String nome;
    private String endereco;
    private String contato;
    private String produto;
    private double valorDvenda;
    private double valorDcomprar;
    private int Qtd_Prod;
    private String data;
   
    public String getCodFornec() {
        return codFornec;
    }

   
    public void setCodFornec(String codFornec) {
        this.codFornec = codFornec;
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

   
    public String getContato() {
        return contato;
    }

   
    public void setContato(String contato) {
        this.contato = contato;
    }

   
    public String getProduto() {
        return produto;
    }

   
    public void setProduto(String produto) {
        this.produto = produto;
    }

  
    public double getValorDvenda() {
        return valorDvenda;
    }

   
    public void setValorDvenda(double valorDvenda) {
        this.valorDvenda = valorDvenda;
    }

   
    public double getValorDcomprar() {
        return valorDcomprar;
    }

   
    public void setValorDcomprar(double valorDcomprar) {
        this.valorDcomprar = valorDcomprar;
    }

  
    public int getQtd_Prod() {
        return Qtd_Prod;
    }

   
    public void setQtd_Prod(int Qtd_Prod) {
        this.Qtd_Prod = Qtd_Prod;
    }

    
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }
    
    
}
