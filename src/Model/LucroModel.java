//Passa os atributos para a classe LucroModel
package Model;

/**
 *
 * @author ander
 */
public class LucroModel {
    
    
    private String codigoLucro;
    private String codigoProduto;
    private double Quantidade;
    private double valorUnitario;
    private double valorTotal;
    private double valorDcomprar;
    private double valorGanhor;
    private String data;
    
    public LucroModel(){
        
    }
    
    
    public LucroModel(String codigoLucro,String codProd,int qtd,double valorUnit,double valorTotal,double valorCompra,double valorGanho,String dat){
        this.codigoLucro=codigoLucro;
        this.codigoProduto=codProd;
        this.Quantidade=qtd;
        this.valorUnitario=valorUnit;
        this.valorTotal=valorTotal;
        this.valorDcomprar=valorCompra;
        this.valorGanhor=valorGanho;
        this.data=dat;
    }
   
    
    /**
     * @return the codigoLucro
     */
    public String getCodigoLucro() {
        return codigoLucro;
    }

    /**
     * @param codigoLucro the codigoLucro to set
     */
    public void setCodigoLucro(String codigoLucro) {
        this.codigoLucro = codigoLucro;
    }

    /**
     * @return the codigoProduto
     */
    public String getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    /**
     * @return the Quantidade
     */
    public double getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(double Quantidade) {
        this.Quantidade = Quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the valorDcomprar
     */
    public double getValorDcomprar() {
        return valorDcomprar;
    }

    /**
     * @param valorDcomprar the valorDcomprar to set
     */
    public void setValorDcomprar(double valorDcomprar) {
        this.valorDcomprar = valorDcomprar;
    }

    /**
     * @return the valorGanhor
     */
    public double getValorGanhor() {
        return valorGanhor;
    }

    /**
     * @param valorGanhor the valorGanhor to set
     */
    public void setValorGanhor(double valorGanhor) {
        this.valorGanhor = valorGanhor;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
}
