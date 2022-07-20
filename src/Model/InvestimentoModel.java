/*  
    
 */
package Model;

/**
 *
 * @author ander
 */
public class InvestimentoModel {
    // Os atributos de investimento
    private int codInvestimento;
    private String nomeProduto;
    private int  QuantidadeProduto;
    private double ValorDeComprar;
    private double ValorDeRevenda;
    private double ValorDoInvestimento;
    private double ValorTotalDeTodasVendas;
    private double ValorDoLucro;
    private String data;

    // Os métodos getters e setters
    public int getCodInvestimento() {
        return codInvestimento;
    }

    public void setCodInvestimento(int codInvestimento) {
        this.codInvestimento = codInvestimento;
    }

    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
    public int getQuantidadeProduto() {
        return QuantidadeProduto;
    }

   
    public void setQuantidadeProduto(int QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

    
    public double getValorDeComprar() {
        return ValorDeComprar;
    }

    
    public void setValorDeComprar(double ValorDeComprar) {
        this.ValorDeComprar = ValorDeComprar;
    }

    
    public double getValorDeRevenda() {
        return ValorDeRevenda;
    }

   
    public void setValorDeRevenda(double ValorDeRevenda) {
        this.ValorDeRevenda = ValorDeRevenda;
    }

    
    public double getValorTotalDeTodasVendas() {
        return ValorTotalDeTodasVendas;
    }

    
    public void setValorTotalDeTodasVendas(double ValorTotalDeTodasVendas) {
        this.ValorTotalDeTodasVendas = ValorTotalDeTodasVendas;
    }

   
    public double getValorDoLucro() {
        return ValorDoLucro;
    }

   
    public void setValorDoLucro(double ValorDoLucro) {
        this.ValorDoLucro = ValorDoLucro;
    }

   
    public String getData() {
        return data;
    }

    
    public void setData(String data) {
        this.data = data;
    }

    
    public double getValorDoInvestimento() {
        return ValorDoInvestimento;
    }

  
    public void setValorDoInvestimento(double ValorDoInvestimento) {
        this.ValorDoInvestimento = ValorDoInvestimento;
    }
    
 
       
}
