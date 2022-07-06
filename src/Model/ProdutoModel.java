
package Model;

/**
 *
 * @author Anderson
 */
public class ProdutoModel {
    
    //Atributos do Produto
    private String codProd;
    private String descricao;
    private String produto;
    private double ValorDeRevenda;
    private double valorDcomprar;
    private int Qtd_estoquer;

    /**
     * @return the codProd
     */
    public String getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the ValorDeRevenda
     */
    public double getValorDeRevenda() {
        return ValorDeRevenda;
    }

    /**
     * @param ValorDeRevenda the ValorDeRevenda to set
     */
    public void setValorDeRevenda(double ValorDeRevenda) {
        this.ValorDeRevenda = ValorDeRevenda;
    }

    /**
     * @return the valorDcomprar
     */
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
        return getCodProd();
    }

     
    
  
}
