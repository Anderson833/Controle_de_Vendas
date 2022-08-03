//Passa os atributos para a classe LucroModel
package Model;

/**
 *
 * @author ander
 */
public class LucroModel {
    
    //atributos
    private String codigoLucro;
    private String codigoProduto;
    private double Quantidade;
    private double valorUnitario;
    private double valorTotal;
    private double valorDcomprar;
    private double valorInvestir;
    private double valorGanhor;
    private String data;
    
    //construtor vazio
    public LucroModel(){
        
    }
    
    //construtor com parâmentros
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
   
    
   
    public String getCodigoLucro() {
        return codigoLucro;
    }

    public void setCodigoLucro(String codigoLucro) {
        this.codigoLucro = codigoLucro;
    }

    
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(double Quantidade) {
        this.Quantidade = Quantidade;
    }

   
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

   
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    public double getValorDcomprar() {
        return valorDcomprar;
    }

    
    public void setValorDcomprar(double valorDcomprar) {
        this.valorDcomprar = valorDcomprar;
    }

    public double getValorGanhor() {
        return valorGanhor;
    }

   
    public void setValorGanhor(double valorGanhor) {
        this.valorGanhor = valorGanhor;
    }

   
    public String getData() {
        return data;
    }

   
    public void setData(String data) {
        this.data = data;
    }

    
    public double getValorInvestir() {
        return valorInvestir;
    }

   
    public void setValorInvestir(double valorInvestir) {
        this.valorInvestir = valorInvestir;
    }
    
    
    
    
}
