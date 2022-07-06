
package Model;

/**
 *
 * @author Anderson
 */
public class FornecedorModel {
    
  // Os Atributos que contem para fornecedor;
    private String codFornec;
    private String nomeFornec;
    private String endereco;
    private String contato;
    private String Nomeproduto;
    private double valorDeRevenda;
    private double valorDcomprar;
    private int Qtd_estoque;
    private String data;
   
    public String getCodFornec() {
        return codFornec;
    }

   
    public void setCodFornec(String codFornec) {
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

   
    public String getNomeproduto() {
        return Nomeproduto;
    }

   
    public void setNomeproduto(String Nomeproduto) {
        this.Nomeproduto = Nomeproduto;
    }

  
    public double getValorDeRevenda() {
        return valorDeRevenda;
    }

   
    public void setValorDeRevenda(double valorDeRevenda) {
        this.valorDeRevenda = valorDeRevenda;
    }

   
    public double getValorDcomprar() {
        return valorDcomprar;
    }

   
    public void setValorDcomprar(double valorDcomprar) {
        this.valorDcomprar = valorDcomprar;
    }

  
    public int getQtd_estoque() {
        return Qtd_estoque;
    }

   
    public void setQtd_estoque(int Qtd_estoque) {
        this.Qtd_estoque = Qtd_estoque;
    }

    
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }
    
    
}
