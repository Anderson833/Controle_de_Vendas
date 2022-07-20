
package Model;

/**
 *
 * @author ander
 */
public class RelatorioModel {
    
    //Passsando os atributos
    private int codRelatorio;
    private double valorDespesa;
    private double valorLucro;
    private double valorInvestido;
    private double valorDeTodosProdutosVendidos;
    private double capital;
    private String data ;

    // métodos getters e setters
    public int getCodRelatorio() {
        return codRelatorio;
    }

   
    public void setCodRelatorio(int codRelatorio) {
        this.codRelatorio = codRelatorio;
    }

    
    public double getValorDespesa() {
        return valorDespesa;
    }

   
    public void setValorDespesa(double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

   
    public double getValorLucro() {
        return valorLucro;
    }

    
    public void setValorLucro(double valorLucro) {
        this.valorLucro = valorLucro;
    }

    
    public double getValorInvestido() {
        return valorInvestido;
    }

   
    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

   
    public double getValorDeTodosProdutosVendidos() {
        return valorDeTodosProdutosVendidos;
    }

    
    public void setValorDeTodosProdutosVendidos(double valorDeTodosProdutosVendidos) {
        this.valorDeTodosProdutosVendidos = valorDeTodosProdutosVendidos;
    }

    
    public double getCapital() {
        return capital;
    }

   
    public void setCapital(double capital) {
        this.capital = capital;
    }

    
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }

   
   
}
