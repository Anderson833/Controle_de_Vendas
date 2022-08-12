
package Model;

/**
 *
 * @author Anderson
 */
public class ProdutoModel {
    
    //Atributos do Produto
    private int codProd;
    private String descricao;
    private String produto;
    private String codigoNome;
    private double ValorDeRevenda;
    private double valorDcomprar;
    private int Qtd_estoquer;
    private int codFornec;

    //Métodos getters e setters
    public int getCodProd() {
        return codProd;
    }

   
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public String getProduto() {
        return produto;
    }

  
    public void setProduto(String produto) {
        this.produto = produto;
    }

   
    public double getValorDeRevenda() {
        return ValorDeRevenda;
    }

    
    public void setValorDeRevenda(double ValorDeRevenda) {
        this.ValorDeRevenda = ValorDeRevenda;
    }

   
    public double getValorDcomprar() {
        return valorDcomprar;
    }

    
    public void setValorDcomprar(double valorDcomprar) {
        this.valorDcomprar = valorDcomprar;
    }

    
    public int getQtd_estoquer() {
        return Qtd_estoquer;
    }

    
    public void setQtd_estoquer(int Qtd_estoquer) {
        this.Qtd_estoquer = Qtd_estoquer;
    }

    @Override
    public String toString() {
      //  return String.valueOf(getCodProd())+"  "+String.valueOf(getProduto
    return String.valueOf(getCodProd());
      // return String.valueOf(getProduto());

    }

    /**
     * @return the codFornec
     */
    public int getCodFornec() {
        return codFornec;
    }

    /**
     * @param codFornec the codFornec to set
     */
    public void setCodFornec(int codFornec) {
        this.codFornec = codFornec;
    }

    /**
     * @return the codigoNome
     */
    public String getCodigoNome() {
        return codigoNome;
    }

    /**
     * @param codigoNome the codigoNome to set
     */
    public void setCodigoNome(String codigoNome) {
        this.codigoNome = codigoNome;
    }

     
   
  
}
